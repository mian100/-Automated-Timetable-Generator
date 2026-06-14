import java.util.Queue;

public class TimetableGenerator {

    private String[][] timetable;

    private String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    private String[] slots = {"9-10", "10-11", "11-12", "12-1"};

    public TimetableGenerator() {
        timetable = new String[5][4];
    }

    public void generateTimetable(DataManager dataManager,
                                  ConflictManager conflictManager) {

        // CHECK 1: Rooms empty
        if (dataManager.getRooms().isEmpty()) {
            System.out.println("ERROR: No rooms available! Please add rooms first.");
            return;
        }

        //  CHECK 2: Courses empty
        if (dataManager.getCourseQueue().isEmpty()) {
            System.out.println("ERROR: No courses available! Please add courses first.");
            return;
        }

        Queue<Course> queue = dataManager.getCourseQueue();

        int roomIndex = 0;
        int roomSize = dataManager.getRooms().size();

        // Reset timetable each time generate is called
        clearTimetable();

        for (int i = 0; i < days.length; i++) {

            for (int j = 0; j < slots.length; j++) {

                if (queue.isEmpty()) {
                    return;
                }

                Course course = queue.poll();

                Room room = dataManager.getRooms().get(roomIndex % roomSize);

                String key = days[i] + "-" + slots[j];

                // Conflict check
                if (!conflictManager.hasConflict(key)) {

                    String entry = course.getCourseName()
                            + " | "
                            + course.getTeacherName()
                            + " | Room "
                            + room.getRoomNumber();

                    timetable[i][j] = entry;

                    conflictManager.assignSlot(key, entry);

                    roomIndex++;
                } else {
                    // If conflict occurs, try next slot (simple skip handling)
                    j--;
                }
            }
        }
    }

    // Clear timetable before regeneration
    private void clearTimetable() {
        for (int i = 0; i < days.length; i++) {
            for (int j = 0; j < slots.length; j++) {
                timetable[i][j] = null;
            }
        }
    }

    // Display timetable
    public void displayTimetable() {

        System.out.println("\n========== WEEKLY TIMETABLE ==========\n");

        for (int i = 0; i < days.length; i++) {

            System.out.println(days[i]);

            for (int j = 0; j < slots.length; j++) {

                if (timetable[i][j] == null)
                    System.out.println(slots[j] + " -> Empty");

                else
                    System.out.println(slots[j] + " -> " + timetable[i][j]);
            }

            System.out.println();
        }
    }
}