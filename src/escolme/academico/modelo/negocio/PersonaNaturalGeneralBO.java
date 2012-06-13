/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package escolme.academico.modelo.negocio;

import escolme.academico.modelo.entidades.PeriodoUniversidadAC;
import escolme.academico.modelo.entidades.PersonaNaturalGeneralAC;
import escolme.vortal.modelo.negocio.UsuarioBO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Jose Luis Orozco Mejia
 * @since 
 */
public class PersonaNaturalGeneralBO {

    public static PersonaNaturalGeneralAC CargarPersonaPorPegeId(int PEGE_ID){
        PersonaNaturalGeneralAC persona = null;
        Connection c =null;
        try{
            persona = new PersonaNaturalGeneralAC();
            String sql = "SELECT GENERAL.PERSONANATURALGENERAL.*,GENERAL.PERSONAGENERAL.PEGE_DOCUMENTOIDENTIDAD FROM GENERAL.PERSONANATURALGENERAL INNER JOIN GENERAL.PERSONAGENERAL ON GENERAL.PERSONANATURALGENERAL.PEGE_ID=GENERAL.PERSONAGENERAL.PEGE_ID WHERE GENERAL.PERSONANATURALGENERAL.PEGE_ID='" + PEGE_ID + "'";
            c = ConexionAcademicoDB.AbrirConexion();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                persona = MapeoUsuario(rs);
            }        
        }
        catch (SQLException ex) {
            Logger.getLogger(UsuarioBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
             ConexionAcademicoDB.CerrarConexion(c);
            return persona;
        }
    }
    
    public static PersonaNaturalGeneralAC MapeoUsuario(ResultSet rs) throws SQLException{
        PersonaNaturalGeneralAC periodo = new PersonaNaturalGeneralAC();
        periodo.setPENG_EMAILINSTITUCIONAL(rs.getString("PENG_EMAILINSTITUCIONAL"));
        periodo.setPENG_PRIMERNOMBRE(rs.getString("PENG_PRIMERNOMBRE"));
        periodo.setPENG_PRIMERAPELLIDO(rs.getString("PENG_PRIMERAPELLIDO"));
        periodo.setPENG_SEGUNDOAPELLIDO(rs.getString("PENG_SEGUNDOAPELLIDO"));
        periodo.setPENG_SEGUNDONOMBRE(rs.getString("PENG_SEGUNDONOMBRE"));
        periodo.setPEGE_DOCUMENTOIDENTIDAD(rs.getString("PEGE_DOCUMENTOIDENTIDAD"));
        periodo.setPEGE_ID(rs.getInt("PEGE_ID"));
        return periodo;
    }
    
}
