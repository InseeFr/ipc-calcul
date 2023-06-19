package fr.insee.prismeipc.open.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import fr.insee.prismeipc.open.model.enumeration.Secteur;

public class Variete {

   private Long id;

   private Long numero;
   private String libelle;
   private Territoire territoire;
   private Secteur secteur;
   private Set<VarieteEchantillon> varieteEchantillons = new HashSet<>();

   public Variete() {
      super();
   }

   public Variete(Long numero, Territoire territoire) {
      super();
      this.numero = numero;
      this.territoire = territoire;
   }

   public Variete(Long id) {
      super();
      this.id = id;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public Long getNumero() {
      return numero;
   }

   public void setNumero(Long numero) {
      this.numero = numero;
   }

   public String getLibelle() {
      return libelle;
   }

   public void setLibelle(String libelle) {
      this.libelle = libelle;
   }

   public Territoire getTerritoire() {
      return territoire;
   }

   public void setTerritoire(Territoire territoire) {
      this.territoire = territoire;
   }

   public Secteur getSecteur() {
      return secteur;
   }

   public void setSecteur(Secteur secteur) {
      this.secteur = secteur;
   }

   public Set<VarieteEchantillon> getVarieteEchantillons() {
      return varieteEchantillons;
   }

   public void setVarieteEchantillons(Set<VarieteEchantillon> varieteEchantillons) {
      this.varieteEchantillons = varieteEchantillons;
   }

   @Override
   public String toString() {
      return "Variete [id=" + id + ", numero=" + numero + ", libelle=" + libelle + ", secteur=" + secteur + "]";
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, numero);
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null) return false;
      if (getClass() != obj.getClass()) return false;
      Variete other = (Variete) obj;
      return Objects.equals(id, other.id) && Objects.equals(numero, other.numero);
   }

}
