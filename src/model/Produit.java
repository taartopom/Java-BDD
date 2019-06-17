/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
/*---------------------------------------------------------------*/
/*Structure de la page
*1- attributs
*2- constructeurs
*3- accesseurs
*4- mutateurs
*5- to string
*/
/*---------------------------------------------------------------*/
/**
 *
 * @author Administrateur
 */
/*----------------------------------------------------------*/
//Attributs
/*----------------------------------------------------------*/
public class Produit {
    private int idProd;
    private String nomProd;
    private String descriptionProd;
    private double prixProd;
    private int qteProd;
    private Categorie catProd;
    
/*---------------------------------------------------------------*/
 //Constructeurs
/*---------------------------------------------------------------*/
    public Produit(int idProd, String nomProd, String descriptionProd, double prixProd, int qteProd) {
        this.idProd = idProd;
        this.nomProd = nomProd;
        this.descriptionProd = descriptionProd;
        this.prixProd = prixProd;
        this.qteProd = qteProd;
    }

    public Produit() {
    }
    
/*---------------------------------------------------------------*/
/*Accesseurs*/
/*---------------------------------------------------------------*/
    public int getIdProd() {
        return idProd;
    }

    public String getNomProd() {
        return nomProd;
    }

    public String getDescriptionProd() {
        return descriptionProd;
    }

    public double getPrixProd() {
        return prixProd;
    }

    public int getQteProd() {
        return qteProd;
    }

    public Categorie getCatProd() {
        return catProd;
    }
/*---------------------------------------------------------------*/
/*Mutateurs*/
/*---------------------------------------------------------------*/
    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public void setNomProd(String nomProd) {
        this.nomProd = nomProd;
    }

    public void setDescriptionProd(String descriptionProd) {
        this.descriptionProd = descriptionProd;
    }

    public void setPrixProd(double prixProd) {
        this.prixProd = prixProd;
    }

    public void setQteProd(int qutProd) {
        this.qteProd = qteProd;
    }

    public void setCatProd(Categorie caProd) {
        this.catProd = catProd;
    }
/*---------------------------------------------------------------*/
/*To string*/
/*---------------------------------------------------------------*/
    @Override
    public String toString() {
        return "Produit{" + "idProd=" + idProd + ", nomProd=" + nomProd + ", descriptionProd=" + descriptionProd + ", prixProd=" + prixProd + ", qteProd=" + qteProd + ", catProd=" + catProd + '}';
    }
    
}
