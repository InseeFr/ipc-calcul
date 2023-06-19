package fr.insee.prismeipc.open.model;

import java.io.Serializable;

import fr.insee.prismeipc.open.model.enumeration.FormeDeVente;

public class VarieteEchantillonCibleId implements Serializable {

   private static final long serialVersionUID = -7813096152960817378L;

   private Long varieteEchantillon;
   private FormeDeVente formeDeVente;

   public Long getVarieteEchantillon() {
      return varieteEchantillon;
   }

   public void setVarieteEchantillon(Long varieteEchantillon) {
      this.varieteEchantillon = varieteEchantillon;
   }

   public FormeDeVente getFormeDeVente() {
      return formeDeVente;
   }

   public void setFormeDeVente(FormeDeVente formeDeVente) {
      this.formeDeVente = formeDeVente;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((formeDeVente == null) ? 0 : formeDeVente.hashCode());
      result = prime * result + ((varieteEchantillon == null) ? 0 : varieteEchantillon.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null) return false;
      if (getClass() != obj.getClass()) return false;
      VarieteEchantillonCibleId other = (VarieteEchantillonCibleId) obj;
      if (formeDeVente != other.formeDeVente) return false;
      if (varieteEchantillon == null) {
         if (other.varieteEchantillon != null) return false;
      } else if (!varieteEchantillon.equals(other.varieteEchantillon)) return false;
      return true;
   }

   @Override
   public String toString() {
      return "VarieteEchantillonCibleId [varieteEchantillon=" + varieteEchantillon + ", formeDeVente=" + formeDeVente + "]";
   }

}
