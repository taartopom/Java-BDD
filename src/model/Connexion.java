/*Class permettant la connexion à la BDD mysql
*/
/*--------------------------------------------------------------*/
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Administrateur
 */
public class Connexion {
   static Connection connex;
   static {
       try{

   Class.forName("com.mysql.jdbc.Driver");
           String url = "jdbc:mysql://localhost:3306/gescom";
           String user = "root";
           String password = "";
           connex = DriverManager.getConnection(url, user, password);
               System.out.println("Connexion ok");

       } catch (ClassNotFoundException | SQLException e) {
           System.out.println(e.getMessage());
       }

}
   public static Connection getConnexion(){
   return connex;
   }
}
