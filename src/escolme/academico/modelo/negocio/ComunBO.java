package escolme.academico.modelo.negocio;

import escolme.modelo.ayudas.MensajesAjaxAY;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Jose Luis Orozco Mejia
 * @since 
 */
public class ComunBO {

    public static long GenerarLongID(String tabla,String columna){
        Connection c =null;
        long id = 0;
        try {
            String sql = "SELECT MAX(" + columna + ") as maximo FROM ACADEMICO." + tabla;
            c = ConexionAcademicoDB.AbrirConexion();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
              id = rs.getLong("maximo") + 1;
            }
        }
        catch(SQLException ex){
            id=1;
        }
        finally{
            ConexionAcademicoDB.CerrarConexion(c);
            return id;
        }
    }
    
}
