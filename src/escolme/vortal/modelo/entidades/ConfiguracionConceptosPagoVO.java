package escolme.vortal.modelo.entidades;

/**
 *
 * @author Jose Luis Orozco
 */
public class ConfiguracionConceptosPagoVO {
    private long conconpag_id;
    private long contipdoc_id;
    private String conconpag_nombre;
    private int conconpag_estado;
    private long conconpag_valor;
    private String conconpag_cuentacontable;
    
    private String contipdoc_nombre;

    public long getConconpag_id() {
        return conconpag_id;
    }

    public void setConconpag_id(long conconpag_id) {
        this.conconpag_id = conconpag_id;
    }

    public long getContipdoc_id() {
        return contipdoc_id;
    }

    public void setContipdoc_id(long contipdoc_id) {
        this.contipdoc_id = contipdoc_id;
    }

    public String getConconpag_nombre() {
        return conconpag_nombre;
    }

    public void setConconpag_nombre(String conconpag_nombre) {
        this.conconpag_nombre = conconpag_nombre;
    }

    public int getConconpag_estado() {
        return conconpag_estado;
    }

    public void setConconpag_estado(int conconpag_estado) {
        this.conconpag_estado = conconpag_estado;
    }

    public String getContipdoc_nombre() {
        return contipdoc_nombre;
    }

    public void setContipdoc_nombre(String contipdoc_nombre) {
        this.contipdoc_nombre = contipdoc_nombre;
    }

    public long getConconpag_valor() {
        return conconpag_valor;
    }

    public void setConconpag_valor(long conconpag_valor) {
        this.conconpag_valor = conconpag_valor;
    }

    /**
     * @return the conconpag_cuentacontable
     */
    public String getConconpag_cuentacontable() {
        return conconpag_cuentacontable;
    }

    /**
     * @param conconpag_cuentacontable the conconpag_cuentacontable to set
     */
    public void setConconpag_cuentacontable(String conconpag_cuentacontable) {
        this.conconpag_cuentacontable = conconpag_cuentacontable;
    }
}
