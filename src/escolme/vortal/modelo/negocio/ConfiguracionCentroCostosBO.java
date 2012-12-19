package escolme.vortal.modelo.negocio;

import escolme.modelo.ayudas.MensajesAjaxAY;
import escolme.vortal.modelo.entidades.BancosVO;
import escolme.vortal.modelo.entidades.ConfiguracionCentroCostosVO;
import escolme.vortal.modelo.entidades.ConfiguracionCuentasContablesVO;
import escolme.vortal.modelo.entidades.ConfiguracionRangosVencimientoVO;
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
public class ConfiguracionCentroCostosBO {
    
    public static List<ConfiguracionCentroCostosVO> ListarConfiguracionCentrosCosto(){
        List<ConfiguracionCentroCostosVO> listaCentrosCosto = null; 
        Connection c =null;
        try{
            listaCentrosCosto = new ArrayList<>();
            String sql = "SELECT * FROM campusadmin.configuracion_centrocostos ORDER BY concencos_nombre";
            c = ConexionDB.AbrirConexion();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                listaCentrosCosto.add(MapeoCentroCosto(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConfiguracionCentroCostosBO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConexionDB.CerrarConexion(c);
            return listaCentrosCosto;
        }
    }

    public static MensajesAjaxAY Guardar(ConfiguracionCentroCostosVO cuenta){
        MensajesAjaxAY resultado = null;
        ConfiguracionCentroCostosVO.Definiciones def = new ConfiguracionCentroCostosVO.Definiciones();
        Connection c =null; String sql;PreparedStatement ps;
        try {
            c = ConexionDB.AbrirConexion();
            if(cuenta.getConcencos_id()== 0){
                cuenta.setConcencos_id(ConexionDB.GenerarNuevoId(def.esquema, def.tabla,def.campoConcencos_id));
                sql = String.format("INSERT INTO %s(%s) VALUES(?,?,?)", def.getTabla(),def.getCampos());
                ps = c.prepareStatement(sql);
                ps.setLong(1, cuenta.getConcencos_id());
                ps.setString(2, cuenta.getConcencos_nombre());
                ps.setInt(3, cuenta.getConcencos_estado());
            }else{
                sql = String.format("UPDATE %s SET %s='%s',%s='%s' WHERE %s=%s",def.getTabla(),def.campoConcencos_nombre,
                        cuenta.getConcencos_nombre(),def.campoConcencos_estado,
                        cuenta.getConcencos_estado(),def.campoConcencos_id,String.valueOf(cuenta.getConcencos_id()));
                ps = c.prepareStatement(sql);
            }

            ps.executeUpdate();
            resultado = new MensajesAjaxAY();
            resultado.setID(String.valueOf(cuenta.getConcencos_id()));
            resultado.setMENSAJE("Cuenta guardada con exito");
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
    
    public static ConfiguracionCentroCostosVO MapeoCentroCosto(ResultSet rs) throws SQLException{
        ConfiguracionCentroCostosVO centroCosto = new ConfiguracionCentroCostosVO();
        centroCosto.setConcencos_id(rs.getLong("concencos_id"));
        centroCosto.setConcencos_nombre(rs.getString("concencos_nombre"));
        centroCosto.setConcencos_estado(rs.getInt("concencos_estado"));
        return centroCosto;
    } 
}
