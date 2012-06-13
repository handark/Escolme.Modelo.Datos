
package escolme.vortal.modelo.entidades;

import java.util.Date;

/**
 * @author Jose Luis Orozco Mejia
 * @since 
 */
public class UsuarioRolVO {

    private long usro_id; //PK
    private String usro_registradopor;
    private Date usro_fechacambio;
    private long usua_id; //Relacion con la tabla usuario
    private long rol_id; //Relacion con la tabla rol

    public long getUsro_id() {
        return usro_id;
    }

    public void setUsro_id(long usro_id) {
        this.usro_id = usro_id;
    }

    public String getUsro_registradopor() {
        return usro_registradopor;
    }

    public void setUsro_registradopor(String usro_registradopor) {
        this.usro_registradopor = usro_registradopor;
    }

    public Date getUsro_fechacambio() {
        return usro_fechacambio;
    }

    public void setUsro_fechacambio(Date usro_fechacambio) {
        this.usro_fechacambio = usro_fechacambio;
    }

    public long getUsua_id() {
        return usua_id;
    }

    public void setUsua_id(long usua_id) {
        this.usua_id = usua_id;
    }

    public long getRol_id() {
        return rol_id;
    }

    public void setRol_id(long rol_id) {
        this.rol_id = rol_id;
    }
    
}
