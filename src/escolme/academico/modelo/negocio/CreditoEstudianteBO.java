package escolme.academico.modelo.negocio;

import escolme.academico.modelo.entidades.CreditoEstudianteAC;
import escolme.academico.modelo.entidades.PagoLiquidacionAC;
import escolme.academico.modelo.entidades.PersonaNaturalGeneralAC;
import escolme.vortal.modelo.negocio.UsuarioBO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Jose Luis Orozco Mejia
 * @since 21-06-2012
 */
public class CreditoEstudianteBO {

    public static CreditoEstudianteAC CargarCreditoPorLiquidacion(long LIQU_ID){
        CreditoEstudianteAC credito = null;
        Connection c =null;
        try{
            credito = new CreditoEstudianteAC();
            String sql = "SELECT * FROM CREDITOESTUDIANTE WHERE LIQU_ID='" + LIQU_ID + "'";
            c = ConexionAcademicoDB.AbrirConexion();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                credito = MapeoCredito(rs);
            }        
        }
        catch (SQLException ex) {
            Logger.getLogger(UsuarioBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
             ConexionAcademicoDB.CerrarConexion(c);
            return credito;
        }
    }
    
    public static CreditoEstudianteAC CargarCreditoPorId(long CRES_ID){
        CreditoEstudianteAC credito = null;
        Connection c =null;
        try{
            credito = new CreditoEstudianteAC();
            String sql = "SELECT * FROM CREDITOESTUDIANTE WHERE CRES_ID='" + CRES_ID + "'";
            c = ConexionAcademicoDB.AbrirConexion();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                credito = MapeoCredito(rs);
            }        
        }
        catch (SQLException ex) {
            Logger.getLogger(UsuarioBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
             ConexionAcademicoDB.CerrarConexion(c);
            return credito;
        }
    }
    
    public static CreditoEstudianteAC MapeoCredito(ResultSet rs) throws SQLException{
        CreditoEstudianteAC credito = new CreditoEstudianteAC();
        credito.setCRES_ID(rs.getLong("CRES_ID"));
        credito.setESTP_ID(rs.getLong("ESTP_ID"));
        credito.setLIQU_ID(rs.getLong("LIQU_ID"));
        credito.setPEGE_ID(rs.getLong("PEGE_ID"));
        credito.setCRES_FECHASOLICITUD(rs.getDate("CRES_FECHASOLICITUD"));
        credito.setCRES_FECHAAPROBACION(rs.getDate("CRES_FECHAAPROBACION"));
        credito.setCRES_VALORSOLICITADO(rs.getFloat("CRES_VALORSOLICITADO"));
        credito.setCRES_VALORAPROBADO(rs.getFloat("CRES_VALORAPROBADO"));
        credito.setESCR_ID(rs.getLong("ESCR_ID"));
        credito.setPALI_ID(rs.getLong("PALI_ID"));
        return credito;
    }
    
}
