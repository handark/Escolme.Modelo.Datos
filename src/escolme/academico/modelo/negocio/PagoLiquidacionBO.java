package escolme.academico.modelo.negocio;

import escolme.academico.modelo.entidades.AbonoPagoLiquidacionAC;
import escolme.academico.modelo.entidades.PagoLiquidacionAC;
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
 * @since 12-06-2012
 */
public class PagoLiquidacionBO {

    public static MensajesAjaxAY GuardarPagoLiquidacion(PagoLiquidacionAC pago){
        MensajesAjaxAY resultado = null;
        Connection c =null;
        try {
            long id = ComunBO.GenerarLongID("PAGOLIQUIDACION", "PALI_ID");
            String sql = "INSERT INTO PAGOLIQUIDACION(PALI_ID,LIQU_ID,PALI_VALOR,PALI_FECHA,PALI_ESTADO,PALI_REGISTRADOPOR,PALI_FECHACAMBIO,TIPL_ID,PALI_OBSERVACIONES) " + 
                            "VALUES(?,?,?,?,?,?,?,?,?)";
            c = ConexionAcademicoDB.AbrirConexion();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setLong(1, id);
            ps.setLong(2, pago.getLIQU_ID());
            ps.setFloat(3, pago.getPALI_VALOR());
            ps.setDate(4, pago.getPALI_FECHA());
            ps.setString(5, pago.getPALI_ESTADO());
            ps.setString(6, pago.getPALI_REGISTRADOPOR());
            ps.setDate(7, pago.getPALI_FECHACAMBIO());
            ps.setLong(8, pago.getTIPL_ID());
            ps.setString(9, pago.getPALI_OBSERVACIONES());
            ps.executeUpdate();
            resultado = new MensajesAjaxAY();
            resultado.setID(String.valueOf(id));
            resultado.setMENSAJE("Pago de Liquidacion agregado con exito");
        }
        catch(SQLException ex){
            resultado = new MensajesAjaxAY();
            resultado.setID("0");
            resultado.setMENSAJE("Error al guardar pago: <br>" + ex.getMessage());
        }
        finally{
            ConexionAcademicoDB.CerrarConexion(c);
            return resultado;
        }
    }    
    
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
