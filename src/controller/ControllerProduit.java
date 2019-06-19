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
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Categorie;
import model.CategorieDAO;
import model.Produit;
import model.ProduitDAO;
import view.ProduitVue;

/*-----------------------------------------------------------------*/
    //1 - Attribu de class
/*-----------------------------------------------------------------*/
/**
 *
 * @author Formation
 */
public class ControllerProduit implements ActionListener{
    private ProduitDAO prodDao;
    private ProduitVue prodVue;
    private CategorieDAO catDao;
    private DefaultTableModel modelProd;

/*-----------------------------------------------------------------*/
    //2 - Constructeurs
/*-----------------------------------------------------------------*/
    public ControllerProduit() {
        prodDao = new ProduitDAO();
        prodVue = new ProduitVue();
        catDao = new CategorieDAO();
        modelProd = new DefaultTableModel();   
        
        ajoutCategorie();
        initModelProd();
        addListerner();
        prodVue.setVisible(true);
    }
    
    
/*-----------------------------------------------------------------*/
    //2 - Méthodes
/*-----------------------------------------------------------------*/
    
    public void addListerner(){
        this.prodVue.getBtnAjouterProd().addActionListener(this);
    }
    /**
     * Cette Méthode permet de charger le combobox avec la liste des 
     * catégories de produit
     */
    public void ajoutCategorie(){
        List<Categorie> listeCat = this.catDao.getAllCategorie();      
        for(Categorie cat : listeCat){
            this.prodVue.getComboCat().addItem(cat.getIdCat() +" "+ cat.getLibelle());
        }
    }
    /**
     * Cette méthode récupère l'idCat dans la chaine de caractère formée de 
     * idcat et du libelle
     * @param chaine
     * @return 
     */
    public int findIdCat(String chaine){
        String [] tabIdCat = chaine.split(" ");  
        return Integer.parseInt(tabIdCat[0]);
    }
    /**
     * 
     */
    public void initModelProd(){
          //création du modele catégorie
        //Ajout des Colonnes du dodele Catégorie
        modelProd.addColumn("ID Prod");
        modelProd.addColumn("Nom");
        modelProd.addColumn("Description");
        modelProd.addColumn("Prix");
        modelProd.addColumn("Qte");
        modelProd.addColumn("Cat");
        //inserer les lignes dans le medele cat
        List<Produit> allProd = new ArrayList<>();
        allProd = this.prodDao.getAllProduit();
        
        for (Produit prod : allProd) {
            modelProd.addRow(new Object[]{prod.getIdProd(),
                prod.getNomProd(),prod.getDescriptionProd(),prod.getPrixProd(),
            prod.getQteProd(),prod.getCatProd().getIdCat()});
        }
        this.prodVue.getTableListeProd().setModel(modelProd);     
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource().equals(this.prodVue.getBtnAjouterProd())){
            Produit prod = new Produit();
            prod.setNomProd(this.prodVue.getTxtNomProd().getText());
            prod.setDescriptionProd(this.prodVue.getTxtDescriptionProd().getText());
            prod.setPrixProd(Double.parseDouble(this.prodVue.getTxtPrixProd().getText()));           
            prod.setQteProd(Integer.parseInt(this.prodVue.getTxtPrixProd().getText())); 
            
            String chaine = this.prodVue.getComboCat().getSelectedItem().toString();
            prod.setCatProd(new Categorie(findIdCat(chaine)));
            
            
            this.prodDao.addProduit(prod);
        }
        
           }
    
}
