package fr.insee.prismeipc.open.model.enumeration;

import java.util.HashMap;
import java.util.Map;

public enum UniteDeMesure {
   AMPERE("Ampère", "A"), //
   AMPERE_PAR_HEURE("Ampère par Heure", "A/H"), //
   ANNEE("Année", "AN"), //
   BAR("Bar", "BAR"), //
   BOITE("Boîte", "BTE"), //
   BOUTEILLE("Bouteille", "BTL"), //
   CENTILITRE("Centilitre", "CL"), //
   CENTIMETRE("Centimètre", "CM"), //
   CENTIMETRE_CARRE("Centimètre carré", "CM2"), //
   CENTIMETRE_CUBE("Centimètre cube", "CM3"), //
   CHEVAL_FISCAL("Cheval fiscal", "CV"), //
   CHEVAUX("Chevaux", "CH"), //
   DECIBEL("Décibel", "DB"), //
   DECIBEL_A("Décibel (A)", "DBA"), //
   DECIMETRE_CUBE("Décimètre cube", "DM3"), //
   DEGRE("Degré", "DEG"), //
   DOUZAINE("Douzaine", "DZ"), //
   EURO("Euro", "E"), //
   FEUILLE("Feuille", "FLE"), //
   FLEUR("Fleur", "FL"), //
   GIGA_OCTET("Giga-Octet", "GO"), //
   GIGAHERTZ("Gigahertz", "GHZ"), //
   GRAMME("Gramme", "G"), //
   GRAMME_PAR_METRE_CARRE("Gramme par mètre carré", "GM2"), //
   GRAMME_PAR_MINUTE("Gramme par minute", "GMN"), //
   HEURE("Heure", "H"), //
   IDENTITE("Identité", "ID"), //
   JOUR("Jour", "J"), //
   KILO_PASCAL("Kilo Pascal", "KPA"), //
   KILOGRAMME("Kilogramme", "KG"), //
   KILOMETRE("Kilomètre", "KM"), //
   KILOWATT("Kilowatt", "KW"), //
   KILOWATT_HEURE("Kilowatt Heure", "KWH"), //
   LITRE("Litre", "L"), //
   LUX("Lux", "LUX"), //
   MEGA_OCTET("Méga-Octet", "MO"), //
   METRE("Mètre", "M"), //
   METRE_CARRE("Mètre carré", "M2"), //
   METRE_CUBE("Mètre cube", "M3"), //
   METRE_CUBE_PAR_HEURE("Mètre cube par Heure", "M3H"), //
   MILLIER_EUROS("Millier d'Euros", "KE"), //
   MILLILITRE("Millilitre", "ML"), //
   MILLIMETRE("Millimètre", "MM"), //
   MINUTE("Minute", "MN"), //
   OEUF("Oeuf", "O"), //
   PAQUET("Paquet", "PQT"), //
   PIECE("Pièce", "PCE"), //
   PIXEL("Pixel", "PIX"), //
   POT("Pot", "PT"), //
   POURCENTAGE("Pourcentage", "%"), //
   SACHET("Sachet", "SA"), //
   TAS("tas", "TAS"), //
   TIGE("Tige", "TGE"), //
   TOURS_PAR_MINUTE("Tours par minute", "TMN"), //
   TRANCHES("Tranches", "TR"), //
   UNITE("Unité", "U"), //
   VOLT("Volt", "V"), //
   WATT("Watt", "W"); //

   private String libelle;
   private String code;

   private UniteDeMesure(String libelle, String code) {
      this.libelle = libelle;
      this.code = code;
   }

   public String getLibelle() {
      return libelle;
   }

   public String getCode() {
      return code;
   }

   private static final Map<String, UniteDeMesure> mapCodes = new HashMap<>();
   static {
      for (UniteDeMesure uniteDeMesure : values()) {
         mapCodes.put(uniteDeMesure.getCode(), uniteDeMesure);
      }
   }

   public static UniteDeMesure getInstance(String code) {
      UniteDeMesure value = mapCodes.get(code);
      if (value != null) {
         return value;
      }
      throw new IllegalArgumentException("Code unité de mesure inconnu : " + code);
   }
}
