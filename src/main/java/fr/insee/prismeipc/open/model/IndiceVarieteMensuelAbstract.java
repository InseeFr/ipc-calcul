package fr.insee.prismeipc.open.model;

import java.math.BigDecimal;

import fr.insee.prismeipc.open.model.enumeration.TypeIndiceVarieteMensuel;

public class IndiceVarieteMensuelAbstract {
   private Long id;

   private VarieteEchantillon varieteEchantillon;
   private short mois;
   private TypeIndiceVarieteMensuel type;
   private BigDecimal ipc;
   private BigDecimal ipch;
   private BigDecimal ipcProvisoire;
   private BigDecimal ipchProvisoire;
   private BigDecimal ipcDiffusion;
   private BigDecimal ipchDiffusion;
   private BigDecimal ipcDiffusionProvisoire;
   private BigDecimal ipchDiffusionProvisoire;
   private BigDecimal itcCoeff;
   private BigDecimal isjCoeff;
   private BigDecimal isjCoeffProvisoire;
   private BigDecimal isj;
   private BigDecimal isjProvisoire;
   private BigDecimal isjDiffusion;
   private BigDecimal isjDiffusionProvisoire;

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

   public short getMois() {
      return mois;
   }

   public void setMois(short mois) {
      this.mois = mois;
   }

   public BigDecimal getIpc() {
      return ipc;
   }

   public void setIpc(BigDecimal ipc) {
      this.ipc = ipc;
   }

   public BigDecimal getIpch() {
      return ipch;
   }

   public void setIpch(BigDecimal ipch) {
      this.ipch = ipch;
   }

   public BigDecimal getIpcProvisoire() {
      return ipcProvisoire;
   }

   public void setIpcProvisoire(BigDecimal ipcProvisoire) {
      this.ipcProvisoire = ipcProvisoire;
   }

   public BigDecimal getIpchProvisoire() {
      return ipchProvisoire;
   }

   public void setIpchProvisoire(BigDecimal ipchProvisoire) {
      this.ipchProvisoire = ipchProvisoire;
   }

   public BigDecimal getIpcDiffusion() {
      return ipcDiffusion;
   }

   public void setIpcDiffusion(BigDecimal ipcDiffusion) {
      this.ipcDiffusion = ipcDiffusion;
   }

   public BigDecimal getIpchDiffusion() {
      return ipchDiffusion;
   }

   public void setIpchDiffusion(BigDecimal ipchDiffusion) {
      this.ipchDiffusion = ipchDiffusion;
   }

   public BigDecimal getIpcDiffusionProvisoire() {
      return ipcDiffusionProvisoire;
   }

   public void setIpcDiffusionProvisoire(BigDecimal ipcDiffusionProvisoire) {
      this.ipcDiffusionProvisoire = ipcDiffusionProvisoire;
   }

   public BigDecimal getIpchDiffusionProvisoire() {
      return ipchDiffusionProvisoire;
   }

   public void setIpchDiffusionProvisoire(BigDecimal ipchDiffusionProvisoire) {
      this.ipchDiffusionProvisoire = ipchDiffusionProvisoire;
   }

   public TypeIndiceVarieteMensuel getType() {
      return type;
   }

   public void setType(TypeIndiceVarieteMensuel type) {
      this.type = type;
   }

   public BigDecimal getItcCoeff() {
      return itcCoeff;
   }

   public void setItcCoeff(BigDecimal itcCoeff) {
      this.itcCoeff = itcCoeff;
   }

   public BigDecimal getIsjCoeff() {
      return isjCoeff;
   }

   public void setIsjCoeff(BigDecimal isjCoeff) {
      this.isjCoeff = isjCoeff;
   }

   public BigDecimal getIsjCoeffProvisoire() {
      return isjCoeffProvisoire;
   }

   public void setIsjCoeffProvisoire(BigDecimal isjCoeffProvisoire) {
      this.isjCoeffProvisoire = isjCoeffProvisoire;
   }

   public BigDecimal getIsj() {
      return isj;
   }

   public void setIsj(BigDecimal isj) {
      this.isj = isj;
   }

   public BigDecimal getIsjProvisoire() {
      return isjProvisoire;
   }

   public void setIsjProvisoire(BigDecimal isjProvisoire) {
      this.isjProvisoire = isjProvisoire;
   }

   public BigDecimal getIsjDiffusion() {
      return isjDiffusion;
   }

   public void setIsjDiffusion(BigDecimal isjDiffusion) {
      this.isjDiffusion = isjDiffusion;
   }

   public BigDecimal getIsjDiffusionProvisoire() {
      return isjDiffusionProvisoire;
   }

   public void setIsjDiffusionProvisoire(BigDecimal isjDiffusionProvisoire) {
      this.isjDiffusionProvisoire = isjDiffusionProvisoire;
   }
}
