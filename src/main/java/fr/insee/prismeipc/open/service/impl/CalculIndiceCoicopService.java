package fr.insee.prismeipc.open.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.insee.prismeipc.open.exception.NotFoundException;
import fr.insee.prismeipc.open.model.AgregatCoicop;
import fr.insee.prismeipc.open.model.Echantillon;
import fr.insee.prismeipc.open.model.IndiceCoicopAnnuel;
import fr.insee.prismeipc.open.model.IndiceCoicopMensuel;
import fr.insee.prismeipc.open.model.IndiceCoicopMensuelAbstract;
import fr.insee.prismeipc.open.model.IndicePosteMensuel;
import fr.insee.prismeipc.open.model.PonderationCoicopAbstract;
import fr.insee.prismeipc.open.model.enumeration.EtatCalendrier;
import fr.insee.prismeipc.open.model.enumeration.NiveauCoicop;
import fr.insee.prismeipc.open.model.enumeration.Population;
import fr.insee.prismeipc.open.service.CacheEchantillonsService;
import fr.insee.prismeipc.open.service.CacheIndiceCoicopEchantillonMoisService;
import fr.insee.prismeipc.open.service.CacheIndiceCoicopEchantillonService;
import fr.insee.prismeipc.open.service.CacheIndicePosteService;
import fr.insee.prismeipc.open.service.CacheItemsCoicopService;
import fr.insee.prismeipc.open.service.CachePonderationCoicopService;
import fr.insee.prismeipc.open.service.CachePonderationPosteService;
import fr.insee.prismeipc.open.service.IndiceCoicopMensuelService;
import fr.insee.prismeipc.open.utils.DecimalesUtils;

public class CalculIndiceCoicopService {
   private static final Logger logger = LoggerFactory.getLogger(CalculIndiceCoicopService.class);

   private CacheEchantillonsService cacheEchantillonsService;
   private CacheIndicePosteService cacheIndicePosteService;
   private CacheIndiceCoicopEchantillonService cacheIndiceCoicopEchantillonService;
   private CacheIndiceCoicopEchantillonMoisService cacheIndiceCoicopEchantillonMoisService;
   private CacheItemsCoicopService cacheItemsCoicopService;
   private CachePonderationCoicopService cachePonderationCoicopService;
   private CachePonderationPosteService cachePonderationPosteService;
   private IndiceCoicopMensuelService indiceCoicopMensuelService;

   public CalculIndiceCoicopService() {
      super();
   }

   public CalculIndiceCoicopService(CacheEchantillonsService cacheEchantillonsService, CacheIndicePosteService cacheIndicePosteService,
      CacheIndiceCoicopEchantillonService cacheIndiceCoicopEchantillonService, CacheIndiceCoicopEchantillonMoisService cacheIndiceCoicopEchantillonMoisService,
      CacheItemsCoicopService cacheItemsCoicopService, CachePonderationCoicopService cachePonderationCoicopService, CachePonderationPosteService cachePonderationPosteService,
      IndiceCoicopMensuelService indiceCoicopMensuelService) {
      super();
      this.cacheEchantillonsService = cacheEchantillonsService;
      this.cacheIndicePosteService = cacheIndicePosteService;
      this.cacheIndiceCoicopEchantillonService = cacheIndiceCoicopEchantillonService;
      this.cacheIndiceCoicopEchantillonMoisService = cacheIndiceCoicopEchantillonMoisService;
      this.cacheItemsCoicopService = cacheItemsCoicopService;
      this.cachePonderationCoicopService = cachePonderationCoicopService;
      this.cachePonderationPosteService = cachePonderationPosteService;
      this.indiceCoicopMensuelService = indiceCoicopMensuelService;

   }

