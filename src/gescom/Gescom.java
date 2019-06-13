/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gescom;


import controller.ControllerCategorie;
import java.sql.SQLException;
import java.util.List;
import model.Categorie;
import model.CategorieDAO;

/**
 *
 * @author Administrateur
 */
public class Gescom {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
      /*  CategorieDAO catDAO = new CategorieDAO();
        List<Categorie> list = catDAO.getAllCategorie();
        
        for (Categorie cat : list){
           System.out.println("IdCat :"+ cat.getIdCat()+ "libelle:" + cat.getLibelle()); 
        }
        
        //catDAO.addCategorie(new Categorie(0,"CD"));
        
        catDAO.updateCategorie(new Categorie(3, "modifier"));
        System.out.println("Après Update");
        list = catDAO.getAllCategorie();
        for (Categorie cat : list) {
            System.out.println("IdCat : " + cat.getIdCat() + "libelle" + cat.getLibelle());
            
        }
        
        
        //catDAO.deleteCategorie(new Categorie(4,));
       // System.out.println(catDAO.getAllCategorie());
        
        System.out.println(catDAO.getOneCategorie(2));
        */
      
        ControllerCategorie controleur = new ControllerCategorie();            
        
    }
    
}
