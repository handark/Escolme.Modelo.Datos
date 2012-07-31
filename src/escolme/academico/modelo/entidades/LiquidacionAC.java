package escolme.academico.modelo.entidades;

import java.util.Date;

/**
 * @author Jose Luis Orozco Mejia
 * @since 05-06-2012
 */
public class LiquidacionAC {
    
    private long LIQU_ID;
    private float LIQU_TOTALLIQUIDADO;
    private float LIQU_TOTALDESCUENTO;
    private Date LIQU_FECHAPAGO;
    private Date LIQU_FECHACAMBIO;
    private long ESTP_ID;
    private long TIPL_ID;
    private String LIQU_ESTADO;
    private float LIQU_SALDOAFAVOR;
    private String LIQU_REGISTRADOPOR;
    private float LIQU_SALDOENCONTRA;
    private String LIQU_REFERENCIA;
    private long PEUN_ID;
    private long UNID_ID;
    private String LIQU_NUMEROCUOTA;
    private String LIQU_NIVELLIQUIDACION;
    private String LIQU_FECHASPROPIAS;
    private long FINA_ID;
    private float LIQU_VALORPAGADO;
    private float LIQU_VALORANTICIPO;
    private float LIQU_VALORCUOTAORIGINAL;
    private String LIQU_TIPOLIQUIDACION;
    
    //Relaciones
    private String PENG_EMAILINSTITUCIONAL;
    private String PENG_PRIMERNOMBRE;
    private String PENG_PRIMERAPELLIDO;
    private int PEGE_ID;
    private String LIAD_ARCHIVO;

    public long getLIQU_ID() {
        return LIQU_ID;
    }

    public void setLIQU_ID(long LIQU_ID) {
        this.LIQU_ID = LIQU_ID;
    }

    public float getLIQU_TOTALLIQUIDADO() {
        return LIQU_TOTALLIQUIDADO;
    }

    public void setLIQU_TOTALLIQUIDADO(float LIQU_TOTALLIQUIDADO) {
        this.LIQU_TOTALLIQUIDADO = LIQU_TOTALLIQUIDADO;
    }

    public float getLIQU_TOTALDESCUENTO() {
        return LIQU_TOTALDESCUENTO;
    }

    public void setLIQU_TOTALDESCUENTO(float LIQU_TOTALDESCUENTO) {
        this.LIQU_TOTALDESCUENTO = LIQU_TOTALDESCUENTO;
    }

    public Date getLIQU_FECHAPAGO() {
        return LIQU_FECHAPAGO;
    }

    public void setLIQU_FECHAPAGO(Date LIQU_FECHAPAGO) {
        this.LIQU_FECHAPAGO = LIQU_FECHAPAGO;
    }

    public Date getLIQU_FECHACAMBIO() {
        return LIQU_FECHACAMBIO;
    }

    public void setLIQU_FECHACAMBIO(Date LIQU_FECHACAMBIO) {
        this.LIQU_FECHACAMBIO = LIQU_FECHACAMBIO;
    }

    public long getESTP_ID() {
        return ESTP_ID;
    }

    public void setESTP_ID(long ESTP_ID) {
        this.ESTP_ID = ESTP_ID;
    }

    public long getTIPL_ID() {
        return TIPL_ID;
    }

    public void setTIPL_ID(long TIPL_ID) {
        this.TIPL_ID = TIPL_ID;
    }

    public String getLIQU_ESTADO() {
        return LIQU_ESTADO;
    }

    public void setLIQU_ESTADO(String LIQU_ESTADO) {
        this.LIQU_ESTADO = LIQU_ESTADO;
    }

    public float getLIQU_SALDOAFAVOR() {
        return LIQU_SALDOAFAVOR;
    }

    public void setLIQU_SALDOAFAVOR(float LIQU_SALDOAFAVOR) {
        this.LIQU_SALDOAFAVOR = LIQU_SALDOAFAVOR;
    }

    public String getLIQU_REGISTRADOPOR() {
        return LIQU_REGISTRADOPOR;
    }

    public void setLIQU_REGISTRADOPOR(String LIQU_REGISTRADOPOR) {
        this.LIQU_REGISTRADOPOR = LIQU_REGISTRADOPOR;
    }

    public float getLIQU_SALDOENCONTRA() {
        return LIQU_SALDOENCONTRA;
    }

    public void setLIQU_SALDOENCONTRA(float LIQU_SALDOENCONTRA) {
        this.LIQU_SALDOENCONTRA = LIQU_SALDOENCONTRA;
    }

