package escolme.academico.modelo.entidades;

import java.sql.Date;

/**
 * @author Jose Luis Orozco Mejia
 * @since 29-06-2012
 */
public class PagareLiquidacionAC {

    private long PAGL_ID;
    private long PALI_ID;
    private long LIQU_ID;
    private float PAGL_VALOR;
    private Date PAGL_FECHA;
    private long PEGE_ID;
    private String PAGL_NUMERO;

    public long getPAGL_ID() {
        return PAGL_ID;
    }

    public void setPAGL_ID(long PAGL_ID) {
        this.PAGL_ID = PAGL_ID;
    }

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

    public float getPAGL_VALOR() {
        return PAGL_VALOR;
    }

    public void setPAGL_VALOR(float PAGL_VALOR) {
        this.PAGL_VALOR = PAGL_VALOR;
    }

    public Date getPAGL_FECHA() {
        return PAGL_FECHA;
    }

    public void setPAGL_FECHA(Date PAGL_FECHA) {
        this.PAGL_FECHA = PAGL_FECHA;
    }

    public long getPEGE_ID() {
        return PEGE_ID;
    }

    public void setPEGE_ID(long PEGE_ID) {
        this.PEGE_ID = PEGE_ID;
    }

    public String getPAGL_NUMERO() {
        return PAGL_NUMERO;
    }

    public void setPAGL_NUMERO(String PAGL_NUMERO) {
        this.PAGL_NUMERO = PAGL_NUMERO;
    }
    
}
