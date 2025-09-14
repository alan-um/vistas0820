package Model;

import java.io.Serializable;

public class Usuario implements Serializable {

    private int dni;
    private String nombre;
    private String usuario;
    private String password;

    public Usuario(int dni, String nombre, String usuario, String password) {
        this.dni = dni;
        this.nombre = nombre;
        this.usuario = usuario;
        this.password = password;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
