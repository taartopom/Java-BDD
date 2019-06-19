/*Structure de la page
*  le CRUD
*/
/*---------------------------------------------------------------*/
package model;

import java.util.List;

/**
 *
 * @author Administrateur
 */
/*---------------------------------------------------------------*/
//CRUD
/*---------------------------------------------------------------*/
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
