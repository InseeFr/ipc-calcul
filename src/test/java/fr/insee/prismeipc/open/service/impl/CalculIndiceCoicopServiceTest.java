package fr.insee.prismeipc.open.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.insee.prismeipc.open.exception.NotFoundException;
import fr.insee.prismeipc.open.impl.CacheEchantillonsServiceTest;
import fr.insee.prismeipc.open.impl.CacheIndiceCoicopEchantillonMoisServiceTest;
import fr.insee.prismeipc.open.impl.CacheIndiceCoicopEchantillonServiceTest;
import fr.insee.prismeipc.open.impl.CacheIndicePosteServiceTest;
import fr.insee.prismeipc.open.impl.CacheItemsCoicopServiceTest;
import fr.insee.prismeipc.open.impl.CachePonderationCoicopServiceTest;
import fr.insee.prismeipc.open.impl.CachePonderationPosteServiceTest;
import fr.insee.prismeipc.open.impl.DonneesTest;
import fr.insee.prismeipc.open.impl.IndiceCoicopMensuelServiceTest;
import fr.insee.prismeipc.open.model.IndiceCoicopMensuel;
import fr.insee.prismeipc.open.model.enumeration.EtatCalendrier;
import fr.insee.prismeipc.open.model.enumeration.Population;
import fr.insee.prismeipc.open.service.impl.CalculIndiceCoicopService;

class CalculIndiceCoicopServiceTest {

   IndiceCoicopMensuelServiceTest indiceCoicopMensuelService = new IndiceCoicopMensuelServiceTest();

   CalculIndiceCoicopService calculIndiceCoicopService = new CalculIndiceCoicopService(//
      new CacheEchantillonsServiceTest()//
      , new CacheIndicePosteServiceTest()//
      , new CacheIndiceCoicopEchantillonServiceTest() //
      , new CacheIndiceCoicopEchantillonMoisServiceTest()//
      , new CacheItemsCoicopServiceTest()//
      , new CachePonderationCoicopServiceTest()//
      , new CachePonderationPosteServiceTest()//
      , indiceCoicopMensuelService//
   );

