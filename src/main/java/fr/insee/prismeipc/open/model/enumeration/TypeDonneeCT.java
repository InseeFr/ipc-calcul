package fr.insee.prismeipc.open.model.enumeration;

public enum TypeDonneeCT {

   QUANTITE("quantite"), //
   PRIX_ET_QUANTITE("prix et quantité"), //
   HIERARCHIE("hierarchie"), //
   PRIX("prix"), //
   LIE_PRIX("lié au prix"), //
   QUANTITE_POUR_HOMOGENE("quantite pour homogene"), //
   IMA_FACULTATIF("IMA Facultatif"), //
   MARQUE("marque"), //
   MODELE("modèle");

   private final String libelle;

   private TypeDonneeCT(String libelle) {
      this.libelle = libelle;
   }

   public String getLibelle() {
      return libelle;
   }

}
