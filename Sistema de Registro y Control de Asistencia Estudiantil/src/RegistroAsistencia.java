import java.util.ArrayList;
import java.util.List;

public class RegistroAsistencia {
    private List<Asistencia> asistencias;

    public RegistroAsistencia() {
        asistencias = new ArrayList<>();
    }

    public void registrarAsistencia(Asistencia asistencia) {
        asistencias.add(asistencia);
    }

    public List<Asistencia> consultarHistorialAsistencia(String numeroIdentificacion) {
        List<Asistencia> historial = new ArrayList<>();
        for (Asistencia asistencia : asistencias) {
            if (asistencia.getEstudiante().getNumeroIdentificacion().equals(numeroIdentificacion)) {
                historial.add(asistencia);
            }
        }
        return historial;
    }
}
