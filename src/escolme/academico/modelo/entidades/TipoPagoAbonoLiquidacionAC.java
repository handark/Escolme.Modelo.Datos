package escolme.academico.modelo.entidades;

/**
 * @author Jose Luis Orozco Mejia
 * @since 27-06-2012
 */
public class TipoPagoAbonoLiquidacionAC {

    private long TIPA_ID;
    private String TIPA_FORMAPAGO;

    public long getTIPA_ID() {
        return TIPA_ID;
    }

    public void setTIPA_ID(long TIPA_ID) {
        this.TIPA_ID = TIPA_ID;
    }

    public String getTIPA_FORMAPAGO() {
        return TIPA_FORMAPAGO;
    }

    public void setTIPA_FORMAPAGO(String TIPA_FORMAPAGO) {
        this.TIPA_FORMAPAGO = TIPA_FORMAPAGO;
    }
    
}
