package fr.insee.prismeipc.open.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import fr.insee.prismeipc.open.model.IndicePosteAnnuel;
import fr.insee.prismeipc.open.model.IndicePosteMensuel;
import fr.insee.prismeipc.open.service.CacheCalculIndicePosteService;

public class CacheCalculIndicePosteServiceTest implements CacheCalculIndicePosteService {

   // Indices Mensuels

   // Indices annuels
   private final static IndicePosteAnnuel INDICE_ANNUEL_POSTE_011111_METROPOLE_2022 = new IndicePosteAnnuel(DonneesTest.ITEM_COICOP_POSTE_011111, DonneesTest.ECHANTILLON_2022,
      DonneesTest.TERRITOIRE_METROPOLE//
      , new BigDecimal(110), new BigDecimal(115));
   private final static IndicePosteAnnuel INDICE_ANNUEL_POSTE_011111_GUADELOUPE_2022 = new IndicePosteAnnuel(DonneesTest.ITEM_COICOP_POSTE_011111, DonneesTest.ECHANTILLON_2022,
      DonneesTest.TERRITOIRE_GUADELOUPE//
      , new BigDecimal(50), new BigDecimal(200));

   private final static List<IndicePosteAnnuel> INDICES_ANNUELS = List.of(//
      INDICE_ANNUEL_POSTE_011111_METROPOLE_2022//
      , INDICE_ANNUEL_POSTE_011111_GUADELOUPE_2022//
   );

   @Override
   public Optional<IndicePosteMensuel> findByItemCoicopIdTerritoireId(Long itemCoicopId, Long territoireId) {
      return Optional.empty();
   }

   @Override
   public Optional<IndicePosteAnnuel> findIndicePosteAnnuelByItemCoicopIdTerritoireId(Long itemCoicopId, Long territoireId) {
      return INDICES_ANNUELS//
         .stream()//
         .filter(indice -> indice.getItemCoicop().getId().equals(itemCoicopId) && indice.getTerritoire().getId().equals(territoireId))//
         .findAny();
   }

}
