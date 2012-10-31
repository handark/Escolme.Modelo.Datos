package escolme.vortal.modelo.entidades;

import java.sql.Date;

/**
 *
 * @author Jose Luis Orozco Mejia
 */
public class FacturasVO {

    private long fac_id;
    private long  fac_secuencia;
    private int fac_tipopersona;
    private String fac_nombrepersona;
    private String fac_identificacionpersona;
    private int conranven_dias;
    private int fac_estado;
    private long fac_total;
    private long fac_saldo;
    private Date fac_fechafactura;
    private long contipdoc_id;
    private long conforpag_id;
    
    private String fac_tipopersonatexto;
    private String contipdoc_nombre;
    private String fac_estadotexto;
    
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

    public int getFac_tipopersona() {
        return fac_tipopersona;
    }

    public void setFac_tipopersona(int fac_tipopersona) {
        this.fac_tipopersona = fac_tipopersona;
    }

    public String getFac_nombrepersona() {
        return fac_nombrepersona;
    }

    public void setFac_nombrepersona(String fac_nombrepersona) {
        this.fac_nombrepersona = fac_nombrepersona;
    }

    public String getFac_identificacionpersona() {
        return fac_identificacionpersona;
    }

    public void setFac_identificacionpersona(String fac_identificacionpersona) {
        this.fac_identificacionpersona = fac_identificacionpersona;
    }

    public int getConranven_dias() {
        return conranven_dias;
    }

    public void setConranven_dias(int conranven_dias) {
        this.conranven_dias = conranven_dias;
    }

    public int getFac_estado() {
        return fac_estado;
    }

    public void setFac_estado(int fac_estado) {
        this.fac_estado = fac_estado;
    }

    public long getFac_total() {
        return fac_total;
    }

    public void setFac_total(long fac_total) {
        this.fac_total = fac_total;
    }

    public Date getFac_fechafactura() {
        return fac_fechafactura;
    }

    public void setFac_fechafactura(Date fac_fechafactura) {
        this.fac_fechafactura = fac_fechafactura;
    }

    public long getContipdoc_id() {
        return contipdoc_id;
    }

    public void setContipdoc_id(long contipdoc_id) {
        this.contipdoc_id = contipdoc_id;
    }

    public String getFac_tipopersonatexto() {
        return fac_tipopersonatexto;
    }

    public void setFac_tipopersonatexto(String fac_tipopersonatexto) {
        this.fac_tipopersonatexto = fac_tipopersonatexto;
    }

    public long getFac_saldo() {
        return fac_saldo;
    }

    public void setFac_saldo(long fac_saldo) {
        this.fac_saldo = fac_saldo;
    }

    public long getConforpag_id() {
        return conforpag_id;
    }

    public void setConforpag_id(long conforpag_id) {
        this.conforpag_id = conforpag_id;
    }

    public String getContipdoc_nombre() {
        return contipdoc_nombre;
    }

    public void setContipdoc_nombre(String contipdoc_nombre) {
        this.contipdoc_nombre = contipdoc_nombre;
    }

    public String getFac_estadotexto() {
        return fac_estadotexto;
    }

    public void setFac_estadotexto(String fac_estadotexto) {
        this.fac_estadotexto = fac_estadotexto;
    }
}
