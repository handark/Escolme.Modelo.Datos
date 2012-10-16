package escolme.vortal.modelo.negocio;

import escolme.modelo.ayudas.MensajesAjaxAY;
import escolme.vortal.modelo.entidades.ConfiguracionConceptosPagoVO;
import escolme.vortal.modelo.entidades.ConfiguracionTipoDocumentosVO;
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
 * @author jose
 */
public class ConfiguracionConceptosPagoBO {

    public static List<ConfiguracionConceptosPagoVO> ListarConfiguracionConceptosPagoActivos(){
        List<ConfiguracionConceptosPagoVO> listaConceptospago = null; ConfiguracionConceptosPagoVO conceptopago;
        Connection c =null;
        try{
            listaConceptospago = new ArrayList<>();
            String sql = "SELECT a.conconpag_id,a.contipdoc_id,a.conconpag_nombre,a.conconpag_estado " +
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
            String sql = "SELECT a.conconpag_id,a.contipdoc_id,a.conconpag_nombre,a.conconpag_estado " +
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
                sql = "INSERT INTO campusadmin.configuracion_conceptosapago(conconpag_id,contipdoc_id,conconpag_nombre,conconpag_estado) " + 
                            " VALUES(?,?,?,?)";
                ps = c.prepareStatement(sql);
                ps.setLong(1, conceptopago.getConconpag_id());
                ps.setLong(2, conceptopago.getContipdoc_id());
                ps.setString(3, conceptopago.getConconpag_nombre());
                ps.setInt(4, conceptopago.getConconpag_estado());
            }else{
                sql = "UPDATE campusadmin.configuracion_conceptosapago SET conconpag_nombre='" + conceptopago.getConconpag_nombre() + "',conconpag_estado=" + String.valueOf(conceptopago.getConconpag_estado()) + 
                        ",contipdoc_id=" + String.valueOf(conceptopago.getContipdoc_id()) + " WHERE conconpag_id=" + String.valueOf(conceptopago.getConconpag_id());
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
        conceptoPago.setConconpag_id(rs.getLong("contipdoc_id"));
        conceptoPago.setContipdoc_id(rs.getLong("contipdoc_id"));
        conceptoPago.setConconpag_nombre(rs.getString("conconpag_nombre"));
        conceptoPago.setConconpag_estado(rs.getInt("contipdoc_estado"));
        return conceptoPago;
    }
    
}
