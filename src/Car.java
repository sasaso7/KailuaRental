public class Car {
    private String brand;
    private String model;
    private String fuel;
    private String regNumber;
    private String regYear;
    private String odometer;
    private CarType carType;

    public Car(String brand, String model, String fuel, String regNumber, String regYear, String odometer, CarType carType) {
        this.brand = brand;
        this.model = model;
        this.fuel = fuel;
        this.regNumber = regNumber;
        this.regYear = regYear;
        this.odometer = odometer;
        this.carType = carType;

    }

    //Getters
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getFuel() {
        return fuel;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public String getRegYear() {
        return regYear;
    }

    public String getOdometer() {
        return odometer;
    }

    //Setters
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public void setRegYear(String regYear) {
        this.regYear = regYear;
    }

    public void setOdometer(String odometer) {
        this.odometer = odometer;
    }
}