package LearningPaths;

import Activities.Activity;
import Users.Student;
import Users.Teacher;
import Users.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LearningPathSystem {
    private List<LearningPath> learningPaths; // Almacena todos los Learning Paths

    public LearningPathSystem() {
        this.learningPaths = new ArrayList<>();
    }

    public LearningPath createLearningPath(User user, String title, String description, String objectives, String difficultyLevel, int durationInMinutes, double rating, LocalDate creationDate, LocalDate modificationDate, int version, List<Activity> activities) {
        if (user instanceof Teacher) {
            Teacher teacher = (Teacher) user;

            // Verificar si ya existe un Learning Path con el mismo título
            if (getLearningPathByTitle(title) != null) {
                throw new IllegalArgumentException("Ya existe un Learning Path con este título.");
            }

            LearningPath learningPath = new LearningPath(
                    title, description, objectives, difficultyLevel, durationInMinutes, rating,
                    creationDate, modificationDate, version, activities, teacher
            );
            learningPaths.add(learningPath); // Añadir a la lista
            return learningPath;
        } else {
            throw new IllegalArgumentException("Solo los profesores pueden crear Learning Paths.");
        }
    }

    public void enrollInLearningPath(User user, String title) {
        if (user instanceof Student) {
            Student student = (Student) user;
            LearningPath learningPath = getLearningPathByTitle(title);

            if (learningPath != null) {
                student.enroll(learningPath);
                System.out.println("Te has inscrito en el Learning Path: " + learningPath.getTitle());
            } else {
                throw new IllegalArgumentException("Learning Path no encontrado.");
            }
        } else {
            throw new IllegalArgumentException("Solo los estudiantes pueden inscribirse en Learning Paths.");
        }
    }

    public void addActivityToLearningPath(User user, LearningPath learningPath, Activity activity) {
        if (user instanceof Teacher) {
            Teacher teacher = (Teacher) user;
            teacher.addActivityToLearningPath(learningPath, activity);
        } else {
            throw new IllegalArgumentException("Solo los profesores pueden añadir actividades a Learning Paths.");
        }
    }

    public List<LearningPath> listLearningPaths() {
        return new ArrayList<>(learningPaths); // Devuelve una copia de la lista
    }

    public LearningPath getLearningPathByTitle(String title) {
        for (LearningPath path : learningPaths) {
            if (path.getTitle().equalsIgnoreCase(title)) {
                return path;
            }
        }
        return null; // Si no se encuentra, se devuelve null
    }
}
