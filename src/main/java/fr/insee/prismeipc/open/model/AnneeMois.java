
package fr.insee.prismeipc.open.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.insee.prismeipc.open.exception.AnneeMoisNonValidesException;

public class AnneeMois implements Comparable<AnneeMois>, Serializable {
   /**
    * 
    */
   private static final long serialVersionUID = 3132839344806158427L;

   private static final Logger logger = LoggerFactory.getLogger(AnneeMois.class);

   private static final Short ANNEE_MIN_VALIDE = 2000;
   private static final Short PREMIER_MOIS = 1;
   private static final Short DERNIER_MOIS = 12;

   private Short annee;
   private Short mois;

   public AnneeMois() {
      super();
   }

   public AnneeMois(Short annee, Short mois) {
      super();
      if (isAnneevalide(annee) && isMoisValide(mois)) {
         this.annee = annee;
         this.mois = mois;
      } else {
         throw new AnneeMoisNonValidesException("L'année et le mois fournis ne sont pas valides : annee=" + annee + " ; mois=" + mois);
      }
   }

   private boolean isMoisValide(Short mois) {
      return mois != null && mois >= PREMIER_MOIS && mois <= DERNIER_MOIS;
   }

   private boolean isAnneevalide(Short annee) {
      return annee != null && annee >= ANNEE_MIN_VALIDE;
   }

   public Short getAnnee() {
      return annee;
   }

   public void setAnnee(Short annee) {
      this.annee = annee;
   }

   public Short getMois() {
      return mois;
   }

   public void setMois(Short mois) {
      this.mois = mois;
   }

   @Override
   public int hashCode() {
      return Objects.hashCode(this.annee + this.mois);
   }

   @Override
   public boolean equals(Object object) {
      if (object == null) {
         return false;
      }
      if (!(object instanceof AnneeMois)) {
         return false;
      }
      final AnneeMois other = (AnneeMois) object;
      return Objects.equals(this.annee, other.annee) && Objects.equals(this.mois, other.mois);
   }

   @Override
   public String toString() {
      return "AnneeMois [annee=" + annee + ", mois=" + mois + "]";
   }

   public AnneeMois findAnneeMoisPrecedent() {
      Integer moisMoinsUn;
      Integer anneeMoinsUn;
      if (PREMIER_MOIS.equals(mois)) {
         moisMoinsUn = 12;
         anneeMoinsUn = annee - 1;
      } else {
         moisMoinsUn = mois - 1;
         anneeMoinsUn = annee - 0;
      }
      try {
         return new AnneeMois(anneeMoinsUn.shortValue(), moisMoinsUn.shortValue());
      } catch (AnneeMoisNonValidesException e) {
         logger.error(e.getMessage());
      }
      return null;
   }

   public AnneeMois findAnneeMoisSuivant() {
      Integer moisPlusUn;
      Integer anneePlusUn;
      if (DERNIER_MOIS.equals(mois)) {
         moisPlusUn = 1;
         anneePlusUn = annee + 1;
      } else {
         moisPlusUn = mois + 1;
         anneePlusUn = annee - 0;
      }
      try {
         return new AnneeMois(anneePlusUn.shortValue(), moisPlusUn.shortValue());
      } catch (AnneeMoisNonValidesException e) {
         logger.error(e.getMessage());
      }
      return null;
   }

   public List<AnneeMois> findLesAnneesMoisPrecedents(int nbCampagnesPrecedentes) {
      List<AnneeMois> campagnesPrecedentes = new ArrayList<>();
      AnneeMois campagneCourante = findAnneeMoisPrecedent();
      campagnesPrecedentes.add(campagneCourante);
      for (int i = 1; i < nbCampagnesPrecedentes; i++) {
         AnneeMois campagnePrecedente = campagneCourante.findAnneeMoisPrecedent();
         campagnesPrecedentes.add(campagnePrecedente);
         campagneCourante = campagnePrecedente;
      }
      return campagnesPrecedentes;
   }

   public AnneeMois findAnneesMoisMoins(int nbMoisARemonter) {
      AnneeMois campagneCourante = findAnneeMoisPrecedent();
      for (int i = 1; i < nbMoisARemonter; i++) {
         AnneeMois campagnePrecedente = campagneCourante.findAnneeMoisPrecedent();
         campagneCourante = campagnePrecedente;
      }
      return campagneCourante;
   }

   @Override
   public int compareTo(AnneeMois otherAnneeMois) {
      if (this.annee.compareTo(otherAnneeMois.annee) == 0) {
         return this.mois.compareTo(otherAnneeMois.mois);
      }
      return this.annee.compareTo(otherAnneeMois.annee);
   }
}
