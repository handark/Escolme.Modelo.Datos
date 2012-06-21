package escolme.academico.modelo.entidades;

import java.util.Date;

/**
 * @author Jose Luis Orozco Mejia
 * @since 20-06-2012
 */
public class CarteraReciboCajaAC {

    private long CARC_ID;
    private long PALI_ID;
    private long CARC_NUMERORECIBO;
    private Date CARC_FECHA;
    private long LIQU_ID;
    private String CARC_OBSERVACION;

    public long getCARC_ID() {
        return CARC_ID;
    }

    public void setCARC_ID(long CARC_ID) {
        this.CARC_ID = CARC_ID;
    }

    public long getPALI_ID() {
        return PALI_ID;
    }

    public void setPALI_ID(long PALI_ID) {
        this.PALI_ID = PALI_ID;
    }

    public long getCARC_NUMERORECIBO() {
        return CARC_NUMERORECIBO;
    }

    public void setCARC_NUMERORECIBO(long CARC_NUMERORECIBO) {
        this.CARC_NUMERORECIBO = CARC_NUMERORECIBO;
    }

    public Date getCARC_FECHA() {
        return CARC_FECHA;
    }

    public void setCARC_FECHA(Date CARC_FECHA) {
        this.CARC_FECHA = CARC_FECHA;
    }

    public long getLIQU_ID() {
        return LIQU_ID;
    }

    public void setLIQU_ID(long LIQU_ID) {
        this.LIQU_ID = LIQU_ID;
    }

    public String getCARC_OBSERVACION() {
        return CARC_OBSERVACION;
    }

    public void setCARC_OBSERVACION(String CARC_OBSERVACION) {
        this.CARC_OBSERVACION = CARC_OBSERVACION;
    }
}
