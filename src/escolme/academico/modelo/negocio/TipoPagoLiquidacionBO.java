package escolme.academico.modelo.negocio;

import escolme.academico.modelo.entidades.TipoPagoLiquidacionAC;
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
 * @since 20-06-2012
 */
public class TipoPagoLiquidacionBO {

    public static List<TipoPagoLiquidacionAC> ListarTipoPagoLiquidacion(){
        List<TipoPagoLiquidacionAC> liquidaciones = null;
        Connection c =null;
        try {
            liquidaciones = new ArrayList<TipoPagoLiquidacionAC>();
            String sql = "SELECT TIPL_ID,TIPL_DESCRIPCION FROM ACADEMICO.TIPOPAGOLIQUIDACION ORDER BY TIPL_DESCRIPCION";
            c = ConexionAcademicoDB.AbrirConexion();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
              liquidaciones.add(MapeoTipoPagoLiquidacion(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConexionAcademicoDB.CerrarConexion(c);
            return liquidaciones;
        }
    }
        
    public static TipoPagoLiquidacionAC MapeoTipoPagoLiquidacion(ResultSet rs) throws SQLException{
        TipoPagoLiquidacionAC periodo = new TipoPagoLiquidacionAC();
        periodo.setTIPL_ID(rs.getLong("TIPL_ID"));
        periodo.setTIPL_DESCRIPCION(rs.getString("TIPL_DESCRIPCION"));
        return periodo;
    }
    
}
