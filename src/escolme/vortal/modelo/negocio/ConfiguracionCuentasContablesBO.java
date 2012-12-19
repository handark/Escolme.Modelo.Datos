package escolme.vortal.modelo.negocio;

import escolme.modelo.ayudas.MensajesAjaxAY;
import escolme.vortal.modelo.entidades.BancosVO;
import escolme.vortal.modelo.entidades.ConfiguracionCuentasContablesVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Jose Luis Orozco Mejia
 */
public class ConfiguracionCuentasContablesBO {

    public static MensajesAjaxAY Guardar(ConfiguracionCuentasContablesVO cuenta){
        MensajesAjaxAY resultado = null;
        ConfiguracionCuentasContablesVO.Definiciones def = new ConfiguracionCuentasContablesVO.Definiciones();
        Connection c =null; String sql;PreparedStatement ps;
        try {
            c = ConexionDB.AbrirConexion();
            if(cuenta.getConcuecon_id()== 0){
                cuenta.setConcuecon_id(ConexionDB.GenerarNuevoId(def.esquema, def.tabla,def.campoConcuecon_id));
                sql = String.format("INSERT INTO %s(%s) VALUES(?,?)", def.getTabla(),def.getCampos());
                ps = c.prepareStatement(sql);
                ps.setLong(1, cuenta.getConcuecon_id());
                ps.setString(2, cuenta.getConcuecon_nombre());
            }else{
                sql = String.format("UPDATE %s SET %s='%s' WHERE %s=%s",def.getTabla(),def.campoConcuecon_nombre,
                        cuenta.getConcuecon_nombre(),def.campoConcuecon_id,String.valueOf(cuenta.getConcuecon_id()));
                ps = c.prepareStatement(sql);
            }

            ps.executeUpdate();
            resultado = new MensajesAjaxAY();
            resultado.setID(String.valueOf(cuenta.getConcuecon_id()));
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
    
}
