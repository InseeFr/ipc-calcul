package fr.insee.prismeipc.open.model;

import java.math.BigDecimal;

import fr.insee.prismeipc.open.model.enumeration.Population;

public class PonderationCoicop extends PonderationCoicopAbstract {

   public PonderationCoicop() {
      super();
   }

   public PonderationCoicop(ItemCoicop itemCoicop, Territoire territoire, Echantillon echantillon, Population population, BigDecimal poidsIpcDansCoicop, Integer poidsIpcDiffusionDansCoicop,
      BigDecimal poidsIpchDansCoicop, Integer poidsIpchDiffusionDansCoicop) {
      super(itemCoicop, territoire, echantillon, population, poidsIpcDansCoicop, poidsIpcDiffusionDansCoicop, poidsIpchDansCoicop, poidsIpchDiffusionDansCoicop);
   }

   @Override
   public String toString() {
      return "PonderationCoicop [getItemCoicop()=" + getItemCoicop() + ", getTerritoire()=" + getTerritoire()
         .getCode() + ", getEchantillon()=" + getEchantillon() + ", getPopulation()=" + getPopulation() + ", getPoidsIpcDansCoicop()=" + getPoidsIpcDansCoicop() + ", getPoidsIpcDiffusionDansCoicop()=" + getPoidsIpcDiffusionDansCoicop() + ", getPoidsIpchDansCoicop()=" + getPoidsIpchDansCoicop() + ", getPoidsIpchDiffusionDansCoicop()=" + getPoidsIpchDiffusionDansCoicop() + "]";
   }

}