   @Test
   void calcul_coicop_cas_nominal() {
      // Given
      // Les différentes données de tests sont dans les implémentations des services appelées
      indiceCoicopMensuelService.clear();

      // When
      try {
         calculIndiceCoicopService.calculIndiceCoicop((short) 2022, (short) 10, EtatCalendrier.PROVISOIRE);
      } catch (NotFoundException e) {
         Assertions.fail("Une erreur est survenue pendant le test : " + e.getLocalizedMessage());
      }

      // Then
      // Actuals
      List<IndiceCoicopMensuel> indicesActuals = indiceCoicopMensuelService.getIndices();

      // Expecteds
      IndiceCoicopMensuel INDICE_ENSEMBLE_METROPOLE_2022_10_LOYER = new IndiceCoicopMensuel(null, DonneesTest.ITEM_COICOP_ENSEMBLE, DonneesTest.TERRITOIRE_METROPOLE, DonneesTest.ECHANTILLON_2022,
         Population.LOYER, (short) 10 //
         , null, null, new BigDecimal("100"), new BigDecimal("200"), null, null, new BigDecimal("50"), new BigDecimal("100"));
      IndiceCoicopMensuel INDICE_DIVISION_01_METROPOLE_2022_10_LOYER = new IndiceCoicopMensuel(null, DonneesTest.ITEM_COICOP_DIVISION_01, DonneesTest.TERRITOIRE_METROPOLE,
         DonneesTest.ECHANTILLON_2022, Population.LOYER, (short) 10 //
         , null, null, new BigDecimal("100"), new BigDecimal("200"), null, null, new BigDecimal("50"), new BigDecimal("100"));
      IndiceCoicopMensuel INDICE_GROUPE_011_METROPOLE_2022_10_LOYER = new IndiceCoicopMensuel(null, DonneesTest.ITEM_COICOP_GROUPE_011, DonneesTest.TERRITOIRE_METROPOLE, DonneesTest.ECHANTILLON_2022,
         Population.LOYER, (short) 10 //
         , null, null, new BigDecimal("100"), new BigDecimal("200"), null, null, new BigDecimal("50"), new BigDecimal("100"));
      IndiceCoicopMensuel INDICE_CLASSE_0111_METROPOLE_2022_10_LOYER = new IndiceCoicopMensuel(null, DonneesTest.ITEM_COICOP_CLASSE_0111, DonneesTest.TERRITOIRE_METROPOLE,
         DonneesTest.ECHANTILLON_2022, Population.LOYER, (short) 10 //
         , null, null, new BigDecimal("100"), new BigDecimal("200"), null, null, new BigDecimal("50"), new BigDecimal("100"));
      IndiceCoicopMensuel INDICE_SOUS_CLASSE_01111_METROPOLE_2022_10_LOYER = new IndiceCoicopMensuel(null, DonneesTest.ITEM_COICOP_SOUS_CLASSE_01111, DonneesTest.TERRITOIRE_METROPOLE,
         DonneesTest.ECHANTILLON_2022, Population.LOYER, (short) 10 //
         , null, null, new BigDecimal("100"), new BigDecimal("200"), null, null, new BigDecimal("50"), new BigDecimal("100"));
      IndiceCoicopMensuel INDICE_ENSEMBLE_GUADELOUPE_2022_10_TOTALE = new IndiceCoicopMensuel(null, DonneesTest.ITEM_COICOP_ENSEMBLE, DonneesTest.TERRITOIRE_GUADELOUPE, DonneesTest.ECHANTILLON_2022,
         Population.TOTALE, (short) 10 //
         , null, null, new BigDecimal("1000"), new BigDecimal("2000"), null, null, new BigDecimal("1000"), new BigDecimal("4000"));
      IndiceCoicopMensuel INDICE_DIVISION_01_GUADELOUPE_2022_10_TOTALE = new IndiceCoicopMensuel(null, DonneesTest.ITEM_COICOP_DIVISION_01, DonneesTest.TERRITOIRE_GUADELOUPE,
         DonneesTest.ECHANTILLON_2022, Population.TOTALE, (short) 10 //
         , null, null, new BigDecimal("1000"), new BigDecimal("2000"), null, null, new BigDecimal("1000"), new BigDecimal("4000"));
      IndiceCoicopMensuel INDICE_GROUPE_011_GUADELOUPE_2022_10_TOTALE = new IndiceCoicopMensuel(null, DonneesTest.ITEM_COICOP_GROUPE_011, DonneesTest.TERRITOIRE_GUADELOUPE,
         DonneesTest.ECHANTILLON_2022, Population.TOTALE, (short) 10 //
         , null, null, new BigDecimal("1000"), new BigDecimal("2000"), null, null, new BigDecimal("1000"), new BigDecimal("4000"));
      IndiceCoicopMensuel INDICE_CLASSE_0111_GUADELOUPE_2022_10_TOTALE = new IndiceCoicopMensuel(null, DonneesTest.ITEM_COICOP_CLASSE_0111, DonneesTest.TERRITOIRE_GUADELOUPE,
         DonneesTest.ECHANTILLON_2022, Population.TOTALE, (short) 10 //
         , null, null, new BigDecimal("1000"), new BigDecimal("2000"), null, null, new BigDecimal("1000"), new BigDecimal("4000"));
      IndiceCoicopMensuel INDICE_SOUS_CLASSE_01111_GUADELOUPE_2022_10_TOTALE = new IndiceCoicopMensuel(null, DonneesTest.ITEM_COICOP_SOUS_CLASSE_01111, DonneesTest.TERRITOIRE_GUADELOUPE,
         DonneesTest.ECHANTILLON_2022, Population.TOTALE, (short) 10 //
         , null, null, new BigDecimal("1000"), new BigDecimal("2000"), null, null, new BigDecimal("1000"), new BigDecimal("4000"));

      List<IndiceCoicopMensuel> indicesExpecteds = List.of(//
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

      // Asserts
      Assertions.assertEquals(indicesExpecteds.size(), indicesActuals.size(), "Le nombres d'indices attendu n'est pas égal au nombre d'indices réel");
      indicesExpecteds.stream().forEach(expected -> {
         Optional<IndiceCoicopMensuel> actual = indicesActuals.stream()//
            .filter(a -> //
         a.getEchantillon().getId() == expected.getEchantillon().getId() //
            && a.getMois() == expected.getMois() //
            && a.getPopulation().equals(expected.getPopulation()) //
            && a.getItemCoicop().getId() == expected.getItemCoicop().getId() //
            && a.getTerritoire().getId() == expected.getTerritoire().getId()) //
            .findFirst();
         Assertions.assertTrue(actual.isPresent(), "L'indice pour l'échantillon " + expected.getEchantillon().getId() + ", le mois " + expected.getMois() + ", la population " + expected
            .getPopulation() + ", l'itemCoicop " + expected.getItemCoicop().getId() + " et le territoire " + expected.getTerritoire().getId() + ", n'est pas dans la base de données");

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
            Assertions.assertEquals(expected.getItcDiffusion() != null ? expected.getItcDiffusion().stripTrailingZeros() : null,
               actual.get().getItcDiffusion() != null ? actual.get().getItcDiffusion().stripTrailingZeros() : null);
         }
      });

   }

}
