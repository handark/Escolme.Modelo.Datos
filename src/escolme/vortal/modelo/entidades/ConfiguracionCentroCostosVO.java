package escolme.vortal.modelo.entidades;

/**
 *
 * @author Jose Luis Orozco Mejia
 */
public class ConfiguracionCentroCostosVO {
    
    private long concencos_id;
    private String  concencos_nombre;
    private int concencos_estado;
    
    public static class Definiciones{   
        public final String campoConcencos_id = "concuecon_id";
        public final String campoConcencos_nombre = "concuecon_nombre";
        public final String campoConcencos_estado = "concencos_estado";
        public final String tabla = "configuracion_centrocostos";
        public final String esquema = "campusadmin";
        public String getTabla(){
            return esquema + "." + tabla;
        }
        public String getCampos(){
            return String.format("%s,%s,%s", campoConcencos_id,campoConcencos_nombre,campoConcencos_estado);
        }
    }

    /**
     * @return the concencos_id
     */
    public long getConcencos_id() {
        return concencos_id;
    }

    /**
     * @param concencos_id the concencos_id to set
     */
    public void setConcencos_id(long concencos_id) {
        this.concencos_id = concencos_id;
    }

    /**
     * @return the concencos_nombre
     */
    public String getConcencos_nombre() {
        return concencos_nombre;
    }

    /**
     * @param concencos_nombre the concencos_nombre to set
     */
    public void setConcencos_nombre(String concencos_nombre) {
        this.concencos_nombre = concencos_nombre;
    }

    /**
     * @return the concencos_estado
     */
    public int getConcencos_estado() {
        return concencos_estado;
    }

    /**
     * @param concencos_estado the concencos_estado to set
     */
    public void setConcencos_estado(int concencos_estado) {
        this.concencos_estado = concencos_estado;
    }
    
}
