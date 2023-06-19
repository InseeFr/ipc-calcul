package fr.insee.prismeipc.open.model;

public class Coicop {

   private Long id;

   public Coicop() {
      super();
   }

   public Coicop(String version) {
      super();
      this.version = version;
   }

   private String version;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getVersion() {
      return version;
   }

   public void setVersion(String version) {
      this.version = version;
   }

   @Override
   public String toString() {
      return "Coicop [id=" + id + ", version=" + version + "]";
   }

}
