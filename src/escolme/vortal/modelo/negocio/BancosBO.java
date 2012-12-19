package escolme.vortal.modelo.negocio;

import escolme.modelo.ayudas.MensajesAjaxAY;
import escolme.vortal.modelo.entidades.BancosVO;
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
public class BancosBO {
    
    public static MensajesAjaxAY GuardarBancos(BancosVO banco){
        MensajesAjaxAY resultado = null;
        Connection c =null; String sql;PreparedStatement ps;
        try {
            c = ConexionDB.AbrirConexion();
            if(banco.getBan_id()== 0){
                banco.setBan_id(GenerarNuevoId());
                sql = "INSERT INTO campusadmin.bancos(ban_id,ban_nombre,ban_estado) " + 
                            " VALUES(?,?,?)";
                ps = c.prepareStatement(sql);
                ps.setLong(1, banco.getBan_id());
                ps.setString(2, banco.getBan_nombre());
                ps.setInt(3, banco.getBan_estado());
            }else{
                sql = "UPDATE campusadmin.bancos SET ban_nombre='" + banco.getBan_nombre()+ "',ban_estado=" + String.valueOf(banco.getBan_estado()) + 
                        " WHERE ban_id=" + String.valueOf(banco.getBan_id());
                ps = c.prepareStatement(sql);
            }

            ps.executeUpdate();
            resultado = new MensajesAjaxAY();
            resultado.setID(String.valueOf(banco.getBan_id()));
            resultado.setMENSAJE("Banco guardado con exito");
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
  
    public static List<BancosVO> ListarBancos(){
        List<BancosVO> listaBancos = null; 
        Connection c =null;
        try{
            listaBancos = new ArrayList<>();
            String sql = "SELECT * FROM campusadmin.bancos ORDER BY ban_nombre";
            c = ConexionDB.AbrirConexion();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                listaBancos.add(MapeoBancos(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BancosBO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConexionDB.CerrarConexion(c);
            return listaBancos;
        }
    }
    
    public static BancosVO MapeoBancos(ResultSet rs) throws SQLException{
        BancosVO banco = new BancosVO();
        banco.setBan_id(rs.getLong("ban_id"));
        banco.setBan_nombre(rs.getString("ban_nombre"));
        banco.setBan_estado(rs.getInt("ban_estado"));
        banco.setBacoCuentas(BancosCuentasBO.ListarCuentasPorBanco(banco.getBan_id()));
        return banco;
    }    
    
    public static long GenerarNuevoId(){
        Connection c =null;
        long resultado = 1;
        try{
           String sql = "SELECT max(ban_id) AS nuevoid FROM campusadmin.bancos";
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
