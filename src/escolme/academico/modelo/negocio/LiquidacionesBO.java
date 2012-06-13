package escolme.academico.modelo.negocio;

import escolme.academico.modelo.entidades.LiquidacionAC;
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
 * @author Jose Luis Orozco Mejia
 * @since 08-06-2012
 */
public class LiquidacionesBO {

    //select ACADEMICO.PAGOLIQUIDACION.*,ACADEMICO.TIPOPAGOLIQUIDACION.*  FROM ACADEMICO.PAGOLIQUIDACION inner join ACADEMICO.TIPOPAGOLIQUIDACION ON ACADEMICO.PAGOLIQUIDACION.TIPL_ID=ACADEMICO.TIPOPAGOLIQUIDACION.TIPL_ID
    
    
    public static List<LiquidacionAC> ListarLiquidacionesPorPersona(int ESTP_ID){
        List<LiquidacionAC> liquidaciones = null; LiquidacionAC liquidacion;
        Connection c =null;
        try {
            liquidaciones = new ArrayList<LiquidacionAC>();
            String sql = "SELECT ACADEMICO.LIQUIDACION.*,ACADEMICO.PERIODOUNIVERSIDAD.* FROM ACADEMICO.LIQUIDACION INNER JOIN ACADEMICO.PERIODOUNIVERSIDAD " + 
                    "ON ACADEMICO.LIQUIDACION.PEUN_ID=ACADEMICO.PERIODOUNIVERSIDAD.PEUN_ID WHERE ACADEMICO.LIQUIDACION.ESTP_ID='" + ESTP_ID + "' "
                    + "ORDER BY ACADEMICO.LIQUIDACION.LIQU_FECHACAMBIO DESC";
            c = ConexionAcademicoDB.AbrirConexion();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                liquidacion = new LiquidacionAC();
                liquidacion.setLIQU_ID(rs.getLong("LIQU_ID"));
                liquidacion.setLIQU_TOTALLIQUIDADO(rs.getFloat("LIQU_TOTALLIQUIDADO"));
                liquidacion.setLIQU_TOTALDESCUENTO(rs.getFloat("LIQU_TOTALDESCUENTO"));
                liquidacion.setLIQU_FECHAPAGO(rs.getDate("LIQU_FECHAPAGO"));
                liquidacion.setLIQU_FECHACAMBIO(rs.getDate("LIQU_FECHACAMBIO"));
                liquidacion.setESTP_ID(rs.getLong("ESTP_ID"));
                liquidacion.setTIPL_ID(rs.getLong("TIPL_ID"));
                liquidacion.setLIQU_ESTADO(rs.getString("LIQU_ESTADO"));
                liquidacion.setLIQU_SALDOAFAVOR(rs.getFloat("LIQU_SALDOAFAVOR"));
                liquidacion.setLIQU_REGISTRADOPOR(rs.getString("LIQU_REGISTRADOPOR"));
                liquidacion.setLIQU_SALDOENCONTRA(rs.getFloat("LIQU_SALDOENCONTRA"));
                liquidacion.setLIQU_REFERENCIA(rs.getString("LIQU_REFERENCIA"));
                liquidacion.setPEUN_ID(rs.getLong("PEUN_ID"));
                liquidacion.setUNID_ID(rs.getLong("UNID_ID"));
                liquidacion.setLIQU_NUMEROCUOTA(rs.getString("LIQU_NUMEROCUOTA"));
                liquidacion.setLIQU_NIVELLIQUIDACION(rs.getString("LIQU_NIVELLIQUIDACION"));
                liquidacion.setLIQU_FECHASPROPIAS(rs.getString("LIQU_FECHASPROPIAS"));
                liquidacion.setFINA_ID(rs.getLong("FINA_ID"));
                liquidacion.setLIQU_VALORPAGADO(rs.getFloat("LIQU_VALORPAGADO"));
                liquidacion.setLIQU_VALORANTICIPO(rs.getFloat("LIQU_VALORANTICIPO"));
                liquidacion.setLIQU_VALORCUOTAORIGINAL(rs.getFloat("LIQU_VALORCUOTAORIGINAL"));
                liquidacion.setLIQU_TIPOLIQUIDACION(rs.getString("LIQU_TIPOLIQUIDACION"));
                liquidaciones.add(liquidacion);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConexionDB.CerrarConexion(c);
            return liquidaciones;
        }
    }
    
