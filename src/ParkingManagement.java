import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;


public class ParkingManagement {
    private int capacity;
    private List<Student> parkedStudents;

    public ParkingManagement(int capacity) {
        this.capacity = capacity;
        this.parkedStudents = new ArrayList<>();

    }

    public void enter(Student student) {
        if (parkedStudents.size() < capacity) {
            // student.enterPark(); //! implement enterPark() on class student
            parkedStudents.add(student);
        } else {
            System.out.println("Parking lot full");
        }
    }

    public void exit(Student student) {
        if (parkedStudents.contains(student)) {
            // student.exitPark();//! implement exitPark() on class student
            parkedStudents.remove(student);

        } else {
            System.out.println(" not found ");
        }
    }
}
