package fr.insee.prismeipc.open.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import fr.insee.prismeipc.open.model.IndiceCoicopMensuelAbstract;
import fr.insee.prismeipc.open.model.IndicePosteMensuel;
import fr.insee.prismeipc.open.service.CacheIndicePosteService;

public class CacheIndicePosteServiceTest implements CacheIndicePosteService {

   private static final IndicePosteMensuel INDICE_MENSUEL_POSTE_011111_METROPOLE_2022_10 = new IndicePosteMensuel(1L, DonneesTest.ITEM_COICOP_POSTE_011111, DonneesTest.TERRITOIRE_METROPOLE,
      DonneesTest.ECHANTILLON_2022, null, (short) 10, //
      null, null, new BigDecimal("100"), new BigDecimal("200"), null, null, null, null);
   private static final IndicePosteMensuel INDICE_MENSUEL_POSTE_011111_GUADELOUPE_2022_10 = new IndicePosteMensuel(2L, DonneesTest.ITEM_COICOP_POSTE_011111, DonneesTest.TERRITOIRE_GUADELOUPE,
      DonneesTest.ECHANTILLON_2022, null, (short) 10, //
      null, null, new BigDecimal("1000"), new BigDecimal("2000"), null, null, null, null);

   private static final List<IndiceCoicopMensuelAbstract> INDICES_POSTE = List.of(//
      INDICE_MENSUEL_POSTE_011111_METROPOLE_2022_10//
      , INDICE_MENSUEL_POSTE_011111_GUADELOUPE_2022_10//
   );

   @Override
   public List<? extends IndiceCoicopMensuelAbstract> findByAnneeMois(Short annee, Short mois) {
      return INDICES_POSTE.stream()//
         .filter(indice -> indice.getEchantillon().getAnnee().equals(annee) && mois.equals(indice.getMois()))//
         .collect(Collectors.toList());
   }

}
