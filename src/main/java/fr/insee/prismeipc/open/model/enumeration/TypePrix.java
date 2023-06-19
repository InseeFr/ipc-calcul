package fr.insee.prismeipc.open.model.enumeration;

public enum TypePrix {

   PRIX_UNITAIRE("Prix unitaire"), //
   PRIX_GLOBAL("Prix global");

   private final String libelle;

   private TypePrix(String libelle) {
      this.libelle = libelle;
   }

   public String getLibelle() {
      return libelle;
   }

}
