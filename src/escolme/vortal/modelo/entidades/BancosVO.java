package escolme.vortal.modelo.entidades;

import java.util.List;

/**
 *
 * @author Jose Luis Orozco Mejia
 * @since 30-11-2012
 */
public class BancosVO {
    private long ban_id;
    private String ban_nombre;
    private int ban_estado;
    
    private List<BancosCuentasVO> bancoCuentas;

    public long getBan_id() {
        return ban_id;
    }

    public void setBan_id(long ban_id) {
        this.ban_id = ban_id;
    }

    public String getBan_nombre() {
        return ban_nombre;
    }

    public void setBan_nombre(String ban_nombre) {
        this.ban_nombre = ban_nombre;
    }

    public int getBan_estado() {
        return ban_estado;
    }

    public void setBan_estado(int ban_estado) {
        this.ban_estado = ban_estado;
    }

    /**
     * @return the bacoCuenta
     */
    public List<BancosCuentasVO> getBacoCuentas() {
        return bancoCuentas;
    }

    /**
     * @param bacoCuenta the bacoCuenta to set
     */
    public void setBacoCuentas(List<BancosCuentasVO> bacoCuentas) {
        this.bancoCuentas = bacoCuentas;
    }
}
