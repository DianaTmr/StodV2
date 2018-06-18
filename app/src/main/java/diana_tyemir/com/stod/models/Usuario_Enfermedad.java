package diana_tyemir.com.stod.models;

public class Usuario_Enfermedad {

    Usuario id_usuario;
    Enfermedad id_enfermedad;

    public Usuario_Enfermedad() {
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Enfermedad getId_enfermedad() {
        return id_enfermedad;
    }

    public void setId_enfermedad(Enfermedad id_enfermedad) {
        this.id_enfermedad = id_enfermedad;
    }

    @Override
    public String toString() {
        return "Usuario_Enfermedad{" +
                "id_usuario=" + id_usuario +
                ", id_enfermedad=" + id_enfermedad +
                '}';
    }
}
