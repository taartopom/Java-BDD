
/*--------------------------------------------------*/
/* Structure de la page 
*1- Attribu de class
*2- Constructeur
*3- Methodes
    -Controller entre la vue et le model
    -Evenement
*/
/*--------------------------------------------------*/
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
import view.PrincipaleVue;


/*-----------------------------------------------------------------*/
    //1 - Attribu de class
/*-----------------------------------------------------------------*/
/**
 *
 * @author Administrateur
 */
public class ControllerCategorie implements ActionListener, MouseListener{
    private CategorieDAO catDAO;
    private CategorieVue catVue;
    private DefaultTableModel modelCat;
    private PrincipaleVue principaleVue;

    
/*-----------------------------------------------------------------*/
    //2 - Constructeurs
/*-----------------------------------------------------------------*/
    public ControllerCategorie(){
        catDAO = new CategorieDAO();
        catVue = new CategorieVue();
        principaleVue = new PrincipaleVue();
        init();    
        
        catVue.getBtnAjouter().setEnabled(true);
        catVue.getBtnModifier().setEnabled(false);
        catVue.getBtnSupprimer().setEnabled(false);
        
        addListener();
        
        //catVue.setVisible(true);
        principaleVue.setVisible(true);
        
    }   

    public ControllerCategorie(CategorieDAO catDAO, CategorieVue catVue) {
        this.catDAO = catDAO;
        this.catVue = catVue;
    }

    public ControllerCategorie(CategorieVue catVue) {
        this.catVue = catVue;
        this.catDAO = new CategorieDAO();
    }
    
/*-----------------------------------------------------------------*/
//1 - Méthodes
/*-----------------------------------------------------------------*/
    /*controller entre la vue et le model*/
/*-------------------------------------------------------------------*/
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
    public void  addListener(){ 
        catVue.getBtnAjouter().addActionListener(this);
        catVue.getBtnModifier().addActionListener(this);
        catVue.getBtnSupprimer().addActionListener(this);
        catVue.getBtnReset().addActionListener(this);
        catVue.getjTable2().addMouseListener(this);
        principaleVue.getMenuCat().addActionListener(this);

    }
    
    /*Evenement*/
/*-------------------------------------------------------------------*/


    @Override
    public void actionPerformed(ActionEvent ae) {
        
        //pour l'ajout
        if (ae.getSource().equals(this.catVue.getBtnAjouter())) {
            Categorie cat = new Categorie();
            cat.setLibelle(this.catVue.getTxtLibelle().getText());
            
            catDAO.addCategorie(cat);
            
            JOptionPane.showMessageDialog(null,"Enregistrement ok");
            
            this.catVue.getTxtLibelle().setText("");
            init();    
        }

        // pour la modification
        if (ae.getSource().equals(this.catVue.getBtnModifier())) {
            Categorie catUp = new Categorie();
            catUp.setIdCat(Integer.parseInt(this.catVue.getTxtIdCat().getText()));

            catDAO.updateCategorie(catUp);

            JOptionPane.showMessageDialog(null, "Modification ok");

            this.catVue.getTxtLibelle().setText("");
            init();
        }

        // pour la suppression
        if (ae.getSource().equals(this.catVue.getBtnSupprimer())) {
            Categorie cat = new Categorie();
            // on mofifie 'id et le libellé
            cat.setIdCat(Integer.parseInt(this.catVue.getTxtIdCat().getText()));
            cat.setLibelle(this.catVue.getTxtLibelle().getText());
            
            catDAO.deleteCategorie(cat);
            
            JOptionPane.showMessageDialog(null,"Suppression ok");
            
            //vider le champs libelle
            this.catVue.getTxtLibelle().setText("");
            init();
            
        }
        
        if (ae.getSource().equals(this.catVue.getBtnReset)) {
            catVue.getBtnAjouter().setEnabled(true);
            catVue.getBtnModifier().setEnabled(false);
            catVue.getBtnSupprimer().setEnabled(false);
            
            catVue.getTxtIdCat().setText("");
            catVue.getTxtLibelle().setText("");
        }
        
        if(ae.getSource().equals(this.principaleVue.getMenuCat())){
            this.catVue.setVisible(true);
        }   
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        int ligne  = this.catVue.getjTable2().getSelectedRow();
        this.catVue.getTxtIdCat().setText(modelCat.getValueAt(ligne, 0).toString());
        this.catVue.getTxtLibelle().setText(modelCat.getValueAt(ligne,1).toString());
        
        catVue.getBtnAjouter().setEnabled(false);
        catVue.getBtnModifier().setEnabled(true);
        catVue.getBtnSupprimer().setEnabled(true);
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
