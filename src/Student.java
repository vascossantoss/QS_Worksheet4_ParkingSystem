import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author gsn
 * @version 1.2
 *
 * Class that represents the student
 */
public class Student {

    private String id;
    private String name;
    private String licencePlate;
    private LocalDateTime enterTime;
    private LocalDateTime exitTime;

    /**
     * Constructor
     * @param id
     * @param name
     * @param licencePlate
     */
    public Student(String id, String name, String licencePlate) {
        this.id = id;
        this.name = name;
        this.licencePlate = licencePlate;
    }

    /**
     *  Get student name
     * @return name Student name
     */
    public String getName() {
        return name;
    }

    /**
     * Get student number
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Registers time student has entered the park
     */
    public void enter(){
        this.enterTime = LocalDateTime.now();
    }

    /**
     * Registers time student has exited the park
     */
    public void exit(){
        this.exitTime = LocalDateTime.now();
    }

    /**
     * Calculates parking fee of student
     * @return value of parking fee
     */
    public double calculateParkingFee(){
        Duration duration = Duration.between(enterTime, exitTime);
        long minutes = duration.toMinutes();
        return (double) minutes / ParkingManagement.TIME_INTERVAL * ParkingManagement.PARKING_FEE;
    }

    /**
     * Saves parking details to file (Entry time, Exit time, Time Spent, Amount to pay)
     */
    public void saveParkingDetailsToFile(){
        // Format the output details
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyyy HH:mm");
        String enterFormatted = enterTime.format(formatter);
        String exitFormatted = exitTime.format(formatter);
        Duration duration = Duration.between(enterTime, exitTime);
        double hoursSpent = (double) duration.toMinutes();
        double totalAmountToPay = calculateParkingFee();
        String filename = "ParkingDetails/" + name + ".txt";

        String parkingDetails = String.format(
                "Parking Details of %s:\nEntry Time: %s\nExit Time: %s\nTime Spent: %.2f minutes\nAmount to Pay: $%.2f\n",
                name, enterFormatted, exitFormatted, hoursSpent, totalAmountToPay
        );

        // Save to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(parkingDetails);
            System.out.println("Parking details saved to file: " + filename);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }


    /**
     * @return student details
     */
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", licencePlate=" + licencePlate +
                '}';
    }
}