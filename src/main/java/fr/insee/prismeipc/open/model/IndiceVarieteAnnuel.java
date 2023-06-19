package fr.insee.prismeipc.open.model;

import java.math.BigDecimal;

public class IndiceVarieteAnnuel {
   private Long id;

   private VarieteEchantillon varieteEchantillon;
   private BigDecimal ipcMoyenne;
   private BigDecimal ipcDiffusionMoyenne;
   private BigDecimal ipcPrixMoyenMoyenne;
   private BigDecimal ipcBaseDiffusion;
   private BigDecimal ipchBaseDiffusion;
   private BigDecimal isjBaseDiffusion;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public VarieteEchantillon getVarieteEchantillon() {
      return varieteEchantillon;
   }

   public void setVarieteEchantillon(VarieteEchantillon varieteEchantillon) {
      this.varieteEchantillon = varieteEchantillon;
   }

   public BigDecimal getIpcMoyenne() {
      return ipcMoyenne;
   }

   public void setIpcMoyenne(BigDecimal ipcMoyenne) {
      this.ipcMoyenne = ipcMoyenne;
   }

   public BigDecimal getIpcDiffusionMoyenne() {
      return ipcDiffusionMoyenne;
   }

   public void setIpcDiffusionMoyenne(BigDecimal ipcDiffusionMoyenne) {
      this.ipcDiffusionMoyenne = ipcDiffusionMoyenne;
   }

   public BigDecimal getIpcPrixMoyenMoyenne() {
      return ipcPrixMoyenMoyenne;
   }

   public void setIpcPrixMoyenMoyenne(BigDecimal ipcPrixMoyenMoyenne) {
      this.ipcPrixMoyenMoyenne = ipcPrixMoyenMoyenne;
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

   public BigDecimal getIsjBaseDiffusion() {
      return isjBaseDiffusion;
   }

   public void setIsjBaseDiffusion(BigDecimal isjBaseDiffusion) {
      this.isjBaseDiffusion = isjBaseDiffusion;
   }

   @Override
   public String toString() {
      return "IndiceVarieteAnnuel [id=" + id + ", varieteEchantillonId=" + (varieteEchantillon.getId() != null ? varieteEchantillon
         .getId() : null) + ", ipcMoyenne=" + ipcMoyenne + ", ipcDiffusionMoyenne=" + ipcDiffusionMoyenne + ", ipcPrixMoyenMoyenne=" + ipcPrixMoyenMoyenne + ", ipcBaseDiffusion=" + ipcBaseDiffusion + ", ipchBaseDiffusion=" + ipchBaseDiffusion + ", isjBaseDiffusion=" + isjBaseDiffusion + "]";
   }

}
