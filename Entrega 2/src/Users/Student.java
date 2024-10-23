package Users;

import Activities.Quiz;
import LearningPaths.LearningPath;
import java.util.List;

public class Student extends User {

    public Student(String id, String name, String email, String password) {
        super(id, name, email, password, STUDENT_ROLE);
    }

    public double getQuizResults(Quiz quiz) {
        return 0.0;
    }
}