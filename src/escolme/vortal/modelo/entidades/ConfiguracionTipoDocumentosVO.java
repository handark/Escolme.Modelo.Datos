package escolme.vortal.modelo.entidades;

/**
 *
 * @author Jose Luis Orozco Mejia
 */
public class ConfiguracionTipoDocumentosVO {
 
    private long contipdoc_id;
    private String contipdoc_nombre;
    private int contipdoc_estado;
    private int contipdoc_tipooperacion;
    private int contipdoc_fijo;
    
    public long getContipdoc_id() {
        return contipdoc_id;
    }

    public void setContipdoc_id(long contipdoc_id) {
        this.contipdoc_id = contipdoc_id;
    }

    public String getContipdoc_nombre() {
        return contipdoc_nombre;
    }

    public void setContipdoc_nombre(String contipdoc_nombre) {
        this.contipdoc_nombre = contipdoc_nombre;
    }

    public int getContipdoc_estado() {
        return contipdoc_estado;
    }

    public void setContipdoc_estado(int contipdoc_estado) {
        this.contipdoc_estado = contipdoc_estado;
    }

    public int getContipdoc_tipooperacion() {
        return contipdoc_tipooperacion;
    }

    public void setContipdoc_tipooperacion(int contipdoc_tipooperacion) {
        this.contipdoc_tipooperacion = contipdoc_tipooperacion;
    }

    /**
     * @return the contipdoc_fijo
     */
    public int getContipdoc_fijo() {
        return contipdoc_fijo;
    }

    /**
     * @param contipdoc_fijo the contipdoc_fijo to set
     */
    public void setContipdoc_fijo(int contipdoc_fijo) {
        this.contipdoc_fijo = contipdoc_fijo;
    }
}
