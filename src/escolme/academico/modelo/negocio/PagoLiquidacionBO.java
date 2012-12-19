package escolme.academico.modelo.negocio;

import escolme.academico.modelo.entidades.LiquidacionAC;
import escolme.academico.modelo.entidades.PagoLiquidacionAC;
import escolme.modelo.ayudas.MensajesAjaxAY;
import escolme.modelo.ayudas.Numero_a_Letra;
import escolme.vortal.modelo.negocio.UsuarioBO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
        NumberFormat formato = NumberFormat.getInstance(Locale.ENGLISH);
        try {
            LiquidacionAC liquidacion = LiquidacionesBO.CargarLiquidacionPorId(pago.getLIQU_ID());
            long id = ComunBO.GenerarLongID("PAGOLIQUIDACION", "PALI_ID");
            String sql = "INSERT INTO ACADEMICO.PAGOLIQUIDACION(PALI_ID,LIQU_ID,PALI_VALOR,PALI_FECHA,PALI_ESTADO,PALI_REGISTRADOPOR,PALI_FECHACAMBIO,TIPL_ID,PALI_OBSERVACIONES) " + 
                            "VALUES(?,?,?,?,?,?,?,?,?)";
            c = ConexionAcademicoDB.AbrirConexion();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setLong(1, id);
            ps.setLong(2, pago.getLIQU_ID());
            ps.setLong(3, pago.getPALI_VALOR());
            ps.setDate(4, pago.getPALI_FECHA());
            ps.setString(5, pago.getPALI_ESTADO());
            ps.setString(6, pago.getPALI_REGISTRADOPOR());
            ps.setDate(7, pago.getPALI_FECHACAMBIO());
            ps.setLong(8, pago.getTIPL_ID());
            ps.setString(9, pago.getPALI_OBSERVACIONES());
            ps.executeUpdate();
            
            String estado = "PAGADO";
            
            float totalAbonos = liquidacion.getLIQU_VALORPAGADO() + pago.getPALI_VALOR();
            
            if(pago.getTIPL_ID() == 405){
                estado = "CARTERA";
            }
            if(totalAbonos >= (liquidacion.getLIQU_TOTALLIQUIDADO()- liquidacion.getLIQU_TOTALDESCUENTO())){
                estado = "PAGADO";
            }
            
            sql = "UPDATE ACADEMICO.LIQUIDACION SET LIQU_ESTADO=?,LIQU_VALORPAGADO=LIQU_VALORPAGADO + ? WHERE LIQU_ID=?";
            ps = c.prepareStatement(sql);
            ps.setString(1, estado);
            ps.setFloat(2, pago.getPALI_VALOR());
            ps.setLong(3, pago.getLIQU_ID());
            ps.executeUpdate();
            
            
            MatriculaAcademicaBO.ActualizarEstadoMatriculaAcademica(liquidacion.getESTP_ID());
            
            resultado = new MensajesAjaxAY();
            resultado.setID(String.valueOf(id));
            resultado.setMENSAJE(String.format("%s Liquidacion por valor de $%s agregado con exito",
                    "CARTERA".equals(estado) ? "Abono a la":"Pago de",formato.format(pago.getPALI_VALOR())));
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
    
    public static PagoLiquidacionAC CargarPagoPorID(long PALI_ID){
        PagoLiquidacionAC liquidacion = null;
        Connection c =null;
        try {
            liquidacion = new PagoLiquidacionAC();
            String sql = "SELECT ACADEMICO.PAGOLIQUIDACION.*,ACADEMICO.TIPOPAGOLIQUIDACION.TIPL_DESCRIPCION FROM ACADEMICO.PAGOLIQUIDACION INNER JOIN ACADEMICO.TIPOPAGOLIQUIDACION ON ACADEMICO.PAGOLIQUIDACION.TIPL_ID=ACADEMICO.TIPOPAGOLIQUIDACION.TIPL_ID WHERE ACADEMICO.PAGOLIQUIDACION.PALI_ID='" + String.valueOf(PALI_ID) + "'";
            c = ConexionAcademicoDB.AbrirConexion();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
              liquidacion = MapeoLiquidacion(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConexionAcademicoDB.CerrarConexion(c);
            return liquidacion;
        }      
    }
    
    public static List<PagoLiquidacionAC> ListarPagosPorLiquidacion(long LIQU_ID){
        List<PagoLiquidacionAC> liquidaciones = null;
        Connection c =null;
        try {
            liquidaciones = new ArrayList<PagoLiquidacionAC>();
            String sql = "SELECT ACADEMICO.PAGOLIQUIDACION.*,ACADEMICO.TIPOPAGOLIQUIDACION.TIPL_DESCRIPCION FROM ACADEMICO.PAGOLIQUIDACION INNER JOIN ACADEMICO.TIPOPAGOLIQUIDACION ON ACADEMICO.PAGOLIQUIDACION.TIPL_ID=ACADEMICO.TIPOPAGOLIQUIDACION.TIPL_ID WHERE ACADEMICO.PAGOLIQUIDACION.LIQU_ID='" + String.valueOf(LIQU_ID) + "'";
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
        Numero_a_Letra NumLetra = new Numero_a_Letra();
        PagoLiquidacionAC periodo = new PagoLiquidacionAC();
        periodo.setLIQU_ID(rs.getLong("LIQU_ID"));
        periodo.setPALI_ESTADO(rs.getString("PALI_ESTADO"));
        periodo.setPALI_ID(rs.getLong("PALI_ID"));
        periodo.setPALI_FECHA(rs.getDate("PALI_FECHA"));
        periodo.setPALI_VALOR(rs.getLong("PALI_VALOR"));
        periodo.setPALI_REGISTRADOPOR(rs.getString("PALI_REGISTRADOPOR"));
        periodo.setPALI_FECHACAMBIO(rs.getDate("PALI_FECHACAMBIO"));
        periodo.setTIPL_ID(rs.getLong("TIPL_ID"));
        periodo.setPALI_OBSERVACIONES(rs.getString("PALI_OBSERVACIONES"));
        periodo.setTIPL_DESCRIPCION(rs.getString("TIPL_DESCRIPCION"));
        periodo.setPALI_VALORLETRA(NumLetra.Convertir(String.valueOf(periodo.getPALI_VALOR()),true));
        return periodo;
    }
    
}
