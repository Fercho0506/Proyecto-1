package Users;

import Activities.Activity;
import LearningPaths.LearningPath;

import java.time.LocalDate;
import java.util.List;

public class Teacher extends User {
    public Teacher(String id, String name, String email, String password) {
        super(id, name, email, password, TEACHER_ROLE);
    }

    public LearningPath createLearningPath(String title, String description, String objectives, String difficultyLevel, int durationInMinutes, double rating, LocalDate creationDate, LocalDate modificationDate, int version, List<Activity> activities) {
        return new LearningPath(title, description, objectives, difficultyLevel, durationInMinutes, rating, creationDate, modificationDate, version, activities, this);
    }

    public void addActivityToLearningPath(LearningPath learningPath, Activity activity) {
        learningPath.addActivity(activity);
    }
}
