package escolme.academico.modelo.entidades;

import java.util.Date;

/**
 * @author Jose Luis Orozco Mejia
 * @since 21-06-2012
 */
public class CreditoEstudianteAC {

    private long CRES_ID;
    private long ESTP_ID;
    private long LIQU_ID;
    private long PEGE_ID;
    private Date CRES_FECHASOLICITUD;
    private Date CRES_FECHAAPROBACION;
    private float CRES_VALORSOLICITADO;
    private float CRES_VALORAPROBADO;
    private long ESCR_ID;
    private long PALI_ID;

    /**
     * @return Id del Credito
     */
    public long getCRES_ID() {
        return CRES_ID;
    }

    /**
     * @param CRES_ID el Id del credito
     */
    public void setCRES_ID(long CRES_ID) {
        this.CRES_ID = CRES_ID;
    }

    /**
     * @return el Id Estuduante Pensum
     */
    public long getESTP_ID() {
        return ESTP_ID;
    }

    /**
     * @param ESTP_ID Id Estuduante Pensum
     */
    public void setESTP_ID(long ESTP_ID) {
        this.ESTP_ID = ESTP_ID;
    }

    /**
     * @return el Id de la Liquidacion del Estudiante
     */
    public long getLIQU_ID() {
        return LIQU_ID;
    }

    /**
     * @param LIQU_ID Id de la Liquidacion del Estudiante
     */
    public void setLIQU_ID(long LIQU_ID) {
        this.LIQU_ID = LIQU_ID;
    }

    /**
     * @return Id de Persona General
     */
    public long getPEGE_ID() {
        return PEGE_ID;
    }

    /**
     * @param PEGE_ID Id de Persona General
     */
    public void setPEGE_ID(long PEGE_ID) {
        this.PEGE_ID = PEGE_ID;
    }

    /**
     * @return the CRES_FECHASOLICITUD
     */
    public Date getCRES_FECHASOLICITUD() {
        return CRES_FECHASOLICITUD;
    }

    /**
     * @param CRES_FECHASOLICITUD the CRES_FECHASOLICITUD to set
     */
    public void setCRES_FECHASOLICITUD(Date CRES_FECHASOLICITUD) {
        this.CRES_FECHASOLICITUD = CRES_FECHASOLICITUD;
    }

    /**
     * @return the CRES_FECHAAPROBACION
     */
    public Date getCRES_FECHAAPROBACION() {
        return CRES_FECHAAPROBACION;
    }

    /**
     * @param CRES_FECHAAPROBACION the CRES_FECHAAPROBACION to set
     */
    public void setCRES_FECHAAPROBACION(Date CRES_FECHAAPROBACION) {
        this.CRES_FECHAAPROBACION = CRES_FECHAAPROBACION;
    }

    /**
     * @return the CRES_VALORSOLICITADO
     */
    public float getCRES_VALORSOLICITADO() {
        return CRES_VALORSOLICITADO;
    }

    /**
     * @param CRES_VALORSOLICITADO the CRES_VALORSOLICITADO to set
     */
    public void setCRES_VALORSOLICITADO(float CRES_VALORSOLICITADO) {
        this.CRES_VALORSOLICITADO = CRES_VALORSOLICITADO;
    }

    /**
     * @return the CRES_VALORAPROBADO
     */
    public float getCRES_VALORAPROBADO() {
        return CRES_VALORAPROBADO;
    }

    /**
     * @param CRES_VALORAPROBADO the CRES_VALORAPROBADO to set
     */
    public void setCRES_VALORAPROBADO(float CRES_VALORAPROBADO) {
        this.CRES_VALORAPROBADO = CRES_VALORAPROBADO;
    }

    /**
     * @return the Id Estado del Credito
     */
    public long getESCR_ID() {
        return ESCR_ID;
    }

    /**
     * @param ESCR_ID Id Estado del Credito
     */
    public void setESCR_ID(long ESCR_ID) {
        this.ESCR_ID = ESCR_ID;
    }

    /**
     * @return Id de Pago Liquidacion
     */
    public long getPALI_ID() {
        return PALI_ID;
    }

    /**
     * @param PALI_ID Id de Pago Liquidacion
     */
    public void setPALI_ID(long PALI_ID) {
        this.PALI_ID = PALI_ID;
    }
    
}
