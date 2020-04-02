import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {

    //Luxury.txt
    public static void luxuryReadFromFile(ArrayList<Luxury> list){
        try {
            Scanner reader = new Scanner(new File("KailuaFiles/Luxury.txt"));

            while(reader.hasNextLine()){
                String line = reader.nextLine();
                String[] split = line.split(",");

                String brand = split[0];
                String model = split[1];
                String fuel = split[2];
                String regNumber = split[3];
                String regYear = split[4];
                String odometer = split[5];
                String autoGear = split[6];
                String airCondition = split[7];
                String cruiseControl = split[8];
                String leatherSeats = split[9];
                new Luxury(brand, model, fuel, regNumber, regYear, odometer, autoGear, airCondition, cruiseControl, leatherSeats, list);
            }
        } catch (FileNotFoundException f) {
            System.out.println("File was not Found");
        }
    }
    public static void luxuryWriteToFile(ArrayList<Luxury> list){
        try{
            PrintStream output = new PrintStream(new File("KailuaFiles/Luxury.txt"));
            for (Luxury l : list){
                output.printf("%s, %s, %s, %s, %s, %s, %s, %s, %s, %s%n", l.getBrand(), l.getModel(), l.getFuel(), l.getRegNumber(), l.getRegYear(), l.getOdometer(), l.getAutoGear(), l.getAirCondition(), l.getCruiseControl(), l.getLeatherSeats()); //Prints Fields
            }
        }catch(FileNotFoundException e){
            System.out.println("File was not found");
        }
    }
}
