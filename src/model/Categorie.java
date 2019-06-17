
/*----------------------------------------------------------------*/
/*Structure de la page
*1- attribut
*2- constructeur
*3- accesseurs
*4- mutateurs
*5- to String
*/
/*----------------------------------------------------------------*/
package model;

/**
 *
 * @author Administrateur
 */
/*----------------------------------------------------------------*/
//Attribut
/*----------------------------------------------------------------*/
public class Categorie {
   private int idCat;
   private String libelle;

/*----------------------------------------------------------------*/
//Constructeurs
/*----------------------------------------------------------------*/

   public Categorie(int idCat, String libelle) {
       this.idCat = idCat;
       this.libelle = libelle;
   }

    public Categorie() {
   }
   
    public Categorie(String libelle) {
        this.libelle = libelle;
    }
/*----------------------------------------------------------------*/
// Accesseurs
/*----------------------------------------------------------------*/
    public int getIdCat() {
       return idCat;
    }
   
    public String getLibelle() {
        return libelle;
    }
/*----------------------------------------------------------------*/
// Mutateurs
/*----------------------------------------------------------------*/
    public void setIdCat(int idCat) {
       this.idCat = idCat;
    } 

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

/*----------------------------------------------------------------*/
// To string
/*----------------------------------------------------------------*/

    @Override
    public String toString() {
        return "Categorie{" + "idCat=" + idCat + ", libelle=" + libelle + '}';
    }
    


}
