package fr.insee.prismeipc.open.model;

import java.math.BigDecimal;

import fr.insee.prismeipc.open.model.enumeration.Population;

public class IndiceCoicopMensuel extends IndiceCoicopMensuelAbstract {

   private Long id;
   protected Population population;
   private BigDecimal itcDiffusion;

   public IndiceCoicopMensuel() {
      super();
   }

   public IndiceCoicopMensuel(Long id, ItemCoicop itemCoicop, Territoire territoire, Echantillon echantillon, Population population, Short mois, BigDecimal ipc, BigDecimal ipch,
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

   public Population getPopulation() {
      return population;
   }

   public void setPopulation(Population population) {
      this.population = population;
   }

   public BigDecimal getItcDiffusion() {
      return itcDiffusion;
   }

   public void setItcDiffusion(BigDecimal itcDiffusion) {
      this.itcDiffusion = itcDiffusion;
   }

   @Override
   public String toString() {
      return "IndiceCoicopMensuel [id=" + id + ", itemCoicop.id=" + (itemCoicop != null ? itemCoicop.getId().toString() : null) + ", echantillon.id=" + (echantillon != null ? echantillon.getId()
         .toString() : null) + ", mois=" + mois + ", population=" + population + ", territoire.id=" + (territoire != null ? territoire.getId()
            .toString() : null) + ", ipc=" + ipc + ", ipch=" + ipch + ", ipcProvisoire=" + ipcProvisoire + ", ipchProvisoire=" + ipchProvisoire + ", ipcDiffusion=" + ipcDiffusion + ", ipchDiffusion=" + ipchDiffusion + ", ipcDiffusionProvisoire=" + ipcDiffusionProvisoire + ", ipchDiffusionProvisoire=" + ipchDiffusionProvisoire + ", itc=" + itc + ", itcDiffusion=" + itcDiffusion + "]";
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = super.hashCode();
      result = prime * result + ((population == null) ? 0 : population.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) return true;
      if (!super.equals(obj)) return false;
      if (getClass() != obj.getClass()) return false;
      IndiceCoicopMensuel other = (IndiceCoicopMensuel) obj;
      if (population != other.population) return false;
      return true;
   }

}
