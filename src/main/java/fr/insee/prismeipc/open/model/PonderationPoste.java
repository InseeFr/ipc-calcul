package fr.insee.prismeipc.open.model;

import java.math.BigDecimal;

import fr.insee.prismeipc.open.model.enumeration.Population;

public class PonderationPoste extends PonderationCoicopAbstract {

   public PonderationPoste() {
      super();
   }

   public PonderationPoste(ItemCoicop itemCoicop, Territoire territoire, Echantillon echantillon, Population population, BigDecimal poidsIpcDansCoicop, Integer poidsIpcDiffusionDansCoicop,
      BigDecimal poidsIpchDansCoicop, Integer poidsIpchDiffusionDansCoicop) {
      super(itemCoicop, territoire, echantillon, population, poidsIpcDansCoicop, poidsIpcDiffusionDansCoicop, poidsIpchDansCoicop, poidsIpchDiffusionDansCoicop);
   }

   @Override
   public String toString() {
      return "PonderationPoste [getItemCoicop()=" + getItemCoicop() + ", getEchantillon()=" + getEchantillon() + ", getPopulation()=" + getPopulation() + ", getPoidsIpcDansCoicop()=" + getPoidsIpcDansCoicop() + ", getPoidsIpcDiffusionDansCoicop()=" + getPoidsIpcDiffusionDansCoicop() + ", getPoidsIpchDansCoicop()=" + getPoidsIpchDansCoicop() + ", getPoidsIpchDiffusionDansCoicop()=" + getPoidsIpchDiffusionDansCoicop() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
   }

}
