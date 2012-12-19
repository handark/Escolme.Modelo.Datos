package escolme.vortal.modelo.negocio;

import escolme.modelo.ayudas.MensajesAjaxAY;
import escolme.vortal.modelo.entidades.ConfiguracionConceptosPagoVO;
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
 */
public class ConfiguracionConceptosPagoBO {

    public static ConfiguracionConceptosPagoVO CargarConceptoPagoPorId(long conconpag_id){
        ConfiguracionConceptosPagoVO conceptopago = null;
        Connection c =null;
        try{
            String sql = "SELECT a.conconpag_id,a.contipdoc_id,a.conconpag_nombre,a.conconpag_estado,a.conconpag_valor,a.conconpag_cuentacontable,b.contipdoc_nombre " +
                    "FROM campusadmin.configuracion_conceptosapago a INNER JOIN campusadmin.configuracion_tipodocumentos b " +
                    "ON a.contipdoc_id=b.contipdoc_id WHERE a.conconpag_estado=1 AND  a.conconpag_id=" + String.valueOf(conconpag_id);
            c = ConexionDB.AbrirConexion();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                conceptopago = MapeoConceptosPago(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConfiguracionConceptosPagoBO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConexionDB.CerrarConexion(c);
            return conceptopago;
        }
    }   
    
    public static List<ConfiguracionConceptosPagoVO> ListarConfiguracionConceptosPagoPorTipoDocumento(long contipdoc_id){
        List<ConfiguracionConceptosPagoVO> listaConceptospago = null; ConfiguracionConceptosPagoVO conceptopago;
        Connection c =null;
        try{
            listaConceptospago = new ArrayList<>();
            String sql = "SELECT a.conconpag_id,a.contipdoc_id,a.conconpag_nombre,a.conconpag_cuentacontable,a.conconpag_estado,a.conconpag_valor,b.contipdoc_nombre " +
                    "FROM campusadmin.configuracion_conceptosapago a INNER JOIN campusadmin.configuracion_tipodocumentos b " +
                    "ON a.contipdoc_id=b.contipdoc_id WHERE a.conconpag_estado=1 AND a.contipdoc_id=" + String.valueOf(contipdoc_id) + " ORDER BY a.conconpag_nombre";
            c = ConexionDB.AbrirConexion();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                listaConceptospago.add(MapeoConceptosPago(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConfiguracionConceptosPagoBO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConexionDB.CerrarConexion(c);
            return listaConceptospago;
        }
    }   
    
    public static List<ConfiguracionConceptosPagoVO> ListarConfiguracionConceptosPagoActivos(){
        List<ConfiguracionConceptosPagoVO> listaConceptospago = null; ConfiguracionConceptosPagoVO conceptopago;
        Connection c =null;
        try{
            listaConceptospago = new ArrayList<>();
            String sql = "SELECT a.conconpag_id,a.contipdoc_id,a.conconpag_nombre,a.conconpag_cuentacontable,a.conconpag_estado,a.conconpag_valor,b.contipdoc_nombre " +
                    "FROM campusadmin.configuracion_conceptosapago a INNER JOIN campusadmin.configuracion_tipodocumentos b " +
                    "ON a.contipdoc_id=b.contipdoc_id WHERE a.conconpag_estado=1 ORDER BY a.conconpag_nombre";
            c = ConexionDB.AbrirConexion();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                listaConceptospago.add(MapeoConceptosPago(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConfiguracionConceptosPagoBO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConexionDB.CerrarConexion(c);
            return listaConceptospago;
        }
    }    
    
    public static List<ConfiguracionConceptosPagoVO> ListarConfiguracionConceptosPago(){
        List<ConfiguracionConceptosPagoVO> listaConceptospago = null; ConfiguracionConceptosPagoVO conceptopago;
        Connection c =null;
        try{
            listaConceptospago = new ArrayList<>();
            String sql = "SELECT a.conconpag_id,a.contipdoc_id,a.conconpag_nombre,a.conconpag_cuentacontable,a.conconpag_estado,a.conconpag_valor,b.contipdoc_nombre " +
                    "FROM campusadmin.configuracion_conceptosapago a INNER JOIN campusadmin.configuracion_tipodocumentos b " +
                    "ON a.contipdoc_id=b.contipdoc_id ORDER BY a.conconpag_nombre";
            c = ConexionDB.AbrirConexion();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                listaConceptospago.add(MapeoConceptosPago(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConfiguracionConceptosPagoBO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConexionDB.CerrarConexion(c);
            return listaConceptospago;
        }
    }
    
    public static MensajesAjaxAY GuardarConfiguracionConceptosPago(ConfiguracionConceptosPagoVO conceptopago){
        MensajesAjaxAY resultado = null;
        Connection c =null; String sql;PreparedStatement ps;
        try {
            c = ConexionDB.AbrirConexion();
            if(conceptopago.getConconpag_id() == 0){
                conceptopago.setConconpag_id(GenerarNuevoId());
                sql = "INSERT INTO campusadmin.configuracion_conceptosapago(conconpag_id,contipdoc_id,conconpag_nombre,conconpag_estado,conconpag_valor,conconpag_cuentacontable) " + 
                            " VALUES(?,?,?,?,?,?)";
                ps = c.prepareStatement(sql);
                ps.setLong(1, conceptopago.getConconpag_id());
                ps.setLong(2, conceptopago.getContipdoc_id());
                ps.setString(3, conceptopago.getConconpag_nombre());
                ps.setInt(4, conceptopago.getConconpag_estado());
                ps.setLong(5, conceptopago.getConconpag_valor());
                ps.setString(6, conceptopago.getConconpag_cuentacontable());
            }else{
                sql = "UPDATE campusadmin.configuracion_conceptosapago SET conconpag_nombre='" + conceptopago.getConconpag_nombre() + "',conconpag_valor=" + conceptopago.getConconpag_valor()+ ",conconpag_estado=" + String.valueOf(conceptopago.getConconpag_estado()) + 
                        ",conconpag_cuentacontable=" + String.valueOf(conceptopago.getConconpag_cuentacontable()) + ",contipdoc_id=" + String.valueOf(conceptopago.getContipdoc_id()) + " WHERE conconpag_id=" + String.valueOf(conceptopago.getConconpag_id());
                ps = c.prepareStatement(sql);
            }

            ps.executeUpdate();
            resultado = new MensajesAjaxAY();
            resultado.setID(String.valueOf(conceptopago.getContipdoc_id()));
            resultado.setMENSAJE("Concepto de Pago guardado con exito");
        }
        catch(SQLException ex){
            resultado = new MensajesAjaxAY();
            resultado.setID("0");
            resultado.setMENSAJE("Error: " + ex.getMessage());
        }
        finally{
            ConexionDB.CerrarConexion(c);
            return resultado;
        }
    }
    
    public static long GenerarNuevoId(){
        Connection c =null;
        long resultado = 1;
        try{
           String sql = "SELECT max(conconpag_id) AS nuevoid FROM campusadmin.configuracion_conceptosapago";
           c = ConexionDB.AbrirConexion();
           PreparedStatement ps = c.prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           while(rs.next()){
               resultado = rs.getLong("nuevoid") + 1;
           }
        }
        catch(SQLException ex){
            resultado = 1;
        }
        finally{
            ConexionDB.CerrarConexion(c);
            return resultado;
        }
    }
    
    public static ConfiguracionConceptosPagoVO MapeoConceptosPago(ResultSet rs) throws SQLException{
        ConfiguracionConceptosPagoVO conceptoPago = new ConfiguracionConceptosPagoVO();
        conceptoPago.setConconpag_id(rs.getLong("conconpag_id"));
        conceptoPago.setContipdoc_id(rs.getLong("contipdoc_id"));
        conceptoPago.setConconpag_nombre(rs.getString("conconpag_nombre"));
        conceptoPago.setConconpag_estado(rs.getInt("conconpag_estado"));
        conceptoPago.setContipdoc_nombre(rs.getString("contipdoc_nombre"));
        conceptoPago.setConconpag_valor(rs.getLong("conconpag_valor"));
        conceptoPago.setConconpag_cuentacontable(rs.getString("conconpag_cuentacontable"));
        return conceptoPago;
    }
    
}
