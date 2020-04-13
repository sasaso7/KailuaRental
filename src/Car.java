public class Car {
    private int carId;
    private String brand;
    private String fuel;
    private String regNumber;
    private String regYear;
    private String odometer;
    public CarType carType;

    public Car(int carId, String brand, String fuel, String regNumber, String regYear, String odometer, CarType carType) {
        this.carId = carId;
        this.brand = brand;
        this.fuel = fuel;
        this.regNumber = regNumber;
        this.regYear = regYear;
        this.odometer = odometer;
        this.carType = carType;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    //Getters
    public String getBrand() {
        return brand;
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