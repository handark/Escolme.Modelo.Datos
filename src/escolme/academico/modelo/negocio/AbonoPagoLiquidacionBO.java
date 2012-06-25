package escolme.academico.modelo.negocio;

import escolme.academico.modelo.entidades.AbonoPagoLiquidacionAC;
import escolme.modelo.ayudas.MensajesAjaxAY;
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
 * @since 22-06-2012
 */
public class AbonoPagoLiquidacionBO {

    public static MensajesAjaxAY GuardarAbonoPagoLiquidacion(AbonoPagoLiquidacionAC abono){
        MensajesAjaxAY resultado = null;
        Connection c =null;
        try {
            String sql = "INSERT INTO(ABPL_ID,PALI_ID,LIQU_ID,ABPL_VALOR,ABPL_FECHA,ABPL_OBSERVACION) " + 
                            " VALUES(?,?,?,?,?,?)";
            c = ConexionAcademicoDB.AbrirConexion();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setLong(1, abono.getABPL_ID());
            ps.setLong(2, abono.getPALI_ID());
            ps.setLong(3, abono.getLIQU_ID());
            ps.setFloat(4, abono.getABPL_VALOR());
            ps.setDate(5, abono.getABPL_FECHA());
            ps.setString(6, abono.getABPL_OBSERVACION());
            ResultSet rs = ps.executeQuery();
            resultado = new MensajesAjaxAY();
            resultado.setID(String.valueOf(abono.getABPL_ID()));
            resultado.setMENSAJE("Abono generado con exito");
        }
        catch(SQLException ex){
            resultado = new MensajesAjaxAY();
            resultado.setID("0");
            resultado.setMENSAJE("Error: " + ex.getMessage());
        }
        finally{
            ConexionAcademicoDB.CerrarConexion(c);
            return resultado;
        }
    }
    
    public static List<AbonoPagoLiquidacionAC> ListarAbonoPagoLiquidacionPorLiquidacion(long LIQU_ID){
        List<AbonoPagoLiquidacionAC> abonos = null;
        Connection c =null;
        try {
            abonos = new ArrayList<AbonoPagoLiquidacionAC>();
            String sql = "SELECT * FROM ABONOPAGOLIQUIDACION WHERE LIQU_ID='" + LIQU_ID + "'";
            c = ConexionAcademicoDB.AbrirConexion();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
              abonos.add(MapeoAbonoPagoLiquidacion(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConexionAcademicoDB.CerrarConexion(c);
            return abonos;
        }
    }
        
    public static AbonoPagoLiquidacionAC MapeoAbonoPagoLiquidacion(ResultSet rs) throws SQLException{
        AbonoPagoLiquidacionAC abono = new AbonoPagoLiquidacionAC();
        abono.setABPL_ID(rs.getLong("ABPL_ID"));
        abono.setPALI_ID(rs.getLong("PALI_ID"));
        abono.setLIQU_ID(rs.getLong("LIQU_ID"));
        abono.setABPL_VALOR(rs.getFloat("ABPL_VALOR"));
        abono.setABPL_FECHA(rs.getDate("ABPL_FECHA"));
        abono.setABPL_OBSERVACION(rs.getString("ABPL_OBSERVACION"));
        return abono;
    }
    
}
