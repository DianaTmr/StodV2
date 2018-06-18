package diana_tyemir.com.stod.models;

class SalaChat {
    int id;
    String nombre;

    public SalaChat() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "SalaChat{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
