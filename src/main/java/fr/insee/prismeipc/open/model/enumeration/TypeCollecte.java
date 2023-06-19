package fr.insee.prismeipc.open.model.enumeration;

public enum TypeCollecte {

   RELEVE("Releve"), //
   INDICE("Indice");

   private final String libelle;

   private TypeCollecte(String libelle) {
      this.libelle = libelle;
   }

   public String getLibelle() {
      return libelle;
   }

}
