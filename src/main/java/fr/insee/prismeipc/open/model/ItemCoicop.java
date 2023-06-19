package fr.insee.prismeipc.open.model;

import fr.insee.prismeipc.open.model.enumeration.NiveauCoicop;

public class ItemCoicop {
   private Long id;

   private String code;
   private String libelleCourt;
   private String libelleLong;
   private Coicop coicop;
   private ItemCoicop parent;
   private NiveauCoicop niveau;

   public ItemCoicop() {
      super();
   }

   public ItemCoicop(Long id, String code, ItemCoicop parent, NiveauCoicop niveau) {
      super();
      this.id = id;
      this.code = code;
      this.parent = parent;
      this.niveau = niveau;
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

   public String getLibelleCourt() {
      return libelleCourt;
   }

   public void setLibelleCourt(String libelleCourt) {
      this.libelleCourt = libelleCourt;
   }

   public String getLibelleLong() {
      return libelleLong;
   }

   public void setLibelleLong(String libelleLong) {
      this.libelleLong = libelleLong;
   }

   public Coicop getCoicop() {
      return coicop;
   }

   public void setCoicop(Coicop coicop) {
      this.coicop = coicop;
   }

   public ItemCoicop getParent() {
      return parent;
   }

   public void setParent(ItemCoicop parent) {
      this.parent = parent;
   }

   public NiveauCoicop getNiveau() {
      return niveau;
   }

   public void setNiveau(NiveauCoicop niveau) {
      this.niveau = niveau;
   }

   @Override
   public String toString() {
      return "ItemCoicop [id=" + id + ", code=" + code + ", libelleCourt=" + libelleCourt + ", libelleLong=" + libelleLong + ", coicop=" + coicop + ", parent.id=" + (parent != null ? parent.getId()
         .toString() : null) + ", niveau=" + niveau + "]";
   }

   public String getCodeWithoutDot() {
      return code.replaceAll("\\.", "");
   }

}
