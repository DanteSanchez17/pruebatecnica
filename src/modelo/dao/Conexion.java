
package modelo.dao;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Dante_Sanchez
 */
public class Conexion {

    //conexion a bdd
    
    public String base = "pruebatecnica";
    public String url = "jdbc:mysql://localhost/" + base;
    public String usuario = "root";
    public String pass = "";
    
    
    public Connection conectar() {
        Connection cn = null;
        
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            cn =(Connection)DriverManager.getConnection(this.url,this.usuario,this.pass);
            
            //prueba de conexion
            System.out.println("conexion exitosa");
        } catch (Exception e) {
            System.out.println("error en conexion");
        }
        return cn;
    }
}
