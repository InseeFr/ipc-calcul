package fr.insee.prismeipc.open.model;

import java.math.BigDecimal;

import fr.insee.prismeipc.open.model.enumeration.Population;

public class IndiceCoicopAnnuel {

   private Long id;
   private ItemCoicop itemCoicop;
   private Territoire territoire;
   private Echantillon echantillon;
   private Population population;

   private BigDecimal ipcBaseDiffusion;
   private BigDecimal ipchBaseDiffusion;
   private BigDecimal itcBaseDiffusion;
   private BigDecimal ipcMoyenne;
   private BigDecimal ipchMoyenne;
   private BigDecimal ipcMoyenneDiffusion;
   private BigDecimal ipchMoyenneDiffusion;

   public IndiceCoicopAnnuel() {
      super();
   }

   public IndiceCoicopAnnuel(Long id, ItemCoicop itemCoicop, Territoire territoire, Echantillon echantillon, Population population, BigDecimal ipcBaseDiffusion, BigDecimal ipchBaseDiffusion) {
      super();
      this.id = id;
      this.itemCoicop = itemCoicop;
      this.territoire = territoire;
      this.echantillon = echantillon;
      this.population = population;
      this.ipcBaseDiffusion = ipcBaseDiffusion;
      this.ipchBaseDiffusion = ipchBaseDiffusion;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public Echantillon getEchantillon() {
      return echantillon;
   }

   public void setEchantillon(Echantillon echantillon) {
      this.echantillon = echantillon;
   }

   public ItemCoicop getItemCoicop() {
      return itemCoicop;
   }

   public void setItemCoicop(ItemCoicop itemcoicop) {
      this.itemCoicop = itemcoicop;
   }

   public Population getPopulation() {
      return population;
   }

   public void setPopulation(Population population) {
      this.population = population;
   }

   public Territoire getTerritoire() {
      return territoire;
   }

   public void setTerritoire(Territoire territoire) {
      this.territoire = territoire;
   }

   public BigDecimal getIpcBaseDiffusion() {
      return ipcBaseDiffusion;
   }

   public void setIpcBaseDiffusion(BigDecimal ipcBaseDiffusion) {
      this.ipcBaseDiffusion = ipcBaseDiffusion;
   }

   public BigDecimal getIpchBaseDiffusion() {
      return ipchBaseDiffusion;
   }

   public void setIpchBaseDiffusion(BigDecimal ipchBaseDiffusion) {
      this.ipchBaseDiffusion = ipchBaseDiffusion;
   }

   public BigDecimal getIpcMoyenne() {
      return ipcMoyenne;
   }

   public void setIpcMoyenne(BigDecimal ipcMoyenne) {
      this.ipcMoyenne = ipcMoyenne;
   }

   public BigDecimal getIpchMoyenne() {
      return ipchMoyenne;
   }

   public void setIpchMoyenne(BigDecimal ipchMoyenne) {
      this.ipchMoyenne = ipchMoyenne;
   }

   public BigDecimal getIpcMoyenneDiffusion() {
      return ipcMoyenneDiffusion;
   }

   public void setIpcMoyenneDiffusion(BigDecimal ipcMoyenneDiffusion) {
      this.ipcMoyenneDiffusion = ipcMoyenneDiffusion;
   }

   public BigDecimal getIpchMoyenneDiffusion() {
      return ipchMoyenneDiffusion;
   }

   public void setIpchMoyenneDiffusion(BigDecimal ipchMoyenneDiffusion) {
      this.ipchMoyenneDiffusion = ipchMoyenneDiffusion;
   }

   public BigDecimal getItcBaseDiffusion() {
      return itcBaseDiffusion;
   }

   public void setItcBaseDiffusion(BigDecimal itcBaseDiffusion) {
      this.itcBaseDiffusion = itcBaseDiffusion;
   }

   @Override
   public String toString() {
      return "IndiceCoicopAnnuel [id=" + id + ", itemCoicop=" + itemCoicop + ", echantillon=" + echantillon + ", population=" + population + ", territoire=" + territoire + ", ipcBaseDiffusion=" + ipcBaseDiffusion + ", ipchBaseDiffusion=" + ipchBaseDiffusion + ", itcBaseDiffusion=" + itcBaseDiffusion + ", ipcMoyenne=" + ipcMoyenne + ", ipchMoyenne=" + ipchMoyenne + ", ipcMoyenneDiffusion=" + ipcMoyenneDiffusion + ", ipchMoyenneDiffusion=" + ipchMoyenneDiffusion + "]";
   }

}
