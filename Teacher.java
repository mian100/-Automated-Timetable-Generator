public class Teacher {

    private String teacherName;
    private String subject;

    public Teacher(String teacherName, String subject) {
        this.teacherName = teacherName;
        this.subject = subject;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return teacherName + " - " + subject;
    }
}