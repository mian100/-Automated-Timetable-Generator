public class Course {

    private String courseName;
    private int creditHours;
    private String teacherName;

    public Course(String courseName, int creditHours, String teacherName) {
        this.courseName = courseName;
        this.creditHours = creditHours;
        this.teacherName = teacherName;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public String getTeacherName() {
        return teacherName;
    }

    @Override
    public String toString() {
        return courseName + " | Teacher: " + teacherName +
                " | Credit Hours: " + creditHours;
    }

}