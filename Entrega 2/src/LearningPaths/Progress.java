package LearningPaths;

import Activities.Activity;
import Users.Student;
import java.util.Date;

public class Progress {
    private Student student;
    private LearningPath learningPath;
    private Activity activity;
    private Date startDate;
    private Date endDate;
    private boolean completed;
    private float percentage;

    public Progress(Student student, LearningPath learningPath, Activity activity, Date startDate, Date endDate, boolean completed, float percentage) {
        this.student = student;
        this.learningPath = learningPath;
        this.activity = activity;
        this.startDate = startDate;
        this.endDate = endDate;
        this.completed = completed;
        this.percentage = percentage;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public LearningPath getLearningPath() {
        return learningPath;
    }

    public void setLearningPath(LearningPath learningPath) {
        this.learningPath = learningPath;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Date getStartDate() {
        return startDate;
    }
}
