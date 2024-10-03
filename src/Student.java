import java.util.ArrayList;
import java.util.List;
public class Student {

    private String name;
    private String id;
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", cars=" + cars +
                '}';
    }
}





