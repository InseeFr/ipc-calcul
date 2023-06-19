package fr.insee.prismeipc.open.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.insee.prismeipc.open.exception.CalculException;
import fr.insee.prismeipc.open.model.Echantillon;
import fr.insee.prismeipc.open.model.IndicePosteAnnuel;
import fr.insee.prismeipc.open.model.IndicePosteMensuel;
import fr.insee.prismeipc.open.model.IndiceVarieteMensuelAbstract;
import fr.insee.prismeipc.open.model.ItemCoicop;
import fr.insee.prismeipc.open.model.Territoire;
import fr.insee.prismeipc.open.model.enumeration.EtatCalendrier;
import fr.insee.prismeipc.open.service.CacheCalculIndicePosteService;
import fr.insee.prismeipc.open.service.CacheCalculIndiceVarieteService;
import fr.insee.prismeipc.open.service.IndicePosteMensuelService;
import fr.insee.prismeipc.open.utils.DecimalesUtils;

public class CalculIndicePosteService {

   private static final Logger logger = LoggerFactory.getLogger(CalculIndicePosteService.class);

   private IndicePosteMensuelService indicePosteMensuelService;
   private CacheCalculIndicePosteService cacheCalculIndicePosteService;
   private CacheCalculIndiceVarieteService cacheCalculIndiceVarieteService;

   public CalculIndicePosteService() {
      super();
   }

   public CalculIndicePosteService(CacheCalculIndiceVarieteService cacheCalculIndiceVarieteService, IndicePosteMensuelService indicePosteMensuelService,
      CacheCalculIndicePosteService cacheCalculIndicePosteService) {
      super();
      this.cacheCalculIndiceVarieteService = cacheCalculIndiceVarieteService;
      this.indicePosteMensuelService = indicePosteMensuelService;
      this.cacheCalculIndicePosteService = cacheCalculIndicePosteService;
   }

   public void calculIndicePoste(Short mois, EtatCalendrier etatCalendrier) {
      // Reader
      Map<ItemCoicop, Map<Territoire, List<IndiceVarieteMensuelAbstract>>> indicesVarieteMensuelParItemCoicopEtTerritoire = cacheCalculIndiceVarieteService.getAllMensuelByPosteAndTerritoire();//
      List<IndicePosteMensuel> resultats = new ArrayList<>();

      for (Map.Entry<ItemCoicop, Map<Territoire, List<IndiceVarieteMensuelAbstract>>> itemCoicopMap : indicesVarieteMensuelParItemCoicopEtTerritoire.entrySet()) {
         ItemCoicop itemCoicop = itemCoicopMap.getKey();
         for (Map.Entry<Territoire, List<IndiceVarieteMensuelAbstract>> territoireMap : itemCoicopMap.getValue().entrySet()) {
            Territoire territoire = territoireMap.getKey();
            // Processor
            IndicePosteMensuel resultat = traiterItemCoicopTerritoire(itemCoicop, territoire, territoireMap.getValue(), mois, etatCalendrier);
            if (resultat != null) {
               resultats.add(resultat);
            }
         }
      }
      // Writer
      indicePosteMensuelService.saveAll(resultats);
   }

   private IndicePosteMensuel traiterItemCoicopTerritoire(ItemCoicop itemCoicop, Territoire territoire, List<IndiceVarieteMensuelAbstract> indicesVarieteMensuel, Short mois,
      EtatCalendrier etatCalendrier) {
      logger.info("Traitement de itemCoicop {} territoireId {} avec {} indiceVarieteMensuel", itemCoicop.getCode(), territoire.getCode(), indicesVarieteMensuel.size());

      Optional<IndicePosteMensuel> opt = cacheCalculIndicePosteService.findByItemCoicopIdTerritoireId(itemCoicop.getId(), territoire.getId());
      IndicePosteMensuel resultat = null;

      if (opt.isPresent()) {
         resultat = opt.get();
      } else {
         Echantillon echantillon = indicesVarieteMensuel.get(0).getVarieteEchantillon().getEchantillon();
         resultat = new IndicePosteMensuel(itemCoicop, territoire, echantillon, mois);
      }

      if (indicesVarieteMensuel.stream().anyMatch(ivm -> Boolean.TRUE.equals(ivm.getVarieteEchantillon().getParticipeIpc()))) {
         calculerDonneesIpc(itemCoicop, territoire, indicesVarieteMensuel, etatCalendrier, resultat);
      }
      if (indicesVarieteMensuel.stream().anyMatch(ivm -> Boolean.TRUE.equals(ivm.getVarieteEchantillon().getParticipeIpch()))) {
         calculerDonneesIpch(itemCoicop, territoire, indicesVarieteMensuel, etatCalendrier, resultat);
      }
      return resultat;
   }

