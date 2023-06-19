package fr.insee.prismeipc.open.model;

import java.math.BigDecimal;

public class IndicePosteAnnuel extends IdMetierIndiceCoicopAnnuelAbstract {

   private Long id;
   private BigDecimal ipcBaseDiffusion;
   private BigDecimal ipchBaseDiffusion;
   private BigDecimal ipcMoy;
   private BigDecimal ipchMoy;
   private BigDecimal ipcDiffMoy;
   private BigDecimal ipchDiffMoy;

   public IndicePosteAnnuel() {
      super();
   }

   public IndicePosteAnnuel(ItemCoicop itemCoicop, Echantillon echantillon, Territoire territoire) {
      super(itemCoicop, echantillon, territoire);
   }

   public IndicePosteAnnuel(ItemCoicop itemCoicop, Echantillon echantillon, Territoire territoire, BigDecimal ipcBaseDiffusion, BigDecimal ipchBaseDiffusion) {
      super(itemCoicop, echantillon, territoire);
      this.ipcBaseDiffusion = ipcBaseDiffusion;
      this.ipchBaseDiffusion = ipchBaseDiffusion;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
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

   public BigDecimal getIpcMoy() {
      return ipcMoy;
   }

   public void setIpcMoy(BigDecimal ipcMoy) {
      this.ipcMoy = ipcMoy;
   }

   public BigDecimal getIpchMoy() {
      return ipchMoy;
   }

   public void setIpchMoy(BigDecimal ipchMoy) {
      this.ipchMoy = ipchMoy;
   }

   public BigDecimal getIpcDiffMoy() {
      return ipcDiffMoy;
   }

   public void setIpcDiffMoy(BigDecimal ipcDiffMoy) {
      this.ipcDiffMoy = ipcDiffMoy;
   }

   public BigDecimal getIpchDiffMoy() {
      return ipchDiffMoy;
   }

   public void setIpchDiffMoy(BigDecimal ipchDiffMoy) {
      this.ipchDiffMoy = ipchDiffMoy;
   }

}
