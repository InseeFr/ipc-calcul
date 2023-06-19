package fr.insee.prismeipc.open.model.enumeration;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public enum NiveauCoicop {
   POSTE("POSTE", 5), //
   SOUS_CLASSE("SOUS-CLASSE", 4), //
   CLASSE("CLASSE", 3), //
   GROUPE("GROUPE", 2), //
   DIVISION("DIVISION", 1), //
   ENSEMBLE("ENSEMBLE", 0)//
   ;

   private String libelle;
   private int rang;

   private NiveauCoicop(String libelle, int rang) {
      this.libelle = libelle;
      this.rang = rang;
   }

   public int getRang() {
      return rang;
   }

   public String getLibelle() {
      return libelle;
   }

   public static Optional<NiveauCoicop> getNiveauSuperieur(NiveauCoicop niveauCoicop) {
      return Arrays.asList(NiveauCoicop.values()).stream().filter(nc -> nc.getRang() == niveauCoicop.getRang() - 1).findFirst();
   }

   public static List<NiveauCoicop> getByRangDecroissant() {
      return Arrays.asList(NiveauCoicop.values()).stream().sorted((a, b) -> b.getRang() - a.getRang()).collect(Collectors.toList());
   }

   public boolean estSuperieurStrictement(NiveauCoicop niveau) {
      return this.getRang() < niveau.getRang();
   }
}
