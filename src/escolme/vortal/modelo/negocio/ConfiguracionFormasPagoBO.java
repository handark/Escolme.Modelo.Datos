/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package escolme.vortal.modelo.negocio;

import escolme.modelo.ayudas.MensajesAjaxAY;
import escolme.vortal.modelo.entidades.ConfiguracionFormasPagoVO;
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
 * @author Jose
 */
public class ConfiguracionFormasPagoBO {

    public static List<ConfiguracionFormasPagoVO> ListarConfiguracionFormasPagoActivos(){
        List<ConfiguracionFormasPagoVO> listaFormasPago = null;
        Connection c =null;
        try{
            listaFormasPago = new ArrayList<>();
            String sql = "SELECT conforpag_id,conforpag_formapago,conforpag_estado FROM campusadmin.configuracion_formaspago WHERE conforpag_estado=1 ORDER BY conforpag_formapago";
            c = ConexionDB.AbrirConexion();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                listaFormasPago.add(MapeoFormasPago(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConfiguracionTipoDocumentosBO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConexionDB.CerrarConexion(c);
            return listaFormasPago;
        }
    }
    
    public static List<ConfiguracionFormasPagoVO> ListarConfiguracionFormasPago(){
        List<ConfiguracionFormasPagoVO> listaRangosVencimiento = null; 
        Connection c =null;
        try{
            listaRangosVencimiento = new ArrayList<>();
            String sql = "SELECT conforpag_id,conforpag_formapago,conforpag_estado FROM campusadmin.configuracion_formaspago ORDER BY conforpag_formapago";
            c = ConexionDB.AbrirConexion();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                listaRangosVencimiento.add(MapeoFormasPago(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConfiguracionTipoDocumentosBO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConexionDB.CerrarConexion(c);
            return listaRangosVencimiento;
        }
    }
    
    public static ConfiguracionFormasPagoVO MapeoFormasPago(ResultSet rs) throws SQLException{
        ConfiguracionFormasPagoVO rangoVencimiento = new ConfiguracionFormasPagoVO();
        rangoVencimiento.setConforpag_id(rs.getLong("conforpag_id"));
        rangoVencimiento.setConforpag_formapago(rs.getString("conforpag_formapago"));
        rangoVencimiento.setConforpag_estado(rs.getInt("conforpag_estado"));
        return rangoVencimiento;
    }
    
    public static MensajesAjaxAY GuardarConfiguracionFormasPago(ConfiguracionFormasPagoVO rangoVencimiento){
        MensajesAjaxAY resultado = null;
        Connection c =null; String sql;PreparedStatement ps;
        try {
            c = ConexionDB.AbrirConexion();
            if(rangoVencimiento.getConforpag_id() == 0){
                rangoVencimiento.setConforpag_id(GenerarNuevoId());
                sql = "INSERT INTO campusadmin.configuracion_formaspago(conforpag_id,conforpag_formapago,conforpag_estado) " + 
                            " VALUES(?,?,?)";
                ps = c.prepareStatement(sql);
                ps.setLong(1, rangoVencimiento.getConforpag_id());
                ps.setString(2, rangoVencimiento.getConforpag_formapago());
                ps.setInt(3, rangoVencimiento.getConforpag_estado());
            }else{
                sql = "UPDATE campusadmin.configuracion_formaspago SET conforpag_formapago='" + rangoVencimiento.getConforpag_formapago() + "',conforpag_estado=" + String.valueOf(rangoVencimiento.getConforpag_estado()) + 
                        " WHERE conforpag_id=" + String.valueOf(rangoVencimiento.getConforpag_id());
                ps = c.prepareStatement(sql);
            }

            ps.executeUpdate();
            resultado = new MensajesAjaxAY();
            resultado.setID(String.valueOf(rangoVencimiento.getConforpag_id()));
            resultado.setMENSAJE("Forma de Pago guardada con exito");
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
           String sql = "SELECT max(conforpag_id) AS nuevoid FROM campusadmin.configuracion_formaspago";
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
    
}
