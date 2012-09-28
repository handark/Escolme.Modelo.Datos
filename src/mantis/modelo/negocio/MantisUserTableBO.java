package mantis.modelo.negocio;

import escolme.academico.modelo.entidades.EstudiantePensumAC;
import escolme.academico.modelo.negocio.ConexionAcademicoDB;
import escolme.academico.modelo.negocio.EstudiantePensumBO;
import escolme.modelo.ayudas.MensajesAjaxAY;
import escolme.vortal.modelo.negocio.UsuarioBO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mantis.modelo.datos.MantisUserTableAC;

/**
 *
 * @author Jose Luis Orozco Mejia
 */
public class MantisUserTableBO {
   
//    public static String GenerarCookie(){
//        
//    }
    
    public static boolean VerificarUsername(String username){
        boolean existe = false;
        Connection c =null;
        try {
            String sql = "SELECT username FROM mantis_user_table WHERE username='" + username + "'";
            c = ConexionMantisDB.AbrirConexion();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
              existe = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MantisUserTableBO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConexionMantisDB.CerrarConexion(c);
            return existe;
        }
    }
    
    public static List<MantisUserTableAC> ListarEstuduantesActivosSinImportar(){
        List<MantisUserTableAC> estudiantes_sin_importar = new ArrayList<>();
        List<EstudiantePensumAC> estudiantes =  EstudiantePensumBO.ListarEstuduantesActivos();
        MantisUserTableAC usuario = null;
        Calendar calendario = Calendar.getInstance();
        Date fecha = new Date(calendario.getTimeInMillis());
        String fecha_s = String.valueOf(fecha.getDate());
        for(EstudiantePensumAC estudiante :estudiantes){
            if(!VerificarUsername(estudiante.getPEGE_DOCUMENTOIDENTIDAD())){
                usuario = new MantisUserTableAC();
                usuario.setAccess_level(25);
                fecha_s = String.valueOf(fecha.getDate());
                usuario.setCookie_string("academusoft" + fecha_s + estudiante.getPEGE_DOCUMENTOIDENTIDAD() + fecha_s);
                usuario.setDate_created(1347034111);
                usuario.setEmail(estudiante.getPEGE_MAIL());
                usuario.setEnabled(1);
                usuario.setFailed_login_count(0);
                usuario.setLast_visit(1347034757);
                usuario.setLogin_count(1);
                usuario.setLost_password_request_count(0);
                usuario.setPassword("e10adc3949ba59abbe56e057f20f883e");
                usuario.setProtected_(0);
                usuario.setRealname(estudiante.getPENG_PRIMERNOMBRE() + " " + estudiante.getPENG_PRIMERAPELLIDO() + " " + estudiante.getPENG_SEGUNDOAPELLIDO());
                usuario.setUsername(estudiante.getPEGE_DOCUMENTOIDENTIDAD());
                estudiantes_sin_importar.add(usuario);
            }
        }
        return estudiantes_sin_importar;
    }
    
    public static MensajesAjaxAY ImportarUsuariosAcademusoftMantis(){
        MensajesAjaxAY resultado = null;
        MantisUserTableAC usuario = null;
        try
        {
            Calendar calendario = Calendar.getInstance();
            Date fecha = new Date(calendario.getTimeInMillis());
            String fecha_s = String.valueOf(fecha.getDate());
            List<EstudiantePensumAC> estudiantes =  EstudiantePensumBO.ListarEstuduantesActivos();
            for(EstudiantePensumAC estudiante :estudiantes){
                if(!VerificarUsername(estudiante.getPEGE_DOCUMENTOIDENTIDAD())){
                   usuario = new MantisUserTableAC();
                   usuario.setAccess_level(25);
                   fecha_s = String.valueOf(fecha.getDate());
                   usuario.setCookie_string("academusoft" + fecha_s + estudiante.getPEGE_DOCUMENTOIDENTIDAD() + fecha_s);
                   usuario.setDate_created(1347034111);
                   usuario.setEmail(estudiante.getPEGE_MAIL());
                   usuario.setEnabled(1);
                   usuario.setFailed_login_count(0);
                   usuario.setLast_visit(1347034757);
                   usuario.setLogin_count(1);
                   usuario.setLost_password_request_count(0);
                   usuario.setPassword("e10adc3949ba59abbe56e057f20f883e");
                   usuario.setProtected_(0);
                   usuario.setRealname(estudiante.getPENG_PRIMERNOMBRE() + " " + estudiante.getPENG_PRIMERAPELLIDO() + " " + estudiante.getPENG_SEGUNDOAPELLIDO());
                   usuario.setUsername(estudiante.getPEGE_DOCUMENTOIDENTIDAD());
                   GuardarUsuario(usuario);
                }
            }

            resultado = new MensajesAjaxAY();
            resultado.setID("1");
            resultado.setMENSAJE("Abono generado con exito");        

            return resultado;
        }
        catch(Exception ex){
            resultado = new MensajesAjaxAY();
            resultado.setID("0");
            resultado.setMENSAJE("Error: " + ex.getMessage());  
            return resultado;
        }
    } 
    
    public static MensajesAjaxAY GuardarUsuario(MantisUserTableAC usuario){
        Connection c =null;
        MensajesAjaxAY resultado = null;
        try {
            String sql = "INSERT INTO mantis_user_table(username,realname,email,password,enabled,protected,access_level,login_count,lost_password_request_count,failed_login_count,cookie_string,last_visit,date_created) " + 
                            " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            c = ConexionMantisDB.AbrirConexion();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, usuario.getUsername());
            ps.setString(2, usuario.getRealname());
            ps.setString(3, usuario.getEmail());
            ps.setString(4, usuario.getPassword());
            ps.setInt(5, usuario.getEnabled());
            ps.setInt(6, usuario.getProtected_());
            ps.setInt(7, usuario.getAccess_level());
            ps.setInt(8, usuario.getLogin_count());
            ps.setInt(9, usuario.getLost_password_request_count());
            ps.setInt(10, usuario.getFailed_login_count());
            ps.setString(11, usuario.getCookie_string());
            ps.setInt(12, usuario.getLast_visit());
            ps.setInt(13, usuario.getDate_created());
            
            int execute = ps.executeUpdate();
            
            resultado = new MensajesAjaxAY();
            resultado.setID("1");
            resultado.setMENSAJE("Esdudiante " + usuario.getRealname() + " importado con Exito");      

        }
        catch(SQLException ex){
            resultado = new MensajesAjaxAY();
            resultado.setID("0");
            resultado.setMENSAJE("Error:" + ex.getMessage());      
        }
        finally{
            ConexionMantisDB.CerrarConexion(c);
            return resultado;
        }
    }
    
}
