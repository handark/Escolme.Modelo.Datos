package escolme.vortal.modelo.entidades;

/**
 *
 * @author Jose Luis Orozco Mejia - http://handark.com
 */
public class BancosCuentasTipoVO {
 
    private long bancuetip_id;
    private String bancuetip_nombre;

    /**
     * @return the bancuetip_id
     */
    public long getBancuetip_id() {
        return bancuetip_id;
    }

    /**
     * @param bancuetip_id the bancuetip_id to set
     */
    public void setBancuetip_id(long bancuetip_id) {
        this.bancuetip_id = bancuetip_id;
    }

    /**
     * @return the bancuetip_nombre
     */
    public String getBancuetip_nombre() {
        return bancuetip_nombre;
    }

    /**
     * @param bancuetip_nombre the bancuetip_nombre to set
     */
    public void setBancuetip_nombre(String bancuetip_nombre) {
        this.bancuetip_nombre = bancuetip_nombre;
    }
    
    public static class Definiciones{   
        public final String campoBancuetip_id = "bancuetip_id";
        public final String campoBancuetip_nombre = "bancuetip_nombre";
        public final String tabla = "bancos_cuentas_tipo";
        public final String esquema = "campusadmin";
        public String getTabla(){
            return esquema + "." + tabla;
        }
        public String getCampos(){
            return String.format("%s,%s", campoBancuetip_id,campoBancuetip_nombre);
        }
    }
}
