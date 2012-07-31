package escolme.academico.modelo.negocio;

import escolme.academico.modelo.entidades.LiquidacionAdjuntoAC;
import escolme.modelo.ayudas.MensajesAjaxAY;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jose Luis Orozco Mejia
 */
public class LiquidacionAdjuntoBO {
    
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