    public String getLIQU_REFERENCIA() {
        return LIQU_REFERENCIA;
    }

    public void setLIQU_REFERENCIA(String LIQU_REFERENCIA) {
        this.LIQU_REFERENCIA = LIQU_REFERENCIA;
    }

    public long getPEUN_ID() {
        return PEUN_ID;
    }

    public void setPEUN_ID(long PEUN_ID) {
        this.PEUN_ID = PEUN_ID;
    }

    public long getUNID_ID() {
        return UNID_ID;
    }

    public void setUNID_ID(long UNID_ID) {
        this.UNID_ID = UNID_ID;
    }

    public String getLIQU_NUMEROCUOTA() {
        return LIQU_NUMEROCUOTA;
    }

    public void setLIQU_NUMEROCUOTA(String LIQU_NUMEROCUOTA) {
        this.LIQU_NUMEROCUOTA = LIQU_NUMEROCUOTA;
    }

    public String getLIQU_NIVELLIQUIDACION() {
        return LIQU_NIVELLIQUIDACION;
    }

    public void setLIQU_NIVELLIQUIDACION(String LIQU_NIVELLIQUIDACION) {
        this.LIQU_NIVELLIQUIDACION = LIQU_NIVELLIQUIDACION;
    }

    public String getLIQU_FECHASPROPIAS() {
        return LIQU_FECHASPROPIAS;
    }

    public void setLIQU_FECHASPROPIAS(String LIQU_FECHASPROPIAS) {
        this.LIQU_FECHASPROPIAS = LIQU_FECHASPROPIAS;
    }

    public long getFINA_ID() {
        return FINA_ID;
    }

    public void setFINA_ID(long FINA_ID) {
        this.FINA_ID = FINA_ID;
    }

    public float getLIQU_VALORPAGADO() {
        return LIQU_VALORPAGADO;
    }

    public void setLIQU_VALORPAGADO(float LIQU_VALORPAGADO) {
        this.LIQU_VALORPAGADO = LIQU_VALORPAGADO;
    }

    public float getLIQU_VALORANTICIPO() {
        return LIQU_VALORANTICIPO;
    }

    public void setLIQU_VALORANTICIPO(float LIQU_VALORANTICIPO) {
        this.LIQU_VALORANTICIPO = LIQU_VALORANTICIPO;
    }

    public float getLIQU_VALORCUOTAORIGINAL() {
        return LIQU_VALORCUOTAORIGINAL;
    }

    public void setLIQU_VALORCUOTAORIGINAL(float LIQU_VALORCUOTAORIGINAL) {
        this.LIQU_VALORCUOTAORIGINAL = LIQU_VALORCUOTAORIGINAL;
    }

    public String getLIQU_TIPOLIQUIDACION() {
        return LIQU_TIPOLIQUIDACION;
    }

    public void setLIQU_TIPOLIQUIDACION(String LIQU_TIPOLIQUIDACION) {
        this.LIQU_TIPOLIQUIDACION = LIQU_TIPOLIQUIDACION;
    }

    public String getPENG_EMAILINSTITUCIONAL() {
        return PENG_EMAILINSTITUCIONAL;
    }

    public void setPENG_EMAILINSTITUCIONAL(String PENG_EMAILINSTITUCIONAL) {
        this.PENG_EMAILINSTITUCIONAL = PENG_EMAILINSTITUCIONAL;
    }

    public String getPENG_PRIMERNOMBRE() {
        return PENG_PRIMERNOMBRE;
    }

    public void setPENG_PRIMERNOMBRE(String PENG_PRIMERNOMBRE) {
        this.PENG_PRIMERNOMBRE = PENG_PRIMERNOMBRE;
    }

    public String getPENG_PRIMERAPELLIDO() {
        return PENG_PRIMERAPELLIDO;
    }

    public void setPENG_PRIMERAPELLIDO(String PENG_PRIMERAPELLIDO) {
        this.PENG_PRIMERAPELLIDO = PENG_PRIMERAPELLIDO;
    }

    public int getPEGE_ID() {
        return PEGE_ID;
    }

    public void setPEGE_ID(int PEGE_ID) {
        this.PEGE_ID = PEGE_ID;
    }

    public String getLIAD_ARCHIVO() {
        return LIAD_ARCHIVO;
    }

    public void setLIAD_ARCHIVO(String LIAD_ARCHIVO) {
        this.LIAD_ARCHIVO = LIAD_ARCHIVO;
    }
}
