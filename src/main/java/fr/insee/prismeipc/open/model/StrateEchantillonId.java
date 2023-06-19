package fr.insee.prismeipc.open.model;

import java.io.Serializable;

public class StrateEchantillonId implements Serializable {

   private static final long serialVersionUID = -8690914828207217251L;

   private Long strate;
   private Long echantillon;

   public StrateEchantillonId() {
      super();
   }

   public StrateEchantillonId(Long strate, Long echantillon) {
      super();
      this.strate = strate;
      this.echantillon = echantillon;
   }

   public Long getStrate() {
      return strate;
   }

   public void setStrate(Long strate) {
      this.strate = strate;
   }

   public Long getEchantillon() {
      return echantillon;
   }

   public void setEchantillon(Long echantillon) {
      this.echantillon = echantillon;
   }

   @Override
   public String toString() {
      return "StrateEchantillonId [strate=" + strate + ", echantillon=" + echantillon + "]";
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((echantillon == null) ? 0 : echantillon.hashCode());
      result = prime * result + ((strate == null) ? 0 : strate.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null) return false;
      if (getClass() != obj.getClass()) return false;
      StrateEchantillonId other = (StrateEchantillonId) obj;
      if (echantillon == null) {
         if (other.echantillon != null) return false;
      } else if (!echantillon.equals(other.echantillon)) return false;
      if (strate == null) {
         if (other.strate != null) return false;
      } else if (!strate.equals(other.strate)) return false;
      return true;
   }

}
