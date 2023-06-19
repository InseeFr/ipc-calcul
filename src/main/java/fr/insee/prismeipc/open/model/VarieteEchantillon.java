package fr.insee.prismeipc.open.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import fr.insee.prismeipc.open.model.enumeration.EtatVarieteEchantillon;
import fr.insee.prismeipc.open.model.enumeration.MethodeAgregation;
import fr.insee.prismeipc.open.model.enumeration.NiveauAgregation;
import fr.insee.prismeipc.open.model.enumeration.Secteur;
import fr.insee.prismeipc.open.model.enumeration.TypeCollecte;
import fr.insee.prismeipc.open.model.enumeration.TypeIndice;
import fr.insee.prismeipc.open.model.enumeration.TypePrix;
import fr.insee.prismeipc.open.model.enumeration.TypeSaisonnalite;
import fr.insee.prismeipc.open.model.enumeration.UniteDeMesure;

public class VarieteEchantillon {

   /**
    * Pour éviter des soucis s'ils sont systématiquement rappatries, les questionnaires ont été sortis dans une entity OneToOne not nullable.
    * Quand on crée une VarieteEchantillon, il faut donc systématiquement créer le questionnaire qui y est associé, en faisant
    * bien le mapping dans les deux sans (grâce au setQuestionnaire). Ce questionnaire pourra avoir des colonnes correspondant aux valeurs des
    * JSON et des XML vides, mais la ligne sera créée, avec l'id correspondant à l'id de la varieteEchantillon
    */
   public VarieteEchantillon() {
      super();
      this.setQuestionnaire(new Questionnaire());
      this.setPonderationVarieteEchantillon(new PonderationVarieteEchantillon());
   }

   public VarieteEchantillon(Variete variete, Echantillon echantillon, ItemCoicop itemCoicop, Boolean participeIpc, Boolean participeIpch, PonderationVarieteEchantillon ponderation) {
      super();
      this.setQuestionnaire(new Questionnaire());
      this.setPonderationVarieteEchantillon(ponderation);
      ponderation.setVarieteEchantillon(this);
      this.variete = variete;
      this.echantillon = echantillon;
      this.itemCoicop = itemCoicop;
      this.participeIpc = participeIpc;
      this.participeIpch = participeIpch;
   }

   private Long id;

   private Variete variete;
   private Echantillon echantillon;

   // Ces 3 variables old... ont été reprises pour information et doivent être supprimées un jour...
   private String oldTypeVariete;
   private String oldAgregat;
   private String oldFormulePrix;

   private LocalDateTime dateDerniereModification;
   private ItemCoicop itemCoicop;
   private ItemCoicop auxiliaireImputationItemCoicop;
   private Variete auxiliaireImputationVariete;
   private List<Integer> listeMoisHorsSaison;
   private UniteDeMesure uniteDeMesure;
   private Float quantiteDeConditionnement;
   private Float borneInf;
   private Float borneSup;
   private TypeSaisonnalite typeSaisonnalite;
   private Boolean publiable;
   private Boolean varieteVolatile;
   private Boolean participeIpc;
   private Boolean participeIpch;
   private Boolean prixIpchDifferent;
   private String exemple;
   private String description;
   private String exclusion;
   private Boolean complementDdc;
   private TypeCollecte typeCollecte;
   private TypeIndice typeIndice;
   private TypePrix typePrix;
   private MethodeAgregation methodeAgregation;
   private Boolean strateAgglomeration;
   private Boolean strateEnLigne;
   private Boolean strateAutre;
   private NiveauAgregation niveauAgregation;
   private EtatVarieteEchantillon etat;
   private Set<VarieteEchantillonCibleFdv> varieteEchantillonCibles = new HashSet<>();

   private Questionnaire questionnaire;

   private Set<FourchetteEvolution> fourchettesEvolution = new HashSet<>();
   private Set<TypeCt> typesCt = new HashSet<>();
   private IndiceVarieteAnnuel indiceVarieteAnnuel;
   private PonderationVarieteEchantillon ponderationVarieteEchantillon;

