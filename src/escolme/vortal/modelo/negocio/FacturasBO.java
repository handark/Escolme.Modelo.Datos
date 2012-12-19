package escolme.vortal.modelo.negocio;

import escolme.modelo.ayudas.MensajesAjaxAY;
import escolme.vortal.modelo.entidades.FacturasDetalleVO;
import escolme.vortal.modelo.entidades.FacturasTodoVO;
import escolme.vortal.modelo.entidades.FacturasVO;
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
 * @since 30-10-2012
 */
public class FacturasBO {

    public static FacturasVO GuardarFactura(FacturasTodoVO facturaTodo){
        FacturasVO factura = facturaTodo.getFactura();
        List<FacturasDetalleVO> facturasDetalle = facturaTodo.getDetalle();
        Connection c =null; String sql;PreparedStatement ps = null;
        try {
            c = ConexionDB.AbrirConexion();
            if(factura.getFac_id() == 0){
                factura.setFac_id(GenerarNuevoId("fac_id"));
                factura.setFac_secuencia(GenerarNuevaSecuencia(factura.getContipdoc_id()));
                if(factura.getFac_estado() == 2){
                    factura.setFac_saldo(0);
                }else{
                    factura.setFac_saldo(factura.getFac_total());
                }
                
                sql = "INSERT INTO campusadmin.facturas(fac_id,fac_secuencia,fac_tipopersona,fac_nombrepersona,fac_identificacionpersona,conranven_dias,fac_estado,fac_total,fac_fechafactura,contipdoc_id,fac_saldo,fac_documentoreferencia,contipdoc_referencia,concencos_id) " + 
                            " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                ps = c.prepareStatement(sql);
                ps.setLong(1, factura.getFac_id());
                ps.setLong(2, factura.getFac_secuencia());
                ps.setInt(3, factura.getFac_tipopersona());
                ps.setString(4, factura.getFac_nombrepersona());
                ps.setString(5, factura.getFac_identificacionpersona());
                ps.setInt(6, factura.getConranven_dias());
                ps.setInt(7, factura.getFac_estado());
                ps.setLong(8, factura.getFac_total());
                ps.setDate(9, factura.getFac_fechafactura());
                ps.setLong(10, factura.getContipdoc_id());
                ps.setLong(11, factura.getFac_saldo());
                ps.setLong(12, factura.getFac_documentoreferencia());
                ps.setLong(13, factura.getContipdoc_referencia());
                ps.setLong(14, factura.getConcencos_id());
            }
            ps.executeUpdate();
                        
            FacturasDetalleBO.GuardarFacturaDetalle(facturasDetalle,factura);

        }
        catch(SQLException ex){
            factura = null;
        }
        finally{
            ConexionDB.CerrarConexion(c);
            return CargarFacturaPorId(factura.getFac_id());
        }
    }    
    
