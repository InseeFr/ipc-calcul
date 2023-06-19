package fr.insee.prismeipc.open.model;

import java.math.BigDecimal;

import fr.insee.prismeipc.open.model.enumeration.Population;

public abstract class IndiceCoicopMensuelAbstract extends IdMetierIndiceCoicopMensuelAbstract {

   protected BigDecimal ipc;
   protected BigDecimal ipch;
   protected BigDecimal ipcProvisoire;
   protected BigDecimal ipchProvisoire;
   protected BigDecimal ipcDiffusion;
   protected BigDecimal ipchDiffusion;
   protected BigDecimal ipcDiffusionProvisoire;
   protected BigDecimal ipchDiffusionProvisoire;
   protected BigDecimal itc;

   protected IndiceCoicopMensuelAbstract() {
      super();
   }

   protected IndiceCoicopMensuelAbstract(ItemCoicop itemCoicop, Echantillon echantillon, Territoire territoire) {
      super();
      this.itemCoicop = itemCoicop;
      this.echantillon = echantillon;
      this.territoire = territoire;
   }

   protected IndiceCoicopMensuelAbstract(IndiceCoicopMensuelAbstract indiceCoicopMensuelAbstract) {
      this.mois = indiceCoicopMensuelAbstract.getMois();
      this.itemCoicop = indiceCoicopMensuelAbstract.getItemCoicop();
      this.echantillon = indiceCoicopMensuelAbstract.getEchantillon();
      this.territoire = indiceCoicopMensuelAbstract.getTerritoire();
      this.ipc = indiceCoicopMensuelAbstract.getIpc();
      this.ipch = indiceCoicopMensuelAbstract.getIpch();
      this.ipcProvisoire = indiceCoicopMensuelAbstract.getIpcProvisoire();
      this.ipchProvisoire = indiceCoicopMensuelAbstract.getIpchProvisoire();
      this.ipcDiffusion = indiceCoicopMensuelAbstract.getIpcDiffusion();
      this.ipchDiffusion = indiceCoicopMensuelAbstract.getIpchDiffusion();
      this.ipcDiffusionProvisoire = indiceCoicopMensuelAbstract.getIpcDiffusionProvisoire();
      this.ipchDiffusionProvisoire = indiceCoicopMensuelAbstract.getIpchDiffusionProvisoire();
   }

   public IndiceCoicopMensuelAbstract(ItemCoicop itemCoicop, Echantillon echantillon, Territoire territoire, BigDecimal ipc, BigDecimal ipch, BigDecimal ipcProvisoire, BigDecimal ipchProvisoire,
      BigDecimal ipcDiffusion, BigDecimal ipchDiffusion, BigDecimal ipcDiffusionProvisoire, BigDecimal ipchDiffusionProvisoire) {
      super(itemCoicop, echantillon, territoire);
      this.ipc = ipc;
      this.ipch = ipch;
      this.ipcProvisoire = ipcProvisoire;
      this.ipchProvisoire = ipchProvisoire;
      this.ipcDiffusion = ipcDiffusion;
      this.ipchDiffusion = ipchDiffusion;
      this.ipcDiffusionProvisoire = ipcDiffusionProvisoire;
      this.ipchDiffusionProvisoire = ipchDiffusionProvisoire;
   }

   public abstract Population getPopulation();

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

   public BigDecimal getItc() {
      return itc;
   }

   public void setItc(BigDecimal itc) {
      this.itc = itc;
   }

}
