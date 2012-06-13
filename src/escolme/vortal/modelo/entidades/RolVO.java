
package escolme.vortal.modelo.entidades;

import java.util.Date;

/**
 * @author Jose Luis Orozco Mejia
 * @since 
 */
public class RolVO {

    private long rol_id;
    private String rol_nombre;
    private String rol_descripcion;
    private String rol_tipo;
    private Date rol_fechacambio;
    private String rol_registradopor;
    private String rol_estado;
    private String rol_publico;

    public long getRol_id() {
        return rol_id;
    }

    public void setRol_id(long rol_id) {
        this.rol_id = rol_id;
    }

    public String getRol_nombre() {
        return rol_nombre;
    }

    public void setRol_nombre(String rol_nombre) {
        this.rol_nombre = rol_nombre;
    }

    public String getRol_descripcion() {
        return rol_descripcion;
    }

    public void setRol_descripcion(String rol_descripcion) {
        this.rol_descripcion = rol_descripcion;
    }

    public String getRol_tipo() {
        return rol_tipo;
    }

    public void setRol_tipo(String rol_tipo) {
        this.rol_tipo = rol_tipo;
    }

    public Date getRol_fechacambio() {
        return rol_fechacambio;
    }

    public void setRol_fechacambio(Date rol_fechacambio) {
        this.rol_fechacambio = rol_fechacambio;
    }

    public String getRol_registradopor() {
        return rol_registradopor;
    }

    public void setRol_registradopor(String rol_registradopor) {
        this.rol_registradopor = rol_registradopor;
    }

    public String getRol_estado() {
        return rol_estado;
    }

    public void setRol_estado(String rol_estado) {
        this.rol_estado = rol_estado;
    }

    public String getRol_publico() {
        return rol_publico;
    }

    public void setRol_publico(String rol_publico) {
        this.rol_publico = rol_publico;
    }
    
}
