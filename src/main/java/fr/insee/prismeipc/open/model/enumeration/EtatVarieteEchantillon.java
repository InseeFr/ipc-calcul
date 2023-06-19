package fr.insee.prismeipc.open.model.enumeration;

public enum EtatVarieteEchantillon {

   ACTIVE("Active"), //
   SUPPRIMEE("Supprimée");

   private final String libelle;

   private EtatVarieteEchantillon(String libelle) {
      this.libelle = libelle;
   }

   public String getLibelle() {
      return libelle;
   }

}
