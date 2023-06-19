package fr.insee.prismeipc.open.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import fr.insee.prismeipc.open.model.AgregatCoicop;
import fr.insee.prismeipc.open.model.PonderationCoicop;
import fr.insee.prismeipc.open.model.PonderationCoicopAbstract;
import fr.insee.prismeipc.open.model.enumeration.Population;
import fr.insee.prismeipc.open.service.CachePonderationCoicopService;

public class CachePonderationCoicopServiceTest implements CachePonderationCoicopService {

   private final static PonderationCoicop PONDERATION_COICOP_ENSEMBLE_METROPOLE_2022_LOYER = new PonderationCoicop(DonneesTest.ITEM_COICOP_ENSEMBLE, DonneesTest.TERRITOIRE_METROPOLE,
      DonneesTest.ECHANTILLON_2022, Population.LOYER, //
      new BigDecimal("50"), 50, new BigDecimal("999"), 999);
   private final static PonderationCoicop PONDERATION_COICOP_DIVISION_01_METROPOLE_2022_LOYER = new PonderationCoicop(DonneesTest.ITEM_COICOP_DIVISION_01, DonneesTest.TERRITOIRE_METROPOLE,
      DonneesTest.ECHANTILLON_2022, Population.LOYER, //
      new BigDecimal("50"), 50, new BigDecimal("999"), 999);
   private final static PonderationCoicop PONDERATION_COICOP_GROUPE_011_METROPOLE_2022_LOYER = new PonderationCoicop(DonneesTest.ITEM_COICOP_GROUPE_011, DonneesTest.TERRITOIRE_METROPOLE,
      DonneesTest.ECHANTILLON_2022, Population.LOYER, //
      new BigDecimal("50"), 50, new BigDecimal("999"), 999);
   private final static PonderationCoicop PONDERATION_COICOP_CLASSE_0111_METROPOLE_2022_LOYER = new PonderationCoicop(DonneesTest.ITEM_COICOP_CLASSE_0111, DonneesTest.TERRITOIRE_METROPOLE,
      DonneesTest.ECHANTILLON_2022, Population.LOYER, //
      new BigDecimal("50"), 50, new BigDecimal("999"), 999);
   private final static PonderationCoicop PONDERATION_COICOP_SOUS_CLASSE_01111_METROPOLE_2022_LOYER = new PonderationCoicop(DonneesTest.ITEM_COICOP_SOUS_CLASSE_01111, DonneesTest.TERRITOIRE_METROPOLE,
      DonneesTest.ECHANTILLON_2022, Population.LOYER, //
      new BigDecimal("50"), 50, new BigDecimal("999"), 999);

   private final static PonderationCoicop PONDERATION_COICOP_ENSEMBLE_GUADELOUPE_2022_TOTALE = new PonderationCoicop(DonneesTest.ITEM_COICOP_ENSEMBLE, DonneesTest.TERRITOIRE_GUADELOUPE,
      DonneesTest.ECHANTILLON_2022, Population.TOTALE, //
      new BigDecimal("75"), 10, new BigDecimal("999"), 999);
   private final static PonderationCoicop PONDERATION_COICOP_DIVISION_01_GUADELOUPE_2022_TOTALE = new PonderationCoicop(DonneesTest.ITEM_COICOP_DIVISION_01, DonneesTest.TERRITOIRE_GUADELOUPE,
      DonneesTest.ECHANTILLON_2022, Population.TOTALE, //
      new BigDecimal("75"), 10, new BigDecimal("999"), 999);
   private final static PonderationCoicop PONDERATION_COICOP_GROUPE_011_GUADELOUPE_2022_TOTALE = new PonderationCoicop(DonneesTest.ITEM_COICOP_GROUPE_011, DonneesTest.TERRITOIRE_GUADELOUPE,
      DonneesTest.ECHANTILLON_2022, Population.TOTALE, //
      new BigDecimal("75"), 10, new BigDecimal("999"), 999);
   private final static PonderationCoicop PONDERATION_COICOP_CLASSE_0111_GUADELOUPE_2022_TOTALE = new PonderationCoicop(DonneesTest.ITEM_COICOP_CLASSE_0111, DonneesTest.TERRITOIRE_GUADELOUPE,
      DonneesTest.ECHANTILLON_2022, Population.TOTALE, //
      new BigDecimal("75"), 10, new BigDecimal("999"), 999);
   private final static PonderationCoicop PONDERATION_COICOP_SOUS_CLASSE_01111_GUADELOUPE_2022_TOTALE = new PonderationCoicop(DonneesTest.ITEM_COICOP_SOUS_CLASSE_01111,
      DonneesTest.TERRITOIRE_GUADELOUPE, DonneesTest.ECHANTILLON_2022, Population.TOTALE, //
      new BigDecimal("75"), 10, new BigDecimal("999"), 999);

   private final static List<PonderationCoicop> PONDERATIONS_COICOP = List.of(//
      PONDERATION_COICOP_ENSEMBLE_METROPOLE_2022_LOYER//
      , PONDERATION_COICOP_DIVISION_01_METROPOLE_2022_LOYER//
      , PONDERATION_COICOP_GROUPE_011_METROPOLE_2022_LOYER//
      , PONDERATION_COICOP_CLASSE_0111_METROPOLE_2022_LOYER//
      , PONDERATION_COICOP_SOUS_CLASSE_01111_METROPOLE_2022_LOYER//
      , PONDERATION_COICOP_ENSEMBLE_GUADELOUPE_2022_TOTALE//
      , PONDERATION_COICOP_DIVISION_01_GUADELOUPE_2022_TOTALE//
      , PONDERATION_COICOP_GROUPE_011_GUADELOUPE_2022_TOTALE//
      , PONDERATION_COICOP_CLASSE_0111_GUADELOUPE_2022_TOTALE//
      , PONDERATION_COICOP_SOUS_CLASSE_01111_GUADELOUPE_2022_TOTALE//
   );

   @Override
   public Optional<? extends Map<Long, ? extends PonderationCoicopAbstract>> findByAgregatSansMois(AgregatCoicop agregat) {
      return Optional.of(PONDERATIONS_COICOP.stream() //
         .filter(ponderation -> //
         (ponderation.getItemCoicop().getParent() != null && ponderation.getItemCoicop().getParent().getId().equals(agregat.getItemCoicopParent().getId())) //
            && ponderation.getTerritoire().getId().equals(agregat.getTerritoire().getId()) //
            && ponderation.getPopulation() == agregat.getPopulation() //
         ).collect(Collectors.toMap(ponderation -> ponderation.getItemCoicop().getId(), ponderation -> ponderation)));
   }

}
