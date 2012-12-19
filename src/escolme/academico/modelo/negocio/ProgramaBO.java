package escolme.academico.modelo.negocio;

import escolme.academico.modelo.entidades.ProgramaAC;
import escolme.vortal.modelo.negocio.UsuarioBO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Jose Luis Orozco Mejia
 * @since 19-06-2012
 */
public class ProgramaBO {

    public static ProgramaAC CargarProgramaPorEstudiantePegeId(int PEGE_ID){
        ProgramaAC programa = null;
        Connection c =null;
        try{
            programa = new ProgramaAC();
            String sql = "SELECT * from ((ACADEMICO.ESTUDIANTEPENSUM INNER JOIN ACADEMICO.PENSUM ON ACADEMICO.ESTUDIANTEPENSUM.PENS_ID=ACADEMICO.PENSUM.PENS_ID)INNER JOIN ACADEMICO.PROGRAMA ON ACADEMICO.PENSUM.PROG_ID=ACADEMICO.PROGRAMA.PROG_ID) INNER JOIN ACADEMICO.MATRICULAACADEMICA ON ACADEMICO.ESTUDIANTEPENSUM.ESTP_ID=ACADEMICO.MATRICULAACADEMICA.ESTP_ID WHERE ACADEMICO.ESTUDIANTEPENSUM.PEGE_ID='" + PEGE_ID + "'";
            c = ConexionAcademicoDB.AbrirConexion();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                programa = MapeoPrograma(rs);
            }        
        }
        catch (SQLException ex) {
            Logger.getLogger(UsuarioBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
             ConexionAcademicoDB.CerrarConexion(c);
            return programa;
        }
    } 
    
    public static ProgramaAC MapeoPrograma(ResultSet rs) throws SQLException{
        ProgramaAC programa = new ProgramaAC();
        programa.setPROG_NOMBRE(rs.getString("PROG_NOMBRE"));  
        programa.setPROG_ID(rs.getLong("PROG_ID"));
        return programa;
    }
    
    
}
