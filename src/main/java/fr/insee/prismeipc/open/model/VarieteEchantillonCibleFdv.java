package fr.insee.prismeipc.open.model;

import java.math.BigDecimal;

import fr.insee.prismeipc.open.model.enumeration.FormeDeVente;

public class VarieteEchantillonCibleFdv {

   private VarieteEchantillon varieteEchantillon;

   private FormeDeVente formeDeVente;
   private Long cible;
   private BigDecimal poidsReel;

   public VarieteEchantillon getVarieteEchantillon() {
      return varieteEchantillon;
   }

   public void setVarieteEchantillon(VarieteEchantillon varieteEchantillon) {
      this.varieteEchantillon = varieteEchantillon;
   }

   public FormeDeVente getFormeDeVente() {
      return formeDeVente;
   }

   public void setFormeDeVente(FormeDeVente formeDeVente) {
      this.formeDeVente = formeDeVente;
   }

   public Long getCible() {
      return cible;
   }

   public void setCible(Long cible) {
      this.cible = cible;
   }

   public BigDecimal getPoidsReel() {
      return poidsReel;
   }

   public void setPoidsReel(BigDecimal poidsReel) {
      this.poidsReel = poidsReel;
   }

   @Override
   public String toString() {
      return "VarieteEchantillonCibleFdv [varieteEchantillon.id=" + varieteEchantillon.getId() + ", formeDeVente=" + formeDeVente + ", cible=" + cible + ", poidsReel=" + poidsReel + "]";
   }

}
