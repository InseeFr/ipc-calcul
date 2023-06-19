package fr.insee.prismeipc.open.model;

import java.math.BigDecimal;

import fr.insee.prismeipc.open.model.enumeration.Population;

public class PonderationCoicopAbstract {

   private ItemCoicop itemCoicop;
   private Territoire territoire;
   private Echantillon echantillon;
   private Population population;
   private BigDecimal poidsIpcDansCoicop;
   private Integer poidsIpcDiffusionDansCoicop;
   private BigDecimal poidsIpchDansCoicop;
   private Integer poidsIpchDiffusionDansCoicop;

   public PonderationCoicopAbstract() {
      super();
   }

   public PonderationCoicopAbstract(ItemCoicop itemCoicop, Territoire territoire, Echantillon echantillon, Population population, BigDecimal poidsIpcDansCoicop, Integer poidsIpcDiffusionDansCoicop,
      BigDecimal poidsIpchDansCoicop, Integer poidsIpchDiffusionDansCoicop) {
      super();
      this.itemCoicop = itemCoicop;
      this.territoire = territoire;
      this.echantillon = echantillon;
      this.population = population;
      this.poidsIpcDansCoicop = poidsIpcDansCoicop;
      this.poidsIpcDiffusionDansCoicop = poidsIpcDiffusionDansCoicop;
      this.poidsIpchDansCoicop = poidsIpchDansCoicop;
      this.poidsIpchDiffusionDansCoicop = poidsIpchDiffusionDansCoicop;
   }

   public ItemCoicop getItemCoicop() {
      return itemCoicop;
   }

   public void setItemCoicop(ItemCoicop itemCoicop) {
      this.itemCoicop = itemCoicop;
   }

   public Territoire getTerritoire() {
      return territoire;
   }

   public void setTerritoire(Territoire territoire) {
      this.territoire = territoire;
   }

   public Echantillon getEchantillon() {
      return echantillon;
   }

   public void setEchantillon(Echantillon echantillon) {
      this.echantillon = echantillon;
   }

   public Population getPopulation() {
      return population;
   }

   public void setPopulation(Population population) {
      this.population = population;
   }

   public BigDecimal getPoidsIpcDansCoicop() {
      return poidsIpcDansCoicop;
   }

   public void setPoidsIpcDansCoicop(BigDecimal poidsIpcDansCoicop) {
      this.poidsIpcDansCoicop = poidsIpcDansCoicop;
   }

   public Integer getPoidsIpcDiffusionDansCoicop() {
      return poidsIpcDiffusionDansCoicop;
   }

   public void setPoidsIpcDiffusionDansCoicop(Integer poidsIpcDiffusionDansCoicop) {
      this.poidsIpcDiffusionDansCoicop = poidsIpcDiffusionDansCoicop;
   }

   public BigDecimal getPoidsIpchDansCoicop() {
      return poidsIpchDansCoicop;
   }

   public void setPoidsIpchDansCoicop(BigDecimal poidsIpchDansCoicop) {
      this.poidsIpchDansCoicop = poidsIpchDansCoicop;
   }

   public Integer getPoidsIpchDiffusionDansCoicop() {
      return poidsIpchDiffusionDansCoicop;
   }

   public void setPoidsIpchDiffusionDansCoicop(Integer poidsIpchDiffusionDansCoicop) {
      this.poidsIpchDiffusionDansCoicop = poidsIpchDiffusionDansCoicop;
   }

}
