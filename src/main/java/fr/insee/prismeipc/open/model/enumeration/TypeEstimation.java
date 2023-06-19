package fr.insee.prismeipc.open.model.enumeration;

public enum TypeEstimation {
   INIT_CHANGEMENT_ANNEE_SANS_REPORT("Z", 7), //
   INIT_CHANGEMENT_ANNEE_AVEC_REPORT("T", 6), //
   REDRESSE("R", 5), //
   MANUEL("M", 4), //
   INDICE_IPC_DIFFERENT_IPCH("H", 2), //
   MANUEL_COVID("I", 3), //
   DDC("D", 1), //
   ;

   private final String codeOldIpc;
   private final int priorite;

   private TypeEstimation(String codeOldIpc, int priorite) {
      this.codeOldIpc = codeOldIpc;
      this.priorite = priorite;
   }

   public String getCodeOldIpc() {
      return codeOldIpc;
   }

   public int getPriorite() {
      return priorite;
   }

}
