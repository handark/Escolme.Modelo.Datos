package escolme.vortal.modelo.negocio;

import escolme.modelo.ayudas.MensajesAjaxAY;
import escolme.vortal.modelo.entidades.FacturasDetalleVO;
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
public class FacturasDetalleBO {
    
    public static int GuardarFacturaDetalle(List<FacturasDetalleVO> facturasDetalle, FacturasVO factura ){
        Connection c =null; String sql;PreparedStatement ps;int resultado = 1;
        try {
            c = ConexionDB.AbrirConexion();

            for(FacturasDetalleVO detalle : facturasDetalle)
            {
                detalle.setFacdet_id(GenerarNuevoId());
                sql = "INSERT INTO campusadmin.facturas_detalle(facdet_id,fac_id,fac_secuencia,conconpag_id,descripcion,cantidad,valor,descuento,total) " + 
                            " VALUES(?,?,?,?,?,?,?,?,?)";
                ps = c.prepareStatement(sql);
                ps.setLong(1, detalle.getFacdet_id());
                ps.setLong(2, factura.getFac_id());
                ps.setLong(3, factura.getFac_secuencia());
                ps.setLong(4, detalle.getConconpag_id());
                ps.setString(5, detalle.getDescripcion());
                ps.setInt(6, detalle.getCantidad());
                ps.setLong(7, detalle.getValor());
                ps.setLong(8, detalle.getDescuento());
                ps.setLong(9, detalle.getTotal());
                ps.executeUpdate();
            }
            resultado = 1;
        }
        catch(SQLException ex){
            resultado = 0;
        }
        finally{
            ConexionDB.CerrarConexion(c);
            return resultado;
        }
    }
    
    public static List<FacturasDetalleVO> ListarFacturaDetalles(long fac_id){
        List<FacturasDetalleVO> listaFormasPago = null;
        Connection c =null;
        try{
            listaFormasPago = new ArrayList<>();
            String sql = "SELECT a.*,b.conconpag_nombre "+
                    "FROM campusadmin.facturas_detalle a INNER JOIN campusadmin.configuracion_conceptosapago b ON a.conconpag_id=b.conconpag_id WHERE fac_id=" + String.valueOf(fac_id);
            c = ConexionDB.AbrirConexion();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                listaFormasPago.add(MapeoFacturaDetalles(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConfiguracionTipoDocumentosBO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConexionDB.CerrarConexion(c);
            return listaFormasPago;
        }
    }        
    
    public static long GenerarNuevoId(){
        Connection c =null;
        long resultado = 1;
        try{
           String sql = "SELECT max(facdet_id) AS nuevoid FROM campusadmin.facturas_detalle";
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

    private static FacturasDetalleVO MapeoFacturaDetalles(ResultSet rs) throws SQLException {
        FacturasDetalleVO factura = new FacturasDetalleVO();
        factura.setFacdet_id(rs.getLong("facdet_id"));
        factura.setFac_id(rs.getLong("fac_id"));
        factura.setFac_secuencia(rs.getLong("fac_secuencia"));
        factura.setConconpag_id(rs.getLong("conconpag_id"));
        factura.setConconpag_nombre(rs.getString("conconpag_nombre"));
        factura.setDescripcion(rs.getString("descripcion"));
        factura.setCantidad(rs.getInt("cantidad"));
        factura.setValor(rs.getLong("valor"));       
        factura.setDescuento(rs.getLong("descuento"));
        factura.setTotal(rs.getLong("total"));

        return factura;
    }
    
}
