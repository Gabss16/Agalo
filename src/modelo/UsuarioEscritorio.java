package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jero
 */
public class UsuarioEscritorio {
   
    private String Nombre; 
    private String Usuario;
    private String Correo;
    private String Contrasena;
   
    // Getters y Setters

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }
   
    public void GuardarUsuario() {
        // Obtenemos la conexión
        Connection conexion = ClaseConexion.getConexion();
        PreparedStatement addUsuarioEscritorio = null;

        try {
            // Ajuste en la sintaxis de la consulta
            String sql = "INSERT INTO UsuarioEscritorio (Nombre, Usuario, CorreoElectronico, Contrasena) VALUES (?, ?, ?, ?)";
            addUsuarioEscritorio = conexion.prepareStatement(sql);
            addUsuarioEscritorio.setString(1, getNombre());
            addUsuarioEscritorio.setString(2, getUsuario());
            addUsuarioEscritorio.setString(3, getCorreo());
            addUsuarioEscritorio.setString(4, getContrasena());

            // Ejecutar la consulta
            addUsuarioEscritorio.executeUpdate();
            System.out.println("Usuario guardado correctamente.");
            
        } catch (SQLException ex) {
            System.out.println("Error en el método GuardarUsuario: " + ex.getMessage());
            ex.printStackTrace(); // Para más detalles del error

        } finally {
            // Cerrar recursos
            try {
                if (addUsuarioEscritorio != null) addUsuarioEscritorio.close();
                if (conexion != null) conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar recursos: " + ex.getMessage());
            }
        }
    }
       
    // Método para iniciar sesión
    public boolean iniciarSesion() {
        Connection conexion = ClaseConexion.getConexion();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        boolean resultado = false;

        try {
            String sql = "SELECT * FROM UsuarioEscritorio WHERE Correo = ? AND Contrasena = ?";
            statement = conexion.prepareStatement(sql);
            statement.setString(1, getCorreo());
            statement.setString(2, getContrasena());

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                resultado = true;
            }

        } catch (SQLException ex) {
            System.out.println("Error en el método iniciarSesion: " + ex.getMessage());
            ex.printStackTrace(); // Para más detalles del error

        } finally {
            // Cerrar recursos
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (conexion != null) conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar recursos: " + ex.getMessage());
            }
        }

        return resultado;
    }
}
