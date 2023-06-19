package fr.insee.prismeipc.open.model;

import java.util.Objects;

public abstract class IdMetierIndiceCoicopMensuelAbstract {

   protected short mois;

   protected ItemCoicop itemCoicop;
   protected Territoire territoire;
   protected Echantillon echantillon;

   protected IdMetierIndiceCoicopMensuelAbstract() {
      super();
   }

   protected IdMetierIndiceCoicopMensuelAbstract(ItemCoicop itemCoicop, Echantillon echantillon, Territoire territoire) {
      super();
      this.itemCoicop = itemCoicop;
      this.echantillon = echantillon;
      this.territoire = territoire;
   }

   public short getMois() {
      return mois;
   }

   public ItemCoicop getItemCoicop() {
      return itemCoicop;
   }

   public Echantillon getEchantillon() {
      return echantillon;
   }

   public Territoire getTerritoire() {
      return territoire;
   }

   public void setMois(short mois) {
      this.mois = mois;
   }

   public void setItemCoicop(ItemCoicop itemCoicop) {
      this.itemCoicop = itemCoicop;
   }

   public void setEchantillon(Echantillon echantillon) {
      this.echantillon = echantillon;
   }

   public void setTerritoire(Territoire territoire) {
      this.territoire = territoire;
   }

   @Override
   public int hashCode() {
      return Objects.hash(echantillon, itemCoicop, mois, territoire);
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null) return false;
      if (getClass() != obj.getClass()) return false;
      IndiceCoicopMensuelAbstract other = (IndiceCoicopMensuelAbstract) obj;
      if (echantillon == null) {
         if (other.echantillon != null) return false;
      } else if (!echantillon.equals(other.echantillon)) return false;
      if (itemCoicop == null) {
         if (other.itemCoicop != null) return false;
      } else if (!itemCoicop.equals(other.itemCoicop)) return false;
      if (mois != other.mois) return false;
      if (territoire == null) {
         if (other.territoire != null) return false;
      } else if (!territoire.equals(other.territoire)) return false;
      return true;
   }

}
