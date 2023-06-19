package fr.insee.prismeipc.open.model.enumeration;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public enum TypeStrate {
   AGGLO("AGGLO"), //
   ECOMMERCE("ECOMMERCE") //
   ;

   private String code;

   private TypeStrate(String code) {
      this.code = code;
   }

   private static final Map<String, TypeStrate> mapCodes = new HashMap<>();
   static {
      for (TypeStrate typeStrate : values()) {
         mapCodes.put(typeStrate.getCode(), typeStrate);
      }
   }

   public static TypeStrate getByCode(String code) {
      final TypeStrate value = mapCodes.get(code);
      if (value != null) {
         return value;
      }
      throw new IllegalArgumentException("Code de type strate : " + code);
   }

   public static TypeStrate fromModeCollecte(String modeCollecte) {
      if (modeCollecte == null) return null;
      if (StringUtils.equalsIgnoreCase(modeCollecte, "Terrain")) return AGGLO;
      if (StringUtils.equalsIgnoreCase(modeCollecte, "Internet")) return ECOMMERCE;
      throw new IllegalArgumentException("Impossible d'associer un type de strate au mode de collecte : " + modeCollecte);
   }

   public String getCode() {
      return code;
   }
}
