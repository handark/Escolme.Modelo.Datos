
package escolme.vortal.modelo.entidades;

import java.util.Date;

/**
 * @author Jose Luis Orozco Mejia
 * @since 
 */
public class UsuarioVO {

    private long usua_id;
    private Date usua_fechacambio;
    private String usua_registradopor;
    private long pege_id;
    private String usua_documento;
    private String usua_nombre;
    private String usua_usuario;
    private String usua_contrasena;
    private String usua_tipo;
    private String usua_nick;
    private String usua_preguntasecreta;
    private String usua_respuestapregunta;
    private String usua_estado;
    private long usua_idvortal;

    public long getUsua_id() {
        return usua_id;
    }

    public void setUsua_id(long usua_id) {
        this.usua_id = usua_id;
    }

    public Date getUsua_fechacambio() {
        return usua_fechacambio;
    }

    public void setUsua_fechacambio(Date usua_fechacambio) {
        this.usua_fechacambio = usua_fechacambio;
    }

    public String getUsua_registradopor() {
        return usua_registradopor;
    }

    public void setUsua_registradopor(String usua_registradopor) {
        this.usua_registradopor = usua_registradopor;
    }

    public long getPege_id() {
        return pege_id;
    }

    public void setPege_id(long pege_id) {
        this.pege_id = pege_id;
    }

    public String getUsua_documento() {
        return usua_documento;
    }

    public void setUsua_documento(String usua_documento) {
        this.usua_documento = usua_documento;
    }

    public String getUsua_nombre() {
        return usua_nombre;
    }

    public void setUsua_nombre(String usua_nombre) {
        this.usua_nombre = usua_nombre;
    }

    public String getUsua_usuario() {
        return usua_usuario;
    }

    public void setUsua_usuario(String usua_usuario) {
        this.usua_usuario = usua_usuario;
    }

    public String getUsua_contrasena() {
        return usua_contrasena;
    }

    public void setUsua_contrasena(String usua_contrasena) {
        this.usua_contrasena = usua_contrasena;
    }

    public String getUsua_tipo() {
        return usua_tipo;
    }

    public void setUsua_tipo(String usua_tipo) {
        this.usua_tipo = usua_tipo;
    }

    public String getUsua_nick() {
        return usua_nick;
    }

    public void setUsua_nick(String usua_nick) {
        this.usua_nick = usua_nick;
    }

    public String getUsua_preguntasecreta() {
        return usua_preguntasecreta;
    }

    public void setUsua_preguntasecreta(String usua_preguntasecreta) {
        this.usua_preguntasecreta = usua_preguntasecreta;
    }

    public String getUsua_respuestapregunta() {
        return usua_respuestapregunta;
    }

    public void setUsua_respuestapregunta(String usua_respuestapregunta) {
        this.usua_respuestapregunta = usua_respuestapregunta;
    }

    public String getUsua_estado() {
        return usua_estado;
    }

    public void setUsua_estado(String usua_estado) {
        this.usua_estado = usua_estado;
    }

    public long getUsua_idvortal() {
        return usua_idvortal;
    }

    public void setUsua_idvortal(long usua_idvortal) {
        this.usua_idvortal = usua_idvortal;
    }
    
}
