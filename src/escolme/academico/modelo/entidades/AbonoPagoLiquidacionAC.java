package escolme.academico.modelo.entidades;

import java.sql.Date;


/**
 * @author Jose Luis Orozco Mejia
 * @since 22-06-2012
 */
public class AbonoPagoLiquidacionAC {

    private long ABPL_ID;
    private long PALI_ID;
    private long LIQU_ID;
    private float ABPL_VALOR;
    private Date ABPL_FECHA;
    private String ABPL_OBSERVACION;

    public long getABPL_ID() {
        return ABPL_ID;
    }

    public void setABPL_ID(long ABPL_ID) {
        this.ABPL_ID = ABPL_ID;
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

    public float getABPL_VALOR() {
        return ABPL_VALOR;
    }

    public void setABPL_VALOR(float ABPL_VALOR) {
        this.ABPL_VALOR = ABPL_VALOR;
    }

    public Date getABPL_FECHA() {
        return ABPL_FECHA;
    }

    public void setABPL_FECHA(Date ABPL_FECHA) {
        this.ABPL_FECHA = ABPL_FECHA;
    }

    public String getABPL_OBSERVACION() {
        return ABPL_OBSERVACION;
    }

    public void setABPL_OBSERVACION(String ABPL_OBSERVACION) {
        this.ABPL_OBSERVACION = ABPL_OBSERVACION;
    }
    
}
