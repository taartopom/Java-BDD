/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class CategorieDAO implements CategorieInterface{
    // Création d'une liste de catégorie pour stocker les enregistrement de la table catégorie
    Connection connex = Connexion.getConnexion();
    @Override
   public List<Categorie> getAllCategorie() {
       List<Categorie> listCategories = new ArrayList<>();
       
        try {
            Statement stmt = connex.createStatement();
            String requete = "SELECT * FROM categorie";
/* rs est un tableau qui reccupere les éléments demandé dans la requête*/
            ResultSet rs = stmt.executeQuery(requete);
            while (rs.next()) {
                Categorie cat = new Categorie();
                cat.setIdCat(rs.getInt("idCat"));
                cat.setLibelle(rs.getString("libelle"));
                //ajout de l'objet catégorie à la liste
                listCategories.add(cat);
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
           PreparedStatement ps = connex.prepareStatement("INSERT INTO Categorie (libelle) VALUE(?)");
           ps.setString(1, cat.getLibelle());
           ps.executeUpdate();
           ps.close();
       } catch (SQLException e) {
       }
   }

   @Override
   public void deleteCategorie(Categorie cat) {
       try {
           PreparedStatement ps = connex.prepareStatement("DELETE FROM Categorie WHERE idCat = ?" );
           ps.setInt(1, cat.getIdCat());
           ps.executeUpdate();
           ps.close();
       } catch (SQLException e) {
       }
   }

   @Override
   public void updateCategorie(Categorie cat) {
       try {
           PreparedStatement ps = connex.prepareStatement("UPDATE Categorie SET libelle = ? WHERE idCat = ?");
           ps.setString(1, cat.getLibelle());
           ps.setInt(2,cat.getIdCat());
           
           ps.executeUpdate();
           ps.close();
       } catch (SQLException e) {
       }
   }
}
