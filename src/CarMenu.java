import com.sun.security.jgss.GSSUtil;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class CarMenu {
    public static void Menu() throws FileNotFoundException {
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
            System.out.println("|\t     - Kailua Car Rental -    |");
            System.out.println("|Press 1# for Cars                |");
            System.out.println("|Press 2# for Renters             |");
            System.out.println("|Press 3# for Contract            |");
            System.out.println("|Press 4# to exit                 |");
            System.out.println("----------------------------------");

            int menuChoice = console.nextInt();

            switch (menuChoice) {
                case 1:
                    System.out.println("___________________________________________");
                    System.out.println("|\t         - Kailua Car Rental -          |");
                    System.out.println("|Press #1 to print car list                 |");
                    System.out.println("|Press #2 to add a car                      |");
                    System.out.println("|Press #3 to delete a car                   |");
                    System.out.println("|Press #4 to update a car                   |");
                    System.out.println("|Press #0 to return to main menu            |");
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
                            break;
                        case 3:
                            DBaccess.deleteCar(cars);
                            break;
                        case 4:
                            DBaccess.updateCar(cars);
                            break;
                    }
                    break;
                case 2:
                    System.out.println("_____________________________________________ ");
                    System.out.println("|\t        - Kailua Car Rental -             |");
                    System.out.println("|Press #1 to print renters list               |");
                    System.out.println("|Press #2 to add new renter                   |");
                    System.out.println("|Press #3 to delete existing renter           |");
                    System.out.println("|Press #0 to return to main menu              |");
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

                            break;
                        case 3:
                            DBaccess.deleteRenter(renters);
                    }
                    break;

                case 3:
                    System.out.println("_________________________________________ ");
                    System.out.println("|\t          - Kailua Car Rental -      |");
                    System.out.println("|Press #1 to print contract list         |");
                    System.out.println("|Press #2 to add new contract            |");
                    System.out.println("|Press #3 to update a contract           |");
                    System.out.println("|Press #4 to delete existing contract    |");
                    System.out.println("|Press #0 to return to main menu         |");
                    System.out.println("-----------------------------------------");
                    int menuChoice4 = console.nextInt();
                    switch (menuChoice4) { //Nested Switch for Contract
                        case 1:
                            for (Contract co : contracts) {
                                System.out.println(co);
                            }
                            break;
                        case 2:
                            DBaccess.createContract(renters, cars, carTypes, contracts);
                            break;
                        case 3:
                            DBaccess.contractEdit(contracts, cars);
                            break;
                        case 4:
                            DBaccess.deleteContract(contracts);
                    }

                    break;
                case 4:
                    isRunning = false;
                    System.out.println("Windows sound - Shutting down");
                    break;
            }

        } while (isRunning);

    }
}
