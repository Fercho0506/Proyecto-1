package Activities;

import Users.Student;

import java.util.List;

public class Quiz extends Activity {
    private List<Question> questions; // Lista de preguntas del quiz
    private double passingGrade; // Calificación necesaria para aprobar

    // Constructor
    public Quiz(String description, String objective, String difficultyLevel, int durationInMinutes, boolean mandatory, List<Activity> prerequisites, List<Activity> recommendedFollowUps, String activityType, List<Question> questions, double passingGrade) {
        super(description, objective, difficultyLevel, durationInMinutes, mandatory, prerequisites, recommendedFollowUps, activityType);
        this.questions = questions; // Inicializa la lista de preguntas
        this.passingGrade = passingGrade; // Inicializa la calificación de aprobación
    }

    // Getter para obtener las preguntas
    public List<Question> getQuestions() {
        return questions;
    }

    // Getter para obtener la calificación de aprobación
    public double getPassingGrade() {
        return passingGrade;
    }

    // Método para verificar si el quiz ha sido completado por el estudiante
    @Override
    public boolean isCompletedByStudent(Student student) {
        // Lógica para determinar si el quiz fue completado (por ahora retorna falso)
        return false;
    }
}
