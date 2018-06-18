package diana_tyemir.com.stod.models;

public class Enfermedad_Sintoma {
    Enfermedad id_enfermedad;
    Sintoma id_sintoma;

    public Enfermedad_Sintoma() {
    }

    public Enfermedad getId_enfermedad() {
        return id_enfermedad;
    }

    public void setId_enfermedad(Enfermedad id_enfermedad) {
        this.id_enfermedad = id_enfermedad;
    }

    public Sintoma getId_sintoma() {
        return id_sintoma;
    }

    public void setId_sintoma(Sintoma id_sintoma) {
        this.id_sintoma = id_sintoma;
    }

    @Override
    public String toString() {
        return "Enfermedad_Sintoma{" +
                "id_enfermedad=" + id_enfermedad +
                ", id_sintoma=" + id_sintoma +
                '}';
    }
}
