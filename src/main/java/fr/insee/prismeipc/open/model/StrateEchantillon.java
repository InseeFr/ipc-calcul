package fr.insee.prismeipc.open.model;

public class StrateEchantillon {

   private Strate strate;
   private Echantillon echantillon;

   private Double poidsSondage;

   public Strate getStrate() {
      return strate;
   }

   public void setStrate(Strate strate) {
      this.strate = strate;
   }

   public Echantillon getEchantillon() {
      return echantillon;
   }

   public void setEchantillon(Echantillon echantillon) {
      this.echantillon = echantillon;
   }

   public Double getPoidsSondage() {
      return poidsSondage;
   }

   public void setPoidsSondage(Double poidsSondage) {
      this.poidsSondage = poidsSondage;
   }

   @Override
   public String toString() {
      return "StrateEchantillon [strate=" + strate + ", echantillon=" + echantillon + ", poidsSondage=" + poidsSondage + "]";
   }

}
