package fr.insee.prismeipc.open.exception;

public class NotFoundException extends Exception {

   private static final long serialVersionUID = -9097661257341801239L;

   public NotFoundException() {
      super();
   }

   public NotFoundException(String message) {
      super("NotFoundException - " + message);
   }

   public NotFoundException(String message, boolean beautifulMessage) {
      super(beautifulMessage ? message : "NotFoundException - " + message);
   }
}
