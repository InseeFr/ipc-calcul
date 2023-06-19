package fr.insee.prismeipc.open.model.enumeration;

public enum EtatCalendrier {
   NON_OUVERT("Non ouvert"), //
   EN_COURS("En cours"), //
   PROVISOIRE("Provisoire"), //
   DEFINITIF("Définitif");

   private final String libelle;

   private EtatCalendrier(String libelle) {
      this.libelle = libelle;
   }

   public static Boolean estNonOuvertOuDefinitif(EtatCalendrier etat) {
      return etat == NON_OUVERT || etat == DEFINITIF;
   }

   public String getLibelle() {
      return libelle;
   }

}
