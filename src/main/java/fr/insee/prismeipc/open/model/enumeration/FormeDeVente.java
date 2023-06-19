package fr.insee.prismeipc.open.model.enumeration;

import java.util.HashMap;
import java.util.Map;

public enum FormeDeVente {
   HYPERMARCHE("10", "Hypermarché"), //
   SUPERMARCHE("20", "Supermarché"), //
   HARD_DISCOUNT("25", "Hard discount"), //
   SUPERETTE("30", "Supérette"), //
   MAGASIN_POPULAIRE("40", "Magasin populaire"), //
   GRAND_MAGASIN("50", "Grand magasin"), //
   GRANDE_SURFACE_SPECIALISEE("60", "Grande surface spécialisée"), //
   PETIT_MAGASIN_TRADITIONNEL("70", "Petit magasin traditionnel"), //
   MARCHE("80", "Marché"), //
   SERVICE("90", "Service"), //
   AUTRE("99", "Autre"), //
   INTERNET("100", "Internet"); //

   private String code;
   private String libelle;

   private FormeDeVente(String code, String libelle) {
      this.code = code;
      this.libelle = libelle;
   }

   public String getCode() {
      return code;
   }

   public String getLibelle() {
      return libelle;
   }

   private static final Map<String, FormeDeVente> mapCodes = new HashMap<>();
   static {
      for (FormeDeVente formeDeVente : values()) {
         mapCodes.put(formeDeVente.getCode(), formeDeVente);
      }
   }

   private static final Map<String, FormeDeVente> mapLibelles = new HashMap<>();
   static {
      for (FormeDeVente formeDeVente : values()) {
         mapLibelles.put(formeDeVente.getLibelle(), formeDeVente);
      }
   }

   public static FormeDeVente getByCode(String code) {
      final FormeDeVente value = mapCodes.get(code);
      if (value != null) {
         return value;
      }
      throw new IllegalArgumentException("Code de forme de vente inconnu : " + code);
   }

   public static FormeDeVente fromJsonObject(Map<String, Object> objetJson) {
      if (objetJson.get("code") == null) return null;

      return getByCode(objetJson.get("code").toString());

   }

}
