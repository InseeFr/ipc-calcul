package fr.insee.prismeipc.open.model.enumeration;

import java.util.Arrays;

public enum Secteur {

   HABILLEMENT("Habillement", "HA"), //
   ALIMENTAIRE("Alimentaire", "AL"), //
   SERVICE("Service", "SE"), //
   MANUFACTURE("Manufacturé", "MA"), //
   BIEN_DURABLE("Bien durable", "BD"), //
   TARIF("Tarif", "TA"), //
   PRODUIT_FRAIS("Produit frais", "PF");

   private String libelle;
   private String code;

   private Secteur(String libelle, String code) {
      this.libelle = libelle;
      this.code = code;
   }

   public String getLibelle() {
      return libelle;
   }

   public String getCode() {
      return code;
   }

   public static Secteur fromLibelle(String libelle) {
      return Arrays.stream(Secteur.values()).filter(s -> s.getLibelle().equals(libelle)).findFirst().orElse(null);
   }

}
