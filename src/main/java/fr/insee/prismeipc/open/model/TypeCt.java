package fr.insee.prismeipc.open.model;

import fr.insee.prismeipc.open.model.enumeration.TypeDonneeCT;

public class TypeCt {

   private Long id;

   private String caracteristiqueTechniqueId;
   private VarieteEchantillon varieteEchantillon;
   private TypeDonneeCT type;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getCaracteristiqueTechniqueId() {
      return caracteristiqueTechniqueId;
   }

   public void setCaracteristiqueTechniqueId(String caracteristiqueTechniqueId) {
      this.caracteristiqueTechniqueId = caracteristiqueTechniqueId;
   }

   public TypeDonneeCT getType() {
      return type;
   }

   public void setType(TypeDonneeCT type) {
      this.type = type;
   }

   public VarieteEchantillon getVarieteEchantillon() {
      return varieteEchantillon;
   }

   public void setVarieteEchantillon(VarieteEchantillon varieteEchantillon) {
      this.varieteEchantillon = varieteEchantillon;
   }

   public void update(TypeCt nouveauTypeCt) {
      this.type = nouveauTypeCt.getType();
   }

}
