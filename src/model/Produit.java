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
    public Produit(int idProd, String nomProd, String descrriptionProd, double prixProd, int qutProd) {
        this.idProd = idProd;
        this.nomProd = nomProd;
        this.descriptionProd = descrriptionProd;
        this.prixProd = prixProd;
        this.qteProd = qutProd;
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

    public String getDescrriptionProd() {
        return descriptionProd;
    }

    public double getPrixProd() {
        return prixProd;
    }

    public int getQutProd() {
        return qteProd;
    }

    public Categorie getCaProd() {
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

    public void setDescrriptionProd(String descrriptionProd) {
        this.descriptionProd = descrriptionProd;
    }

    public void setPrixProd(double prixProd) {
        this.prixProd = prixProd;
    }

    public void setQutProd(int qutProd) {
        this.qteProd = qutProd;
    }

    public void setCaProd(Categorie caProd) {
        this.catProd = caProd;
    }
/*---------------------------------------------------------------*/
/*To string*/
/*---------------------------------------------------------------*/
    @Override
    public String toString() {
        return "Produit{" + "idProd=" + idProd + ", nomProd=" + nomProd + ", descrriptionProd=" + descriptionProd + ", prixProd=" + prixProd + ", qutProd=" + qteProd + ", caProd=" + catProd + '}';
    }
    
}
