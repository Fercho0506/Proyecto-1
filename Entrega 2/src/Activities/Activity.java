package Activities;

import Users.Student;

import java.time.LocalDate;
import java.util.List;

public abstract class Activity {
    private String description;             // Descripción de la actividad
    private String objective;               // Objetivo de la actividad
    private String difficultyLevel;         // Nivel de dificultad de la actividad
    private int durationInMinutes;          // Duración en minutos de la actividad
    private boolean mandatory;               // Indica si la actividad es obligatoria
    private List<Activity> prerequisites;   // Lista de actividades previas necesarias
    private LocalDate deadline;              // Fecha límite para completar la actividad
    private List<Activity> recommendedFollowUps; // Actividades recomendadas a seguir
    private String activityType;            // Tipo de actividad

    // Constructor
    public Activity(String description, String objective, String difficultyLevel, int durationInMinutes, boolean mandatory,
                    List<Activity> prerequisites, List<Activity> recommendedFollowUps, String activityType) {
        this.description = description;                       // Inicializa la descripción
        this.objective = objective;                           // Inicializa el objetivo
        this.difficultyLevel = difficultyLevel;               // Inicializa el nivel de dificultad
        this.durationInMinutes = durationInMinutes;           // Inicializa la duración
        this.mandatory = mandatory;                            // Inicializa si es obligatoria
        this.prerequisites = prerequisites;                   // Inicializa las actividades previas
        this.recommendedFollowUps = recommendedFollowUps;     // Inicializa las actividades recomendadas
        this.activityType = activityType;                     // Inicializa el tipo de actividad
    }

    // Método abstracto que debe ser implementado por las subclases para verificar si el estudiante ha completado la actividad
    public abstract boolean isCompletedByStudent(Student student);

    // Getters para acceder a los atributos de la actividad
    public String getDescription() {
        return description;
    }

    public String getObjective() {
        return objective;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public boolean isMandatory() {
        return mandatory;
    }

    public List<Activity> getPrerequisites() {
        return prerequisites;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public List<Activity> getRecommendedFollowUps() {
        return recommendedFollowUps;
    }

    public String getActivityType() {
        return activityType;
    }

    // Setter para la fecha límite
    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }
}
