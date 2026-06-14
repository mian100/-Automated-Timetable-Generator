import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        DataManager dataManager = new DataManager();
        ConflictManager conflictManager = new ConflictManager();
        SearchBST bst = new SearchBST();
        TimetableGenerator generator = new TimetableGenerator();

        int choice;

        do {

            System.out.println("\n===== AUTOMATED TIMETABLE SYSTEM =====");
            System.out.println("1. Add Course");
            System.out.println("2. Add Teacher");
            System.out.println("3. Add Room");
            System.out.println("4. Generate Timetable");
            System.out.println("5. Display Timetable");
            System.out.println("6. Search Course");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Course Name: ");
                    String cname = input.nextLine();

                    System.out.print("Credit Hours: ");
                    int ch = input.nextInt();
                    input.nextLine();

                    System.out.print("Teacher Name: ");
                    String tname = input.nextLine();

                    Course c = new Course(cname, ch, tname);
                    dataManager.addCourse(c);

                    // insert into BST for searching
                    bst.insert(cname);

                    break;

                case 2:

                    System.out.print("Teacher Name: ");
                    String tn = input.nextLine();

                    System.out.print("Subject: ");
                    String sub = input.nextLine();

                    dataManager.addTeacher(new Teacher(tn, sub));
                    break;

                case 3:

                    System.out.print("Room Number: ");
                    String rn = input.nextLine();

                    System.out.print("Capacity: ");
                    int cap = input.nextInt();

                    dataManager.addRoom(new Room(rn, cap));
                    break;

                case 4:

                    generator.generateTimetable(dataManager, conflictManager);
                    System.out.println("Timetable Generated Successfully!");
                    break;

                case 5:

                    generator.displayTimetable();
                    break;

                case 6:

                    System.out.print("Enter course name to search: ");
                    String search = input.nextLine();

                    if (bst.search(search))
                        System.out.println("Course FOUND in BST.");
                    else
                        System.out.println("Course NOT FOUND.");

                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        input.close();
    }
}