package fr.insee.prismeipc.open.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class GroupeStrates {
   private Long id;
   private String code;
   private String libelle;

   private Set<Strate> strates = new HashSet<>();

   public void addStrate(Strate strate) {
      if (strates.stream().anyMatch(s -> s.getId().equals(strate.getId()))) {
         return;
      }
      strates.add(strate);
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getCode() {
      return code;
   }

   public void setCode(String code) {
      this.code = code;
   }

   public String getLibelle() {
      return libelle;
   }

   public void setLibelle(String libelle) {
      this.libelle = libelle;
   }

   public Set<Strate> getStrates() {
      return strates;
   }

   public void setStrates(Set<Strate> strates) {
      this.strates = strates;
   }

   @Override
   public String toString() {
      return "Groupe [id=" + id + ", code=" + code + ", libelle=" + libelle + "]";
   }

   @Override
   public int hashCode() {
      return Objects.hash(code, id, libelle);
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null) return false;
      if (getClass() != obj.getClass()) return false;
      GroupeStrates other = (GroupeStrates) obj;
      return Objects.equals(code, other.code) && Objects.equals(id, other.id) && Objects.equals(libelle, other.libelle);
   }

}