   public Short getAnnee() {
      return this.echantillon.getAnnee();
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public Variete getVariete() {
      return variete;
   }

   public void setVariete(Variete variete) {
      this.variete = variete;
   }

   public Echantillon getEchantillon() {
      return echantillon;
   }

   public void setEchantillon(Echantillon echantillon) {
      this.echantillon = echantillon;
   }

   public String getOldTypeVariete() {
      return oldTypeVariete;
   }

   public void setOldTypeVariete(String oldTypeVariete) {
      this.oldTypeVariete = oldTypeVariete;
   }

   public String getOldAgregat() {
      return oldAgregat;
   }

   public void setOldAgregat(String oldAgregat) {
      this.oldAgregat = oldAgregat;
   }

   public String getOldFormulePrix() {
      return oldFormulePrix;
   }

   public void setOldFormulePrix(String oldFormulePrix) {
      this.oldFormulePrix = oldFormulePrix;
   }

   public LocalDateTime getDateDerniereModification() {
      return dateDerniereModification;
   }

   public void setDateDerniereModification(LocalDateTime dateDerniereModification) {
      this.dateDerniereModification = dateDerniereModification;
   }

   public ItemCoicop getItemCoicop() {
      return itemCoicop;
   }

   public void setItemCoicop(ItemCoicop itemCoicop) {
      this.itemCoicop = itemCoicop;
   }

   public ItemCoicop getAuxiliaireImputationItemCoicop() {
      return auxiliaireImputationItemCoicop;
   }

   public void setAuxiliaireImputationItemCoicop(ItemCoicop auxiliaireImputationItemCoicop) {
      this.auxiliaireImputationItemCoicop = auxiliaireImputationItemCoicop;
   }

   public Variete getAuxiliaireImputationVariete() {
      return auxiliaireImputationVariete;
   }

   public void setAuxiliaireImputationVariete(Variete auxiliaireImputationVariete) {
      this.auxiliaireImputationVariete = auxiliaireImputationVariete;
   }

   public List<Integer> getListeMoisHorsSaison() {
      return listeMoisHorsSaison;
   }

   public void setListeMoisHorsSaison(List<Integer> listeMoisHorsSaison) {
      this.listeMoisHorsSaison = listeMoisHorsSaison;
   }

   public UniteDeMesure getUniteDeMesure() {
      return uniteDeMesure;
   }

   public void setUniteDeMesure(UniteDeMesure uniteDeMesure) {
      this.uniteDeMesure = uniteDeMesure;
   }

   public Float getQuantiteDeConditionnement() {
      return quantiteDeConditionnement;
   }

   public void setQuantiteDeConditionnement(Float quantiteDeConditionnement) {
      this.quantiteDeConditionnement = quantiteDeConditionnement;
   }

   public Float getBorneInf() {
      return borneInf;
   }

   public void setBorneInf(Float borneInf) {
      this.borneInf = borneInf;
   }

   public Float getBorneSup() {
      return borneSup;
   }

   public void setBorneSup(Float borneSup) {
      this.borneSup = borneSup;
   }

   public TypeSaisonnalite getTypeSaisonnalite() {
      return typeSaisonnalite;
   }

   public void setTypeSaisonnalite(TypeSaisonnalite typeSaisonnalite) {
      this.typeSaisonnalite = typeSaisonnalite;
   }

   public Boolean getPubliable() {
      return publiable;
   }

   public void setPubliable(Boolean publiable) {
      this.publiable = publiable;
   }

   public Boolean getVarieteVolatile() {
      return varieteVolatile;
   }

   public void setVarieteVolatile(Boolean varieteVolatile) {
      this.varieteVolatile = varieteVolatile;
   }

   public Boolean getParticipeIpc() {
      return participeIpc;
   }

   public void setParticipeIpc(Boolean participeIpc) {
      this.participeIpc = participeIpc;
   }

   public Boolean getParticipeIpch() {
      return participeIpch;
   }

   public void setParticipeIpch(Boolean participeIpch) {
      this.participeIpch = participeIpch;
   }

   public Boolean getPrixIpchDifferent() {
      return prixIpchDifferent;
   }

   public void setPrixIpchDifferent(Boolean prixIpchDifferent) {
      this.prixIpchDifferent = prixIpchDifferent;
   }

   public String getExemple() {
      return exemple;
   }

   public void setExemple(String exemple) {
      this.exemple = exemple;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public String getExclusion() {
      return exclusion;
   }

   public void setExclusion(String exclusion) {
      this.exclusion = exclusion;
   }

   public Boolean getComplementDdc() {
      return complementDdc;
   }

   public void setComplementDdc(Boolean complementDdc) {
      this.complementDdc = complementDdc;
   }

   public TypeCollecte getTypeCollecte() {
      return typeCollecte;
   }

   public void setTypeCollecte(TypeCollecte typeCollecte) {
      this.typeCollecte = typeCollecte;
   }

   public TypeIndice getTypeIndice() {
      return typeIndice;
   }

   public void setTypeIndice(TypeIndice typeIndice) {
      this.typeIndice = typeIndice;
   }

   public TypePrix getTypePrix() {
      return typePrix;
   }

   public void setTypePrix(TypePrix typePrix) {
      this.typePrix = typePrix;
   }

   public MethodeAgregation getMethodeAgregation() {
      return methodeAgregation;
   }

   public void setMethodeAgregation(MethodeAgregation methodeAgregation) {
      this.methodeAgregation = methodeAgregation;
   }

   public Boolean getStrateAgglomeration() {
      return strateAgglomeration;
   }

   public void setStrateAgglomeration(Boolean strateAgglomeration) {
      this.strateAgglomeration = strateAgglomeration;
   }

   public Boolean getStrateEnLigne() {
      return strateEnLigne;
   }

   public void setStrateEnLigne(Boolean strateEnLigne) {
      this.strateEnLigne = strateEnLigne;
   }

   public Boolean getStrateAutre() {
      return strateAutre;
   }

   public void setStrateAutre(Boolean strateAutre) {
      this.strateAutre = strateAutre;
   }

   public NiveauAgregation getNiveauAgregation() {
      return niveauAgregation;
   }

   public void setNiveauAgregation(NiveauAgregation niveauAgregation) {
      this.niveauAgregation = niveauAgregation;
   }

   public Secteur getSecteur() {
      return this.variete.getSecteur();
   }

   public Secteur getSecteurVariete() {
      return getSecteur();
   }

   public Long getTerritoireId() {
      if (this.variete.getTerritoire() == null) return null;
      return this.variete.getTerritoire().getId();
   }

   public String getCodeTerritoire() {
      if (this.variete.getTerritoire() == null) return null;
      return this.variete.getTerritoire().getCode();
   }

   public String getLibelleTerritoire() {
      if (this.variete.getTerritoire() == null) return null;
      return this.variete.getTerritoire().getLibelle();
   }

   public EtatVarieteEchantillon getEtat() {
      return etat;
   }

   public void setEtat(EtatVarieteEchantillon etat) {
      this.etat = etat;
   }

   public Set<VarieteEchantillonCibleFdv> getVarieteEchantillonCibles() {
      return varieteEchantillonCibles;
   }

   public void setVarieteEchantillonCibles(Set<VarieteEchantillonCibleFdv> varieteEchantillonCibles) {
      this.varieteEchantillonCibles = varieteEchantillonCibles;
   }

   @Override
   public String toString() {
      return "VarieteEchantillon [id=" + id + ", oldTypeVariete=" + oldTypeVariete + ", oldAgregat=" + oldAgregat + ", oldFormulePrix=" + oldFormulePrix + ", dateDerniereModification=" + dateDerniereModification + ", variete=" + variete + " itemCoicop=" + itemCoicop + ", participeIpc=" + participeIpc + ", participeIpch=" + participeIpch + ", typeCollecte=" + typeCollecte + ", typeIndice=" + typeIndice + ", typePrix=" + typePrix + "]";
   }

   public String getLibelleVariete() {
      return this.variete.getLibelle();
   }

   public Long getNumeroVariete() {
      return this.variete.getNumero();
   }

   public Long getItemCoicopId() {
      return this.itemCoicop.getId();
   }

   public Long getIdVarieteEchantillon() {
      return this.id;
   }

   public Questionnaire getQuestionnaire() {
      return questionnaire;
   }

   public void setQuestionnaire(Questionnaire questionnaire) {
      if (questionnaire == null) {
         if (this.questionnaire != null) {
            this.questionnaire.setVarieteEchantillon(null);
         }
      } else {
         questionnaire.setVarieteEchantillon(this);
      }
      this.questionnaire = questionnaire;
   }

   public String getQuestionnaireCtXml() {
      if (questionnaire == null) return null;
      return questionnaire.getQuestionnaireCtXml();
   }

   public void setQuestionnaireCtXml(String questionnaireCtXml) {
      if (questionnaire == null) {
         this.setQuestionnaire(new Questionnaire());
      }
      questionnaire.setQuestionnaireCtXml(questionnaireCtXml);
   }

   public String getQuestionnaireCtJson() {
      if (questionnaire == null) return null;
      return questionnaire.getQuestionnaireCtJson();
   }

   public void setQuestionnaireCtJson(String questionnaireCtJson) {
      if (questionnaire == null) {
         this.setQuestionnaire(new Questionnaire());
      }
      questionnaire.setQuestionnaireCtJson(questionnaireCtJson);
   }

   private Set<FourchetteEvolution> findFourchettesAbsentes(Set<FourchetteEvolution> nouvellesFourchettes) {
      Set<FourchetteEvolution> fourchettesAbsentes = new HashSet<>();
      for (FourchetteEvolution fourchetteActuelle : this.fourchettesEvolution) {
         if (isFourchetteAbsenteFrom(fourchetteActuelle, nouvellesFourchettes)) {
            fourchettesAbsentes.add(fourchetteActuelle);
         }
      }
      return fourchettesAbsentes;
   }

   public void metAJourLesFourchettes(Set<FourchetteEvolution> nouvellesFourchettes) {
      Set<FourchetteEvolution> fourchettesAbsentes = findFourchettesAbsentes(nouvellesFourchettes);
      removeFourchettesEvolution(fourchettesAbsentes);
      addOrUpdateFourchettesEvolution(nouvellesFourchettes);
   }

   private boolean isSameFourchette(FourchetteEvolution fourchetteActuelle, FourchetteEvolution nouvelleFourchette) {
      return nouvelleFourchette == null ? fourchetteActuelle == null : Objects.equals(fourchetteActuelle.isPrixPromotionnelMoisCourant(), nouvelleFourchette.isPrixPromotionnelMoisCourant()) && Objects
         .equals(fourchetteActuelle.isPrixPromotionnelMoisPrecedent(), nouvelleFourchette.isPrixPromotionnelMoisPrecedent());
   }

   public void addFourchetteEvolution(FourchetteEvolution fourchette) {
      this.fourchettesEvolution.add(fourchette);
      fourchette.setVarieteEchantillon(this);
   }

   public void updateFourchetteEvolution(FourchetteEvolution nouvelleFourchette) {
      for (FourchetteEvolution fourchetteActuelle : fourchettesEvolution) {
         if (isSameFourchette(fourchetteActuelle, nouvelleFourchette)) {
            fourchetteActuelle.update(nouvelleFourchette);
         }
      }
   }

   public void clearFourchetteEvolution() {
      this.fourchettesEvolution.clear();
   }

   public void removeFourchetteEvolution(FourchetteEvolution fourchetteToRemove) {
      this.fourchettesEvolution.remove(fourchetteToRemove);
      fourchetteToRemove.setVarieteEchantillon(null);
   }

   private void removeFourchettesEvolution(Set<FourchetteEvolution> fourchettesToRemove) {
      for (FourchetteEvolution fourchetteToRemove : fourchettesToRemove) {
         removeFourchetteEvolution(fourchetteToRemove);
      }
   }

   private void addOrUpdateFourchetteEvolution(FourchetteEvolution nouvelleFourchette) {
      if (isFourchetteDejaPresente(nouvelleFourchette)) {
         updateFourchetteEvolution(nouvelleFourchette);
      } else {
         addFourchetteEvolution(nouvelleFourchette);
      }
   }

   private void addOrUpdateFourchettesEvolution(Set<FourchetteEvolution> fourchettes) {
      fourchettes.stream().forEach(fourchette -> addOrUpdateFourchetteEvolution(fourchette));
   }

   private boolean isFourchetteDejaPresente(FourchetteEvolution nouvelleFourchette) {
      return fourchettesEvolution.stream().anyMatch(fourchetteActuelle -> isSameFourchette(fourchetteActuelle, nouvelleFourchette));
   }

   public Set<FourchetteEvolution> getFourchettesEvolution() {
      return fourchettesEvolution;
   }

   private boolean isFourchetteAbsenteFrom(FourchetteEvolution fourchetteActuelle, Set<FourchetteEvolution> nouvellesFourchettes) {
      return nouvellesFourchettes.stream().noneMatch(nouveauDescriptif -> isSameFourchette(fourchetteActuelle, nouveauDescriptif));
   }

   public Set<TypeCt> getTypesCt() {
      return typesCt;
   }

   public void metAJourLesTypesCt(Set<TypeCt> nouveauxTypesCt) {
      Set<TypeCt> typesCtAbsents = findTypesCtAbsents(nouveauxTypesCt);
      removeTypesCt(typesCtAbsents);
      addOrUpdateTypesCt(nouveauxTypesCt);
   }

   private void removeTypesCt(Set<TypeCt> typesCtToRemove) {
      for (TypeCt typeCtToRemove : typesCtToRemove) {
         removeTypeCt(typeCtToRemove);
      }
   }

   public void addOrUpdateTypesCt(Set<TypeCt> typesCt) {
      typesCt.stream().forEach(this::addOrUpdateTypeCt);
   }

   private Set<TypeCt> findTypesCtAbsents(Set<TypeCt> nouveauxTypesCt) {
      Set<TypeCt> typesCtAbsents = new HashSet<>();
      for (TypeCt typeCtExistant : this.typesCt) {
         if (isTypeCtAbsentFrom(typeCtExistant, nouveauxTypesCt)) {
            typesCtAbsents.add(typeCtExistant);
         }
      }
      return typesCtAbsents;
   }

   private boolean isTypeCtAbsentFrom(TypeCt typeCtExistant, Set<TypeCt> nouveauxTypesCt) {
      return nouveauxTypesCt.stream().noneMatch(nouveauTypeCt -> isSameTypeCt(typeCtExistant, nouveauTypeCt));
   }

   private boolean isSameTypeCt(TypeCt typeCtExistant, TypeCt typeCtNouveau) {
      return typeCtNouveau == null ? typeCtExistant == null : //
         Objects.equals(typeCtExistant.getCaracteristiqueTechniqueId(), typeCtNouveau.getCaracteristiqueTechniqueId()) //
            && Objects.equals(typeCtExistant.getType(), typeCtNouveau.getType());
   }

   public void addTypeCt(TypeCt typeCt) {
      this.typesCt.add(typeCt);
      typeCt.setVarieteEchantillon(this);
   }

   public void removeTypeCt(TypeCt typeCt) {
      this.typesCt.remove(typeCt);
      typeCt.setVarieteEchantillon(null);
   }

   public void addOrUpdateTypeCt(TypeCt nouveauTypeCt) {
      if (isTypeCtDejaPresent(nouveauTypeCt)) {
         updateTypeCt(nouveauTypeCt);
      } else {
         addTypeCt(nouveauTypeCt);
      }
   }

   public void updateTypeCt(TypeCt nouveauTypeCt) {
      for (TypeCt typeCtExistant : typesCt) {
         if (isSameTypeCt(typeCtExistant, nouveauTypeCt)) {
            typeCtExistant.update(nouveauTypeCt);
         }
      }
   }

   private boolean isTypeCtDejaPresent(TypeCt typeCt) {
      return typesCt.stream().filter(typeCtExistant -> isSameTypeCt(typeCtExistant, typeCt)).findFirst().isPresent();
   }

   public IndiceVarieteAnnuel getIndiceVarieteAnnuel() {
      return indiceVarieteAnnuel;
   }

   public void setIndiceVarieteAnnuel(IndiceVarieteAnnuel indiceVarieteAnnuel) {
      if (indiceVarieteAnnuel == null) {
         if (this.indiceVarieteAnnuel != null) {
            this.indiceVarieteAnnuel.setVarieteEchantillon(null);
         }
      } else {
         indiceVarieteAnnuel.setVarieteEchantillon(this);
      }
      this.indiceVarieteAnnuel = indiceVarieteAnnuel;
   }

   public PonderationVarieteEchantillon getPonderationVarieteEchantillon() {
      return ponderationVarieteEchantillon;
   }

   public void setPonderationVarieteEchantillon(PonderationVarieteEchantillon ponderationVarieteEchantillon) {
      if (ponderationVarieteEchantillon == null) {
         if (this.ponderationVarieteEchantillon != null) {
            this.ponderationVarieteEchantillon.setVarieteEchantillon(null);
         }
      } else {
         ponderationVarieteEchantillon.setVarieteEchantillon(this);
      }
      this.ponderationVarieteEchantillon = ponderationVarieteEchantillon;
   }

   @Override
   public int hashCode() {
      return Objects.hash(echantillon, variete);
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null) return false;
      if (getClass() != obj.getClass()) return false;
      VarieteEchantillon other = (VarieteEchantillon) obj;
      return Objects.equals(echantillon, other.echantillon) && Objects.equals(variete, other.variete);
   }

//   @Override
//   public int hashCode() {
//      return Objects.hash(id);
//   }
//
//   @Override
//   public boolean equals(Object obj) {
//      if (this == obj) return true;
//      if (obj == null) return false;
//      if (getClass() != obj.getClass()) return false;
//      VarieteEchantillon other = (VarieteEchantillon) obj;
//      return Objects.equals(id, other.id);
//   }

}
