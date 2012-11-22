package escolme.vortal.modelo.negocio;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Jose Luis Orozco Mejia
 * @since 
 */
public class ConexionDB {
    private static ConexionDB instancia;

    private String CadenaConexion;

    
    private ConexionDB(){
       // CadenaConexion = "jdbc:postgresql://10.10.1.12:5432/escolme?user=postgres&password=Escolme2008";
       CadenaConexion = "jdbc:postgresql://localhost:5432/escolme?user=postgres&password=juanita";
    }
    
    public static Connection AbrirConexion() throws ClassNotFoundException{
        Connection con = null;
        try {
            if(instancia == null){
                instancia = new ConexionDB();
            }
            Driver d = null;
  
            d = (Driver) Class.forName("org.postgresql.Driver").newInstance();

            con = d.connect(instancia.CadenaConexion, new Properties());

        } catch (Exception ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    public static void CerrarConexion(Connection conexion){
        if(conexion != null)
            try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
