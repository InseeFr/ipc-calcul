package fr.insee.prismeipc.open.model;

import java.util.HashSet;
import java.util.Set;

import fr.insee.prismeipc.open.model.enumeration.TypeStrate;

public class Strate {
   private Long id;

   private String code;
   private String libelle;
   private TypeStrate type;
   private GroupeStrates groupeStrates;
   private Set<StrateEchantillon> stratesEchantillon = new HashSet<>();
   private String siteCollecteCode;

   public Strate() {
      super();
   }

   public Strate(Long id) {
      super();
      this.id = id;
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

   public GroupeStrates getGroupeStrates() {
      return groupeStrates;
   }

   public void setGroupeStrates(GroupeStrates groupeStrates) {
      this.groupeStrates = groupeStrates;
   }

   public TypeStrate getType() {
      return type;
   }

   public Set<StrateEchantillon> getStratesEchantillon() {
      return stratesEchantillon;
   }

   public void setStratesEchantillon(Set<StrateEchantillon> stratesEchantillon) {
      this.stratesEchantillon = stratesEchantillon;
   }

   public String getGroupeStrateCode() {
      return (groupeStrates == null ? null : groupeStrates.getCode());
   }

   public void setType(TypeStrate type) {
      this.type = type;
   }

   public String getSiteCollecteCode() {
      return siteCollecteCode;
   }

   public void setSiteCollecteCode(String siteCollecteCode) {
      this.siteCollecteCode = siteCollecteCode;
   }

   @Override
   public String toString() {
      return "Strate [id=" + id + ", code=" + code + ", libelle=" + libelle + ", type=" + type + ", groupeStrates=" + groupeStrates + ", stratesEchantillon=" + stratesEchantillon + ", siteCollecteCode=" + siteCollecteCode + "]";
   }

}
