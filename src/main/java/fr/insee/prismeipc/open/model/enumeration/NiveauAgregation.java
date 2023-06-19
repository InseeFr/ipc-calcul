package fr.insee.prismeipc.open.model.enumeration;

public enum NiveauAgregation {

   STRATE("Strate"), //
   GROUPE_STRATE("Groupe strates");

   private final String libelle;

   private NiveauAgregation(String libelle) {
      this.libelle = libelle;
   }

   public String getLibelle() {
      return libelle;
   }

}
