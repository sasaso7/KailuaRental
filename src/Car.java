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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getRegYear() {
        return regYear;
    }

    public void setRegYear(String regYear) {
        this.regYear = regYear;
    }

    public String getOdometer() {
        return odometer;
    }

    public void setOdometer(String odometer) {
        this.odometer = odometer;
    }

    public CarType getCarType() {
        return carType;
    }

    @Override
    public String toString(){
        return String.format ("CarId: %-4s Brand: %-18s Fuel: %-10s RegNumber: %-10s RegYear: %-12s Odometer: %-12s CarType: %-10s", getCarId(), getBrand(),getFuel(),getRegNumber(),getRegYear(),getOdometer(),getCarType());
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }
}