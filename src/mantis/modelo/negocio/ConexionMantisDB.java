package mantis.modelo.negocio;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jose
 */
public class ConexionMantisDB {
    private static ConexionMantisDB instancia;

    private String CadenaConexion;
    
    private ConexionMantisDB(){
        CadenaConexion = "jdbc:mysql://localhost:3306/mantis_soporte?user=root&password=Esc$2009";
    }
    
    public static Connection AbrirConexion(){
        Connection con = null;
        try {
            if(instancia == null){
                instancia = new ConexionMantisDB();
            }
            Driver d = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = d.connect(instancia.CadenaConexion, new Properties());

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            Logger.getLogger(ConexionMantisDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    public static void CerrarConexion(Connection conexion){
        if(conexion != null) {
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConexionMantisDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
