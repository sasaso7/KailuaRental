import com.sun.security.jgss.GSSUtil;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class CarMenu {
    public static void Menu() throws FileNotFoundException{
        Scanner console = new Scanner(System.in);
        boolean isRunning = true;

        ArrayList<CarType> carTypes = new ArrayList();
        DBaccess.getCarType(carTypes);
        ArrayList<Car> cars = new ArrayList();
        ArrayList<Renters> renters = new ArrayList();
        DBaccess.getCars(cars, carTypes);
        DBaccess.getRenters(renters);
        ArrayList<Contract> contracts = new ArrayList();
        DBaccess.getContracts(cars, carTypes, renters, contracts);
        //Contract.createContract(renters, cars, carTypes);

        //formats and prints date at start of the new session
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        System.out.println("\t" + formattedDate);

        do {
            System.out.println("__________________________________");
            System.out.println("|\t   - Kailua Car Rental -     |");
            System.out.println("|Tryk 1# for Cars                |");
            System.out.println("|Tryk 2# for Renters             |");
            System.out.println("|Tryk 3# for Contract            |");
            System.out.println("|Tryk 4# for at lukke programmet |");
            System.out.println("----------------------------------");

            int menuChoice = console.nextInt();

            switch (menuChoice) {
                case 1:
                    System.out.println("___________________________________________");
                    System.out.println("|\t       - Kailua Car Rental -           |");
                    System.out.println("|Tryk #1 for at printe en liste af biler ud|");
                    System.out.println("|Tryk #2 for at tilføje en ny bil          |");
                    System.out.println("|Tryk #0 for at gå tilbage til menu        |");
                    System.out.println("--------------------------------------------");
                    int menuChoice2 = console.nextInt();
                    switch (menuChoice2) { //Nested switch for Cars
                        case 1:
                            for (Car c : cars) {
                                System.out.println(c);
                            }
                            break;
                        case 2:
                            DBaccess.insertCar(cars, carTypes);
                    }
                    break;
                case 2:
                    System.out.println("_____________________________________________ ");
                    System.out.println("|\t        - Kailua Car Rental -            |");
                    System.out.println("|Tryk #1 for at printe en liste af renters ud|");
                    System.out.println("|Tryk #2 for at tilføje en ny renter         |");
                    System.out.println("|Tryk #0 for at vende tilbage til menuen     |");
                    System.out.println("----------------------------------------------");
                    int menuChoice3 = console.nextInt();
                    switch (menuChoice3) { //Nested switch for renters
                        case 1:
                            for (Renters r : renters) {
                                System.out.println(r);
                            }
                            break;
                        case 2:
                            DBaccess.insertRenters(renters);
                    }
                    break;
                case 3:
                    System.out.println("_________________________________________ ");
                    System.out.println("|\t        - Kailua Car Rental -       |");
                    System.out.println("|Tryk #1 for at printe en liste af contracts ud|");
                    System.out.println("|Tryk #2 for at oprette en ny contract  |");
                    System.out.println("|Tryk #0 for at vende tilbage til menuen|");
                    System.out.println("-----------------------------------------");
                    int menuChoice4 = console.nextInt();
                    switch (menuChoice4) { //Nested Switch for Contract
                        case 1:
                            for(Contract co : contracts){
                                System.out.println(co);
                            }
                            break;
                        case 2:
                            DBaccess.createContract(renters, cars, carTypes, contracts);
                            break;
                    }

                    break;
                case 4:
                    isRunning = false;
                    System.out.println("Windows sound - Shutting down");
                    break;
            }

        } while(isRunning);

    }
}