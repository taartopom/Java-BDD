/*Structure de la page
*1- implement de l'interface Categorie interface
  1.1 - Connection à la BDD
  1.2 - appel de toutes les méthodes
*/
/*---------------------------------------------------------------*/
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrateur
 */

/*---------------------------------------------------------------*/
/*implement de produitInterface
*génération automatique de toutes les méthodes abstraites
*/
/*---------------------------------------------------------------*/
public class CategorieDAO implements CategorieInterface{
    
    //1.1 - Connection à la bdd
/*----------------------------------------------------------------*/
    
    Connection connex = Connexion.getConnexion();
    
    // 1.2 - les méthodes
/*----------------------------------------------------------------*/
    @Override
    public List<Categorie> getAllCategorie() {
       List<Categorie> listCategories = new ArrayList<>();
       
        try {
            Statement stmt = connex.createStatement();
            String requete = "SELECT * FROM categorie";
            ResultSet rs = stmt.executeQuery(requete);//rs est un tableau qui reccupere les éléments demandé dans la requête
            while (rs.next()) {
                Categorie cat = new Categorie();
                cat.setIdCat(rs.getInt("idCat"));
                cat.setLibelle(rs.getString("libelle"));
                
                listCategories.add(cat);////ajout de l'objet catégorie à la liste
            }
        } catch (SQLException e) {
        }
       return listCategories;
   }
   

   @Override
   public Categorie getOneCategorie(int idCat) {
       Categorie cat = new Categorie();
       try {
           PreparedStatement ps = connex.prepareStatement("SELECT * FROM categorie WHERE idCat=?");
           ps.setInt(1, idCat);
           ResultSet rs = ps.executeQuery();
           rs.first();
           cat.setIdCat(rs.getInt("idCat"));
           cat.setLibelle(rs.getString("libelle"));
           /*ou après rs.first();
           cat = new Categories(rs.getInt("idCat"),rs.getString("libelle"))*/
       } catch (SQLException e) {
       }
        
               return cat; 
   }

   @Override
   public void addCategorie(Categorie cat) {
       try {
           PreparedStatement ps = connex.prepareStatement("INSERT INTO categorie (libelle) VALUE(?)");
           ps.setString(1, cat.getLibelle());
           ps.executeUpdate();
           ps.close();
       } catch (SQLException e) {
       }
   }

   @Override
   public void deleteCategorie(Categorie cat) {
       try {
           PreparedStatement ps = connex.prepareStatement("DELETE FROM categorie WHERE idCat = ?" );
           ps.setInt(1, cat.getIdCat());
           ps.executeUpdate();
           ps.close();
       } catch (SQLException e) {
       }
   }

   @Override
   public void updateCategorie(Categorie cat) {
       try {
           PreparedStatement ps = connex.prepareStatement("UPDATE categorie SET libelle = ? WHERE idCat = ?");
           ps.setString(1, cat.getLibelle());
           ps.setInt(2,cat.getIdCat());
           
           ps.executeUpdate();
           ps.close();
       } catch (SQLException e) {
       }
   }
}
