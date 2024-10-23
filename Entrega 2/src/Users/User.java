package Users;

import LearningPaths.LearningPath;
import java.util.List;

public class User {
    private String id;
    private String name;
    private String role; // "student" o "teacher"
    private String email;
    private String password;
    private List<LearningPath> enrolledPaths;

    public static final String STUDENT_ROLE = "student";
    public static final String TEACHER_ROLE = "teacher";

    public User(String id, String name, String email, String password, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void enroll(LearningPath path) {
        enrolledPaths.add(path);
    }

    public void unenroll(LearningPath path) {
        enrolledPaths.remove(path);
    }

    public List<LearningPath> getEnrolledPaths() {
        return enrolledPaths;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean login(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }

    public Object getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
