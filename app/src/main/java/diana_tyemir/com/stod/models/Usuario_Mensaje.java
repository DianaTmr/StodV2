package diana_tyemir.com.stod.models;

public class Usuario_Mensaje {
    Usuario id_usuario;
    Mensaje id_mensaje;


    public Usuario_Mensaje() {
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Mensaje getId_mensaje() {
        return id_mensaje;
    }

    public void setId_mensaje(Mensaje id_mensaje) {
        this.id_mensaje = id_mensaje;
    }

    @Override
    public String toString() {
        return "Usuario_Mensaje{" +
                "id_usuario=" + id_usuario +
                ", id_mensaje=" + id_mensaje +
                '}';
    }
}
