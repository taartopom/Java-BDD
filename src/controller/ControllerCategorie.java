/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
public class ControllerCategorie implements ActionListener, MouseListener{
    private CategorieDAO catDAO;
    private CategorieVue catVue;
    private DefaultTableModel modelCat;

    public ControllerCategorie(){
        catDAO = new CategorieDAO();
        catVue = new CategorieVue();
        init();    
        
        catVue.getBtnAjouter().addActionListener(this);
        catVue.getjTable2().addMouseListener(this);
        catVue.setVisible(true);
        
        catVue.getBtnModifier().addActionListener(this);
        catVue.getBtnSupprimer().addActionListener(this);
       
         
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
        
        //pour l'ajout
        if (ae.getSource().equals(this.catVue.getBtnAjouter())) {
            Categorie cat = new Categorie();
            cat.setLibelle(this.catVue.getTxtLibelle().getText());
            
            catDAO.addCategorie(cat);
            
            JOptionPane.showMessageDialog(null,"Enregistrement ok");
            
            //vider le champs libelle
            this.catVue.getTxtLibelle().setText("");
            init();
            
        }
        //pour la modification
        if (ae.getSource().equals(this.catVue.getBtnModifier())) {
            
          
            int catSup  = this.catVue.getjTable2().getSelectedRow();
            this.catVue.getTxtIdCat().setText(modelCat.getValueAt(ligne, 0).toString());
            this.catVue.getTxtLibelle().setText(modelCat.getValueAt(ligne,1).toString());
            
            
           /* catUp.setLibelle(this.catVue.getTxtLibelle().getText());
            
            catDAO.updateCategorie(catUp);
            
            JOptionPane.showMessageDialog(null,"Modification ok");
            
            //vider le champs libelle
            this.catVue.getTxtLibelle().setText("");
            init();*/
            
        }
        // pour la suppression
        if (ae.getSource().equals(this.catVue.getBtnSupprimer())) {
            Categorie cat = new Categorie();
            cat.setIdCat(Integer.parseInt(this.catVue.getTxtIdCat().getText()));
            
            catDAO.deleteCategorie(cat);
            
            JOptionPane.showMessageDialog(null,"Suppression ok");
            
            //vider le champs libelle
            this.catVue.getTxtLibelle().setText("");
            init();
            
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        int ligne  = this.catVue.getjTable2().getSelectedRow();
        this.catVue.getTxtIdCat().setText(modelCat.getValueAt(ligne, 0).toString());
        this.catVue.getTxtLibelle().setText(modelCat.getValueAt(ligne,1).toString());
    }

    @Override
    public void mousePressed(MouseEvent me) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