   public void calculIndiceCoicop(Short annee, Short mois, EtatCalendrier etatCalendrier) throws NotFoundException {
      logger.info("Calcul des indices pour les différents niveau de coicop pour {}-{}", annee, mois);

      Optional<Echantillon> optionalEchantillon = cacheEchantillonsService.findByAnnee(annee);
      if (optionalEchantillon.isEmpty()) {
         throw new NotFoundException("Echantillon manquant pour l'année " + annee);
      }
      Echantillon echantillon = optionalEchantillon.get();

      Map<NiveauCoicop, List<IndiceCoicopMensuel>> indicesParNiveau = new EnumMap<>(NiveauCoicop.class);

      for (NiveauCoicop niveauCoicop : NiveauCoicop.getByRangDecroissant()) {
         if (niveauCoicop.getRang() == 0) break;
         List<IndiceCoicopMensuel> indicesCoicopParents = new ArrayList<>();
         logger.info("Traitement du niveau {} de la Coicop", niveauCoicop);
         List<? extends IndiceCoicopMensuelAbstract> indicesEnfants;
         if (niveauCoicop == NiveauCoicop.POSTE) {
            indicesEnfants = cacheIndicePosteService.findByAnneeMois(annee, mois);
         } else {
            indicesEnfants = indicesParNiveau.get(niveauCoicop);
         }
         if (indicesEnfants == null) {
            logger.warn("Aucun indice de niveau {} n'a été trouvé pour {}-{}. Impossible de calculer l'indice de niveau supérieur", niveauCoicop, annee, mois);
         } else {
            Map<AgregatCoicop, List<IndiceCoicopMensuelAbstract>> indicesEnfantsParAgregats = indicesEnfants.stream() //
               .flatMap(indice -> {
                  if (indice instanceof IndicePosteMensuel) {
                     IndicePosteMensuel indicePosteMensuel = (IndicePosteMensuel) indice;
                     IndicePosteMensuel indicePosteMensuelTotale = new IndicePosteMensuel(indicePosteMensuel);
                     IndicePosteMensuel indicePosteMensuelModeste = new IndicePosteMensuel(indicePosteMensuel);
                     IndicePosteMensuel indicePosteMensuelLoyer = new IndicePosteMensuel(indicePosteMensuel);
                     indicePosteMensuelTotale.setPopulation(Population.TOTALE);
                     indicePosteMensuelModeste.setPopulation(Population.MODESTE);
                     indicePosteMensuelLoyer.setPopulation(Population.LOYER);
                     return Stream.of(indicePosteMensuelTotale, indicePosteMensuelModeste, indicePosteMensuelLoyer);
                  }
                  return Stream.of(indice);
               }) //
               .collect(Collectors.groupingBy(
                  indice -> new AgregatCoicop(cacheItemsCoicopService.findById(indice.getItemCoicop().getParent().getId()).get(), indice.getPopulation(), indice.getTerritoire(), indice.getMois())));

            for (Entry<AgregatCoicop, List<IndiceCoicopMensuelAbstract>> entry : indicesEnfantsParAgregats.entrySet()) {
               AgregatCoicop agregat = entry.getKey();
               logger.info("Calcul de l'indice pour l'agrégat : {}", agregat);
               List<IndiceCoicopMensuelAbstract> indicesEnfantsAgregat = entry.getValue();
               Optional<IndiceCoicopMensuel> optionalIndiceParent = cacheIndiceCoicopEchantillonMoisService.findByItemCoicopTerritoirePopulation(agregat.getItemCoicopParent(), agregat.getTerritoire(),
                  agregat.getPopulation());
               IndiceCoicopMensuel indiceParent;
               if (optionalIndiceParent.isPresent()) {
                  indiceParent = optionalIndiceParent.get();
               } else {
                  indiceParent = new IndiceCoicopMensuel();
                  indiceParent.setMois(mois);
                  indiceParent.setEchantillon(echantillon);
                  indiceParent.setItemCoicop(agregat.getItemCoicopParent());
                  indiceParent.setPopulation(agregat.getPopulation());
                  indiceParent.setTerritoire(agregat.getTerritoire());
               }

               BigDecimal ipc = BigDecimal.ZERO;
               BigDecimal ipch = BigDecimal.ZERO;
               BigDecimal poidsIpc = BigDecimal.ZERO;
               BigDecimal poidsIpch = BigDecimal.ZERO;
               Optional<? extends Map<Long, ? extends PonderationCoicopAbstract>> ponderationParCodeCoicop;
               if (niveauCoicop == NiveauCoicop.POSTE) {
                  ponderationParCodeCoicop = cachePonderationPosteService.findByAgregatSansMois(agregat);
               } else {
                  ponderationParCodeCoicop = cachePonderationCoicopService.findByAgregatSansMois(agregat);
               }
               if (ponderationParCodeCoicop.isPresent()) {
                  for (IndiceCoicopMensuelAbstract indiceEnfant : indicesEnfantsAgregat) {
                     PonderationCoicopAbstract ponderationCoicop = ponderationParCodeCoicop.get().get(indiceEnfant.getItemCoicop().getId());
                     if (EtatCalendrier.PROVISOIRE.equals(etatCalendrier)) {
                        if (indiceEnfant.getIpcProvisoire() != null && ponderationCoicop.getPoidsIpcDansCoicop() != null) {
                           ipc = ipc.add(indiceEnfant.getIpcProvisoire().multiply(ponderationCoicop.getPoidsIpcDansCoicop()));
                           poidsIpc = poidsIpc.add(ponderationCoicop.getPoidsIpcDansCoicop());
                        }
                        if (indiceEnfant.getIpchProvisoire() != null && ponderationCoicop.getPoidsIpchDansCoicop() != null) {
                           ipch = ipch.add(indiceEnfant.getIpchProvisoire().multiply(ponderationCoicop.getPoidsIpchDansCoicop()));
                           poidsIpch = poidsIpch.add(ponderationCoicop.getPoidsIpchDansCoicop());
                        }
                     } else {
                        if (indiceEnfant.getIpc() != null && ponderationCoicop.getPoidsIpcDansCoicop() != null) {
                           ipc = ipc.add(indiceEnfant.getIpc().multiply(ponderationCoicop.getPoidsIpcDansCoicop()));
                           poidsIpc = poidsIpc.add(ponderationCoicop.getPoidsIpcDansCoicop());
                        }
                        if (indiceEnfant.getIpch() != null && ponderationCoicop.getPoidsIpchDansCoicop() != null) {
                           ipch = ipch.add(indiceEnfant.getIpch().multiply(ponderationCoicop.getPoidsIpchDansCoicop()));
                           poidsIpch = poidsIpch.add(ponderationCoicop.getPoidsIpchDansCoicop());
                        }
                     }
                  }
                  Optional<IndiceCoicopAnnuel> optionalIndiceAnnuel = cacheIndiceCoicopEchantillonService.findByItemCoicopTerritoirePopulation(indiceParent.getItemCoicop(),
                     indiceParent.getTerritoire(), indiceParent.getPopulation());
                  if (optionalIndiceAnnuel.isEmpty()) {
                     logger.warn("Aucun indice annuel n'a été trouvé pour cet agrégat. Aucun calcul n'a été fait.");
                  } else {
                     IndiceCoicopAnnuel indiceAnnuel = optionalIndiceAnnuel.get();
                     BigDecimal numerateurBaseDiffusion = indiceAnnuel.getIpcBaseDiffusion() != null ? ipc.multiply(indiceAnnuel.getIpcBaseDiffusion()) : BigDecimal.ZERO;
                     BigDecimal numerateurBaseDiffusionProvisoire = indiceAnnuel.getIpchBaseDiffusion() != null ? ipch.multiply(indiceAnnuel.getIpchBaseDiffusion()) : BigDecimal.ZERO;
                     if (EtatCalendrier.PROVISOIRE.equals(etatCalendrier)) {
                        indiceParent.setIpcProvisoire(DecimalesUtils.diviser(ipc, poidsIpc));
                        indiceParent.setIpcDiffusionProvisoire(DecimalesUtils.diviser(numerateurBaseDiffusion, poidsIpc.multiply(DecimalesUtils.valueOf(100))));
                        indiceParent.setIpchProvisoire(DecimalesUtils.diviser(ipch, poidsIpch));
                        indiceParent.setIpchDiffusionProvisoire(DecimalesUtils.diviser(numerateurBaseDiffusionProvisoire, poidsIpch.multiply(DecimalesUtils.valueOf(100))));
                        if (indiceParent.getIpcProvisoire() != null || indiceParent.getIpchProvisoire() != null) {
                           indicesCoicopParents.add(indiceParent);
                        }
                     } else {
                        indiceParent.setIpc(DecimalesUtils.diviser(ipc, poidsIpc));
                        indiceParent.setIpcDiffusion(DecimalesUtils.diviser(numerateurBaseDiffusion, poidsIpc.multiply(DecimalesUtils.valueOf(100))));
                        indiceParent.setIpch(DecimalesUtils.diviser(ipch, poidsIpch));
                        indiceParent.setIpchDiffusion(DecimalesUtils.diviser(numerateurBaseDiffusionProvisoire, poidsIpch.multiply(DecimalesUtils.valueOf(100))));
                        if (indiceParent.getIpc() != null || indiceParent.getIpch() != null) {
                           indicesCoicopParents.add(indiceParent);
                        }
                     }
                  }
               } else {
                  logger.warn("Aucune pondération n'a été trouvée pour cet agrégat. Aucun calcul n'a été fait.");
               }
            }
         }
         Optional<NiveauCoicop> niveauSuperieur = NiveauCoicop.getNiveauSuperieur(niveauCoicop);
         if (niveauSuperieur.isPresent()) {
            indicesParNiveau.put(niveauSuperieur.get(), indicesCoicopParents);
         }
      }

      List<IndiceCoicopMensuel> indicesAEnregistrer = indicesParNiveau.values().stream().flatMap(List::stream).collect(Collectors.toList());
      logger.info("Enregistrement des {} indices de regroupement coicop", indicesAEnregistrer.size());
      indiceCoicopMensuelService.persisteAll(indicesAEnregistrer);
   }

}
