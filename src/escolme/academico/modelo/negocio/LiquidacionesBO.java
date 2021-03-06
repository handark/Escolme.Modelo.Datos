package escolme.academico.modelo.negocio;

import escolme.academico.modelo.entidades.DescuentosAC;
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

    public static LiquidacionAC CargarLiquidacionPorReferencia(long LIQU_REFERENCIA){
        LiquidacionAC liquidacion = null;
        Connection c =null;
        try {

            String sql = "SELECT * FROM ACADEMICO.LIQUIDACION WHERE LIQU_REFERENCIA='" + LIQU_REFERENCIA + "'";
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
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConexionDB.CerrarConexion(c);
            return liquidacion;
        }       
    }    
    
    public static LiquidacionAC CargarLiquidacionPorId(long LIQU_ID){
        LiquidacionAC liquidacion = null;
        Connection c =null;
        try {

            String sql = "SELECT * FROM ACADEMICO.LIQUIDACION WHERE LIQU_ID='" + LIQU_ID + "'";
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
            }
        } catch (SQLException ex) {
            Logger.getLogger(LiquidacionesBO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConexionDB.CerrarConexion(c);
            return liquidacion;
        }       
    }
    
    public static List<DescuentosAC> CargarDescuentos(long LIQU_ID){
        List<DescuentosAC> descuentos = new ArrayList<>(); DescuentosAC descuento = null;
        Connection c =null;
        try{
            String sql = "SELECT * FROM (((ACADEMICO.LIQUIDACION A INNER JOIN ACADEMICO.CONCEPTOLIQUIDADO B ON A.LIQU_ID=B.LIQU_ID)" + 
                    "INNER JOIN ACADEMICO.NORMACONCEPTO C ON B.NOCO_ID=C.NOCO_ID) INNER JOIN ACADEMICO.CONCEPTOMATRICULA D ON C.COMA_ID=D.COMA_ID)" +
                    "INNER JOIN ACADEMICO.TIPOCONCEPTO E ON D.TICO_ID=E.TICO_ID WHERE A.LIQU_ID=" + String.valueOf(LIQU_ID) + " AND E.TICO_ID=2";
            c = ConexionAcademicoDB.AbrirConexion();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                descuento = new DescuentosAC();
                descuento.setDescripcion(rs.getString("COMA_DESCRIPCION"));
                descuento.setPorcentaje_descuento(rs.getFloat("NOCO_PORCENTAJE"));
                descuento.setDescuento_fijo(rs.getLong("NOCO_VALORFIJO"));  
                descuentos.add(descuento);
            }         
        }
        catch(SQLException ex){
             Logger.getLogger(LiquidacionesBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            return descuentos;
        }
    }
    
    public static List<LiquidacionAC> ListarLiquidacionesPorPersona(long PEGE_ID){
        List<LiquidacionAC> liquidaciones = null; LiquidacionAC liquidacion;
        Connection c =null;
        try {
            liquidaciones = new ArrayList<>();
            String sql = "SELECT ACADEMICO.LIQUIDACION.*,ACADEMICO.PERIODOUNIVERSIDAD.*,ACADEMICO.LIQUIDACIONADJUNTO.LIAD_ARCHIVO " +
                    "FROM (((ACADEMICO.LIQUIDACION INNER JOIN ACADEMICO.PERIODOUNIVERSIDAD ON ACADEMICO.LIQUIDACION.PEUN_ID=ACADEMICO.PERIODOUNIVERSIDAD.PEUN_ID) " +
                    "INNER JOIN ACADEMICO.ESTUDIANTEPENSUM ON ACADEMICO.LIQUIDACION.ESTP_ID = ACADEMICO.ESTUDIANTEPENSUM.ESTP_ID) " +
                    "INNER JOIN GENERAL.PERSONAGENERAL ON ACADEMICO.ESTUDIANTEPENSUM.PEGE_ID=GENERAL.PERSONAGENERAL.PEGE_ID) LEFT OUTER JOIN ACADEMICO.LIQUIDACIONADJUNTO ON GENERAL.PERSONAGENERAL.PEGE_ID=ACADEMICO.LIQUIDACIONADJUNTO.PEGE_ID " +
                        "WHERE ACADEMICO.ESTUDIANTEPENSUM.PEGE_ID='" + PEGE_ID + "'" +
                        " ORDER BY ACADEMICO.LIQUIDACION.LIQU_FECHACAMBIO DESC";
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
            liquidaciones = new ArrayList<>();
            String sql = "SELECT ACADEMICO.LIQUIDACION.*,ACADEMICO.ESTUDIANTEPENSUM.PEGE_ID,GENERAL.PERSONANATURALGENERAL.PENG_EMAILINSTITUCIONAL," +
                         "GENERAL.PERSONANATURALGENERAL.PENG_PRIMERNOMBRE,GENERAL.PERSONANATURALGENERAL.PENG_PRIMERAPELLIDO,ACADEMICO.LIQUIDACIONADJUNTO.LIAD_ARCHIVO" +
                         " FROM (((ACADEMICO.LIQUIDACION INNER JOIN ACADEMICO.ESTUDIANTEPENSUM" +
                         " ON ACADEMICO.LIQUIDACION.ESTP_ID=ACADEMICO.ESTUDIANTEPENSUM.ESTP_ID) INNER JOIN GENERAL.PERSONANATURALGENERAL ON " +
                         "ACADEMICO.ESTUDIANTEPENSUM.PEGE_ID=GENERAL.PERSONANATURALGENERAL.PEGE_ID) " +
                         "INNER JOIN GENERAL.PERSONAGENERAL ON GENERAL.PERSONANATURALGENERAL.PEGE_ID=GENERAL.PERSONAGENERAL.PEGE_ID) LEFT OUTER JOIN ACADEMICO.LIQUIDACIONADJUNTO ON GENERAL.PERSONAGENERAL.PEGE_ID=ACADEMICO.LIQUIDACIONADJUNTO.PEGE_ID " +
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
        LiquidacionAC liquidacion = new LiquidacionAC();
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
        
        liquidacion.setPENG_EMAILINSTITUCIONAL(rs.getString("PENG_EMAILINSTITUCIONAL"));
        liquidacion.setPENG_PRIMERNOMBRE(rs.getString("PENG_PRIMERNOMBRE"));
        liquidacion.setPENG_PRIMERAPELLIDO(rs.getString("PENG_PRIMERAPELLIDO"));
        liquidacion.setPEGE_ID(rs.getInt("PEGE_ID"));
        
        liquidacion.setLIAD_ARCHIVO(rs.getString("LIAD_ARCHIVO"));
        return liquidacion;
    }
    
}
