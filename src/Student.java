import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.1
 */
public class Student {

    private String name;
    private String id;
    private LocalDateTime enterTime;
    private LocalDateTime exitTime;
    private List<Car> cars;

    public Student(String nome, String id) {
        this.name = name;
        this.id = id;
        this.cars = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void enter(){
        this.enterTime = LocalDateTime.now();
    }

    public void exit(){
        this.exitTime = LocalDateTime.now();
    }

    public double calculateParkingFee(){
        Duration duration = Duration.between(enterTime, exitTime);
        long minutes = duration.toMinutes();
        return (double) minutes / ParkingManagement.TIME_INTERVAL * ParkingManagement.PARKING_FEE;
        /*
            public static final double PARKING_FEE = 0.1;
            public static final double TIME_INTERVAL = 15.0;

            !!! This two constants must be declared in ParkingManagement.java for this method to work
         */
    }

    public void saveParkingDetailsToFile(){
        // Format the output details
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyyy HH:mm");
        String enterFormatted = enterTime.format(formatter);
        String exitFormatted = exitTime.format(formatter);
        Duration duration = Duration.between(enterTime, exitTime);
        double hoursSpent = (double) duration.toMinutes();
        double totalAmountToPay = calculateParkingFee();
        String filename = name + ".text";

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


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", cars=" + cars +
                '}';
    }
}