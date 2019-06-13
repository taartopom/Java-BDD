/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Categorie;
import model.CategorieDAO;
import view.CategorieVue;

/**
 *
 * @author Administrateur
 */
public class ControllerCategorie implements ActionListener{
    private CategorieDAO catDAO;
    private CategorieVue catVue;
    private DefaultTableModel modelCat;

    public ControllerCategorie(){
        catDAO = new CategorieDAO();
        catVue = new CategorieVue();
        init();    
        catVue.getBtnAjouter().addActionListener(this);
        catVue.setVisible(true);
         
    }
    public ControllerCategorie(CategorieDAO catDAO, CategorieVue catVue) {
        this.catDAO = catDAO;
        this.catVue = catVue;
    }

    public ControllerCategorie(CategorieVue catVue) {
        this.catVue = catVue;
        this.catDAO = new CategorieDAO();
    }
    
    public void init(){
         //création du modèle catégorie
        modelCat = new DefaultTableModel();
        //ajout de colonne
        modelCat.addColumn("Id catégorie");
        modelCat.addColumn("libelle");
        
        //inserer les lignes dans le modèle
        List<Categorie> allcat = this.catDAO.getAllCategorie();
        for(Categorie cat: allcat){
            modelCat.addRow(new Object[]{cat.getIdCat(),cat.getLibelle()});
        }
        
        catVue.getjTable2().setModel(modelCat);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        
        if (ae.getSource().equals(this.catVue.getBtnAjouter())) {
            Categorie cat = new Categorie();
            cat.setLibelle(this.catVue.getTxtLibelle().getText());
            
            catDAO.addCategorie(cat);
            
            JOptionPane.showMessageDialog(null,"Enregistrement ok");
            
            //vider le champs libelle
            this.catVue.getTxtLibelle().setText("");
            init();
            
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
