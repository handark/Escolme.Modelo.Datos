package escolme.academico.modelo.entidades;

import java.util.Date;

/**
 * @author Jose Luis Orozco Mejia
 * @since 05-06-2012
 */
public class PeriodoUniversidadAC {

    //Campos Principales
    private long PEUN_ID;
    private Date PEUN_FECHAINICIO;
    private Date PEUN_FECHAFIN;
    private int PEUN_ANO;
    private String PEUN_PERIODO;
    private int TPPA_ID;
    private String PEUN_REGISTRADOPOR;
    private Date PEUN_FECHACAMBIO;
    private Date PEUN_FECHAINICIOCLASES;
    private Date PEUN_FECHAFINCLASES;
    private String PEUN_CODIGOPERIODO;

    //Relaciones
    private String TPPA_DESCRIPCION;

    public long getPEUN_ID() {
        return PEUN_ID;
    }

    public void setPEUN_ID(long PEUN_ID) {
        this.PEUN_ID = PEUN_ID;
    }

    public Date getPEUN_FECHAINICIO() {
        return PEUN_FECHAINICIO;
    }

    public void setPEUN_FECHAINICIO(Date PEUN_FECHAINICIO) {
        this.PEUN_FECHAINICIO = PEUN_FECHAINICIO;
    }

    public Date getPEUN_FECHAFIN() {
        return PEUN_FECHAFIN;
    }

    public void setPEUN_FECHAFIN(Date PEUN_FECHAFIN) {
        this.PEUN_FECHAFIN = PEUN_FECHAFIN;
    }

    public int getPEUN_ANO() {
        return PEUN_ANO;
    }

    public void setPEUN_ANO(int PEUN_ANO) {
        this.PEUN_ANO = PEUN_ANO;
    }

    public String getPEUN_PERIODO() {
        return PEUN_PERIODO;
    }

    public void setPEUN_PERIODO(String PEUN_PERIODO) {
        this.PEUN_PERIODO = PEUN_PERIODO;
    }

    public int getTPPA_ID() {
        return TPPA_ID;
    }

    public void setTPPA_ID(int TPPA_ID) {
        this.TPPA_ID = TPPA_ID;
    }

    public String getPEUN_REGISTRADOPOR() {
        return PEUN_REGISTRADOPOR;
    }

    public void setPEUN_REGISTRADOPOR(String PEUN_REGISTRADOPOR) {
        this.PEUN_REGISTRADOPOR = PEUN_REGISTRADOPOR;
    }

    public Date getPEUN_FECHACAMBIO() {
        return PEUN_FECHACAMBIO;
    }

    public void setPEUN_FECHACAMBIO(Date PEUN_FECHACAMBIO) {
        this.PEUN_FECHACAMBIO = PEUN_FECHACAMBIO;
    }

    public Date getPEUN_FECHAINICIOCLASES() {
        return PEUN_FECHAINICIOCLASES;
    }

    public void setPEUN_FECHAINICIOCLASES(Date PEUN_FECHAINICIOCLASES) {
        this.PEUN_FECHAINICIOCLASES = PEUN_FECHAINICIOCLASES;
    }

    public Date getPEUN_FECHAFINCLASES() {
        return PEUN_FECHAFINCLASES;
    }

    public void setPEUN_FECHAFINCLASES(Date PEUN_FECHAFINCLASES) {
        this.PEUN_FECHAFINCLASES = PEUN_FECHAFINCLASES;
    }

    public String getPEUN_CODIGOPERIODO() {
        return PEUN_CODIGOPERIODO;
    }

    public void setPEUN_CODIGOPERIODO(String PEUN_CODIGOPERIODO) {
        this.PEUN_CODIGOPERIODO = PEUN_CODIGOPERIODO;
    }

    public String getTPPA_DESCRIPCION() {
        return TPPA_DESCRIPCION;
    }

    public void setTPPA_DESCRIPCION(String TPPA_DESCRIPCION) {
        this.TPPA_DESCRIPCION = TPPA_DESCRIPCION;
    }
    
   
}
