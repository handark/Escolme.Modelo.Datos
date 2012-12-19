package escolme.vortal.modelo.entidades;

import java.sql.Date;

/**
 * Clase que define las propiedades de la tabla facturas_pagos
 * @author Jose Luis Orozco Mejia - http://handark.com
 */
public class FacturasPagosVO {
    
    //Campos de la Tabla facturas_pagos
    private long facpag_id;
    private long fac_id;
    private long fac_secuencia;
    private Date facpag_fecha;
    private long facpag_valor;
    private String facpag_observaciones;
    private long conforpag_id;
    
    private String conforpag_formapago;

    /**
     * @return the conforpag_formapago
     */
    public String getConforpag_formapago() {
        return conforpag_formapago;
    }

    /**
     * @param conforpag_formapago the conforpag_formapago to set
     */
    public void setConforpag_formapago(String conforpag_formapago) {
        this.conforpag_formapago = conforpag_formapago;
    }
    
    /**
     *  Definiciones de la tabla facturas_pagos
     */
    public static class Definiciones{   
        public final String campoFacpag_id = "facpag_id";
        public final String campoFac_id = "fac_id";
        public final String campoFac_secuencia = "fac_secuencia";
        public final String campoFacpag_fecha = "facpag_fecha";
        public final String campoFacpag_valor = "facpag_valor";
        public final String campoFacpag_observaciones = "facpag_observaciones";
        public final String campoConforpag_id = "conforpag_id";
        public final String tabla = "facturas_pagos";
        public final String esquema = "campusadmin";
        public String getTabla(){
            return esquema + "." + tabla;
        }
        public String getCampos(){
            return String.format("%s,%s,%s,%s,%s,%s,%s", campoFacpag_id,campoFac_id,campoFac_secuencia,campoFacpag_fecha,campoFacpag_valor,campoFacpag_observaciones,campoConforpag_id);
        }
    }

    /**
     * @return the facpag_id
     */
    public long getFacpag_id() {
        return facpag_id;
    }

    /**
     * @param facpag_id the facpag_id to set
     */
    public void setFacpag_id(long facpag_id) {
        this.facpag_id = facpag_id;
    }

    /**
     * @return the fac_id
     */
    public long getFac_id() {
        return fac_id;
    }

    /**
     * @param fac_id the fac_id to set
     */
    public void setFac_id(long fac_id) {
        this.fac_id = fac_id;
    }

    /**
     * @return the fac_secuencia
     */
    public long getFac_secuencia() {
        return fac_secuencia;
    }

    /**
     * @param fac_secuencia the fac_secuencia to set
     */
    public void setFac_secuencia(long fac_secuencia) {
        this.fac_secuencia = fac_secuencia;
    }

    /**
     * @return the facpag_fecha
     */
    public Date getFacpag_fecha() {
        return facpag_fecha;
    }

    /**
     * @param facpag_fecha the facpag_fecha to set
     */
    public void setFacpag_fecha(Date facpag_fecha) {
        this.facpag_fecha = facpag_fecha;
    }

    /**
     * @return the facpag_valor
     */
    public long getFacpag_valor() {
        return facpag_valor;
    }

    /**
     * @param facpag_valor the facpag_valor to set
     */
    public void setFacpag_valor(long facpag_valor) {
        this.facpag_valor = facpag_valor;
    }

    /**
     * @return the facpag_observaciones
     */
    public String getFacpag_observaciones() {
        return facpag_observaciones;
    }

    /**
     * @param facpag_observaciones the facpag_observaciones to set
     */
    public void setFacpag_observaciones(String facpag_observaciones) {
        this.facpag_observaciones = facpag_observaciones;
    }

    /**
     * @return the conforpag_id
     */
    public long getConforpag_id() {
        return conforpag_id;
    }

    /**
     * @param conforpag_id the conforpag_id to set
     */
    public void setConforpag_id(long conforpag_id) {
        this.conforpag_id = conforpag_id;
    }
    
}
