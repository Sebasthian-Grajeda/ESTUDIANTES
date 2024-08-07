import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        GestionEstudiantes gestionEstudiantes = new GestionEstudiantes();
        RegistroAsistencia registroAsistencia = new RegistroAsistencia();

        // Crear estudiantes
        Estudiante estudiante1 = new Estudiante("Sebasthian", "Grajeda", "001", "Ingeniería", 3);
        Estudiante estudiante2 = new Estudiante("Ana", "Vasquez", "002", "Administracion", 9);

        // Agregar estudiantes
        gestionEstudiantes.agregarEstudiante(estudiante1);
        gestionEstudiantes.agregarEstudiante(estudiante2);

        Asistencia asistencia1 = new Asistencia(estudiante1, LocalDateTime.now(), LocalDateTime.of(2024, 7, 18, 8, 0), LocalDateTime.of(2024, 7, 28, 10, 0), "ausente");
        Asistencia asistencia2 = new Asistencia(estudiante2, LocalDateTime.now(), LocalDateTime.of(2024, 7, 15, 8, 0), LocalDateTime.of(2024, 7, 28, 10, 0), "ausente");
        Asistencia asistencia3 = new Asistencia(estudiante2, LocalDateTime.now(), LocalDateTime.of(2024, 7, 15, 8, 0), LocalDateTime.of(2024, 7, 28, 10, 0), "presente");
        Asistencia asistencia4 = new Asistencia(estudiante2, LocalDateTime.now(), LocalDateTime.of(2024, 7, 15, 8, 0), LocalDateTime.of(2024, 7, 28, 10, 0), "presente");

        registroAsistencia.registrarAsistencia(asistencia1);
        registroAsistencia.registrarAsistencia(asistencia2);

        List<Asistencia> todasAsistencias = registroAsistencia.consultarHistorialAsistencia("001");
        Map<String, Double> porcentajeAsistencia = GeneracionReportes.generarPorcentajeAsistencia(todasAsistencias, gestionEstudiantes);
        Map<String, Integer> ausencias = GeneracionReportes.estudiantesConMasAusencias(todasAsistencias);

        // Mostrar informes
        System.out.println("Porcentaje de asistencia por estudiante: " + porcentajeAsistencia);
        System.out.println("Estudiantes con más ausencias: " + ausencias);
    }
}
