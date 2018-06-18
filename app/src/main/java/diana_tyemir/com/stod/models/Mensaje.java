package diana_tyemir.com.stod.models;

import java.sql.Date;

public class Mensaje {
    int id;
    String mensaje;
    Usuario id_usuario;
    Date fecha;
    SalaChat id_chat;


    public Mensaje() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public SalaChat getId_chat() {
        return id_chat;
    }

    public void setId_chat(SalaChat id_chat) {
        this.id_chat = id_chat;
    }

    @Override
    public String toString() {
        return "Mensaje{" +
                "id=" + id +
                ", mensaje='" + mensaje + '\'' +
                ", id_usuario=" + id_usuario +
                ", fecha=" + fecha +
                ", id_chat=" + id_chat +
                '}';
    }
}
