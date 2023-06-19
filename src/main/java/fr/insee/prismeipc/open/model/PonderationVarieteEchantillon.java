package fr.insee.prismeipc.open.model;

import java.math.BigDecimal;

public class PonderationVarieteEchantillon {

   private Long id;

   private VarieteEchantillon varieteEchantillon;
   private BigDecimal poidsIpcDansCoicop;
   private BigDecimal poidsIpchDansCoicop;
   private Integer poidsIpcDansPoste;
   private BigDecimal poidsParDdcIpcDansPoste;
   private Integer poidsIpchDansPoste;
   private BigDecimal poidsParDdcIpchDansPoste;

   public PonderationVarieteEchantillon() {
      super();
   }

   public PonderationVarieteEchantillon(Integer poidsIpcDansPoste, Integer poidsIpchDansPoste, BigDecimal poidsIpcDansCoicop, BigDecimal poidsIpchDansCoicop) {
      super();
      this.poidsIpcDansPoste = poidsIpcDansPoste;
      this.poidsIpchDansPoste = poidsIpchDansPoste;
      this.poidsIpcDansCoicop = poidsIpcDansCoicop;
      this.poidsIpchDansCoicop = poidsIpchDansCoicop;
   }

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

   public BigDecimal getPoidsIpcDansCoicop() {
      return poidsIpcDansCoicop;
   }

   public void setPoidsIpcDansCoicop(BigDecimal poidsIpcDansCoicop) {
      this.poidsIpcDansCoicop = poidsIpcDansCoicop;
   }

   public BigDecimal getPoidsIpchDansCoicop() {
      return poidsIpchDansCoicop;
   }

   public void setPoidsIpchDansCoicop(BigDecimal poidsIpchDansCoicop) {
      this.poidsIpchDansCoicop = poidsIpchDansCoicop;
   }

   public Integer getPoidsIpcDansPoste() {
      return poidsIpcDansPoste;
   }

   public void setPoidsIpcDansPoste(Integer poidsIpcDansPoste) {
      this.poidsIpcDansPoste = poidsIpcDansPoste;
   }

   public BigDecimal getPoidsParDdcIpcDansPoste() {
      return poidsParDdcIpcDansPoste;
   }

   public void setPoidsParDdcIpcDansPoste(BigDecimal poidsParDdcIpcDansPoste) {
      this.poidsParDdcIpcDansPoste = poidsParDdcIpcDansPoste;
   }

   public Integer getPoidsIpchDansPoste() {
      return poidsIpchDansPoste;
   }

   public void setPoidsIpchDansPoste(Integer poidsIpchDansPoste) {
      this.poidsIpchDansPoste = poidsIpchDansPoste;
   }

   public BigDecimal getPoidsParDdcIpchDansPoste() {
      return poidsParDdcIpchDansPoste;
   }

   public void setPoidsParDdcIpchDansPoste(BigDecimal poidsParDdcIpchDansPoste) {
      this.poidsParDdcIpchDansPoste = poidsParDdcIpchDansPoste;
   }

   @Override
   public String toString() {
      return "PonderationVarieteEchantillon [id=" + id + ", varieteEchantillon=" + varieteEchantillon + ", poidsIpcDansCoicop=" + poidsIpcDansCoicop + ", poidsIpchDansCoicop=" + poidsIpchDansCoicop + ", poidsIpcDansPoste=" + poidsIpcDansPoste + ", poidsParDdcIpcDansPoste=" + poidsParDdcIpcDansPoste + ", poidsIpchDansPoste=" + poidsIpchDansPoste + ", poidsParDdcIpchDansPoste=" + poidsParDdcIpchDansPoste + "]";
   }

}
