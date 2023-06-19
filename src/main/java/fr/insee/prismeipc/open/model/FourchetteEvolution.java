package fr.insee.prismeipc.open.model;

public class FourchetteEvolution {

   private Long id;
   private boolean prixPromotionnelMoisCourant;
   private boolean prixPromotionnelMoisPrecedent;
   private Double borneInf;
   private Double borneSup;

   private VarieteEchantillon varieteEchantillon;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public boolean isPrixPromotionnelMoisCourant() {
      return prixPromotionnelMoisCourant;
   }

   public void setPrixPromotionnelMoisCourant(boolean prixPromotionnelMoisCourant) {
      this.prixPromotionnelMoisCourant = prixPromotionnelMoisCourant;
   }

   public boolean isPrixPromotionnelMoisPrecedent() {
      return prixPromotionnelMoisPrecedent;
   }

   public void setPrixPromotionnelMoisPrecedent(boolean prixPromotionnelMoisPrecedent) {
      this.prixPromotionnelMoisPrecedent = prixPromotionnelMoisPrecedent;
   }

   public VarieteEchantillon getVarieteEchantillon() {
      return varieteEchantillon;
   }

   public void setVarieteEchantillon(VarieteEchantillon varieteEchantillon) {
      this.varieteEchantillon = varieteEchantillon;
   }

   public Double getBorneInf() {
      return borneInf;
   }

   public void setBorneInf(Double borneInf) {
      this.borneInf = borneInf;
   }

   public Double getBorneSup() {
      return borneSup;
   }

   public void setBorneSup(Double borneSup) {
      this.borneSup = borneSup;
   }

   @Override
   public String toString() {
      return "FourchetteEvolution [id=" + id + ", prixPromotionnelMoisCourant=" + prixPromotionnelMoisCourant + ", prixPromotionnelMoisPrecedent=" + prixPromotionnelMoisPrecedent + ", borneInf=" + borneInf + ", borneSup=" + borneSup + ", varieteEchantillon=" + varieteEchantillon + "]";
   }

   public void update(FourchetteEvolution nouvelleFourchette) {
      borneInf = nouvelleFourchette.getBorneInf();
      borneSup = nouvelleFourchette.getBorneSup();

   }
}
