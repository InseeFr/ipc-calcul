package fr.insee.prismeipc.open.model;

import java.math.BigDecimal;

import fr.insee.prismeipc.open.model.enumeration.TypeEstimation;
import fr.insee.prismeipc.open.model.enumeration.TypeIndiceVarieteMensuel;

public class IndiceVarieteMensuel extends IndiceVarieteMensuelAbstract {

   private BigDecimal ipcPrixMoyen;
   private BigDecimal ipchPrixMoyen;
   private BigDecimal ipcPrixMoyenProvisoire;
   private BigDecimal ipchPrixMoyenProvisoire;
   private TypeEstimation typeEstimation;
   private TypeEstimation typeEstimationProvisoire;

   public IndiceVarieteMensuel() {
      super();
   }

   public IndiceVarieteMensuel(VarieteEchantillon varieteEchantillon, short mois) {
      super();
      super.setVarieteEchantillon(varieteEchantillon);
      super.setMois(mois);
   }

   public IndiceVarieteMensuel(VarieteEchantillon varieteEchantillon, Short mois, TypeIndiceVarieteMensuel type, BigDecimal ipc, BigDecimal ipch, BigDecimal ipcProvisoire, BigDecimal ipchProvisoire,
      BigDecimal ipcDiffusion, BigDecimal ipchDiffusion, BigDecimal ipcDiffusionProvisoire, BigDecimal ipchDiffusionProvisoire) {
      super();
      super.setVarieteEchantillon(varieteEchantillon);
      super.setMois(mois);
      super.setType(type);
      super.setIpc(ipc);
      super.setIpch(ipch);
      super.setIpcProvisoire(ipcProvisoire);
      super.setIpchProvisoire(ipchProvisoire);
      super.setIpcDiffusion(ipcDiffusion);
      super.setIpchDiffusion(ipchDiffusion);
      super.setIpcDiffusionProvisoire(ipcDiffusionProvisoire);
      super.setIpchDiffusionProvisoire(ipchDiffusionProvisoire);
   }

   public BigDecimal getIpcPrixMoyen() {
      return ipcPrixMoyen;
   }

   public void setIpcPrixMoyen(BigDecimal ipcPrixMoyen) {
      this.ipcPrixMoyen = ipcPrixMoyen;
   }

   public BigDecimal getIpchPrixMoyen() {
      return ipchPrixMoyen;
   }

   public void setIpchPrixMoyen(BigDecimal ipchPrixMoyen) {
      this.ipchPrixMoyen = ipchPrixMoyen;
   }

   public BigDecimal getIpcPrixMoyenProvisoire() {
      return ipcPrixMoyenProvisoire;
   }

   public void setIpcPrixMoyenProvisoire(BigDecimal ipcPrixMoyenProvisoire) {
      this.ipcPrixMoyenProvisoire = ipcPrixMoyenProvisoire;
   }

   public BigDecimal getIpchPrixMoyenProvisoire() {
      return ipchPrixMoyenProvisoire;
   }

   public void setIpchPrixMoyenProvisoire(BigDecimal ipchPrixMoyenProvisoire) {
      this.ipchPrixMoyenProvisoire = ipchPrixMoyenProvisoire;
   }

   public TypeEstimation getTypeEstimation() {
      return typeEstimation;
   }

   public void setTypeEstimation(TypeEstimation typeEstimation) {
      this.typeEstimation = typeEstimation;
   }

   public TypeEstimation getTypeEstimationProvisoire() {
      return typeEstimationProvisoire;
   }

   public void setTypeEstimationProvisoire(TypeEstimation typeEstimationProvisoire) {
      this.typeEstimationProvisoire = typeEstimationProvisoire;
   }

   @Override
   public String toString() {
      return "IndiceVarieteMensuel [id=" + getId() + ", varieteEchantillon=" + getVarieteEchantillon() + ", mois=" + getMois() + "]";
   }

}
