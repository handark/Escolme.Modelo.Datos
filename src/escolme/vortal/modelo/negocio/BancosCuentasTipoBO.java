package escolme.vortal.modelo.negocio;

import escolme.vortal.modelo.entidades.BancosCuentasTipoVO;
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
public class BancosCuentasTipoBO {

    public static List<BancosCuentasTipoVO> ListarCuentasBancosTipo(){
        List<BancosCuentasTipoVO> listaCentrosCosto = null; 
        Connection c =null;
        BancosCuentasTipoVO.Definiciones def = new BancosCuentasTipoVO.Definiciones();
        try{
            listaCentrosCosto = new ArrayList<>();
            String sql =  String.format("SELECT %s FROM %s",def.getCampos(),def.tabla);
            c = ConexionDB.AbrirConexion();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                listaCentrosCosto.add(MapeoBancoCuentasTipo(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BancosCuentasTipoBO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConexionDB.CerrarConexion(c);
            return listaCentrosCosto;
        }
    }
    
    public static BancosCuentasTipoVO MapeoBancoCuentasTipo(ResultSet rs) throws SQLException{
        BancosCuentasTipoVO tipo = new BancosCuentasTipoVO();
        tipo.setBancuetip_id(rs.getLong("bancuetip_id"));
        tipo.setBancuetip_nombre(rs.getString("bancuetip_nombre"));
        return tipo;
    }       
    
}
