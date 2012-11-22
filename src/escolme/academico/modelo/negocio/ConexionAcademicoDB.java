package escolme.academico.modelo.negocio;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionAcademicoDB {

    private static ConexionAcademicoDB instancia;

    private String CadenaConexion;


    private ConexionAcademicoDB(){
        CadenaConexion = "jdbc:oracle:thin:academico/ACA0369@10.10.1.12:1521:escolme";
        //CadenaConexion = "jdbc:oracle:thin:SYSTEM/ACA0369@10.10.1.49:1521:ESCOLMEPRUEBA";
       //CadenaConexion = "jdbc:oracle:thin:SYSTEM/ACA0369@JOSE-W8:1521:escolme";
    }
    
    public static Connection AbrirConexion(){
        Connection con = null;
        try {
            if(instancia == null){
                instancia = new ConexionAcademicoDB();
            }
            Driver d = (Driver) Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            con = d.connect(instancia.CadenaConexion, new Properties());

        } catch (Exception ex) {
            Logger.getLogger(ConexionAcademicoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    public static void CerrarConexion(Connection conexion){
        if(conexion != null)
            try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionAcademicoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