   private void calculerDonneesIpc(ItemCoicop itemCoicop, Territoire territoire, List<IndiceVarieteMensuelAbstract> indicesVarieteMensuel, EtatCalendrier etatCalendrier, IndicePosteMensuel resultat) {
      List<IndiceVarieteMensuelAbstract> ipcVarieteMensuel = indicesVarieteMensuel.stream().filter(ivm -> ivm.getVarieteEchantillon().getParticipeIpc()).collect(Collectors.toList());
      logger.info("IndiceVarieteMensuel participant au calcul ipc {}", ipcVarieteMensuel.stream().map(IndiceVarieteMensuelAbstract::getId).collect(Collectors.toList()));
      boolean possedePonderationNull = ipcVarieteMensuel.stream()
         .anyMatch(ivm -> ivm.getVarieteEchantillon().getPonderationVarieteEchantillon() == null || ivm.getVarieteEchantillon().getPonderationVarieteEchantillon().getPoidsIpcDansPoste() == null);
      if (!possedePonderationNull) {
         BigDecimal ipcPoste;
         if (EtatCalendrier.PROVISOIRE.equals(etatCalendrier)) {
            BigDecimal numerateurIpcPoste = ipcVarieteMensuel.stream()
               .map(ivm -> ivm.getIpcProvisoire().multiply(DecimalesUtils.valueOf(ivm.getVarieteEchantillon().getPonderationVarieteEchantillon().getPoidsIpcDansPoste())))
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            ipcPoste = DecimalesUtils.diviser(numerateurIpcPoste, DecimalesUtils.valueOf(100));
            resultat.setIpcProvisoire(ipcPoste);
         } else {
            BigDecimal numerateurIpcPoste = ipcVarieteMensuel.stream()
               .map(ivm -> ivm.getIpc().multiply(DecimalesUtils.valueOf(ivm.getVarieteEchantillon().getPonderationVarieteEchantillon().getPoidsIpcDansPoste())))
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            ipcPoste = DecimalesUtils.diviser(numerateurIpcPoste, DecimalesUtils.valueOf(100));
            resultat.setIpc(ipcPoste);
         }
         Optional<IndicePosteAnnuel> optIpa = cacheCalculIndicePosteService.findIndicePosteAnnuelByItemCoicopIdTerritoireId(itemCoicop.getId(), territoire.getId());
         if (optIpa.isPresent()) {
            IndicePosteAnnuel ipa = optIpa.get();
            BigDecimal numerateurIpcPosteDiffusion = ipa.getIpcBaseDiffusion().multiply(ipcPoste);
            BigDecimal ipcPosteDiffusion = DecimalesUtils.diviser(numerateurIpcPosteDiffusion, DecimalesUtils.valueOf(100));
            if (EtatCalendrier.PROVISOIRE.equals(etatCalendrier)) {
               resultat.setIpcDiffusionProvisoire(ipcPosteDiffusion);
            } else {
               resultat.setIpcDiffusion(ipcPosteDiffusion);
            }
         } else {
            logger.error("Aucun IndicePosteAnnuel trouvé");
            throw new CalculException("Aucun IndicePosteAnnuel trouvé");
         }
      }
   }

   private void calculerDonneesIpch(ItemCoicop itemCoicop, Territoire territoire, List<IndiceVarieteMensuelAbstract> indicesVarieteMensuel, EtatCalendrier etatCalendrier,
      IndicePosteMensuel resultat) {
      List<IndiceVarieteMensuelAbstract> ipchVarieteMensuel = indicesVarieteMensuel.stream().filter(ivm -> ivm.getVarieteEchantillon().getParticipeIpch()).collect(Collectors.toList());
      logger.info("IndiceVarieteMensuel participant au calcul ipch {}", ipchVarieteMensuel.stream().map(IndiceVarieteMensuelAbstract::getId).collect(Collectors.toList()));
      boolean possedePonderationNull = ipchVarieteMensuel.stream()
         .anyMatch(ivm -> ivm.getVarieteEchantillon().getPonderationVarieteEchantillon() == null || ivm.getVarieteEchantillon().getPonderationVarieteEchantillon().getPoidsIpchDansPoste() == null);
      BigDecimal cent = DecimalesUtils.valueOf(100);
      if (!possedePonderationNull) {
         BigDecimal ipchPoste;
         if (EtatCalendrier.PROVISOIRE.equals(etatCalendrier)) {
            BigDecimal numerateurIpchPoste = ipchVarieteMensuel.stream()
               .map(ivm -> ivm.getIpchProvisoire().multiply(DecimalesUtils.valueOf(ivm.getVarieteEchantillon().getPonderationVarieteEchantillon().getPoidsIpchDansPoste())))
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            ipchPoste = DecimalesUtils.diviser(numerateurIpchPoste, cent);
            resultat.setIpchProvisoire(ipchPoste);
         } else {
            BigDecimal numerateurIpchPoste = ipchVarieteMensuel.stream()
               .map(ivm -> ivm.getIpch().multiply(DecimalesUtils.valueOf(ivm.getVarieteEchantillon().getPonderationVarieteEchantillon().getPoidsIpchDansPoste())))
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            ipchPoste = DecimalesUtils.diviser(numerateurIpchPoste, cent);
            resultat.setIpch(ipchPoste);
         }
         Optional<IndicePosteAnnuel> optIpa = cacheCalculIndicePosteService.findIndicePosteAnnuelByItemCoicopIdTerritoireId(itemCoicop.getId(), territoire.getId());
         if (optIpa.isPresent()) {
            IndicePosteAnnuel ipa = optIpa.get();
            BigDecimal ipchBaseDiffusion = ipa.getIpchBaseDiffusion();
            if (ipchBaseDiffusion == null && territoire.isMayotte()) {
               // TODO ATTENTION, verrue à supprimer, l'ipch de mayotte est erronné, les données sources sont mal remplies et calculées, on remplace les valeurs nulles par 100 pour ne pas échouer mais
               // le problème est traité par l'équipe stat pour apporter une solution pérenne
               ipchBaseDiffusion = DecimalesUtils.valueOf(100);
            }
            BigDecimal numerateurIpchPosteDiffusion = ipchBaseDiffusion.multiply(ipchPoste);
            BigDecimal ipchPosteDiffusion = DecimalesUtils.diviser(numerateurIpchPosteDiffusion, cent);
            if (EtatCalendrier.PROVISOIRE.equals(etatCalendrier)) {
               resultat.setIpchDiffusionProvisoire(ipchPosteDiffusion);
            } else {
               resultat.setIpchDiffusion(ipchPosteDiffusion);
            }
         } else {
            logger.error("Aucun IndicePosteAnnuel trouvé");
            throw new CalculException("Aucun IndicePosteAnnuel trouvé");
         }
      }
   }
}
