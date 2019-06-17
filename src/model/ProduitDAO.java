
/*---------------------------------------------------------------*/
/*Structure de la page
*1- implement de l'interface Produit interface
  1.1 - Connection à la BDD
  1.2 - appel de toutes les méthodes
*/
/*---------------------------------------------------------------*/
package model;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author Administrateur
 */

/*---------------------------------------------------------------*/
/*implement de produitInterface
*génération automatique de toutes les méthodes abstraites
*/
/*---------------------------------------------------------------*/
public class ProduitDAO implements ProduitInterface{

    //1.1 - Connection à la bdd
/*----------------------------------------------------------------*/
    
    Connection connex = Connexion.getConnexion();
    
    // 1.2 - les méthodes
/*----------------------------------------------------------------*/
    @Override
    public List<Produit> getAllProduit() {
        List<Produit> listProduits = new ArrayList<>();
       
        try {
            Statement stmt = connex.createStatement();
            String requete = "SELECT * FROM produit";
    
            ResultSet rs = stmt.executeQuery(requete);//rs est un tableau qui reccupere les éléments demandé dans la requête
            while (rs.next()) {
                Produit produits = new Produit();
                produits.setIdProd(rs.getInt("idProd"));
                produits.setNomProd(rs.getString("nomProd"));
                produits.setDescrriptionProd(rs.getString("descriptionProd"));
                produits.setPrixProd(rs.getInt("prixProd"));
                produits.setQutProd(rs.getInt("qutProd"));
                produits.setCaProd(caProd);
                
                listProduits.add(produits);//ajout de l'objet catégorie à la liste
            }
        } 
        catch (SQLException e) {
        }
    return listProduits;
    }  

    @Override
    public Produit getOneProduit(int idProd) {
        Produit produits = new Produit();
        try {
            PreparedStatement ps = connex.prepareStatement("SELECT * FROM produit WHERE idProd=?");
            ps.setInt(1, idProd);
            ResultSet rs = ps.executeQuery();
            rs.first();
            produits.setIdProd(rs.getInt("idProd"));
            produits.setNomProd(rs.getString("nomProd"));
            produits.setDescrriptionProd(rs.getString("descriptionProd"));
            produits.setPrixProd(rs.getInt("prixProd"));
            produits.setQutProd(rs.getInt("qutProd"));

        } 
        catch (SQLException e) {
        }
        return produits; 
    } 
    @Override
    public void addProduit(Produit prod) {
         try {
           PreparedStatement ps = connex.prepareStatement("INSERT INTO produit (nomProd,descriptionProd,prixProd,qteProd) VALUE(?)");
           ps.setString(1, prod.getNomProd());
           ps.setString(1,prod.getDescrriptionProd());
           ps.setInt(1,prod.getQutProd());
           ps.setDouble(1, prod.getPrixProd());
           
           ps.executeUpdate();
           ps.close();
       } catch (SQLException e) {
       }
    }

    @Override
    public void deleteProduit(Produit prod) {
        try {
           PreparedStatement ps = connex.prepareStatement("DELETE FROM produit WHERE idProd = ?" );
           ps.setInt(1, prod.getIdProd());
           
           ps.executeUpdate();
           ps.close();
       } catch (SQLException e) {
       }
    }

    @Override
    public void updateProduit(Produit prod) {
         try {
           PreparedStatement ps = connex.prepareStatement("UPDATE produit SET nomProd = ?,descriptionProd = ?,prixprod = ?,qteProd = ? WHERE idProd = ?");
           ps.setString(1, prod.getNomProd());
           ps.setString(1,prod.getDescrriptionProd());
           ps.setInt(1,prod.getQutProd());
           ps.setDouble(1, prod.getPrixProd());
           
           ps.executeUpdate();
           ps.close();
       } catch (SQLException e) {
       }
    }

   
/*----------------------------------------------------------------*/
}
