package escolme.vortal.modelo.negocio;

import escolme.vortal.modelo.entidades.FacturasPagosVO;
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
 * Clase que contiene los metodos para interactuar con la tabla facturas_pagos
 * @author Jose Luis Orozco Mejia - http://handark.com
 */
public class FacturasPagosBO {
    
    /**
     * Guarda un nuevo pago de un Documento
     * @param Datos del Pago
     * @return Datos del Pago
     */
    public static FacturasVO Guardar(FacturasPagosVO pago){
        FacturasPagosVO.Definiciones def = new FacturasPagosVO.Definiciones();
        Connection c =null; String sql;PreparedStatement ps;FacturasVO factura = null;
        try {
            c = ConexionDB.AbrirConexion();
            pago.setFacpag_id(ConexionDB.GenerarNuevoId(def.esquema, def.tabla,def.campoFacpag_id));
            sql = String.format("INSERT INTO %s(%s) VALUES(?,?,?,?,?,?,?)", def.getTabla(),def.getCampos());
            ps = c.prepareStatement(sql);
            ps.setLong(1, pago.getFacpag_id());
            ps.setLong(2, pago.getFac_id());
            ps.setLong(3, pago.getFac_secuencia());
            ps.setDate(4, pago.getFacpag_fecha());
            ps.setLong(5, pago.getFacpag_valor());
            ps.setString(6, pago.getFacpag_observaciones());
            ps.setLong(7, pago.getConforpag_id());
            ps.executeUpdate();
            
            factura = FacturasBO.CargarFacturaPorId(pago.getFac_id());
            long nuevoSaldo = factura.getFac_saldo() - pago.getFacpag_valor();
            factura.setFac_saldo(nuevoSaldo);
            factura.setFac_estado(nuevoSaldo <= 0 ? 2:1);
            FacturasBO.ActualizarSaldoFactura(factura);
        }
        catch(SQLException ex){
            factura = null;
        }
        finally{
            ConexionDB.CerrarConexion(c);
            return factura;
        }
    }    
    
    public static List<FacturasPagosVO> ListarPagosPorFactura(long fac_id){
        List<FacturasPagosVO> listaPagos = null; 
        Connection c =null;
        FacturasPagosVO.Definiciones def = new FacturasPagosVO.Definiciones();
        try{
            listaPagos = new ArrayList<>();
            String sql =  String.format("SELECT a.*,b.conforpag_formapago FROM %s a INNER JOIN %s.configuracion_formaspago b ON a.conforpag_id=b.conforpag_id WHERE a.%s=%s",
                    def.getTabla(),def.esquema, def.campoFac_id,String.valueOf(fac_id) );
            c = ConexionDB.AbrirConexion();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                listaPagos.add(MapeoPago(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FacturasPagosBO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConexionDB.CerrarConexion(c);
            return listaPagos;
        }
    }
    
    public static FacturasPagosVO MapeoPago(ResultSet rs) throws SQLException{
        FacturasPagosVO pago = new FacturasPagosVO();
        pago.setFacpag_id(rs.getLong("facpag_id"));
        pago.setFac_id(rs.getLong("fac_id"));
        pago.setFac_secuencia(rs.getLong("fac_secuencia"));
        pago.setFacpag_fecha(rs.getDate("facpag_fecha"));
        pago.setFacpag_valor(rs.getLong("facpag_valor"));
        pago.setFacpag_observaciones(rs.getString("facpag_observaciones"));
        pago.setConforpag_id(rs.getLong("conforpag_id"));
        pago.setConforpag_formapago(rs.getString("conforpag_formapago"));
        return pago;
    }       
    
}
