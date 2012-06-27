package escolme.academico.modelo.negocio;

import escolme.academico.modelo.entidades.TipoPagoAbonoLiquidacionAC;
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
 * @since 27-06-2012
 */
public class TipoPagoAbonoLiquidacionBO {

    public static List<TipoPagoAbonoLiquidacionAC> ListarTipoPagoAbonoLiquidacion(){
        List<TipoPagoAbonoLiquidacionAC> liquidaciones = null;
        Connection c =null;
        try {
            liquidaciones = new ArrayList<TipoPagoAbonoLiquidacionAC>();
            String sql = "SELECT TIPA_ID,TIPA_FORMAPAGO FROM ACADEMICO.TIPOPAGOABONOLIQUIDACION ORDER BY TIPA_FORMAPAGO";
            c = ConexionAcademicoDB.AbrirConexion();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
              liquidaciones.add(MapeoTipoPagoAbonoLiquidacion(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConexionAcademicoDB.CerrarConexion(c);
            return liquidaciones;
        }
    }
        
    public static TipoPagoAbonoLiquidacionAC MapeoTipoPagoAbonoLiquidacion(ResultSet rs) throws SQLException{
        TipoPagoAbonoLiquidacionAC periodo = new TipoPagoAbonoLiquidacionAC();
        periodo.setTIPA_ID(rs.getLong("TIPA_ID"));
        periodo.setTIPA_FORMAPAGO(rs.getString("TIPA_FORMAPAGO"));
        return periodo;
    }    
    
}
