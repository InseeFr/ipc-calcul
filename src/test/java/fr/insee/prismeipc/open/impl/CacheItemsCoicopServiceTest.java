package fr.insee.prismeipc.open.impl;

import java.util.Map;
import java.util.Optional;

import fr.insee.prismeipc.open.model.ItemCoicop;
import fr.insee.prismeipc.open.service.CacheItemsCoicopService;

public class CacheItemsCoicopServiceTest implements CacheItemsCoicopService {

   private static final Map<Long, ItemCoicop> ITEMS_COICOP = Map.of(//
      DonneesTest.ITEM_COICOP_ENSEMBLE.getId(), DonneesTest.ITEM_COICOP_ENSEMBLE, //
      DonneesTest.ITEM_COICOP_DIVISION_01.getId(), DonneesTest.ITEM_COICOP_DIVISION_01, //
      DonneesTest.ITEM_COICOP_GROUPE_011.getId(), DonneesTest.ITEM_COICOP_GROUPE_011, //
      DonneesTest.ITEM_COICOP_CLASSE_0111.getId(), DonneesTest.ITEM_COICOP_CLASSE_0111, //
      DonneesTest.ITEM_COICOP_SOUS_CLASSE_01111.getId(), DonneesTest.ITEM_COICOP_SOUS_CLASSE_01111, //
      DonneesTest.ITEM_COICOP_SOUS_CLASSE_01112.getId(), DonneesTest.ITEM_COICOP_SOUS_CLASSE_01112, //
      DonneesTest.ITEM_COICOP_POSTE_011111.getId(), DonneesTest.ITEM_COICOP_POSTE_011111, //
      DonneesTest.ITEM_COICOP_POSTE_011122.getId(), DonneesTest.ITEM_COICOP_POSTE_011122, //
      DonneesTest.ITEM_COICOP_POSTE_011121.getId(), DonneesTest.ITEM_COICOP_POSTE_011121//
   );

   @Override
   public Optional<ItemCoicop> findById(Long id) {
      return Optional.of(ITEMS_COICOP.get(id));
   }

}
