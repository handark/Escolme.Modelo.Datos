package escolme.academico.modelo.entidades;

/**
 * @author Jose Luis Orozco Mejia
 * @since 13-06-2012
 */
public class EstudiantePensumAC {

    private long PEGE_ID;
    private String ESTP_CODIGOMATRICULA;
    private long CATE_ID;
    private long ESTP_PERIODOACADEMICO;
    private long UNPR_ID;
    
    
    //Relacion con PERSONAGENERAL
    private String PEGE_DOCUMENTOIDENTIDAD; 
    private String PEGE_MAIL;
    
    //Relacion con PERSONANATURALGENERAL
    private String PENG_PRIMERNOMBRE; 
    private String PENG_PRIMERAPELLIDO;
    private String PENG_SEGUNDOAPELLIDO;

    public long getPEGE_ID() {
        return PEGE_ID;
    }

    public void setPEGE_ID(long PEGE_ID) {
        this.PEGE_ID = PEGE_ID;
    }

    public String getPEGE_DOCUMENTOIDENTIDAD() {
        return PEGE_DOCUMENTOIDENTIDAD;
    }

    public void setPEGE_DOCUMENTOIDENTIDAD(String PEGE_DOCUMENTOIDENTIDAD) {
        this.PEGE_DOCUMENTOIDENTIDAD = PEGE_DOCUMENTOIDENTIDAD;
    }

    public String getPEGE_MAIL() {
        return PEGE_MAIL;
    }

    public void setPEGE_MAIL(String PEGE_MAIL) {
        this.PEGE_MAIL = PEGE_MAIL;
    }

    public String getPENG_PRIMERNOMBRE() {
        return PENG_PRIMERNOMBRE;
    }

    public void setPENG_PRIMERNOMBRE(String PENG_PRIMERNOMBRE) {
        this.PENG_PRIMERNOMBRE = PENG_PRIMERNOMBRE;
    }

    public String getPENG_PRIMERAPELLIDO() {
        return PENG_PRIMERAPELLIDO;
    }

    public void setPENG_PRIMERAPELLIDO(String PENG_PRIMERAPELLIDO) {
        this.PENG_PRIMERAPELLIDO = PENG_PRIMERAPELLIDO;
    }

    public String getPENG_SEGUNDOAPELLIDO() {
        return PENG_SEGUNDOAPELLIDO;
    }

    public void setPENG_SEGUNDOAPELLIDO(String PENG_SEGUNDOAPELLIDO) {
        this.PENG_SEGUNDOAPELLIDO = PENG_SEGUNDOAPELLIDO;
    }

    public String getESTP_CODIGOMATRICULA() {
        return ESTP_CODIGOMATRICULA;
    }

    public void setESTP_CODIGOMATRICULA(String ESTP_CODIGOMATRICULA) {
        this.ESTP_CODIGOMATRICULA = ESTP_CODIGOMATRICULA;
    }

    public long getCATE_ID() {
        return CATE_ID;
    }

    public void setCATE_ID(long CATE_ID) {
        this.CATE_ID = CATE_ID;
    }

    public long getESTP_PERIODOACADEMICO() {
        return ESTP_PERIODOACADEMICO;
    }

    public void setESTP_PERIODOACADEMICO(long ESTP_PERIODOACADEMICO) {
        this.ESTP_PERIODOACADEMICO = ESTP_PERIODOACADEMICO;
    }

    public long getUNPR_ID() {
        return UNPR_ID;
    }

    public void setUNPR_ID(long UNPR_ID) {
        this.UNPR_ID = UNPR_ID;
    }
}
