package LearningPaths;

import Activities.Activity;
import Users.Student;
import Users.Teacher;

import java.time.LocalDate;
import java.util.List;

public class LearningPath {
    private String title;
    private String description;
    private String objectives;
    private String difficultyLevel;
    private int durationInMinutes;
    private double rating;
    private LocalDate creationDate;
    private LocalDate modificationDate;
    private int version;
    private List<Activity> activities;
    private Teacher teacher;

    public LearningPath(String title, String description, String objectives, String difficultyLevel, int durationInMinutes, double rating, LocalDate creationDate, LocalDate modificationDate, int version, List<Activity> activities, Teacher teacher) {
        this.title = title;
        this.description = description;
        this.objectives = objectives;
        this.difficultyLevel = difficultyLevel;
        this.durationInMinutes = durationInMinutes;
        this.rating = rating;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
        this.version = version;
        this.activities = activities;
        this.teacher = teacher;
    }

    public double calculateProgress(Student student) {
        long completedMandatoryActivities = activities.stream()
                .filter(Activity::isMandatory)
                .filter(activity -> activity.isCompletedByStudent(student))
                .count();
        return (double) completedMandatoryActivities / activities.size() * 100;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public void updateActivity(Activity activity) {
        activities.set(activities.indexOf(activity), activity);
    }

    public List<Activity> getActivities() {
        return activities;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getObjectives() {
        return objectives;
    }

    public void setObjectives(String objectives) {
        this.objectives = objectives;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public LocalDate getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(LocalDate modificationDate) {
        this.modificationDate = modificationDate;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Teacher getTeacher() {
        return teacher;
    }
}


