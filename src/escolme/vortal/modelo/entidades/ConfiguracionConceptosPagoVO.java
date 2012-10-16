package escolme.vortal.modelo.entidades;

/**
 *
 * @author jose
 */
public class ConfiguracionConceptosPagoVO {
    private long conconpag_id;
    private long contipdoc_id;
    private String conconpag_nombre;
    private int conconpag_estado;

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
}
