package fr.insee.prismeipc.open.model;

import fr.insee.prismeipc.open.model.enumeration.Population;

public class AgregatCoicop {

   private ItemCoicop itemCoicopParent;
   private Population population;
   private Territoire territoire;
   private Short mois;

   public AgregatCoicop(ItemCoicop itemCoicopParent, Population population, Territoire territoire) {
      super();
      this.itemCoicopParent = itemCoicopParent;
      this.population = population;
      this.territoire = territoire;
   }

   public AgregatCoicop(ItemCoicop itemCoicopParent, Population population, Territoire territoire, Short mois) {
      super();
      this.itemCoicopParent = itemCoicopParent;
      this.population = population;
      this.territoire = territoire;
      this.mois = mois;
   }

   public ItemCoicop getItemCoicopParent() {
      return itemCoicopParent;
   }

   public Population getPopulation() {
      return population;
   }

   public Territoire getTerritoire() {
      return territoire;
   }

   public Short getMois() {
      return mois;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((itemCoicopParent == null) ? 0 : itemCoicopParent.getId().hashCode());
      result = prime * result + ((mois == null) ? 0 : mois.hashCode());
      result = prime * result + ((population == null) ? 0 : population.hashCode());
      result = prime * result + ((territoire == null) ? 0 : territoire.getId().hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null) return false;
      if (getClass() != obj.getClass()) return false;
      AgregatCoicop other = (AgregatCoicop) obj;
      if (itemCoicopParent == null) {
         if (other.itemCoicopParent != null) return false;
      } else if (!itemCoicopParent.getId().equals(other.itemCoicopParent.getId())) return false;
      if (mois == null) {
         if (other.mois != null) return false;
      } else if (!mois.equals(other.mois)) return false;
      if (population != other.population) return false;
      if (territoire == null) {
         if (other.territoire != null) return false;
      } else if (!territoire.getId().equals(other.territoire.getId())) return false;
      return true;
   }

   @Override
   public String toString() {
      return "AgregatCoicop [itemCoicopParent.id=" + itemCoicopParent.getId() + ", population=" + population + ", territoire.id=" + territoire.getId() + ", mois=" + mois + "]";
   }

}
