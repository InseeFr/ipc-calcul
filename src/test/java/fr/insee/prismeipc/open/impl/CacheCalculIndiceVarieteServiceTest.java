package fr.insee.prismeipc.open.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import fr.insee.prismeipc.open.model.IndiceVarieteMensuel;
import fr.insee.prismeipc.open.model.IndiceVarieteMensuelAbstract;
import fr.insee.prismeipc.open.model.ItemCoicop;
import fr.insee.prismeipc.open.model.Territoire;
import fr.insee.prismeipc.open.model.enumeration.TypeIndiceVarieteMensuel;
import fr.insee.prismeipc.open.service.CacheCalculIndiceVarieteService;

public class CacheCalculIndiceVarieteServiceTest implements CacheCalculIndiceVarieteService {

   private static final IndiceVarieteMensuel INDICE_VARIETE_METROPOLE_1_2022_10 = new IndiceVarieteMensuel(DonneesTest.VARIETE_2022_METROPOLE_1, (short) 10, TypeIndiceVarieteMensuel.CALCULE//
      , null, null, new BigDecimal(110), null, null, null, null, null);
   private static final IndiceVarieteMensuel INDICE_VARIETE_METROPOLE_2_2022_10 = new IndiceVarieteMensuel(DonneesTest.VARIETE_2022_METROPOLE_2, (short) 10, TypeIndiceVarieteMensuel.CALCULE//
      , null, null, new BigDecimal(120), null, null, null, null, null);
   private static final IndiceVarieteMensuel INDICE_VARIETE_GUADELOUPE_4_2022_10 = new IndiceVarieteMensuel(DonneesTest.VARIETE_2022_GUADELOUPE_4, (short) 10, TypeIndiceVarieteMensuel.CALCULE//
      , null, null, new BigDecimal(130), null, null, null, null, null);

   private final static List<IndiceVarieteMensuelAbstract> INDICES_VARIETE = List.of(//
      INDICE_VARIETE_METROPOLE_1_2022_10//
      , INDICE_VARIETE_METROPOLE_2_2022_10//
      , INDICE_VARIETE_GUADELOUPE_4_2022_10//
   );

   @Override
   public Map<ItemCoicop, Map<Territoire, List<IndiceVarieteMensuelAbstract>>> getAllMensuelByPosteAndTerritoire() {
      // TODO Auto-generated method stub
      return INDICES_VARIETE.stream()//
         .filter(indice -> indice.getVarieteEchantillon().getEchantillon().getAnnee().equals((short) 2022) && indice.getMois() == (short) 10)//
         .collect(Collectors.groupingBy(ivm -> ivm.getVarieteEchantillon().getItemCoicop(), //
            Collectors.groupingBy(ivm -> ivm.getVarieteEchantillon().getVariete().getTerritoire())));
   }

}
