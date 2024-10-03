/**
 * @author vss
 * @version 1.1
 *
 * Class that represents car objects
 */
public class Car {
    private String brand;
    private String model;
    private String licencePlate;

    /**
     * Constructor
     * @param brand
     * @param model
     * @param licencePlate
     */
    public Car(String brand, String model, String licencePlate) {
        this.brand = brand;
        this.model = model;
        this.licencePlate = licencePlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", licencePlate='" + licencePlate + '\'' +
                '}';
    }
}
