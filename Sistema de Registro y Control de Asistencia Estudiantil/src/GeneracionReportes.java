import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GeneracionReportes {
    public static Map<String, Double> generarPorcentajeAsistencia(List<Asistencia> asistencias, GestionEstudiantes gestionEstudiantes) {
        Map<String, Double> porcentajeAsistencia = new HashMap<>();
        Map<String, Integer> totalAsistencias = new HashMap<>();
        Map<String, Integer> asistenciasPresentes = new HashMap<>();

        for (Asistencia asistencia : asistencias) {
            String id = asistencia.getEstudiante().getNumeroIdentificacion();
            totalAsistencias.put(id, totalAsistencias.getOrDefault(id, 0) + 1);
            if ("presente".equals(asistencia.getEstado())) {
                asistenciasPresentes.put(id, asistenciasPresentes.getOrDefault(id, 0) + 1);
            }
        }

        for (String id : totalAsistencias.keySet()) {
            double porcentaje = (double) asistenciasPresentes.getOrDefault(id, 0) / totalAsistencias.get(id) * 100;
            porcentajeAsistencia.put(id, porcentaje);
        }

        return porcentajeAsistencia;
    }

    public static Map<String, Integer> estudiantesConMasAusencias(List<Asistencia> asistencias) {
        Map<String, Integer> ausencias = new HashMap<>();

        for (Asistencia asistencia : asistencias) {
            if ("ausente".equals(asistencia.getEstado())) {
                String id = asistencia.getEstudiante().getNumeroIdentificacion();
                ausencias.put(id, ausencias.getOrDefault(id, 0) + 1);
            }
        }

        return ausencias;
    }
}
