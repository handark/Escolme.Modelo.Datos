package escolme.vortal.modelo.entidades;

/**
 *
 * @author Jose Luis Orozco Mejia
 */
public class ConfiguracionCuentasContablesVO {
    
    private long concuecon_id;
    private String concuecon_nombre;
    
    public static class Definiciones{   
        public final String campoConcuecon_id = "concuecon_id";
        public final String campoConcuecon_nombre = "concuecon_nombre";
        public final String tabla = "configuracion_cuentascontables";
        public final String esquema = "campusadmin";
        public String getTabla(){
            return esquema + "." + tabla;
        }
        public String getCampos(){
            return String.format("%s,%s", campoConcuecon_id,campoConcuecon_nombre);
        }
    }
    
    public long getConcuecon_id() {
        return concuecon_id;
    }

    public void setConcuecon_id(long concuecon_id) {
        this.concuecon_id = concuecon_id;
    }

    public String getConcuecon_nombre() {
        return concuecon_nombre;
    }

    public void setConcuecon_nombre(String concuecon_nombre) {
        this.concuecon_nombre = concuecon_nombre;
    }    
    
}
