package escolme.vortal.modelo.negocio;

import escolme.modelo.ayudas.MensajesAjaxAY;
import escolme.vortal.modelo.entidades.ConfiguracionRangosVencimientoVO;
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
 * @author Jose Luis Orozco Mejia
 */
public class ConfiguracionRangosVencimientoBO {

    public static List<ConfiguracionRangosVencimientoVO> ListarConfiguracionRangosVencimientoActivos(){
        List<ConfiguracionRangosVencimientoVO> listaTipodocumento = null; ConfiguracionRangosVencimientoVO tipodocumento;
        Connection c =null;
        try{
            listaTipodocumento = new ArrayList<>();
            String sql = "SELECT conranven_id,conranven_dias,conranven_estado FROM campusadmin.configuracion_rangosvencimiento WHERE conranven_estado=1 ORDER BY conranven_dias";
            c = ConexionDB.AbrirConexion();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                listaTipodocumento.add(MapeoRangosVencimiento(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConfiguracionTipoDocumentosBO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConexionDB.CerrarConexion(c);
            return listaTipodocumento;
        }
    }
    
    public static List<ConfiguracionRangosVencimientoVO> ListarConfiguracionRangosVencimiento(){
        List<ConfiguracionRangosVencimientoVO> listaRangosVencimiento = null; 
        Connection c =null;
        try{
            listaRangosVencimiento = new ArrayList<>();
            String sql = "SELECT conranven_id,conranven_dias,conranven_estado FROM campusadmin.configuracion_rangosvencimiento ORDER BY conranven_dias";
            c = ConexionDB.AbrirConexion();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                listaRangosVencimiento.add(MapeoRangosVencimiento(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConfiguracionTipoDocumentosBO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConexionDB.CerrarConexion(c);
            return listaRangosVencimiento;
        }
    }
    
    public static ConfiguracionRangosVencimientoVO MapeoRangosVencimiento(ResultSet rs) throws SQLException{
        ConfiguracionRangosVencimientoVO rangoVencimiento = new ConfiguracionRangosVencimientoVO();
        rangoVencimiento.setConranven_id(rs.getLong("conranven_id"));
        rangoVencimiento.setConranven_dias(rs.getInt("conranven_dias"));
        rangoVencimiento.setConranven_estado(rs.getInt("conranven_estado"));
        rangoVencimiento.setConranven_diastexto(String.valueOf(rs.getInt("conranven_dias")) + " Dias");
        return rangoVencimiento;
    }
    
    public static MensajesAjaxAY GuardarConfiguracionRangosVencimiento(ConfiguracionRangosVencimientoVO rangoVencimiento){
        MensajesAjaxAY resultado = null;
        Connection c =null; String sql;PreparedStatement ps;
        try {
            c = ConexionDB.AbrirConexion();
            if(rangoVencimiento.getConranven_id() == 0){
                rangoVencimiento.setConranven_id(GenerarNuevoId());
                sql = "INSERT INTO campusadmin.configuracion_rangosvencimiento(conranven_id,conranven_dias,conranven_estado) " + 
                            " VALUES(?,?,?)";
                ps = c.prepareStatement(sql);
                ps.setLong(1, rangoVencimiento.getConranven_id());
                ps.setInt(2, rangoVencimiento.getConranven_dias());
                ps.setInt(3, rangoVencimiento.getConranven_estado());
            }else{
                sql = "UPDATE campusadmin.configuracion_rangosvencimiento SET conranven_dias=" + rangoVencimiento.getConranven_dias() + ",conranven_estado=" + String.valueOf(rangoVencimiento.getConranven_estado()) + 
                        " WHERE conranven_id=" + String.valueOf(rangoVencimiento.getConranven_id());
                ps = c.prepareStatement(sql);
            }

            ps.executeUpdate();
            resultado = new MensajesAjaxAY();
            resultado.setID(String.valueOf(rangoVencimiento.getConranven_id()));
            resultado.setMENSAJE("Rango de Vencimiento guardado con exito");
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
           String sql = "SELECT max(conranven_id) AS nuevoid FROM campusadmin.configuracion_rangosvencimiento";
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
