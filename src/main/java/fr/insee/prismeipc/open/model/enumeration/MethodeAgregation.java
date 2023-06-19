package fr.insee.prismeipc.open.model.enumeration;

public enum MethodeAgregation {

   MOYENNE_ARITHMETIQUE("Rapport de moyennes arithmetiques"), //
   MOYENNE_GEOMETRIQUE("rapport de moyennes géométriques");

   private final String libelle;

   private MethodeAgregation(String libelle) {
      this.libelle = libelle;
   }

   public String getLibelle() {
      return libelle;
   }

}
