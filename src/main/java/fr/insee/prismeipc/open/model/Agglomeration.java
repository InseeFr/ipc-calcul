package fr.insee.prismeipc.open.model;

import java.util.HashSet;
import java.util.Set;

public class Agglomeration extends Strate {

   private Set<Commune> communes = new HashSet<>();
   private Territoire territoire;

   public void addCommune(Commune commune) {
      if (communes.stream().anyMatch(c -> c.getId().equals(commune.getId()))) {
         return;
      }
      communes.add(commune);
   }

   public Set<Commune> getCommunes() {
      return communes;
   }

   public void setCommunes(Set<Commune> communes) {
      this.communes = communes;
   }

   public Territoire getTerritoire() {
      return territoire;
   }

   public void setTerritoire(Territoire territoire) {
      this.territoire = territoire;
   }

   @Override
   public String toString() {
      return "Agglomeration [" + super.toString() + ", territoire=" + (territoire == null ? "null" : territoire.getId()) + "]";
   }

}
