package escolme.vortal.modelo.negocio;

import escolme.modelo.ayudas.MensajesAjaxAY;
import escolme.vortal.modelo.entidades.BancosCuentasVO;
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
 * @author Jose Luis Orozco Mejia - http://handark.com
 */
public class BancosCuentasBO {

    public static MensajesAjaxAY Guardar(BancosCuentasVO cuenta){
        MensajesAjaxAY resultado = null;
        BancosCuentasVO.Definiciones def = new BancosCuentasVO.Definiciones();
        Connection c =null; String sql;PreparedStatement ps;
        try {
            c = ConexionDB.AbrirConexion();
            if(cuenta.getBancue_id()== 0){
                cuenta.setBancue_id(ConexionDB.GenerarNuevoId(def.esquema, def.tabla,def.campoBancue_id));
                sql = String.format("INSERT INTO %s(%s) VALUES(?,?,?,?)", def.getTabla(),def.getCampos());
                ps = c.prepareStatement(sql);
                ps.setLong(1, cuenta.getBancue_id());
                ps.setString(2, cuenta.getBancue_numero());
                ps.setLong(3, cuenta.getBancuetip_id());
                ps.setLong(4, cuenta.getBan_id());
            }else{
                sql = String.format("UPDATE %s SET %s='%s',%s='%s' WHERE %s=%s",def.getTabla(),def.campoBancue_numero,
                        cuenta.getBancue_numero(),def.campoBancuetip_id,String.valueOf(cuenta.getBancuetip_id()),
                        def.campoBancue_id,String.valueOf(cuenta.getBancue_id()));
                ps = c.prepareStatement(sql);
            }

            ps.executeUpdate();
            resultado = new MensajesAjaxAY();
            resultado.setID(String.valueOf(cuenta.getBancue_id()));
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
    
    public static List<BancosCuentasVO> ListarCuentasPorBanco(long ban_id){
        List<BancosCuentasVO> listaCentrosCosto = null; 
        Connection c =null;
        BancosCuentasVO.Definiciones def = new BancosCuentasVO.Definiciones();
        try{
            listaCentrosCosto = new ArrayList<>();
            String sql =  String.format("SELECT a.*,b.bancuetip_nombre FROM %s a INNER JOIN %s.bancos_cuentas_tipo b ON a.bancuetip_id=b.bancuetip_id WHERE a.%s=%s",
                    def.getTabla(),def.esquema, def.campoBan_id,String.valueOf(ban_id) );
            c = ConexionDB.AbrirConexion();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                listaCentrosCosto.add(MapeoCentroCosto(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BancosCuentasBO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConexionDB.CerrarConexion(c);
            return listaCentrosCosto;
        }
    }
    
    public static BancosCuentasVO MapeoCentroCosto(ResultSet rs) throws SQLException{
        BancosCuentasVO cuenta = new BancosCuentasVO();
        cuenta.setBancue_id(rs.getLong("bancue_id"));
        cuenta.setBancue_numero(rs.getString("bancue_numero"));
        cuenta.setBancuetip_id(rs.getLong("bancuetip_id"));
        cuenta.setBan_id(rs.getLong("ban_id"));
        cuenta.setBancuetip_nombre(rs.getString("bancuetip_nombre"));
        return cuenta;
    }     
   
}