    public static List<LiquidacionAC> ListarLiquidacionesPorPagar(int PEUN_ID,String LIQU_ESTADO){
        List<LiquidacionAC> liquidaciones = null;
        Connection c =null;
        try {
            LIQU_ESTADO = "TODO".equals(LIQU_ESTADO) ? "":LIQU_ESTADO;
            liquidaciones = new ArrayList<LiquidacionAC>();
            String sql = "SELECT ACADEMICO.LIQUIDACION.*,ACADEMICO.ESTUDIANTEPENSUM.PEGE_ID,GENERAL.PERSONANATURALGENERAL.PENG_EMAILINSTITUCIONAL," +
                         "GENERAL.PERSONANATURALGENERAL.PENG_PRIMERNOMBRE,GENERAL.PERSONANATURALGENERAL.PENG_PRIMERAPELLIDO" +
                         " FROM (ACADEMICO.LIQUIDACION INNER JOIN ACADEMICO.ESTUDIANTEPENSUM" +
                         " ON ACADEMICO.LIQUIDACION.ESTP_ID=ACADEMICO.ESTUDIANTEPENSUM.ESTP_ID) INNER JOIN GENERAL.PERSONANATURALGENERAL ON " +
                         "ACADEMICO.ESTUDIANTEPENSUM.PEGE_ID=GENERAL.PERSONANATURALGENERAL.PEGE_ID " +
                         "WHERE ACADEMICO.LIQUIDACION.PEUN_ID='" + String.valueOf(PEUN_ID) + "' AND ACADEMICO.LIQUIDACION.LIQU_ESTADO LIKE '%" + LIQU_ESTADO + "%' " +
                         "ORDER BY GENERAL.PERSONANATURALGENERAL.PENG_PRIMERNOMBRE,GENERAL.PERSONANATURALGENERAL.PENG_PRIMERAPELLIDO ASC";
            c = ConexionAcademicoDB.AbrirConexion();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
              liquidaciones.add(MapeoLiquidacion(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConexionDB.CerrarConexion(c);
            return liquidaciones;
        }
    }
    
    public static LiquidacionAC MapeoLiquidacion(ResultSet rs) throws SQLException{
        LiquidacionAC periodo = new LiquidacionAC();
        periodo.setLIQU_ID(rs.getLong("LIQU_ID"));
        periodo.setLIQU_TOTALLIQUIDADO(rs.getFloat("LIQU_TOTALLIQUIDADO"));
        periodo.setLIQU_TOTALDESCUENTO(rs.getFloat("LIQU_TOTALDESCUENTO"));
        periodo.setLIQU_FECHAPAGO(rs.getDate("LIQU_FECHAPAGO"));
        periodo.setLIQU_FECHACAMBIO(rs.getDate("LIQU_FECHACAMBIO"));
        periodo.setESTP_ID(rs.getLong("ESTP_ID"));
        periodo.setTIPL_ID(rs.getLong("TIPL_ID"));
        periodo.setLIQU_ESTADO(rs.getString("LIQU_ESTADO"));
        periodo.setLIQU_SALDOAFAVOR(rs.getFloat("LIQU_SALDOAFAVOR"));
        periodo.setLIQU_REGISTRADOPOR(rs.getString("LIQU_REGISTRADOPOR"));
        periodo.setLIQU_SALDOENCONTRA(rs.getFloat("LIQU_SALDOENCONTRA"));
        periodo.setLIQU_REFERENCIA(rs.getString("LIQU_REFERENCIA"));
        periodo.setPEUN_ID(rs.getLong("PEUN_ID"));
        periodo.setUNID_ID(rs.getLong("UNID_ID"));
        periodo.setLIQU_NUMEROCUOTA(rs.getString("LIQU_NUMEROCUOTA"));
        periodo.setLIQU_NIVELLIQUIDACION(rs.getString("LIQU_NIVELLIQUIDACION"));
        periodo.setLIQU_FECHASPROPIAS(rs.getString("LIQU_FECHASPROPIAS"));
        periodo.setFINA_ID(rs.getLong("FINA_ID"));
        periodo.setLIQU_VALORPAGADO(rs.getFloat("LIQU_VALORPAGADO"));
        periodo.setLIQU_VALORANTICIPO(rs.getFloat("LIQU_VALORANTICIPO"));
        periodo.setLIQU_VALORCUOTAORIGINAL(rs.getFloat("LIQU_VALORCUOTAORIGINAL"));
        periodo.setLIQU_TIPOLIQUIDACION(rs.getString("LIQU_TIPOLIQUIDACION"));
        
        periodo.setPENG_EMAILINSTITUCIONAL(rs.getString("PENG_EMAILINSTITUCIONAL"));
        periodo.setPENG_PRIMERNOMBRE(rs.getString("PENG_PRIMERNOMBRE"));
        periodo.setPENG_PRIMERAPELLIDO(rs.getString("PENG_PRIMERAPELLIDO"));
        periodo.setPEGE_ID(rs.getInt("PEGE_ID"));
        return periodo;
    }
    
}
