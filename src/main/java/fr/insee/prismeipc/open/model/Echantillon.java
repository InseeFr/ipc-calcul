package fr.insee.prismeipc.open.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Echantillon {

   private Long id;
   private Short annee;

   private Set<StrateEchantillon> stratesEchantillon = new HashSet<>();

   public Echantillon() {
      super();
   }

   public Echantillon(Short annee) {
      super();
      this.annee = annee;
   }

   public Echantillon(Long id, Short annee) {
      super();
      this.id = id;
      this.annee = annee;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public Short getAnnee() {
      return annee;
   }

   public void setAnnee(Short annee) {
      this.annee = annee;
   }

   public Set<StrateEchantillon> getStratesEchantillon() {
      return stratesEchantillon;
   }

   public void setStratesEchantillon(Set<StrateEchantillon> stratesEchantillon) {
      this.stratesEchantillon = stratesEchantillon;
   }

   @Override
   public String toString() {
      return "Echantillon [id=" + id + ", annee=" + annee + "]";
   }

   @Override
   public int hashCode() {
      return Objects.hash(annee, id);
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null) return false;
      if (getClass() != obj.getClass()) return false;
      Echantillon other = (Echantillon) obj;
      return Objects.equals(annee, other.annee) && Objects.equals(id, other.id);
   }

}
