import java.util.*;

/**
 * @author jno
 * @version 1.1
 *
 * Class responsible to manage the car park
 */
public class ParkingManagement {
    public static final double PARKING_FEE = 0.1;
    public static final double TIME_INTERVAL = 15.0;
    public static final int CAPACITY = 500;

    private final int capacity;
    private List<Student> parkedStudents;

    /**
     * Constructor
     */
    public ParkingManagement() {
        this.capacity = CAPACITY;
        this.parkedStudents = new ArrayList<>();

    }

    /**
     * Registers student enter
     * @param student
     */
    public void enter(Student student) {
        Student studentAlreadyParked = searchStudent(student.getId());
        if (parkedStudents.size() < capacity && studentAlreadyParked == null) {
            student.enter();
            parkedStudents.add(student);
            System.out.println(student.getName() + " entered the park");
        } else {
            System.out.println("Parking lot full");
        }
    }

    /**
     * Register student exit
     * @param studentNumber
     */
    public void exit(String studentNumber) {
        Student studentFound = searchStudent(studentNumber);
        if (studentFound != null) {
            studentFound.exit();
            parkedStudents.remove(studentFound);
            studentFound.saveParkingDetailsToFile();
            System.out.println(studentFound.getName() + " left the park");
        } else {
            System.out.println("Student is not in the park");
        }
    }

    /**
     * searches for student
     * @param studentNumber
     * @return s student object if found otherwise returns null
     */
    public Student searchStudent(String studentNumber){
        for (Student s : parkedStudents){
            if (s.getId().equals(studentNumber)) {
                return s;
            }
        }
        return null;
    }

}
