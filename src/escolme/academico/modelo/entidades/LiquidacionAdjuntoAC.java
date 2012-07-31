package escolme.academico.modelo.entidades;

import java.sql.Date;

/**
 *
 * @author Jose Luis Orozco Mejia
 */
public class LiquidacionAdjuntoAC {
    
    private long LIAD_ID;
    private String LIAD_ARCHIVO;
    private Date LIAD_FECHA;
    private String PEGE_DOCUMENTOIDENTIDAD;
    private long PEGE_ID;

    public long getLIAD_ID() {
        return LIAD_ID;
    }

    public void setLIAD_ID(long LIAD_ID) {
        this.LIAD_ID = LIAD_ID;
    }

    public String getLIAD_ARCHIVO() {
        return LIAD_ARCHIVO;
    }

    public void setLIAD_ARCHIVO(String LIAD_ARCHIVO) {
        this.LIAD_ARCHIVO = LIAD_ARCHIVO;
    }

    public Date getLIAD_FECHA() {
        return LIAD_FECHA;
    }

    public void setLIAD_FECHA(Date LIAD_FECHA) {
        this.LIAD_FECHA = LIAD_FECHA;
    }

    public String getPEGE_DOCUMENTOIDENTIDAD() {
        return PEGE_DOCUMENTOIDENTIDAD;
    }

    public void setPEGE_DOCUMENTOIDENTIDAD(String PEGE_DOCUMENTOIDENTIDAD) {
        this.PEGE_DOCUMENTOIDENTIDAD = PEGE_DOCUMENTOIDENTIDAD;
    }

    public long getPEGE_ID() {
        return PEGE_ID;
    }

    public void setPEGE_ID(long PEGE_ID) {
        this.PEGE_ID = PEGE_ID;
    }


}
