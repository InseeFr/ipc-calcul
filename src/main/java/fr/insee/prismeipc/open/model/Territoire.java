package fr.insee.prismeipc.open.model;

import java.util.HashSet;
import java.util.Set;

public class Territoire {
   private static final String CODE_FRANCE_ENTIERE = "FRE";
   public static final String CODE_FRANCE_METROPOLITAINE = "MET";
   public static final String CODE_MAYOTTE = "MAY";

   private Long id;
   private String code;
   private String libelle;
   private Long tri;
   private Long oldId;

   private Set<Agglomeration> agglomerations = new HashSet<>();
   private Set<String> codesSitesApurement;

   public Territoire() {
      super();
   }

   public Territoire(Long id, String code, String libelle, Long oldId) {
      super();
      this.id = id;
      this.code = code;
      this.libelle = libelle;
      this.oldId = oldId;
   }

   public void addAgglomeration(Agglomeration agglomeration) {
      if (agglomerations.stream().anyMatch(a -> a.getId().equals(agglomeration.getId()))) {
         return;
      }
      agglomerations.add(agglomeration);
   }

   public boolean isFranceEntiere() {
      return CODE_FRANCE_ENTIERE.equals(code);
   }

   public boolean isFranceMetropolitaine() {
      return CODE_FRANCE_METROPOLITAINE.equals(code);
   }

   public boolean isMayotte() {
      return CODE_MAYOTTE.equals(code);
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

   public Long getTri() {
      return tri;
   }

   public void setTri(Long tri) {
      this.tri = tri;
   }

   public Long getOldId() {
      return oldId;
   }

   public void setOldId(Long oldId) {
      this.oldId = oldId;
   }

   public Set<Agglomeration> getAgglomerations() {
      return agglomerations;
   }

   public void setAgglomerations(Set<Agglomeration> agglomerations) {
      this.agglomerations = agglomerations;
   }

   @Override
   public String toString() {
      return "Territoire [id=" + id + ", code=" + code + ", libelle=" + libelle + ", tri=" + tri + ", oldId=" + oldId + ", agglomerations=" + agglomerations.size() + "]";
   }

   public Set<String> getCodesSitesApurement() {
      return codesSitesApurement;
   }

   public void setCodesSitesApurement(Set<String> codesSitesApurement) {
      this.codesSitesApurement = codesSitesApurement;
   }

}
