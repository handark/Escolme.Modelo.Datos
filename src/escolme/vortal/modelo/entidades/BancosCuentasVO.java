package escolme.vortal.modelo.entidades;

/**
 *
 * @author Jose Luis Orozco Mejia - http://handark.com
 */
public class BancosCuentasVO {
    
    private long bancue_id;
    private String bancue_numero;
    private long bancuetip_id;
    private long ban_id;

    private String bancuetip_nombre;

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
        public final String campoBancue_id = "bancue_id";
        public final String campoBancue_numero = "bancue_numero";
        public final String campoBancuetip_id = "bancuetip_id";
        public final String campoBan_id = "ban_id";
        public final String tabla = "bancos_cuentas";
        public final String esquema = "campusadmin";
        public String getTabla(){
            return esquema + "." + tabla;
        }
        public String getCampos(){
            return String.format("%s,%s,%s,%s", campoBancue_id,campoBancue_numero,campoBancuetip_id,campoBan_id);
        }
    }
    
    /**
     * @return the bancue_id
     */
    public long getBancue_id() {
        return bancue_id;
    }

    /**
     * @param bancue_id the bancue_id to set
     */
    public void setBancue_id(long bancue_id) {
        this.bancue_id = bancue_id;
    }

    /**
     * @return the bancue_numero
     */
    public String getBancue_numero() {
        return bancue_numero;
    }

    /**
     * @param bancue_numero the bancue_numero to set
     */
    public void setBancue_numero(String bancue_numero) {
        this.bancue_numero = bancue_numero;
    }

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
     * @return the ban_id
     */
    public long getBan_id() {
        return ban_id;
    }

    /**
     * @param ban_id the ban_id to set
     */
    public void setBan_id(long ban_id) {
        this.ban_id = ban_id;
    }

}
