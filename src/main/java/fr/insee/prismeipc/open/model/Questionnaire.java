package fr.insee.prismeipc.open.model;

public class Questionnaire {

   private Long id;

   private VarieteEchantillon varieteEchantillon;
   private String questionnaireCtXml;
   private String questionnaireCtJson;

   public String getQuestionnaireCtXml() {
      return questionnaireCtXml;
   }

   public void setQuestionnaireCtXml(String questionnaireCtXml) {
      this.questionnaireCtXml = questionnaireCtXml;
   }

   public String getQuestionnaireCtJson() {
      return questionnaireCtJson;
   }

   public void setQuestionnaireCtJson(String questionnaireCtJson) {
      this.questionnaireCtJson = questionnaireCtJson;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public VarieteEchantillon getVarieteEchantillon() {
      return varieteEchantillon;
   }

   public void setVarieteEchantillon(VarieteEchantillon varieteEchantillon) {
      this.varieteEchantillon = varieteEchantillon;
   }

}
