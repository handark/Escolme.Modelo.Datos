package escolme.academico.modelo.negocio;

import escolme.academico.modelo.entidades.FechaLimiteAC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jose Luis Orozco Mejia
 * @since 20-11-2012
 */
public class FechaLimiteBO {

    public static List<FechaLimiteAC> ListarFechasLimite(long PEUN_ID,long CATE_ID,long UNPR_ID,long FELI_SEMESTRE){
        List<FechaLimiteAC> fechas = null;
        Connection c =null;
        try {
            fechas = new ArrayList<>();
            String sql = "SELECT a.* FROM ACADEMICO.FECHALIMITE a WHERE a.PEUN_ID=" + PEUN_ID + " AND a.CATE_ID=" + CATE_ID + " AND a.UNPR_ID=" + UNPR_ID + " AND a.FELI_SEMESTRE=" + FELI_SEMESTRE + " ORDER BY FELI_DESCRIPCION DESC";
            c = ConexionAcademicoDB.AbrirConexion();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
              fechas.add(MapeoFechaLimite(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FechaLimiteBO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConexionAcademicoDB.CerrarConexion(c);
            return fechas;
        }
    }    

    private static FechaLimiteAC MapeoFechaLimite(ResultSet rs) throws SQLException{
        FechaLimiteAC fecha = new FechaLimiteAC();
        fecha.setPEUN_ID(rs.getLong("PEUN_ID"));
        fecha.setFELI_ID(rs.getLong("FELI_ID"));
        fecha.setFELI_FECHAFINAL(rs.getDate("FELI_FECHAFINAL"));
        fecha.setFELI_DESCRIPCION(rs.getString("FELI_DESCRIPCION"));
        fecha.setFELI_PORCENTAJE(rs.getLong("FELI_PORCENTAJE"));
        return fecha;
    }
    
}
