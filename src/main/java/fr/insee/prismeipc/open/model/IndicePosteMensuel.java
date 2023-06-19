package fr.insee.prismeipc.open.model;

import java.math.BigDecimal;

import fr.insee.prismeipc.open.model.enumeration.Population;
import fr.insee.prismeipc.open.model.enumeration.TypeEstimation;

public class IndicePosteMensuel extends IndiceCoicopMensuelAbstract {

   private Long id;
   private TypeEstimation typeEstimationIpc;
   private TypeEstimation typeEstimationIpch;
   private TypeEstimation typeEstimationProvisoireIpc;
   private TypeEstimation typeEstimationProvisoireIpch;

   // N'existe pas dans la table, il est juste là pour simplifier le calcul des indices au niveau Coicop
   private Population population;

   public IndicePosteMensuel() {
      super();
   }

   public IndicePosteMensuel(ItemCoicop itemCoicop, Territoire territoire, Echantillon echantillon, Short mois) {
      super(itemCoicop, echantillon, territoire);
      this.mois = mois;
   }

   public IndicePosteMensuel(Long id, ItemCoicop itemCoicop, Territoire territoire, Echantillon echantillon, TypeEstimation typeEstimationIpc, TypeEstimation typeEstimationIpch,
      TypeEstimation typeEstimationProvisoireIpc, TypeEstimation typeEstimationProvisoireIpch, BigDecimal itc, Population population) {
      super(itemCoicop, echantillon, territoire);
      this.id = id;
      this.typeEstimationIpc = typeEstimationIpc;
      this.typeEstimationIpch = typeEstimationIpch;
      this.typeEstimationProvisoireIpc = typeEstimationProvisoireIpc;
      this.typeEstimationProvisoireIpch = typeEstimationProvisoireIpch;
      this.itc = itc;
      this.population = population;
   }

   public IndicePosteMensuel(IndicePosteMensuel indicePosteMensuel) {
      super(indicePosteMensuel);
      this.id = indicePosteMensuel.getId();
      this.typeEstimationIpc = indicePosteMensuel.getTypeEstimationIpc();
      this.typeEstimationIpch = indicePosteMensuel.getTypeEstimationIpch();
      this.typeEstimationProvisoireIpc = indicePosteMensuel.getTypeEstimationProvisoireIpc();
      this.typeEstimationProvisoireIpch = indicePosteMensuel.getTypeEstimationProvisoireIpch();
      this.itc = indicePosteMensuel.getItc();
      this.population = indicePosteMensuel.getPopulation();
   }

   public IndicePosteMensuel(Long id, ItemCoicop itemCoicop, Territoire territoire, Echantillon echantillon, Population population, Short mois, BigDecimal ipc, BigDecimal ipch,
      BigDecimal ipcProvisoire, BigDecimal ipchProvisoire, BigDecimal ipcDiffusion, BigDecimal ipchDiffusion, BigDecimal ipcDiffusionProvisoire, BigDecimal ipchDiffusionProvisoire) {
      super(itemCoicop, echantillon, territoire, ipc, ipch, ipcProvisoire, ipchProvisoire, ipcDiffusion, ipchDiffusion, ipcDiffusionProvisoire, ipchDiffusionProvisoire);
      this.id = id;
      this.mois = mois;
      this.population = population;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public TypeEstimation getTypeEstimationIpc() {
      return typeEstimationIpc;
   }

   public void setTypeEstimationIpc(TypeEstimation typeEstimationIpc) {
      this.typeEstimationIpc = typeEstimationIpc;
   }

   public TypeEstimation getTypeEstimationIpch() {
      return typeEstimationIpch;
   }

   public void setTypeEstimationIpch(TypeEstimation typeEstimationIpch) {
      this.typeEstimationIpch = typeEstimationIpch;
   }

   public TypeEstimation getTypeEstimationProvisoireIpc() {
      return typeEstimationProvisoireIpc;
   }

   public void setTypeEstimationProvisoireIpc(TypeEstimation typeEstimationProvisoireIpc) {
      this.typeEstimationProvisoireIpc = typeEstimationProvisoireIpc;
   }

   public TypeEstimation getTypeEstimationProvisoireIpch() {
      return typeEstimationProvisoireIpch;
   }

   public void setTypeEstimationProvisoireIpch(TypeEstimation typeEstimationProvisoireIpch) {
      this.typeEstimationProvisoireIpch = typeEstimationProvisoireIpch;
   }

   public Population getPopulation() {
      return population;
   }

   public void setPopulation(Population population) {
      this.population = population;
   }

   @Override
   public String toString() {
      return "IndicePosteMensuel [id=" + id + ",ipc=" + ipc + ", typeEstimationIpc=" + typeEstimationIpc + ", typeEstimationIpch=" + typeEstimationIpch + ", typeEstimationProvisoireIpc=" + typeEstimationProvisoireIpc + ", typeEstimationProvisoireIpch=" + typeEstimationProvisoireIpch + ", itc=" + itc + ", population=" + population + "]";
   }

}
