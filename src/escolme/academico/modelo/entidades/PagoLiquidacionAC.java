package escolme.academico.modelo.entidades;

import java.util.Date;

/**
 * @author Jose Luis Orozco Mejia
 * @since 08-06-2012
 */
public class PagoLiquidacionAC {

    private long PALI_ID;
    private long LIQU_ID;
    private float PALI_VALOR;
    private Date PALI_FECHA;
    private String PALI_ESTADO;
    private String PALI_REGISTRADOPOR;
    private Date PALI_FECHACAMBIO;
    private long TIPL_ID;
    private String PALI_OBSERVACIONES;

    private String TIPL_DESCRIPCION;
    
    public long getPALI_ID() {
        return PALI_ID;
    }

    public void setPALI_ID(long PALI_ID) {
        this.PALI_ID = PALI_ID;
    }

    public long getLIQU_ID() {
        return LIQU_ID;
    }

    public void setLIQU_ID(long LIQU_ID) {
        this.LIQU_ID = LIQU_ID;
    }

    public float getPALI_VALOR() {
        return PALI_VALOR;
    }

    public void setPALI_VALOR(float PALI_VALOR) {
        this.PALI_VALOR = PALI_VALOR;
    }

    public Date getPALI_FECHA() {
        return PALI_FECHA;
    }

    public void setPALI_FECHA(Date PALI_FECHA) {
        this.PALI_FECHA = PALI_FECHA;
    }

    public String getPALI_ESTADO() {
        return PALI_ESTADO;
    }

    public void setPALI_ESTADO(String PALI_ESTADO) {
        this.PALI_ESTADO = PALI_ESTADO;
    }

    public String getPALI_REGISTRADOPOR() {
        return PALI_REGISTRADOPOR;
    }

    public void setPALI_REGISTRADOPOR(String PALI_REGISTRADOPOR) {
        this.PALI_REGISTRADOPOR = PALI_REGISTRADOPOR;
    }

    public Date getPALI_FECHACAMBIO() {
        return PALI_FECHACAMBIO;
    }

    public void setPALI_FECHACAMBIO(Date PALI_FECHACAMBIO) {
        this.PALI_FECHACAMBIO = PALI_FECHACAMBIO;
    }

    public long getTIPL_ID() {
        return TIPL_ID;
    }

    public void setTIPL_ID(long TIPL_ID) {
        this.TIPL_ID = TIPL_ID;
    }

    public String getPALI_OBSERVACIONES() {
        return PALI_OBSERVACIONES;
    }

    public void setPALI_OBSERVACIONES(String PALI_OBSERVACIONES) {
        this.PALI_OBSERVACIONES = PALI_OBSERVACIONES;
    }

    public String getTIPL_DESCRIPCION() {
        return TIPL_DESCRIPCION;
    }

    public void setTIPL_DESCRIPCION(String TIPL_DESCRIPCION) {
        this.TIPL_DESCRIPCION = TIPL_DESCRIPCION;
    }
    
}
