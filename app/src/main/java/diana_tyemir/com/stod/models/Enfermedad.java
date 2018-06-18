package diana_tyemir.com.stod.models;

public class Enfermedad {

    int id, gravedad;
    String nombre, descripcion;

    public Enfermedad(int id, int gravedad, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.gravedad = gravedad;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGravedad() {
        return gravedad;
    }

    public void setGravedad(int gravedad) {
        this.gravedad = gravedad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Enfermedad{" +
                "id=" + id +
                ", gravedad=" + gravedad +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
