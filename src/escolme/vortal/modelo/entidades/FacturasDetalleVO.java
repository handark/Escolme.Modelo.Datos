package escolme.vortal.modelo.entidades;

/**
 *
 * @author Jose Luis Orozco Mejia
 * @since 30-10-2012
 */
public class FacturasDetalleVO {
    
    private long facdet_id;
    private long fac_id;
    private long fac_secuencia;
    private long conconpag_id;
    private String descripcion;
    private int cantidad;
    private long valor;
    private long descuento;
    private long total;
    
    private String conconpag_nombre;

    public long getFacdet_id() {
        return facdet_id;
    }

    public void setFacdet_id(long facdet_id) {
        this.facdet_id = facdet_id;
    }

    public long getFac_id() {
        return fac_id;
    }

    public void setFac_id(long fac_id) {
        this.fac_id = fac_id;
    }

    public long getFac_secuencia() {
        return fac_secuencia;
    }

    public void setFac_secuencia(long fac_secuencia) {
        this.fac_secuencia = fac_secuencia;
    }

    public long getConconpag_id() {
        return conconpag_id;
    }

    public void setConconpag_id(long conconpag_id) {
        this.conconpag_id = conconpag_id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public long getDescuento() {
        return descuento;
    }

    public void setDescuento(long descuento) {
        this.descuento = descuento;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public String getConconpag_nombre() {
        return conconpag_nombre;
    }

    public void setConconpag_nombre(String conconpag_nombre) {
        this.conconpag_nombre = conconpag_nombre;
    }
    
}
