package fr.insee.prismeipc.open.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import fr.insee.prismeipc.open.model.IndiceCoicopAnnuel;
import fr.insee.prismeipc.open.model.ItemCoicop;
import fr.insee.prismeipc.open.model.Territoire;
import fr.insee.prismeipc.open.model.enumeration.Population;
import fr.insee.prismeipc.open.service.CacheIndiceCoicopEchantillonService;

public class CacheIndiceCoicopEchantillonServiceTest implements CacheIndiceCoicopEchantillonService {

   // Indices Population LOYER
   private final static IndiceCoicopAnnuel INDICE_ANNUEL_ENSEMBLE_METROPOLE_2022_LOYER = new IndiceCoicopAnnuel(1L, DonneesTest.ITEM_COICOP_ENSEMBLE, DonneesTest.TERRITOIRE_METROPOLE,
      DonneesTest.ECHANTILLON_2022, Population.LOYER, //
      new BigDecimal("50"), new BigDecimal("50"));
   private final static IndiceCoicopAnnuel INDICE_ANNUEL_DIVISION_01_METROPOLE_2022_LOYER = new IndiceCoicopAnnuel(2L, DonneesTest.ITEM_COICOP_DIVISION_01, DonneesTest.TERRITOIRE_METROPOLE,
      DonneesTest.ECHANTILLON_2022, Population.LOYER, //
      new BigDecimal("50"), new BigDecimal("50"));
   private final static IndiceCoicopAnnuel INDICE_ANNUEL_GROUPE_011_METROPOLE_2022_LOYER = new IndiceCoicopAnnuel(3L, DonneesTest.ITEM_COICOP_GROUPE_011, DonneesTest.TERRITOIRE_METROPOLE,
      DonneesTest.ECHANTILLON_2022, Population.LOYER, //
      new BigDecimal("50"), new BigDecimal("50"));
   private final static IndiceCoicopAnnuel INDICE_ANNUEL_CLASSE_0111_METROPOLE_2022_LOYER = new IndiceCoicopAnnuel(4L, DonneesTest.ITEM_COICOP_CLASSE_0111, DonneesTest.TERRITOIRE_METROPOLE,
      DonneesTest.ECHANTILLON_2022, Population.LOYER, //
      new BigDecimal("50"), new BigDecimal("50"));
   private final static IndiceCoicopAnnuel INDICE_ANNUEL_SOUS_CLASSE_01111_METROPOLE_2022_LOYER = new IndiceCoicopAnnuel(5L, DonneesTest.ITEM_COICOP_SOUS_CLASSE_01111,
      DonneesTest.TERRITOIRE_METROPOLE, DonneesTest.ECHANTILLON_2022, Population.LOYER, //
      new BigDecimal("50"), new BigDecimal("50"));

   // Indices Population TOTALE
   private final static IndiceCoicopAnnuel INDICE_ANNUEL_ENSEMBLE_GUADELOUPE_2022_TOTALE = new IndiceCoicopAnnuel(6L, DonneesTest.ITEM_COICOP_ENSEMBLE, DonneesTest.TERRITOIRE_GUADELOUPE,
      DonneesTest.ECHANTILLON_2022, Population.TOTALE, //
      new BigDecimal("100"), new BigDecimal("200"));
   private final static IndiceCoicopAnnuel INDICE_ANNUEL_DIVISION_01_GUADELOUPE_2022_TOTALE = new IndiceCoicopAnnuel(7L, DonneesTest.ITEM_COICOP_DIVISION_01, DonneesTest.TERRITOIRE_GUADELOUPE,
      DonneesTest.ECHANTILLON_2022, Population.TOTALE, //
      new BigDecimal("100"), new BigDecimal("200"));
   private final static IndiceCoicopAnnuel INDICE_ANNUEL_GROUPE_011_GUADELOUPE_2022_TOTALE = new IndiceCoicopAnnuel(8L, DonneesTest.ITEM_COICOP_GROUPE_011, DonneesTest.TERRITOIRE_GUADELOUPE,
      DonneesTest.ECHANTILLON_2022, Population.TOTALE, //
      new BigDecimal("100"), new BigDecimal("200"));
   private final static IndiceCoicopAnnuel INDICE_ANNUEL_CLASSE_0111_GUADELOUPE_2022_TOTALE = new IndiceCoicopAnnuel(9L, DonneesTest.ITEM_COICOP_CLASSE_0111, DonneesTest.TERRITOIRE_GUADELOUPE,
      DonneesTest.ECHANTILLON_2022, Population.TOTALE, //
      new BigDecimal("100"), new BigDecimal("200"));
   private final static IndiceCoicopAnnuel INDICE_ANNUEL_SOUS_CLASSE_01111_GUADELOUPE_2022_TOTALE = new IndiceCoicopAnnuel(10L, DonneesTest.ITEM_COICOP_SOUS_CLASSE_01111,
      DonneesTest.TERRITOIRE_GUADELOUPE, DonneesTest.ECHANTILLON_2022, Population.TOTALE, //
      new BigDecimal("100"), new BigDecimal("200"));

   private final static List<IndiceCoicopAnnuel> INDICES_COICOP_ANNUELS = List.of(//
      INDICE_ANNUEL_ENSEMBLE_METROPOLE_2022_LOYER, //
      INDICE_ANNUEL_DIVISION_01_METROPOLE_2022_LOYER, //
      INDICE_ANNUEL_GROUPE_011_METROPOLE_2022_LOYER, //
      INDICE_ANNUEL_CLASSE_0111_METROPOLE_2022_LOYER, //
      INDICE_ANNUEL_SOUS_CLASSE_01111_METROPOLE_2022_LOYER, //
      INDICE_ANNUEL_ENSEMBLE_GUADELOUPE_2022_TOTALE, //
      INDICE_ANNUEL_DIVISION_01_GUADELOUPE_2022_TOTALE, //
      INDICE_ANNUEL_GROUPE_011_GUADELOUPE_2022_TOTALE, //
      INDICE_ANNUEL_CLASSE_0111_GUADELOUPE_2022_TOTALE, //
      INDICE_ANNUEL_SOUS_CLASSE_01111_GUADELOUPE_2022_TOTALE//
   );

   @Override
   public Optional<IndiceCoicopAnnuel> findByItemCoicopTerritoirePopulation(ItemCoicop itemCoicop, Territoire territoire, Population population) {
      return INDICES_COICOP_ANNUELS.stream() //
         .filter(indice -> //
         indice.getItemCoicop().getId().equals(itemCoicop.getId()) //
            && indice.getTerritoire().getId().equals(territoire.getId()) //
            && indice.getPopulation() == population //
         ).findFirst();
   }

}
