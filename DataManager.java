import java.util.LinkedList;
import java.util.Queue;

public class DataManager {

    // Linked Lists
    private LinkedList<Course> courses;
    private LinkedList<Teacher> teachers;
    private LinkedList<Room> rooms;

    // Queue for scheduling
    private Queue<Course> courseQueue;

    public DataManager() {
        courses = new LinkedList<>();
        teachers = new LinkedList<>();
        rooms = new LinkedList<>();
        courseQueue = new LinkedList<>();
    }

    // Add Course
    public void addCourse(Course course) {
        courses.add(course);
        courseQueue.offer(course);

        System.out.println("✔ Course Added Successfully: " + course.getCourseName());
    }

    // Add Teacher
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);

        System.out.println("✔ Teacher Added Successfully: " + teacher.getTeacherName());
    }

    // Add Room
    public void addRoom(Room room) {
        rooms.add(room);

        System.out.println("✔ Room Added Successfully: " + room.getRoomNumber());
    }

    // Getters
    public LinkedList<Course> getCourses() {
        return courses;
    }

    public LinkedList<Teacher> getTeachers() {
        return teachers;
    }

    public LinkedList<Room> getRooms() {
        return rooms;
    }

    public Queue<Course> getCourseQueue() {
        return courseQueue;
    }

    // Display Courses
    public void displayCourses() {
        System.out.println("\n--- Courses List ---");
        for (Course c : courses) {
            System.out.println(c);
        }
    }

    // Display Teachers
    public void displayTeachers() {
        System.out.println("\n--- Teachers List ---");
        for (Teacher t : teachers) {
            System.out.println(t);
        }
    }

    // Display Rooms
    public void displayRooms() {
        System.out.println("\n--- Rooms List ---");
        for (Room r : rooms) {
            System.out.println(r);
        }
    }
}