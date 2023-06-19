package fr.insee.prismeipc.open.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.insee.prismeipc.open.impl.CacheCalculIndicePosteServiceTest;
import fr.insee.prismeipc.open.impl.CacheCalculIndiceVarieteServiceTest;
import fr.insee.prismeipc.open.impl.DonneesTest;
import fr.insee.prismeipc.open.impl.IndicePosteMensuelServiceTest;
import fr.insee.prismeipc.open.model.IndicePosteMensuel;
import fr.insee.prismeipc.open.model.enumeration.EtatCalendrier;

class CalculIndicePosteServiceTest {

   private IndicePosteMensuelServiceTest indicePosteMensuelService = new IndicePosteMensuelServiceTest();

   private CalculIndicePosteService calculIndicePosteService = new CalculIndicePosteService(//
      new CacheCalculIndiceVarieteServiceTest()//
      , indicePosteMensuelService//
      , new CacheCalculIndicePosteServiceTest());

   @Test
   public void calcul_indice_poste_cas_nominal() {
      // Given
      // Les différentes données de tests sont dans les implémentations des services appelées
      indicePosteMensuelService.clear();

      // When
      calculIndicePosteService.calculIndicePoste((short) 10, EtatCalendrier.PROVISOIRE);

      // Then
      // Actuals
      List<IndicePosteMensuel> indicesActuals = indicePosteMensuelService.getIndices();

      // Expecteds
      IndicePosteMensuel INDICE_POSTE_011111_METROPOLE_2022_10 = new IndicePosteMensuel(DonneesTest.ITEM_COICOP_POSTE_011111, DonneesTest.TERRITOIRE_METROPOLE, DonneesTest.ECHANTILLON_2022,
         (short) 10);
      INDICE_POSTE_011111_METROPOLE_2022_10.setIpcProvisoire(new BigDecimal(115));
      INDICE_POSTE_011111_METROPOLE_2022_10.setIpcDiffusionProvisoire(new BigDecimal(126.5));
      IndicePosteMensuel INDICE_POSTE_011111_GUADELOUPE_2022_10 = new IndicePosteMensuel(DonneesTest.ITEM_COICOP_POSTE_011111, DonneesTest.TERRITOIRE_GUADELOUPE, DonneesTest.ECHANTILLON_2022,
         (short) 10);
      INDICE_POSTE_011111_GUADELOUPE_2022_10.setIpcProvisoire(new BigDecimal(130));
      INDICE_POSTE_011111_GUADELOUPE_2022_10.setIpcDiffusionProvisoire(new BigDecimal(65));

      List<IndicePosteMensuel> indicesExpecteds = List.of(//
         INDICE_POSTE_011111_METROPOLE_2022_10//
         , INDICE_POSTE_011111_GUADELOUPE_2022_10//
      );

      // Asserts
      Assertions.assertEquals(indicesExpecteds.size(), indicesActuals.size(), "Le nombres d'indices attendu n'est pas égal au nombre d'indices réel");
      indicesExpecteds.stream().forEach(expected -> {
         Optional<IndicePosteMensuel> actual = indicesActuals.stream()//
            .filter(a -> //
         a.getEchantillon().getId() == expected.getEchantillon().getId() //
            && a.getMois() == expected.getMois() //
            && a.getItemCoicop().getId() == expected.getItemCoicop().getId() //
            && a.getTerritoire().getId() == expected.getTerritoire().getId()) //
            .findFirst();
         Assertions.assertTrue(actual.isPresent(), "L'indice pour l'échantillon " + expected.getEchantillon().getId() + ", le mois " + expected.getMois() + ", l'itemCoicop " + expected.getItemCoicop()
            .getId() + " et le territoire " + expected.getTerritoire().getId() + ", n'est pas dans la base de données");

         if (actual.isPresent()) {
            Assertions.assertEquals(expected.getIpc() != null ? expected.getIpc().stripTrailingZeros() : null, actual.get().getIpc() != null ? actual.get().getIpc().stripTrailingZeros() : null);
            Assertions.assertEquals(expected.getIpch() != null ? expected.getIpch().stripTrailingZeros() : null, actual.get().getIpch() != null ? actual.get().getIpch().stripTrailingZeros() : null);
            Assertions.assertEquals(expected.getIpcProvisoire() != null ? expected.getIpcProvisoire().stripTrailingZeros() : null,
               actual.get().getIpcProvisoire() != null ? actual.get().getIpcProvisoire().stripTrailingZeros() : null);
            Assertions.assertEquals(expected.getIpchProvisoire() != null ? expected.getIpchProvisoire().stripTrailingZeros() : null,
               actual.get().getIpchProvisoire() != null ? actual.get().getIpchProvisoire().stripTrailingZeros() : null);
            Assertions.assertEquals(expected.getIpcDiffusion() != null ? expected.getIpcDiffusion().stripTrailingZeros() : null,
               actual.get().getIpcDiffusion() != null ? actual.get().getIpcDiffusion().stripTrailingZeros() : null);
            Assertions.assertEquals(expected.getIpchDiffusion() != null ? expected.getIpchDiffusion().stripTrailingZeros() : null,
               actual.get().getIpchDiffusion() != null ? actual.get().getIpchDiffusion().stripTrailingZeros() : null);
            Assertions.assertEquals(expected.getIpcDiffusionProvisoire() != null ? expected.getIpcDiffusionProvisoire().stripTrailingZeros() : null,
               actual.get().getIpcDiffusionProvisoire() != null ? actual.get().getIpcDiffusionProvisoire().stripTrailingZeros() : null);
            Assertions.assertEquals(expected.getIpchDiffusionProvisoire() != null ? expected.getIpchDiffusionProvisoire().stripTrailingZeros() : null,
               actual.get().getIpchDiffusionProvisoire() != null ? actual.get().getIpchDiffusionProvisoire().stripTrailingZeros() : null);
            Assertions.assertEquals(expected.getItc() != null ? expected.getItc().stripTrailingZeros() : null, actual.get().getItc() != null ? actual.get().getItc().stripTrailingZeros() : null);
         }
      });

   }
}
