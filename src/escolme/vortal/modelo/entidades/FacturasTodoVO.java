package escolme.vortal.modelo.entidades;

import java.util.List;

/**
 *
 * @author Jose
 */
public class FacturasTodoVO {

    private FacturasVO factura;
    private List<FacturasDetalleVO> detalle;

    public FacturasVO getFactura() {
        return factura;
    }

    public void setFactura(FacturasVO factura) {
        this.factura = factura;
    }

    public List<FacturasDetalleVO> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<FacturasDetalleVO> detalle) {
        this.detalle = detalle;
    }
    
}
