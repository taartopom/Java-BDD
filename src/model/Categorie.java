/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Administrateur
 */
public class Categorie {
   private int idCat;
   private String libelle;

   public Categorie(int idCat, String libelle) {
       this.idCat = idCat;
       this.libelle = libelle;
   }

   public Categorie() {
   }

   public int getIdCat() {
       return idCat;
   }

   public void setIdCat(int idCat) {
       this.idCat = idCat;
   } 

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Categorie(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Categorie{" + "idCat=" + idCat + ", libelle=" + libelle + '}';
    }
    
// constructeur
    public String getLibelle() {
        return libelle;
    }
}