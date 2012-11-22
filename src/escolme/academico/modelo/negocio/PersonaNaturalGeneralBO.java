/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package escolme.academico.modelo.negocio;

import escolme.academico.modelo.entidades.PersonaNaturalGeneralAC;
import escolme.vortal.modelo.negocio.UsuarioBO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Jose Luis Orozco Mejia
 * @since 
 */
public class PersonaNaturalGeneralBO {

    public static List<PersonaNaturalGeneralAC> ListarPersonasPorIdentificacionNombre(String parametro){
        List<PersonaNaturalGeneralAC> persona = new ArrayList<>();
        Connection c =null;
        try{
            String sql = "SELECT GENERAL.PERSONAGENERAL.PEGE_DOCUMENTOIDENTIDAD,GENERAL.PERSONANATURALGENERAL.* FROM GENERAL.PERSONAGENERAL INNER JOIN GENERAL.PERSONANATURALGENERAL ON GENERAL.PERSONAGENERAL.PEGE_ID=GENERAL.PERSONANATURALGENERAL.PEGE_ID" + 
                    " WHERE GENERAL.PERSONAGENERAL.PEGE_DOCUMENTOIDENTIDAD LIKE '" + parametro + "%' OR GENERAL.PERSONANATURALGENERAL.PENG_PRIMERAPELLIDO  LIKE '" + parametro + "%' OR GENERAL.PERSONANATURALGENERAL.PENG_PRIMERNOMBRE  LIKE '" + parametro + "%' OR GENERAL.PERSONANATURALGENERAL.PENG_SEGUNDONOMBRE  LIKE '" + parametro + "%' ORDER BY GENERAL.PERSONANATURALGENERAL.PENG_PRIMERNOMBRE";
            c = ConexionAcademicoDB.AbrirConexion();
            PreparedStatement ps = c.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               persona.add(MapeoUsuario(rs));
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
    
    public static PersonaNaturalGeneralAC CargarPersonaPorIdentificacion(String PEGE_DOCUMENTOIDENTIDAD){
        PersonaNaturalGeneralAC persona = null;
        Connection c =null;
        long PEGE_ID = 0;
        try{
            String sql = "SELECT PEGE_ID FROM GENERAL.PERSONAGENERAL WHERE GENERAL.PERSONAGENERAL.PEGE_DOCUMENTOIDENTIDAD='" + PEGE_DOCUMENTOIDENTIDAD + "'";
            c = ConexionAcademicoDB.AbrirConexion();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               PEGE_ID = rs.getLong("PEGE_ID");
            }        
            persona = CargarPersonaPorPegeId(PEGE_ID);
        }
        catch (SQLException ex) {
            Logger.getLogger(UsuarioBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
             ConexionAcademicoDB.CerrarConexion(c);
            return persona;
        }
    }
    
    public static PersonaNaturalGeneralAC CargarPersonaPorPegeId(long PEGE_ID){
        PersonaNaturalGeneralAC persona = null;
        Connection c =null;
        try{
            persona = new PersonaNaturalGeneralAC();
            String sql = "SELECT GENERAL.PERSONANATURALGENERAL.*,GENERAL.PERSONAGENERAL.PEGE_DOCUMENTOIDENTIDAD,PERSONAGENERAL.PEGE_DIRECCION,PERSONAGENERAL.PEGE_TELEFONO " +
                    "FROM GENERAL.PERSONANATURALGENERAL INNER JOIN GENERAL.PERSONAGENERAL ON GENERAL.PERSONANATURALGENERAL.PEGE_ID=GENERAL.PERSONAGENERAL.PEGE_ID WHERE GENERAL.PERSONANATURALGENERAL.PEGE_ID='" + PEGE_ID + "'";
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
        periodo.setPEGE_DIRECCION(rs.getString("PEGE_DIRECCION"));
        periodo.setPEGE_TELEFONO(rs.getString("PEGE_TELEFONO"));
        periodo.setPEGE_ID(rs.getInt("PEGE_ID"));
        return periodo;
    }
    
}
