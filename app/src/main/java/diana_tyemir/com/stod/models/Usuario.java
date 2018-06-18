package diana_tyemir.com.stod.models;

import java.sql.Date;

public class Usuario {

    int id;
    String token, nombre, email, pass;
    Date registrado;

    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Date getRegistrado() {
        return registrado;
    }

    public void setRegistrado(Date registrado) {
        this.registrado = registrado;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", token='" + token + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                ", registrado=" + registrado +
                '}';
    }
}
