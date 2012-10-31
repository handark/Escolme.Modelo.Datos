package escolme.vortal.modelo.entidades;

/**
 *
 * @author Jose Luis Orozco Mejia
 */
public class ConfiguracionFormasPagoVO {
    
    private long conforpag_id;
    private String conforpag_formapago;
    private int conforpag_estado;

    public long getConforpag_id() {
        return conforpag_id;
    }

    public void setConforpag_id(long conforpag_id) {
        this.conforpag_id = conforpag_id;
    }

    public String getConforpag_formapago() {
        return conforpag_formapago;
    }

    public void setConforpag_formapago(String conforpag_formapago) {
        this.conforpag_formapago = conforpag_formapago;
    }

    public int getConforpag_estado() {
        return conforpag_estado;
    }

    public void setConforpag_estado(int conforpag_estado) {
        this.conforpag_estado = conforpag_estado;
    }
    
}
