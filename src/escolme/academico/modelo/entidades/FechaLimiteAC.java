package escolme.academico.modelo.entidades;

import java.sql.Date;

/**
 *
 * @author Jose Luis Orozco Mejia
 * @since 20-11-2012
 */
public class FechaLimiteAC {

    private long FELI_ID;
    private Date FELI_FECHAFINAL;
    private long PEUN_ID;
    private String FELI_DESCRIPCION;
    private long FELI_PORCENTAJE;
    
    public long getFELI_ID() {
        return FELI_ID;
    }

    public void setFELI_ID(long FELI_ID) {
        this.FELI_ID = FELI_ID;
    }

    public Date getFELI_FECHAFINAL() {
        return FELI_FECHAFINAL;
    }

    public void setFELI_FECHAFINAL(Date FELI_FECHAFINAL) {
        this.FELI_FECHAFINAL = FELI_FECHAFINAL;
    }

    public long getPEUN_ID() {
        return PEUN_ID;
    }

    public void setPEUN_ID(long PEUN_ID) {
        this.PEUN_ID = PEUN_ID;
    }

    public String getFELI_DESCRIPCION() {
        return FELI_DESCRIPCION;
    }

    public void setFELI_DESCRIPCION(String FELI_DESCRIPCION) {
        this.FELI_DESCRIPCION = FELI_DESCRIPCION;
    }

    public long getFELI_PORCENTAJE() {
        return FELI_PORCENTAJE;
    }

    public void setFELI_PORCENTAJE(long FELI_PORCENTAJE) {
        this.FELI_PORCENTAJE = FELI_PORCENTAJE;
    }
}
