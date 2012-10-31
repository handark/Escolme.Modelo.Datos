
package escolme.vortal.modelo.entidades;

/**
 *
 * @author Jose Luis Orozco
 */
public class ConfiguracionRangosVencimientoVO {

    private long conranven_id;
    private int conranven_dias;
    private int conranven_estado;
    private String conranven_diastexto;

    public long getConranven_id() {
        return conranven_id;
    }

    public void setConranven_id(long conranven_id) {
        this.conranven_id = conranven_id;
    }

    public int getConranven_dias() {
        return conranven_dias;
    }

    public void setConranven_dias(int conranven_dias) {
        this.conranven_dias = conranven_dias;
    }

    public int getConranven_estado() {
        return conranven_estado;
    }

    public void setConranven_estado(int conranven_estado) {
        this.conranven_estado = conranven_estado;
    }   

    public String getConranven_diastexto() {
        return conranven_diastexto;
    }

    public void setConranven_diastexto(String conranven_diastexto) {
        this.conranven_diastexto = conranven_diastexto;
    }
    
}
