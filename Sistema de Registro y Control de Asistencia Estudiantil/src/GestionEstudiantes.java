import java.util.HashMap;
import java.util.Map;

public class GestionEstudiantes {
    private Map<String, Estudiante> estudiantes;

    public GestionEstudiantes() {
        estudiantes = new HashMap<>();
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.put(estudiante.getNumeroIdentificacion(), estudiante);
    }

    public void actualizarEstudiante(Estudiante estudiante) {
        estudiantes.put(estudiante.getNumeroIdentificacion(), estudiante);
    }

    public Estudiante consultarEstudiante(String numeroIdentificacion) {
        return estudiantes.get(numeroIdentificacion);
    }

    public void eliminarEstudiante(String numeroIdentificacion) {
        estudiantes.remove(numeroIdentificacion);
    }
}
