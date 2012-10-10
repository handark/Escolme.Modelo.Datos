package escolme.vortal.modelo.entidades;

/**
 *
 * @author Jose Luis Orozco Mejia
 */
public class ConfiguracionTipoDocumentosVO {
 
    private long contipdoc_id;
    private String contipdoc_nombre;
    private int contipdoc_estado;

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
}