    public static FacturasVO ActualizarSaldoFactura(FacturasVO factura){
        Connection c =null; String sql;PreparedStatement ps = null;
        try {
            c = ConexionDB.AbrirConexion();
            sql = "UPDATE campusadmin.facturas SET fac_saldo=" + factura.getFac_saldo() + ",fac_estado=" + factura.getFac_estado() + " WHERE fac_id=" + factura.getFac_id();
            ps = c.prepareStatement(sql);
            ps.executeUpdate();
        }
        catch(SQLException ex){
            factura = null;
        }
        finally{
            ConexionDB.CerrarConexion(c);
            return factura;
        }
    }    
        
    
    public static FacturasVO CargarFacturaPorId(long fac_id){
        FacturasVO factura = null;
        Connection c =null;
        try{
            String sql = "SELECT a.fac_id,a.fac_secuencia,a.fac_tipopersona,a.fac_nombrepersona,a.fac_identificacionpersona,a.conranven_dias,a.fac_estado,a.fac_total,a.fac_saldo,a.fac_fechafactura,a.contipdoc_id,a.fac_documentoreferencia,a.contipdoc_referencia,a.concencos_id,b.contipdoc_nombre,b.contipdoc_tipooperacion,c.concencos_nombre "+
                    "FROM (campusadmin.facturas a INNER JOIN campusadmin.configuracion_tipodocumentos b ON a.contipdoc_id=b.contipdoc_id) LEFT JOIN campusadmin.configuracion_centrocostos c ON a.concencos_id=c.concencos_id " +
                    "WHERE a.fac_id=" + String.valueOf(fac_id);
            c = ConexionDB.AbrirConexion();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                factura = MapeoFacturas(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConfiguracionTipoDocumentosBO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConexionDB.CerrarConexion(c);
            return factura;
        }
    }

    public static List<FacturasVO> ListarFacturasPorPersona(String identificacion){
        List<FacturasVO> listaFacturas = null;
        Connection c =null;
        try{
            listaFacturas = new ArrayList<>();
            String sql = "SELECT a.fac_id,a.fac_secuencia,a.fac_tipopersona,a.fac_nombrepersona,a.fac_identificacionpersona,a.conranven_dias,a.fac_estado,a.fac_total,a.fac_saldo,a.fac_fechafactura,a.contipdoc_id,a.fac_documentoreferencia,a.contipdoc_referencia,a.concencos_id,b.contipdoc_nombre,b.contipdoc_tipooperacion,c.concencos_nombre "+
                    "FROM (campusadmin.facturas a INNER JOIN campusadmin.configuracion_tipodocumentos b ON a.contipdoc_id=b.contipdoc_id) LEFT JOIN campusadmin.configuracion_centrocostos c ON a.concencos_id=c.concencos_id " +
                    "WHERE a.fac_identificacionpersona='" + identificacion + "' ORDER BY a.fac_secuencia DESC";
            c = ConexionDB.AbrirConexion();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                listaFacturas.add(MapeoFacturas(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConfiguracionTipoDocumentosBO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConexionDB.CerrarConexion(c);
            return listaFacturas;
        }
    }    
    
    public static List<FacturasVO> ListarFacturas(){
        List<FacturasVO> listaFacturas = null;
        Connection c =null;
        try{
            listaFacturas = new ArrayList<>();
            String sql = "SELECT a.fac_id,a.fac_secuencia,a.fac_tipopersona,a.fac_nombrepersona,a.fac_identificacionpersona,a.conranven_dias,a.fac_estado,a.fac_total,a.fac_saldo,a.fac_fechafactura,a.contipdoc_id,a.fac_documentoreferencia,a.contipdoc_referencia,a.concencos_id,b.contipdoc_nombre,b.contipdoc_tipooperacion,c.concencos_nombre "+
                    "FROM (campusadmin.facturas a INNER JOIN campusadmin.configuracion_tipodocumentos b ON a.contipdoc_id=b.contipdoc_id) " +
                    "LEFT JOIN campusadmin.configuracion_centrocostos c ON a.concencos_id=c.concencos_id ORDER BY a.fac_secuencia DESC";
            c = ConexionDB.AbrirConexion();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                listaFacturas.add(MapeoFacturas(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConfiguracionTipoDocumentosBO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConexionDB.CerrarConexion(c);
            return listaFacturas;
        }
    }    
    
    public static long GenerarNuevoId(String campo){
        Connection c =null;
        long resultado = 1;
        try{
           String sql = "SELECT max(" + campo + ") AS nuevoid FROM campusadmin.facturas";
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
    
    public static long GenerarNuevaSecuencia(long contipdoc_id){
        Connection c =null;
        long resultado = 1;
        try{
           String sql = "SELECT max(fac_secuencia) AS nuevoid FROM campusadmin.facturas WHERE contipdoc_id=" + String.valueOf(contipdoc_id);
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

    private static FacturasVO MapeoFacturas(ResultSet rs) throws SQLException{
        FacturasVO factura = new FacturasVO();
        factura.setFac_id(rs.getLong("fac_id"));
        factura.setFac_secuencia(rs.getLong("fac_secuencia"));
        factura.setFac_tipopersona(rs.getInt("fac_tipopersona"));
        
        switch(factura.getFac_tipopersona()){
            case 1:
                factura.setFac_tipopersonatexto("Estudiante");
                break;
            case 2:
                factura.setFac_tipopersonatexto("Docente");
                break;       
            case 3:
                factura.setFac_tipopersonatexto("Empleado");
                break;       
            case 4:
                factura.setFac_tipopersonatexto("General");
                break;       
        }
        
        factura.setFac_nombrepersona(rs.getString("fac_nombrepersona"));
        factura.setFac_identificacionpersona(rs.getString("fac_identificacionpersona"));
        factura.setConranven_dias(rs.getInt("conranven_dias"));
        factura.setFac_estado(rs.getInt("fac_estado"));
        
        switch(factura.getFac_estado()){
            case 1:
                factura.setFac_estadotexto("abierta");
                break;
            case 2:
                factura.setFac_estadotexto("cerrada");
                break;       
        }
        
        factura.setFac_total(rs.getLong("fac_total"));
        factura.setFac_saldo(rs.getLong("fac_saldo"));
        factura.setFac_fechafactura(rs.getDate("fac_fechafactura"));
        factura.setContipdoc_id(rs.getLong("contipdoc_id"));
        factura.setContipdoc_nombre(rs.getString("contipdoc_nombre"));
        factura.setFac_documentoreferencia(rs.getLong("fac_documentoreferencia"));
        factura.setContipdoc_referencia(rs.getLong("contipdoc_referencia"));
        factura.setContipdoc_tipooperacion(rs.getInt("contipdoc_tipooperacion"));
        factura.setContipdoc_referencia(rs.getLong("concencos_id"));
        factura.setConcencos_nombre(rs.getString("concencos_nombre"));
        //factura.setFacturaPagos(FacturasPagosBO.ListarPagosPorFactura(factura.getFac_id()));
        return factura;
    }
    
}
