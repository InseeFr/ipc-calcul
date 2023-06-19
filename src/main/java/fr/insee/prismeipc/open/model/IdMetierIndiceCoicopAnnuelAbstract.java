package fr.insee.prismeipc.open.model;

public abstract class IdMetierIndiceCoicopAnnuelAbstract {

   private ItemCoicop itemCoicop;
   private Echantillon echantillon;
   private Territoire territoire;

   public IdMetierIndiceCoicopAnnuelAbstract(ItemCoicop itemCoicop, Echantillon echantillon, Territoire territoire) {
      super();
      this.itemCoicop = itemCoicop;
      this.echantillon = echantillon;
      this.territoire = territoire;
   }

   public IdMetierIndiceCoicopAnnuelAbstract() {
      super();
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

   public void setItemCoicop(ItemCoicop itemCoicop) {
      this.itemCoicop = itemCoicop;
   }

   public void setEchantillon(Echantillon echantillon) {
      this.echantillon = echantillon;
   }

   public void setTerritoire(Territoire territoire) {
      this.territoire = territoire;
   }

}
