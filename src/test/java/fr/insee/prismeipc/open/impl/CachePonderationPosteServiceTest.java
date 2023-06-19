package fr.insee.prismeipc.open.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import fr.insee.prismeipc.open.model.AgregatCoicop;
import fr.insee.prismeipc.open.model.PonderationCoicopAbstract;
import fr.insee.prismeipc.open.model.PonderationPoste;
import fr.insee.prismeipc.open.model.enumeration.Population;
import fr.insee.prismeipc.open.service.CachePonderationPosteService;

public class CachePonderationPosteServiceTest implements CachePonderationPosteService {

   private static final PonderationPoste PONDERATION_POSTE_011111_METROPOLE_2022_LOYER = new PonderationPoste(DonneesTest.ITEM_COICOP_POSTE_011111, DonneesTest.TERRITOIRE_METROPOLE,
      DonneesTest.ECHANTILLON_2022, Population.LOYER, //
      BigDecimal.valueOf(50), 50, BigDecimal.valueOf(999), 999);
   private static final PonderationPoste PONDERATION_POSTE_011111_GUADELOUPE_2022_TOTALE = new PonderationPoste(DonneesTest.ITEM_COICOP_POSTE_011111, DonneesTest.TERRITOIRE_GUADELOUPE,
      DonneesTest.ECHANTILLON_2022, Population.TOTALE, //
      BigDecimal.valueOf(75), 10, BigDecimal.valueOf(999), 999);

   private final static List<PonderationPoste> PONDERATIONS_POSTE = List.of(//
      PONDERATION_POSTE_011111_METROPOLE_2022_LOYER//
      , PONDERATION_POSTE_011111_GUADELOUPE_2022_TOTALE//
   );

   @Override
   public Optional<? extends Map<Long, ? extends PonderationCoicopAbstract>> findByAgregatSansMois(AgregatCoicop agregat) {
      Map<Long, ? extends PonderationCoicopAbstract> map = PONDERATIONS_POSTE.stream() //
         .filter(ponderation -> //
         ponderation.getItemCoicop().getParent().getId().equals(agregat.getItemCoicopParent().getId()) //
            && ponderation.getTerritoire().getId().equals(agregat.getTerritoire().getId()) //
            && ponderation.getPopulation() == agregat.getPopulation() //
         )//
         .collect(Collectors.toMap(ponderation -> ponderation.getItemCoicop().getId(), ponderation -> ponderation));
      if (map.isEmpty()) return Optional.empty();
      return Optional.of(map);
   }

}
