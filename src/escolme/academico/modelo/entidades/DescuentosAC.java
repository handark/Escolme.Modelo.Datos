/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package escolme.academico.modelo.entidades;

/**
 *
 * @author Jose
 */
public class DescuentosAC {
    
    private float porcentaje_descuento;
    private String descripcion;
    private long descuento_fijo;

    public float getPorcentaje_descuento() {
        return porcentaje_descuento;
    }

    public void setPorcentaje_descuento(float porcentaje_descuento) {
        this.porcentaje_descuento = porcentaje_descuento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the descuento_fijo
     */
    public long getDescuento_fijo() {
        return descuento_fijo;
    }

    /**
     * @param descuento_fijo the descuento_fijo to set
     */
    public void setDescuento_fijo(long descuento_fijo) {
        this.descuento_fijo = descuento_fijo;
    }
    
}
