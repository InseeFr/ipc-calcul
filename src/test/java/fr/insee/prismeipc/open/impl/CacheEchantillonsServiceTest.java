package fr.insee.prismeipc.open.impl;

import java.util.Map;
import java.util.Optional;

import fr.insee.prismeipc.open.model.Echantillon;
import fr.insee.prismeipc.open.service.CacheEchantillonsService;

public class CacheEchantillonsServiceTest implements CacheEchantillonsService {

   private final static Map<Short, Echantillon> ECHANTILLONS = Map.of(//
      (short) 2022, DonneesTest.ECHANTILLON_2022 //
   );

   @Override
   public Optional<Echantillon> findByAnnee(Short annee) {
      return Optional.of(ECHANTILLONS.get(annee));
   }

}
