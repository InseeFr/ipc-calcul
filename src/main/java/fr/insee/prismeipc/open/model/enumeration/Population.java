package fr.insee.prismeipc.open.model.enumeration;

public enum Population {

   TOTALE("T"), //
   MODESTE("M"), //
   LOYER("L"); //

   private final String codePopulation;

   private Population(String codePopulation) {
      this.codePopulation = codePopulation;
   }

   public String getCodePopulation() {
      return codePopulation;
   }

   public static Population valueFromCode(String code) {
      switch (code) {
         case "T":
            return TOTALE;
         case "M":
            return MODESTE;
         case "L":
            return LOYER;
         default:
            return null;
      }
   }

}
