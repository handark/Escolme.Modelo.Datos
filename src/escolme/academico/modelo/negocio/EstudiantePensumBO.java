package escolme.academico.modelo.negocio;

import escolme.academico.modelo.entidades.EstudiantePensumAC;
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
 * @since 19-06-2012
 */
public class EstudiantePensumBO {

    
    public static EstudiantePensumAC CargarEstudiantePensumPorPegeId(long PEGE_ID,long PENS_ID){
        EstudiantePensumAC estudiante = null;
        Connection c =null;
        try{
            estudiante = new EstudiantePensumAC();
            String sql = "SELECT ACADEMICO.ESTUDIANTEPENSUM.* FROM ACADEMICO.ESTUDIANTEPENSUM WHERE ACADEMICO.ESTUDIANTEPENSUM.PEGE_ID='" + PEGE_ID + "' AND ACADEMICO.ESTUDIANTEPENSUM.PENS_ID=" + PENS_ID;
            c = ConexionAcademicoDB.AbrirConexion();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                estudiante = MapeoEstudiantePensum(rs);
            }        
        }
        catch (SQLException ex) {
            Logger.getLogger(EstudiantePensumBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            ConexionAcademicoDB.CerrarConexion(c);
            return estudiante;
        }
    }    
    
    public static List<EstudiantePensumAC> ListarEstuduantesActivos(){
        List<EstudiantePensumAC> estudiante = null;
        Connection c =null;
        try{
            estudiante = new ArrayList<>();
            String sql = "SELECT A.PEGE_ID,B.PEGE_DOCUMENTOIDENTIDAD,B.PEGE_MAIL,C.PENG_PRIMERNOMBRE,C.PENG_PRIMERAPELLIDO,C.PENG_SEGUNDOAPELLIDO FROM (ACADEMICO.ESTUDIANTEPENSUM A INNER JOIN GENERAL.PERSONAGENERAL B ON A.PEGE_ID=B.PEGE_ID) INNER JOIN GENERAL.PERSONANATURALGENERAL C ON A.PEGE_ID=C.PEGE_ID WHERE A.SITE_ID=5";
            //AND ROWNUM<=100
            c = ConexionAcademicoDB.AbrirConexion();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if(rs.getString("PEGE_MAIL") != null){
                    estudiante.add(MapeoEstudiante(rs));
                }
            }        
        }
        catch (SQLException ex) {
            Logger.getLogger(UsuarioBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
             ConexionAcademicoDB.CerrarConexion(c);
            return estudiante;
        }
    }
    
    public static EstudiantePensumAC MapeoEstudiante(ResultSet rs) throws SQLException{
        EstudiantePensumAC credito = new EstudiantePensumAC();
        credito.setPEGE_ID(rs.getLong("PEGE_ID"));
        credito.setPEGE_DOCUMENTOIDENTIDAD(rs.getString("PEGE_DOCUMENTOIDENTIDAD"));
        credito.setPEGE_MAIL(rs.getString("PEGE_MAIL"));
        credito.setPENG_PRIMERNOMBRE(rs.getString("PENG_PRIMERNOMBRE"));
        credito.setPENG_PRIMERAPELLIDO(rs.getString("PENG_PRIMERAPELLIDO"));
        credito.setPENG_SEGUNDOAPELLIDO(rs.getString("PENG_SEGUNDOAPELLIDO"));
        return credito;
    }
    
    public static EstudiantePensumAC MapeoEstudiantePensum(ResultSet rs) throws SQLException{
        EstudiantePensumAC credito = new EstudiantePensumAC();
        credito.setESTP_CODIGOMATRICULA(rs.getString("ESTP_CODIGOMATRICULA"));
        credito.setCATE_ID(rs.getLong("CATE_ID"));
        credito.setESTP_PERIODOACADEMICO(rs.getLong("ESTP_PERIODOACADEMICO"));
        credito.setUNPR_ID(rs.getLong("UNPR_ID"));
        return credito;
    }
    
    
}
