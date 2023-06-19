package fr.insee.prismeipc.open.model.enumeration;

public enum TypeIndice {

   TARIF("Tarif"), //
   DDC("Donnée de caisse");

   private final String libelle;

   private TypeIndice(String libelle) {
      this.libelle = libelle;
   }

   public String getLibelle() {
      return libelle;
   }

}
