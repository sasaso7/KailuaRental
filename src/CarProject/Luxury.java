import java.util.ArrayList;
import java.util.Scanner;

public class Luxury extends Car{
    private String autoGear;
    private String airCondition;
    private String cruiseControl;
    private String leatherSeats;

    public Luxury(String brand, String model, String fuel, String regNumber, String regYear, String odometer, String autoGear, String airCondition, String cruiseControl, String leatherSeats, ArrayList<Luxury> list){
    super(brand, model, fuel, regNumber, regYear, odometer);
    this.autoGear = autoGear;
    this.airCondition = airCondition;
    this.cruiseControl = cruiseControl;
    this.leatherSeats = leatherSeats;

    list.add(this);
}
    public static void createLuxury(ArrayList<Luxury> list){
        Scanner console = new Scanner(System.in);

        System.out.println("Indtast navnet på bilen:");
        String brand = console.nextLine();
        System.out.println("Indtast model på bilen:");
        String model = console.nextLine();
        System.out.println("Indtast bezintypen på bilen");
        String fuel = console.nextLine();
        System.out.println("Indtast registreringsnummer på bilen");
        String regNumber = console.nextLine();
        System.out.println("Indtast registrerings år på bilen");
        String regYear = console.nextLine();
        System.out.println("Indtast kørte kilometer");
        String odometer = console.nextLine();
        System.out.println("Indtast gear typen");
        String autoGear = console.nextLine();
        System.out.println("Indtast om der er Aircon");
        String airCondition = console.nextLine();
        System.out.println("Indtast om der er aircondition");
        String cruiseControl = console.nextLine();
        System.out.println("Indtast hvilke sæder der er i bilen");
        String leatherSeats = console.nextLine();

        new Luxury(brand, model, fuel, regNumber, regYear, odometer, autoGear, airCondition, cruiseControl, leatherSeats, list);
        FileHandler.luxuryWriteToFile(list);
        System.out.println("Luxury.txt Bil tilføjet!\n");
    }
    @Override
    public String toString(){
        return String.format ("Brand: %s \nModel:%s \nFuel: %s \nRegNumber: %s \nRegYear: %s \nSeats:%s \nGear: %s \nAircondition:%s \nOdometer: %s",getBrand(),getModel(),getFuel(),getRegNumber(),getRegYear(), autoGear, airCondition, cruiseControl, leatherSeats, getOdometer());
    }
    public String getAutoGear() {
        return autoGear;
    }

    public String getAirCondition() {
        return airCondition;
    }

    public String getCruiseControl() {
        return cruiseControl;
    }

    public String getLeatherSeats() {
        return leatherSeats;
    }

    public void setAutoGear(String autoGear) {
        this.autoGear = autoGear;
    }

    public void setAirCondition(String airCondition) {
        this.airCondition = airCondition;
    }

    public void setCruiseControl(String cruiseControl) {
        this.cruiseControl = cruiseControl;
    }

    public void setLeatherSeats(String leatherSeats) {
        this.leatherSeats = leatherSeats;
    }
}
