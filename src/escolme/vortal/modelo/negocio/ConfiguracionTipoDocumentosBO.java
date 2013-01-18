package escolme.vortal.modelo.negocio;

import escolme.modelo.ayudas.MensajesAjaxAY;
import escolme.vortal.modelo.entidades.ConfiguracionTipoDocumentosVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfiguracionTipoDocumentosBO
{
  public static List<ConfiguracionTipoDocumentosVO> ListarConfiguracionTipoDocumentosActivos()
  {
    List listaTipodocumento = null;
    Connection c = null;
    try {
      listaTipodocumento = new ArrayList();
      String sql = "SELECT contipdoc_id,contipdoc_nombre,contipdoc_estado,contipdoc_tipooperacion,contipdoc_fijo FROM campusadmin.configuracion_tipodocumentos WHERE contipdoc_estado=1 ORDER BY contipdoc_nombre";
      c = ConexionDB.AbrirConexion();
      PreparedStatement ps = c.prepareStatement(sql);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        listaTipodocumento.add(MapeoTipoDocumentos(rs));
      }

      return listaTipodocumento;
    }
    catch (SQLException ex)
    {
      Logger.getLogger(ConfiguracionTipoDocumentosBO.class.getName()).log(Level.SEVERE, null, ex);

      return listaTipodocumento;
    }
    finally
    {
      ConexionDB.CerrarConexion(c);
      return listaTipodocumento;
    }
    
  }

  public static List<ConfiguracionTipoDocumentosVO> ListarConfiguracionTipoDocumentos()
  {
    List listaTipodocumento = null;
    Connection c = null;
    try {
      listaTipodocumento = new ArrayList();
      String sql = "SELECT contipdoc_id,contipdoc_nombre,contipdoc_estado,contipdoc_tipooperacion,contipdoc_fijo FROM campusadmin.configuracion_tipodocumentos ORDER BY contipdoc_nombre";
      c = ConexionDB.AbrirConexion();
      PreparedStatement ps = c.prepareStatement(sql);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        listaTipodocumento.add(MapeoTipoDocumentos(rs));
      }

      return listaTipodocumento;
    }
    catch (SQLException ex)
    {
      Logger.getLogger(ConfiguracionTipoDocumentosBO.class.getName()).log(Level.SEVERE, null, ex);

      return listaTipodocumento;
    }
    finally
    {
      ConexionDB.CerrarConexion(c);
      return listaTipodocumento;
    }
    
  }

  public static ConfiguracionTipoDocumentosVO MapeoTipoDocumentos(ResultSet rs) throws SQLException
  {
    ConfiguracionTipoDocumentosVO tipodocumento = new ConfiguracionTipoDocumentosVO();
    tipodocumento.setContipdoc_id(rs.getLong("contipdoc_id"));
    tipodocumento.setContipdoc_nombre(rs.getString("contipdoc_nombre"));
    tipodocumento.setContipdoc_estado(rs.getInt("contipdoc_estado"));
    tipodocumento.setContipdoc_tipooperacion(rs.getInt("contipdoc_tipooperacion"));
    tipodocumento.setContipdoc_fijo(rs.getInt("contipdoc_fijo"));
    return tipodocumento;
  }

  public static MensajesAjaxAY GuardarConfiguracionTipoDocumentos(ConfiguracionTipoDocumentosVO tipodocumento) {
    MensajesAjaxAY resultado = null;
    Connection c = null;
    try {
      c = ConexionDB.AbrirConexion();
      PreparedStatement ps = null;
      if (tipodocumento.getContipdoc_id() == 0L) {
        tipodocumento.setContipdoc_id(GenerarNuevoId());
        String sql = "INSERT INTO campusadmin.configuracion_tipodocumentos(contipdoc_id,contipdoc_nombre,contipdoc_estado,contipdoc_tipooperacion,contipdoc_fijo)  VALUES(?,?,?,?,?)";

        ps = c.prepareStatement(sql);
        ps.setLong(1, tipodocumento.getContipdoc_id());
        ps.setString(2, tipodocumento.getContipdoc_nombre());
        ps.setInt(3, tipodocumento.getContipdoc_estado());
        ps.setInt(4, tipodocumento.getContipdoc_tipooperacion());
        ps.setInt(5, tipodocumento.getContipdoc_fijo());
      } else {
        String sql = "UPDATE campusadmin.configuracion_tipodocumentos SET contipdoc_nombre='" + tipodocumento.getContipdoc_nombre() + "',contipdoc_estado=" + String.valueOf(tipodocumento.getContipdoc_estado()) + " contipdoc_tipooperacion=" + String.valueOf(tipodocumento.getContipdoc_tipooperacion()) + " WHERE contipdoc_id=" + String.valueOf(tipodocumento.getContipdoc_id());

        ps = c.prepareStatement(sql);
      }

      ps.executeUpdate();
      resultado = new MensajesAjaxAY();
      resultado.setID(String.valueOf(tipodocumento.getContipdoc_id()));
      resultado.setMENSAJE("Tipo de documento guardado con exito");

      return resultado;
    }
    catch (SQLException ex)
    {
      resultado = new MensajesAjaxAY();
      resultado.setID("0");
      resultado.setMENSAJE("Error: " + ex.getMessage());

      return resultado;
    }
    finally
    {
      ConexionDB.CerrarConexion(c);
      return resultado;
    }
  }

  public static long GenerarNuevoId()
  {
    Connection c = null;
    long resultado = 1L;
    try {
      String sql = "SELECT max(contipdoc_id) AS nuevoid FROM campusadmin.configuracion_tipodocumentos";
      c = ConexionDB.AbrirConexion();
      PreparedStatement ps = c.prepareStatement(sql);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        resultado = rs.getLong("nuevoid") + 1L;
      }

      return resultado;
    }
    catch (SQLException ex)
    {
      return 1L;
    }
    finally {
      ConexionDB.CerrarConexion(c);
      return resultado;
    }
  }
}