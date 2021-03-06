package escolme.vortal.modelo.negocio;

import escolme.vortal.modelo.entidades.UsuarioVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Jose Luis Orozco Mejia
 * @since 04-06-2012
 */
public class UsuarioBO {

    public static UsuarioVO CargarUsuarioPorCredenciales(String usua_usuario, String usua_contrasena){
        UsuarioVO usuario = null;
        Connection c =null;
        try {
            String sql = "select general.usuario.* from general.usuario " + 
                    "WHERE general.usuario.usua_usuario='"+usua_usuario+"' AND general.usuario.usua_contrasena='"+usua_contrasena+"' AND " +
                    "general.usuario.usua_id IN (SELECT ur.usua_id FROM vortal.usuariorol ur WHERE ur.rol_id=123 OR ur.rol_id=124 OR ur.rol_id=125 OR ur.rol_id=126 OR ur.rol_id=127 OR ur.rol_id=132 OR ur.rol_id=148) ";
            c = ConexionDB.AbrirConexion();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                usuario = MapeoUsuario(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConexionDB.CerrarConexion(c);
            return usuario;
        }
    }
    
    public static UsuarioVO MapeoUsuario(ResultSet rs) throws SQLException{
        UsuarioVO usuario = new UsuarioVO();
        usuario.setPege_id(rs.getLong("pege_id"));
        usuario.setUsua_contrasena(rs.getString("usua_contrasena"));
        usuario.setUsua_documento(rs.getString("usua_documento"));
        usuario.setUsua_estado(rs.getString("usua_estado"));
        usuario.setUsua_id(rs.getLong("usua_id"));
        usuario.setUsua_idvortal(rs.getLong("usua_idvortal"));
        usuario.setUsua_nombre(rs.getString("usua_nombre"));
        usuario.setUsua_usuario(rs.getString("usua_usuario"));
        return usuario;
    }
    
}
