package escolme.academico.modelo.entidades;

/**
 * @author Jose Luis Orozco Mejia
 * @since 05-06-2012
 */
public class TipoPeriodoAcademicoAC {

    private String TPPA_DESCRIPCION;
    private String TPPA_REGISTRADOPOR;
    private String TPPA_FECHACAMBIO;
    private int TPPA_ID;
    private int TPPA_DURACIONSEMANAS;

    public String getTPPA_DESCRIPCION() {
        return TPPA_DESCRIPCION;
    }

    public void setTPPA_DESCRIPCION(String TPPA_DESCRIPCION) {
        this.TPPA_DESCRIPCION = TPPA_DESCRIPCION;
    }

    public String getTPPA_REGISTRADOPOR() {
        return TPPA_REGISTRADOPOR;
    }

    public void setTPPA_REGISTRADOPOR(String TPPA_REGISTRADOPOR) {
        this.TPPA_REGISTRADOPOR = TPPA_REGISTRADOPOR;
    }

    public String getTPPA_FECHACAMBIO() {
        return TPPA_FECHACAMBIO;
    }

    public void setTPPA_FECHACAMBIO(String TPPA_FECHACAMBIO) {
        this.TPPA_FECHACAMBIO = TPPA_FECHACAMBIO;
    }

    public int getTPPA_ID() {
        return TPPA_ID;
    }

    public void setTPPA_ID(int TPPA_ID) {
        this.TPPA_ID = TPPA_ID;
    }

    public int getTPPA_DURACIONSEMANAS() {
        return TPPA_DURACIONSEMANAS;
    }

    public void setTPPA_DURACIONSEMANAS(int TPPA_DURACIONSEMANAS) {
        this.TPPA_DURACIONSEMANAS = TPPA_DURACIONSEMANAS;
    }
}
