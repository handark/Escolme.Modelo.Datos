package escolme.academico.modelo.negocio;

import escolme.academico.modelo.entidades.PeriodoUniversidadAC;
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
 * @since 06-05-2012
 */
public class PeriodoUniversidadBO {

    public static List<PeriodoUniversidadAC> ListarPeriodosUniversidad(int ano){
        List<PeriodoUniversidadAC> periodos = null;
        Connection c =null;
        try {
            periodos = new ArrayList<PeriodoUniversidadAC>();
            String sql = "select PEUN_ID,PEUN_ANO,PEUN_PERIODO,b.TPPA_DESCRIPCION FROM ACADEMICO.PERIODOUNIVERSIDAD INNER JOIN ACADEMICO.TIPOPERIODOACADEMICO b ON ACADEMICO.PERIODOUNIVERSIDAD.TPPA_ID=b.TPPA_ID WHERE ACADEMICO.PERIODOUNIVERSIDAD.PEUN_ANO='" + String.valueOf(ano) + "'";
            c = ConexionAcademicoDB.AbrirConexion();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
              periodos.add(MapeoUsuario(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PeriodoUniversidadBO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConexionAcademicoDB.CerrarConexion(c);
            return periodos;
        }
    }
    
    public static PeriodoUniversidadAC CargarPeriodoPorId(long PEUN_ID){
        PeriodoUniversidadAC persona = null;
        Connection c =null;
        try{
            persona = new PeriodoUniversidadAC();
            String sql = "SELECT * FROM ACADEMICO.PERIODOUNIVERSIDAD INNER JOIN ACADEMICO.TIPOPERIODOACADEMICO b ON ACADEMICO.PERIODOUNIVERSIDAD.TPPA_ID=b.TPPA_ID WHERE ACADEMICO.PERIODOUNIVERSIDAD.PEUN_ID=" + PEUN_ID;
            c = ConexionAcademicoDB.AbrirConexion();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                persona = MapeoUsuario(rs);
            }        
        }
        catch (SQLException ex) {
            Logger.getLogger(PeriodoUniversidadBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
             ConexionAcademicoDB.CerrarConexion(c);
            return persona;
        }
    }    
    
    public static PeriodoUniversidadAC MapeoUsuario(ResultSet rs) throws SQLException{
        PeriodoUniversidadAC periodo = new PeriodoUniversidadAC();
        periodo.setPEUN_ID(rs.getLong("PEUN_ID"));
        periodo.setPEUN_ANO(rs.getInt("PEUN_ANO"));
        periodo.setPEUN_PERIODO(rs.getString("PEUN_PERIODO"));
        periodo.setTPPA_DESCRIPCION(rs.getString("TPPA_DESCRIPCION"));
        return periodo;
    }
    
}
