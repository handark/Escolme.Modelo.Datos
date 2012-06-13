package escolme.academico.modelo.negocio;

import escolme.academico.modelo.entidades.PagoLiquidacionAC;
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
 * @since 12-06-2012
 */
public class PagoLiquidacionBO {

    public static List<PagoLiquidacionAC> ListarPagosPorLiquidacion(long LIQU_ID){
        List<PagoLiquidacionAC> liquidaciones = null;
        Connection c =null;
        try {
            liquidaciones = new ArrayList<PagoLiquidacionAC>();
            String sql = "SELECT PAGOLIQUIDACION.*,TIPOPAGOLIQUIDACION.TIPL_DESCRIPCION FROM PAGOLIQUIDACION INNER JOIN TIPOPAGOLIQUIDACION ON PAGOLIQUIDACION.TIPL_ID=TIPOPAGOLIQUIDACION.TIPL_ID WHERE PAGOLIQUIDACION.LIQU_ID='" + String.valueOf(LIQU_ID) + "'";
            c = ConexionAcademicoDB.AbrirConexion();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
              liquidaciones.add(MapeoLiquidacion(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConexionAcademicoDB.CerrarConexion(c);
            return liquidaciones;
        }
    }
    
     public static PagoLiquidacionAC MapeoLiquidacion(ResultSet rs) throws SQLException{
        PagoLiquidacionAC periodo = new PagoLiquidacionAC();
        periodo.setLIQU_ID(rs.getLong("LIQU_ID"));
        periodo.setPALI_ESTADO(rs.getString("PALI_ESTADO"));
        periodo.setPALI_ID(rs.getLong("PALI_ID"));
        periodo.setPALI_FECHA(rs.getDate("PALI_FECHA"));
        periodo.setPALI_VALOR(rs.getFloat("PALI_VALOR"));
        periodo.setPALI_REGISTRADOPOR(rs.getString("PALI_REGISTRADOPOR"));
        periodo.setPALI_FECHACAMBIO(rs.getDate("PALI_FECHACAMBIO"));
        periodo.setTIPL_ID(rs.getLong("TIPL_ID"));
        periodo.setPALI_OBSERVACIONES(rs.getString("PALI_OBSERVACIONES"));
        periodo.setTIPL_DESCRIPCION(rs.getString("TIPL_DESCRIPCION"));
        return periodo;
    }
    
}
