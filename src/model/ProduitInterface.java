
/*---------------------------------------------------------------*/
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
public interface ProduitInterface {
    public List<Produit> getAllProduit();//retourne de la liste des produits
    public void addProduit(Produit prod);
    public void deleteProduit(Produit prod);
    public void updateProduit(Produit prod);
    public Produit getOneProduit(int idProd);//retourne un seul produit
    
}
