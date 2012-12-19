/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package escolme.academico.modelo.negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jose
 */
public class MatriculaAcademicaBO {
    
    public static void ActualizarEstadoMatriculaAcademica(long ESTP_ID){
        String sql = "UPDATE ACADEMICO.MATRICULAACADEMICA SET MAAC_ESTADO='ACTIVA' WHERE ESTP_ID=?";
        PreparedStatement ps; Connection c = null;
        try {
            c = ConexionAcademicoDB.AbrirConexion();
            ps = c.prepareStatement(sql);
            ps.setLong(1, ESTP_ID);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MatriculaAcademicaBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            ConexionAcademicoDB.CerrarConexion(c);
        }
    }
    
}
