package fr.insee.prismeipc.open.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.apfloat.Apfloat;
import org.apfloat.ApfloatMath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DecimalesUtils {

   private static final Logger logger = LoggerFactory.getLogger(DecimalesUtils.class);

   public static final int SCALE_STOCKAGE = 40;
   public static final int SCALE_CALCUL = 100;
   public static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_EVEN;

   public static BigDecimal ajouter(BigDecimal terme1, BigDecimal terme2) {
      return terme1.add(terme2);
   }

   public static BigDecimal soustraire(BigDecimal diminuende, BigDecimal diminuteur) {
      return diminuende.subtract(diminuteur);
   }

   public static BigDecimal multiplier(BigDecimal facteur1, BigDecimal facteur2) {
      return facteur1.multiply(facteur2);
   }

   public static BigDecimal diviser(BigDecimal numerateur, BigDecimal denominateur) {
      if (numerateur == null || denominateur == null || denominateur.compareTo(BigDecimal.ZERO) == 0) {
         logger.warn("Division par zéro");
         return null;
      }
      return numerateur.divide(denominateur, SCALE_CALCUL, ROUNDING_MODE);
   }

   public static BigDecimal arrondir(BigDecimal x) {
      return enleverZeros(x.setScale(SCALE_STOCKAGE, ROUNDING_MODE));
   }

   private static BigDecimal enleverZeros(BigDecimal x) {
      String s = x.toString();
      for (int i = 0; i < 40; i++) {
         if (s.charAt(s.length() - 1) == '0') {
            s = s.substring(0, s.length() - 1);
         }
      }
      return valueOf(s);
   }

   public static BigDecimal valueOf(Double x) {
      Apfloat apX = new Apfloat(x, SCALE_CALCUL);
      Apfloat arrondi = ApfloatMath.round(apX, SCALE_CALCUL, ROUNDING_MODE);
      return new BigDecimal(arrondi.toString());
   }

   public static BigDecimal valueOf(String x) {
      Apfloat apX = new Apfloat(x, SCALE_CALCUL);
      Apfloat arrondi = ApfloatMath.round(apX, SCALE_CALCUL, ROUNDING_MODE);
      return new BigDecimal(arrondi.toString());
   }

   public static BigDecimal valueOfOu1(Double x) {
      if (x == null) {
         return valueOf(1);
      } else return valueOf(x);
   }

   public static BigDecimal valueOf(int x) {
      Apfloat apX = new Apfloat(x, SCALE_CALCUL);
      Apfloat arrondi = ApfloatMath.round(apX, SCALE_CALCUL, ROUNDING_MODE);
      return new BigDecimal(arrondi.toString());
   }

   public static BigDecimal valueOf(long x) {
      Apfloat apX = new Apfloat(x, SCALE_CALCUL);
      Apfloat arrondi = ApfloatMath.round(apX, SCALE_CALCUL, ROUNDING_MODE);
      return new BigDecimal(arrondi.toString());
   }

   /**
    * Calcul de puissance avec BigDecimal, le BigDecimal résultat sera arrondi avec une précision valant SCALE_STOCKAGE
    * 
    * @param a
    * @param b
    * @return
    */
   public static BigDecimal pow(BigDecimal a, BigDecimal b) {
      Apfloat apA = new Apfloat(a, SCALE_CALCUL);
      Apfloat apB = new Apfloat(b, SCALE_CALCUL);
      Apfloat apResult = ApfloatMath.pow(apA, apB);
      Apfloat arrondi = ApfloatMath.round(apResult, SCALE_CALCUL, ROUNDING_MODE);

      BigDecimal bigResult = null;
      if (arrondi.toString().contains("e")) {
         String[] tab = arrondi.toString().split("e");
         BigDecimal mantisse = new BigDecimal(tab[0]);
         Integer exposant = Integer.valueOf(tab[1]);
         BigDecimal valeurPuissanceDe10;
         if (exposant < 0) {
            valeurPuissanceDe10 = valueOf(0.1).pow(-exposant);
         } else {
            valeurPuissanceDe10 = valueOf(10).pow(exposant);
         }
         bigResult = mantisse.multiply(valeurPuissanceDe10);
      } else {
         bigResult = new BigDecimal(arrondi.toString());
      }
      return bigResult;
   }

   /**
    * Inverse un BigDecimal (renvoie 1/a en BigDecimal précision SCALE_CALCUL)
    * 
    * @param a
    * @return
    */
   public static BigDecimal inverse(BigDecimal a) {
      return diviser(BigDecimal.ONE.setScale(SCALE_CALCUL), a);
   }

   /**
    * Renvoie un BigDecimal valant a^(1/b), précision SCALE_STOCKAGE
    * 
    * @param a
    * @param b
    * @return
    */
   public static BigDecimal powInverse(BigDecimal a, BigDecimal b) {
      return pow(a, inverse(b));
   }
}
