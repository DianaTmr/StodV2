package diana_tyemir.com.stod.models;

public class Sintoma {
    int id;
    String nombre;

    public Sintoma(Integer id, String name) {
        this.id = id;
        this.nombre = name;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Sintoma{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
