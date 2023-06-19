package fr.insee.prismeipc.open.model.enumeration;

public enum TypeSaisonnalite {

   NULLE("Pas saisonnière"), //
   FAIBLE("Difficile à enquêter hors saison"), //
   FORTE("Impossible à enquêter hors saison");

   private final String libelle;

   private TypeSaisonnalite(String libelle) {
      this.libelle = libelle;
   }

   public String getLibelle() {
      return libelle;
   }

   public static boolean estSaisonniere(TypeSaisonnalite typeSaiso) {
      return typeSaiso.equals(FORTE);
   }
}
