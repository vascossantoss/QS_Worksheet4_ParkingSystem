import java.util.Scanner;

/**
 * @author vss
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {

        // Declare scanners for strings and numbers
        Scanner scanStr = new Scanner(System.in);
        Scanner scanInt = new Scanner(System.in);

        // Instantiate park manager
        ParkingManagement parkManager = new ParkingManagement();

        // Print menu
        System.out.println( "(1) Enter park \n" +
                            "(2) Exit park\n" +
                            "(0) Exit");

        // Selected option
        int op = scanInt.nextInt();

        while (op != 0){
            switch (op){
                case 1:
                    System.out.println("Student number:");
                    String studentNumber = scanStr.next();
                    System.out.println("Student name:");
                    String studentName = scanStr.next();
                    System.out.println("Licence plate:");
                    String licencePlate = scanStr.next();
                    Student s = new Student(studentNumber, studentName, licencePlate);
                    parkManager.enter(s);
                    break;

                case 2:
                    System.out.println("Student number:");
                    studentNumber = scanStr.next();
                    parkManager.exit(studentNumber);
                    break;
                default: System.out.println("Invalid option");
            }

            // Print menu
            System.out.println( "(1) Enter park \n" +
                                "(2) Exit park\n" +
                                "(0) Exit");

            // Selected option
            op = scanInt.nextInt();
        }
    }
}