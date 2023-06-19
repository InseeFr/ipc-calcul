package fr.insee.prismeipc.open.model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Commune {
   private Long id;
   private String code;
   private String libelle;

   private Set<Agglomeration> agglomerations = new HashSet<>();

   public Commune() {
      super();
   }

   public Commune(Long id) {
      super();
      this.id = id;
   }

   public void addAgglomeration(Agglomeration agglomeration) {
      if (agglomerations.stream().anyMatch(a -> a.getId().equals(agglomeration.getId()))) {
         return;
      }
      agglomerations.add(agglomeration);
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getLibelle() {
      return libelle;
   }

   public void setLibelle(String libelle) {
      this.libelle = libelle;
   }

   public String getCode() {
      return code;
   }

   public void setCode(String code) {
      this.code = code;
   }

   public Set<Agglomeration> getAgglomerations() {
      return agglomerations;
   }

   public void setAgglomerations(Set<Agglomeration> agglomerations) {
      this.agglomerations = agglomerations;
   }

   @Override
   public String toString() {
      return "Commune [id=" + id + ", code=" + code + ", libelle=" + libelle + ", stratesGeographiques=" + agglomerations.stream().map(Agglomeration::getId).collect(Collectors.toSet()) + "]";
   }

}
