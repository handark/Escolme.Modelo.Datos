/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package escolme.academico.modelo.entidades;

/**
 * @author Jose Luis Orozco Mejia
 * @since 07-06-2012
 */
public class PersonaNaturalGeneralAC {
    
    private String PENG_EMAILINSTITUCIONAL;
    private String PENG_PRIMERNOMBRE;
    private String PENG_PRIMERAPELLIDO;
    private String PENG_SEGUNDOAPELLIDO;
    private String PENG_SEGUNDONOMBRE;
    private String PEGE_DOCUMENTOIDENTIDAD;
    private String PEGE_DIRECCION;
    private String PEGE_TELEFONO;
    
    private int PEGE_ID;

    public String getPENG_EMAILINSTITUCIONAL() {
        return PENG_EMAILINSTITUCIONAL;
    }

    public void setPENG_EMAILINSTITUCIONAL(String PENG_EMAILINSTITUCIONAL) {
        this.PENG_EMAILINSTITUCIONAL = PENG_EMAILINSTITUCIONAL;
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

    public int getPEGE_ID() {
        return PEGE_ID;
    }

    public void setPEGE_ID(int PEGE_ID) {
        this.PEGE_ID = PEGE_ID;
    }

    public String getPENG_SEGUNDOAPELLIDO() {
        return PENG_SEGUNDOAPELLIDO;
    }

    public void setPENG_SEGUNDOAPELLIDO(String PENG_SEGUNDOAPELLIDO) {
        this.PENG_SEGUNDOAPELLIDO = PENG_SEGUNDOAPELLIDO;
    }

    public String getPENG_SEGUNDONOMBRE() {
        return PENG_SEGUNDONOMBRE;
    }

    public void setPENG_SEGUNDONOMBRE(String PENG_SEGUNDONOMBRE) {
        this.PENG_SEGUNDONOMBRE = PENG_SEGUNDONOMBRE;
    }

    public String getPEGE_DOCUMENTOIDENTIDAD() {
        return PEGE_DOCUMENTOIDENTIDAD;
    }

    public void setPEGE_DOCUMENTOIDENTIDAD(String PEGE_DOCUMENTOIDENTIDAD) {
        this.PEGE_DOCUMENTOIDENTIDAD = PEGE_DOCUMENTOIDENTIDAD;
    }

    public String getPEGE_DIRECCION() {
        return PEGE_DIRECCION;
    }

    public void setPEGE_DIRECCION(String PEGE_DIRECCION) {
        this.PEGE_DIRECCION = PEGE_DIRECCION;
    }

    public String getPEGE_TELEFONO() {
        return PEGE_TELEFONO;
    }

    public void setPEGE_TELEFONO(String PEGE_TELEFONO) {
        this.PEGE_TELEFONO = PEGE_TELEFONO;
    }
}
