/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author Administrateur
 */
public interface CategorieInterface {
    public List<Categorie>getAllCategorie();

   /**
    *
    * @param idCat
    * @return
    */
   public Categorie getOneCategorie(int idCat);

   /**
    *
    * @param cat
    */
   public void addCategorie(Categorie cat);
   public void deleteCategorie(Categorie cat);
   public void updateCategorie(Categorie cat);
}
