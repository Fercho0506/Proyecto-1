package Activities;

import Users.Student;

import java.util.List;

public class Task extends Activity {
    private String taskText; // Texto de la tarea

    // Constructor
    public Task(String description, String objective, String difficultyLevel, int durationInMinutes, boolean mandatory, List<Activity> prerequisites, List<Activity> recommendedFollowUps, String activityType, String taskText) {
        super(description, objective, difficultyLevel, durationInMinutes, mandatory, prerequisites, recommendedFollowUps, activityType);
        this.taskText = taskText; // Inicializa el texto de la tarea
    }

    // Verifica si la tarea ha sido completada por el estudiante
    @Override
    public boolean isCompletedByStudent(Student student) {
        // Aquí podrías implementar la lógica para verificar si el estudiante ha completado la tarea
        // Por ahora, retornamos false como un marcador de posición
        return false;
    }

    // Obtiene el texto de la tarea
    public String getTaskText() {
        return taskText;
    }

    // Establece el texto de la tarea
    public void setTaskText(String taskText) {
        this.taskText = taskText;
    }

    // Método para proporcionar detalles de la tarea
    public String getDetails() {
        return "Tarea: " + taskText + "\n" +
                "Descripción: " + getDescription() + "\n" +
                "Objetivo: " + getObjective() + "\n" +
                "Dificultad: " + getDifficultyLevel() + "\n" +
                "Duración: " + getDurationInMinutes() + " minutos" + "\n" +
                "Obligatoria: " + (isMandatory() ? "Sí" : "No");
    }
}
