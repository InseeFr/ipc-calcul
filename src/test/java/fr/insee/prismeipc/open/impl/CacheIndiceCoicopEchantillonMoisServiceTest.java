package fr.insee.prismeipc.open.impl;

import java.util.List;
import java.util.Optional;

import fr.insee.prismeipc.open.model.IndiceCoicopMensuel;
import fr.insee.prismeipc.open.model.ItemCoicop;
import fr.insee.prismeipc.open.model.Territoire;
import fr.insee.prismeipc.open.model.enumeration.Population;
import fr.insee.prismeipc.open.service.CacheIndiceCoicopEchantillonMoisService;

public class CacheIndiceCoicopEchantillonMoisServiceTest implements CacheIndiceCoicopEchantillonMoisService {

   private final static IndiceCoicopMensuel INDICE_ENSEMBLE_METROPOLE_2022_10_LOYER = new IndiceCoicopMensuel(1L, DonneesTest.ITEM_COICOP_ENSEMBLE, DonneesTest.TERRITOIRE_METROPOLE,
      DonneesTest.ECHANTILLON_2022, Population.LOYER, (short) 10, //
      null, null, null, null, null, null, null, null);
   private final static IndiceCoicopMensuel INDICE_DIVISION_01_METROPOLE_2022_10_LOYER = new IndiceCoicopMensuel(1L, DonneesTest.ITEM_COICOP_DIVISION_01, DonneesTest.TERRITOIRE_METROPOLE,
      DonneesTest.ECHANTILLON_2022, Population.LOYER, (short) 10, //
      null, null, null, null, null, null, null, null);
   private final static IndiceCoicopMensuel INDICE_GROUPE_011_METROPOLE_2022_10_LOYER = new IndiceCoicopMensuel(1L, DonneesTest.ITEM_COICOP_GROUPE_011, DonneesTest.TERRITOIRE_METROPOLE,
      DonneesTest.ECHANTILLON_2022, Population.LOYER, (short) 10, //
      null, null, null, null, null, null, null, null);
   private final static IndiceCoicopMensuel INDICE_CLASSE_0111_METROPOLE_2022_10_LOYER = new IndiceCoicopMensuel(1L, DonneesTest.ITEM_COICOP_CLASSE_0111, DonneesTest.TERRITOIRE_METROPOLE,
      DonneesTest.ECHANTILLON_2022, Population.LOYER, (short) 10, //
      null, null, null, null, null, null, null, null);
   private final static IndiceCoicopMensuel INDICE_SOUS_CLASSE_01111_METROPOLE_2022_10_LOYER = new IndiceCoicopMensuel(1L, DonneesTest.ITEM_COICOP_SOUS_CLASSE_01111, DonneesTest.TERRITOIRE_METROPOLE,
      DonneesTest.ECHANTILLON_2022, Population.LOYER, (short) 10, //
      null, null, null, null, null, null, null, null);
   private final static IndiceCoicopMensuel INDICE_ENSEMBLE_GUADELOUPE_2022_10_TOTALE = new IndiceCoicopMensuel(1L, DonneesTest.ITEM_COICOP_ENSEMBLE, DonneesTest.TERRITOIRE_GUADELOUPE,
      DonneesTest.ECHANTILLON_2022, Population.TOTALE, (short) 10, //
      null, null, null, null, null, null, null, null);
   private final static IndiceCoicopMensuel INDICE_DIVISION_01_GUADELOUPE_2022_10_TOTALE = new IndiceCoicopMensuel(1L, DonneesTest.ITEM_COICOP_DIVISION_01, DonneesTest.TERRITOIRE_GUADELOUPE,
      DonneesTest.ECHANTILLON_2022, Population.TOTALE, (short) 10, //
      null, null, null, null, null, null, null, null);
   private final static IndiceCoicopMensuel INDICE_GROUPE_011_GUADELOUPE_2022_10_TOTALE = new IndiceCoicopMensuel(1L, DonneesTest.ITEM_COICOP_GROUPE_011, DonneesTest.TERRITOIRE_GUADELOUPE,
      DonneesTest.ECHANTILLON_2022, Population.TOTALE, (short) 10, //
      null, null, null, null, null, null, null, null);
   private final static IndiceCoicopMensuel INDICE_CLASSE_0111_GUADELOUPE_2022_10_TOTALE = new IndiceCoicopMensuel(1L, DonneesTest.ITEM_COICOP_CLASSE_0111, DonneesTest.TERRITOIRE_GUADELOUPE,
      DonneesTest.ECHANTILLON_2022, Population.TOTALE, (short) 10, //
      null, null, null, null, null, null, null, null);
   private final static IndiceCoicopMensuel INDICE_SOUS_CLASSE_01111_GUADELOUPE_2022_10_TOTALE = new IndiceCoicopMensuel(1L, DonneesTest.ITEM_COICOP_SOUS_CLASSE_01111,
      DonneesTest.TERRITOIRE_GUADELOUPE, DonneesTest.ECHANTILLON_2022, Population.TOTALE, (short) 10, //
      null, null, null, null, null, null, null, null);

   private final static List<IndiceCoicopMensuel> INDICES_COICOP = List.of(//
      INDICE_ENSEMBLE_METROPOLE_2022_10_LOYER//
      , INDICE_DIVISION_01_METROPOLE_2022_10_LOYER//
      , INDICE_GROUPE_011_METROPOLE_2022_10_LOYER//
      , INDICE_CLASSE_0111_METROPOLE_2022_10_LOYER//
      , INDICE_SOUS_CLASSE_01111_METROPOLE_2022_10_LOYER//
      , INDICE_ENSEMBLE_GUADELOUPE_2022_10_TOTALE//
      , INDICE_DIVISION_01_GUADELOUPE_2022_10_TOTALE//
      , INDICE_GROUPE_011_GUADELOUPE_2022_10_TOTALE//
      , INDICE_CLASSE_0111_GUADELOUPE_2022_10_TOTALE//
      , INDICE_SOUS_CLASSE_01111_GUADELOUPE_2022_10_TOTALE//
   );

   @Override
   public Optional<IndiceCoicopMensuel> findByItemCoicopTerritoirePopulation(ItemCoicop itemCoicop, Territoire territoire, Population population) {
      return INDICES_COICOP.stream() //
         .filter(indice -> //
         indice.getItemCoicop().getId().equals(itemCoicop.getId()) //
            && indice.getTerritoire().getId().equals(territoire.getId()) //
            && indice.getPopulation() == population //
         ).findFirst();
   }

}
