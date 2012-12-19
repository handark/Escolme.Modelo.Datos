package escolme.academico.modelo.negocio;

import escolme.academico.modelo.entidades.LiquidacionAC;
import escolme.academico.modelo.entidades.LiquidacionAdjuntoAC;
import escolme.modelo.ayudas.MensajesAjaxAY;
import escolme.vortal.modelo.negocio.ConexionDB;
import escolme.vortal.modelo.negocio.UsuarioBO;
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
public class LiquidacionAdjuntoBO {
 
    public static List<LiquidacionAdjuntoAC> ListarAdjuntosPorIdentificacion(String PEGE_DOCUMENTOIDENTIDAD){
        Connection c =null;LiquidacionAdjuntoAC adjunto;
        List<LiquidacionAdjuntoAC> adjuntos = new ArrayList<>();
        try {

            String sql = "SELECT * FROM ACADEMICO.LIQUIDACIONADJUNTO WHERE PEGE_DOCUMENTOIDENTIDAD='" + PEGE_DOCUMENTOIDENTIDAD + "'";
            c = ConexionAcademicoDB.AbrirConexion();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                adjunto = new LiquidacionAdjuntoAC();
                adjunto.setLIAD_ARCHIVO(rs.getString("LIAD_ARCHIVO"));
                adjunto.setLIAD_FECHA(rs.getDate("LIAD_FECHA"));
                adjunto.setLIAD_ID(rs.getLong("LIAD_ID"));
                adjuntos.add(adjunto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConexionDB.CerrarConexion(c);
            return adjuntos;
        }       
    }    
    
     public static MensajesAjaxAY GuardarAdjuntoLiquidacion(LiquidacionAdjuntoAC adjunto){
        MensajesAjaxAY resultado = null;
        Connection c =null;
        try {
            long id = ComunBO.GenerarLongID("LIQUIDACIONADJUNTO", "LIAD_ID");
            String sql = "INSERT INTO LIQUIDACIONADJUNTO(LIAD_ID,LIAD_ARCHIVO,LIAD_FECHA,PEGE_ID,PEGE_DOCUMENTOIDENTIDAD) " + 
                            " VALUES(?,?,?,?,?)";
            c = ConexionAcademicoDB.AbrirConexion();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setLong(1, id);
            ps.setString(2, adjunto.getLIAD_ARCHIVO());
            ps.setDate(3, adjunto.getLIAD_FECHA());
            ps.setLong(4, adjunto.getPEGE_ID());
            ps.setString(5, adjunto.getPEGE_DOCUMENTOIDENTIDAD());
            
            ResultSet rs = ps.executeQuery();
            resultado = new MensajesAjaxAY();
            resultado.setID(String.valueOf(adjunto.getLIAD_ID()));
            resultado.setMENSAJE("Adjunto guardado con exito");
        }
        catch(SQLException ex){
            resultado = new MensajesAjaxAY();
            resultado.setID("0");
            resultado.setMENSAJE("Error: " + ex.getMessage());
        }
        finally{
            ConexionAcademicoDB.CerrarConexion(c);
            return resultado;
        }
    }  
     
}
