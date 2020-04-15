import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class DBaccess {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/cars";
    static Connection con;
    static String password = "1234";


        //Nu bliver der lavet getRenters metoden, som skal hive alle renters ud af vores database
        public static void getRenters(ArrayList<Renters> renters){
            try {
                con = null;
                Statement s = null;
                Class.forName(JDBC_DRIVER);

                con = DriverManager.getConnection(DATABASE_URL, "root", password);
                s = con.createStatement();

                ResultSet rs = s.executeQuery("SELECT renter_id, renter_first_name, renter_last_name, renter_phone, renter_mail, renter_adress, renter_city, renter_zip, renter_licence_number, renter_licence_since  FROM renters");
                if (rs != null)
                    //Dette er et while loop, for at køre igennem database tabellen og tilføje data til at arrayliste
                    //som kan bruges i java
                    while (rs.next()) {
                         int renterID = rs.getInt("renter_id");
                         String renterFirstName = rs.getString("renter_first_name");
                         String renterLastName = rs.getString("renter_last_name");
                         String phone = rs.getString("renter_phone");
                         String mail = rs.getString("renter_mail");
                         String address = rs.getString("renter_adress");
                         String city = rs.getString("renter_city");
                         String zip = rs.getString("renter_zip");
                         String licenceNumber = rs.getString("renter_licence_number");
                         Date licenceSince = rs.getDate("renter_licence_since");
                         //nu laves objektet
                         Renters addman = new Renters(renterID, renterFirstName, renterLastName, phone, mail, address, city, zip, licenceNumber, licenceSince);
                        //objektet tilføjes på vores arrayliste
                         renters.add(addman);

                    }
                s.close();
                con.close();

            }
            catch(SQLException sqlex) {
                try {
                    System.out.println(sqlex.getMessage());
                    con.close();
                    System.exit(1);  // terminate program
                }
                catch(SQLException sql){}
            }
            catch (ClassNotFoundException noClass) {
                System.err.println("Driver Class not found");
                System.out.println(noClass.getMessage());
                System.exit(1);  // terminate program
            }
        }
    public static void insertRenters(ArrayList<Renters> renters){
        Scanner in = new Scanner(System.in);
        try {
            con = null;
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(DATABASE_URL, "root", password);

            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());


            String query =  "insert into renters (renter_first_name, renter_last_name, renter_phone, renter_mail, renter_adress, renter_city, renter_zip, renter_licence_number, renter_license_since)" + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStmt = con.prepareStatement(query);

            //Her bestemmes renterID
            int RenterIDCounter = renters.size();
                    int renterID = RenterIDCounter+1;
            System.out.println("Please enter your first name");
                    String a = in.nextLine();
                    preparedStmt.setString (1, a);
            System.out.println("Please enter your last name");
                    String b = in.nextLine();
                    preparedStmt.setString (2, b);
            System.out.println("Please enter your phone");
                    String c = in.nextLine();
                    preparedStmt.setString (3, c);
            System.out.println("Please enter your E-mail");
                    String d = in.nextLine();
                    preparedStmt.setString (4, d);
            System.out.println("Please enter your address");
                    String e = in.nextLine();
                    preparedStmt.setString (5, e);
            System.out.println("Please enter your city");
                    String f = in.nextLine();
                    preparedStmt.setString (6, f);
            System.out.println("Please enter your zip");
                    String g = in.nextLine();
                    preparedStmt.setString (7, g);
            System.out.println("Please enter your driver licence number");
                    String h = in.nextLine();
                    preparedStmt.setString (8, h);
            System.out.println("Please enter when your driver licence got registered in YYYY-MM-DD");
                    String i = in.nextLine();
                    preparedStmt.setString (9, i);

            // execute the preparedstatement
            preparedStmt.execute();

            con.close();

        }
        catch(SQLException sqlex) {
            try {
                System.out.println(sqlex.getMessage());
                con.close();
                System.exit(1);  // terminate program
            }
            catch(SQLException sql){}
        }
        catch (ClassNotFoundException noClass) {
            System.err.println("Driver Class not found");
            System.out.println(noClass.getMessage());
            System.exit(1);  // terminate program
        }
    }

    public static void insertCar(ArrayList<Car> cars, ArrayList<CarType> carTypes){
        Scanner in = new Scanner(System.in);
        try {
            con = null;
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(DATABASE_URL, "root", password);

            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());


            String query =  "insert into car (car_id, car_brand, car_fuel, car_register_number, car_register_date, car_how_much, cartype_id)" + " values (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStmt = con.prepareStatement(query);

            //Her bestemmes renterID
            int carIdCounter = cars.size();
            int carId = carIdCounter+1;
            preparedStmt.setInt(1, carId);

            System.out.println("Please enter the car brand");
            String a = in.nextLine();
            preparedStmt.setString (2, a);
            System.out.println("Please enter the fuel type");
            String b = in.nextLine();
            preparedStmt.setString (3, b);
            System.out.println("Please enter the register number");
            String c = in.nextLine();
            preparedStmt.setString (4, c);
            System.out.println("Please enter enter the register date YYYY-MM-DD");
            String d = in.nextLine();
            preparedStmt.setString (5, d);
            System.out.println("Enter how many kilometers");
            String e = in.nextLine();
            preparedStmt.setString(6, e);

            int typeId = carTypes.size() + 1;
            preparedStmt.setInt(7, typeId);

            // execute the preparedstatement

            String query2 = "insert into cartype (cartype_description, cartype_gear, cartype_motorpower, cartype_cruisecontrol, cartype_aircon, cartype_seats)" + " values (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt2 = con.prepareStatement(query2);

            System.out.printf("Type 1 for Luxury %nType 2 for sport %nType 3 for family%n");
            int choice = in.nextInt();
            in.nextLine();
            switch(choice){
                case 1:
                    preparedStmt2.setString(1,"Luxury");
                    preparedStmt2.setString(2, "Auto");
                    System.out.println("Enter motor power");
                    String aa = in.nextLine();
                    preparedStmt2.setString(3, aa);
                    preparedStmt2.setString(4, "True");
                    preparedStmt2.setString(5, "True");
                    preparedStmt2.setString(6, "Leather");
                    preparedStmt2.execute();
                    CarType typeObj = new CarType(carTypes.size()+1, "Luxury", "Auto", aa, "True", "True", "Leather");
                    carTypes.add(typeObj);
                    preparedStmt.execute();
                    Car obj = new Car(carId, a, b, c, d, e, typeObj);
                    cars.add(obj);

                    break;
                case 2:
                    preparedStmt2.setString(1,"Sport");
                    preparedStmt2.setString(2, "Manual");
                    System.out.println("Enter motor power");
                    String ab = in.nextLine();
                    preparedStmt2.setString(3, ab);
                    preparedStmt2.setString(4, "False");
                    preparedStmt2.setString(5, "False");
                    System.out.println("Enter amount of seats");
                    String ac = in.nextLine();
                    preparedStmt2.setString(6, ac);
                    preparedStmt2.execute();

                    CarType typeObj2 = new CarType(carTypes.size()+1, "Sport", "Manual", ab, "False", "False", ac);
                    carTypes.add(typeObj2);
                    preparedStmt.execute();
                    Car obj2 = new Car(carId, a, b, c, d, e, typeObj2);
                    cars.add(obj2);
                    break;
                case 3:
                    preparedStmt2.setString(1,"Family");
                    preparedStmt2.setString(2, "Manual");
                    System.out.println("Enter motor power");
                    String ad = in.nextLine();
                    preparedStmt2.setString(3, ad);

                    System.out.println("Does the car have cruise control? type 'y/n'");
                    String cruiseControl = in.nextLine();
                    if(cruiseControl.equals("y")){
                        cruiseControl = "True";
                    } else if(cruiseControl.equals("n")){
                        cruiseControl = "False";
                    }
                    preparedStmt2.setString(4, cruiseControl);
                    preparedStmt2.setString(5, "True");
                    System.out.println("Enter amount of seats");
                    String ae = in.nextLine();
                    preparedStmt2.setString(6, ae);
                    preparedStmt2.execute();

                    CarType typeObj3 = new CarType(carTypes.size()+1, "Family", "Manual", ad, cruiseControl, "False", ae);
                    carTypes.add(typeObj3);
                    preparedStmt.execute();
                    Car obj3 = new Car(carId, a, b, c, d, e, typeObj3);
                    cars.add(obj3);
                    break;
            }

            con.close();

        }
        catch(SQLException sqlex) {
            try {
                System.out.println(sqlex.getMessage());
                con.close();
                System.exit(1);  // terminate program
            }
            catch(SQLException sql){}
        }
        catch (ClassNotFoundException noClass) {
            System.err.println("Driver Class not found");
            System.out.println(noClass.getMessage());
            System.exit(1);  // terminate program
        }
    }

    public static void getCars(ArrayList<Car> car, ArrayList<CarType> carTypes){
        try {
            con = null;
            Statement s = null;
            Class.forName(JDBC_DRIVER);

            con = DriverManager.getConnection(DATABASE_URL, "root", password);
            s = con.createStatement();

            ResultSet rs = s.executeQuery("SELECT car_id, car_brand, car_fuel, car_register_number, car_register_date, car_how_much, cartype_id FROM car");
            if (rs != null)
                //Dette er et while loop, for at køre igennem database tabellen og tilføje data til at arrayliste
                //som kan bruges i java
                while (rs.next()) {
                    int carID = rs.getInt("car_id");
                    String carBrand = rs.getString("car_brand");
                    String carFuel = rs.getString("car_fuel");
                    String carRegisterNumber = rs.getString("car_register_number");
                    String carRegisterDate = rs.getString("car_register_date");
                    String carHowMuch= rs.getString("car_how_much");
                    int carTypeId = rs.getInt("cartype_id");
                    //nu laves objektet
                    Car addman = new Car(carID, carBrand, carFuel, carRegisterNumber, carRegisterDate, carHowMuch, carTypes.get(carTypeId-1));
                            //objektet tilføjes på vores arrayliste
                            car.add(addman);


                }
            s.close();
            con.close();



        }
        catch(SQLException sqlex) {
            try {
                System.out.println(sqlex.getMessage());
                con.close();
                System.exit(1);  // terminate program
            }
            catch(SQLException sql){}
        }
        catch (ClassNotFoundException noClass) {
            System.err.println("Driver Class not found");
            System.out.println(noClass.getMessage());
            System.exit(1);  // terminate program
        }
    }

    public static void getCarType(ArrayList<CarType> carTypes){
        try {
            con = null;
            Statement s = null;
            Class.forName(JDBC_DRIVER);

            con = DriverManager.getConnection(DATABASE_URL, "root", password);
            s = con.createStatement();

            ResultSet rs = s.executeQuery("SELECT cartype_id, cartype_description, cartype_gear, cartype_motorpower, cartype_cruisecontrol, cartype_aircon, cartype_seats FROM cartype");
            if (rs != null)
                //Dette er et while loop, for at køre igennem database tabellen og tilføje data til at arrayliste
                //som kan bruges i java
                while (rs.next()) {
                    int cartypeID = rs.getInt("cartype_id");
                    String cartypeDescription = rs.getString("cartype_description");
                    String gear = rs.getString("cartype_gear");
                    String motorpower = rs.getString("cartype_motorpower");
                    String cruisecontrol = rs.getString("cartype_cruisecontrol");
                    String aircon = rs.getString("cartype_aircon");
                    String seats = rs.getString("cartype_seats");
                    //nu laves objektet
                    CarType addman = new CarType(cartypeID, cartypeDescription, gear, motorpower, cruisecontrol, aircon, seats);
                    //objektet tilføjes på vores arrayliste
                    carTypes.add(addman);

                }
            s.close();
            con.close();

        }
        catch(SQLException sqlex) {
            try {
                System.out.println(sqlex.getMessage());
                con.close();
                System.exit(1);  // terminate program
            }
            catch(SQLException sql){}
        }
        catch (ClassNotFoundException noClass) {
            System.err.println("Driver Class not found");
            System.out.println(noClass.getMessage());
            System.exit(1);  // terminate program
        }
    }
    public static void createContract(ArrayList<Renters> renters, ArrayList<Car> cars, ArrayList<CarType> carTypes, ArrayList<Contract> contracts) {
        try {
            con = null;
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(DATABASE_URL, "root", password);

            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

            String query =  "insert into contract (contract_id, renter_id, car_id, car_odometer_start, contract_start, contract_end)" + " VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);

            Scanner console = new Scanner(System.in);
            String odometerStart = "";
            int inputRenterId = 0;
            System.out.println("You have choosen to create a new contract");
            System.out.println("Would you like to add a new customer? y/n");
            String input = console.nextLine();
            if (input.equals("y")) {
                DBaccess.insertRenters(renters);
            } else if (input.equals("n")) {
                System.out.println("Enter the first name of the customer");
                String inputName = console.nextLine();
                for (int i = 0; i < renters.size(); i++) {
                    if (inputName.equals(renters.get(i).renterFirstName)) {
                        System.out.println(renters.get(i).renterFirstName + " " + renters.get(i).renterLastName + " - " + renters.get(i).phone + " - RENTER ID: " + renters.get(i).renterID);
                    }
                }
                System.out.println("Enter the Renter ID of the desired customer");
                inputRenterId = console.nextInt();
                preparedStmt.setInt(2, inputRenterId);
                for (int j = 0; j < renters.size(); j++) {
                    if (inputRenterId == renters.get(j).renterID) {
                        System.out.println(renters.get(j));
                    }
                }
            }
            System.out.printf("Press 1 to view luxury cars%n Press 2 to view sport cars%n Press 3 to view family cars%n");
            int inputCar = console.nextInt();
            String carType = "";
            if (inputCar == 1) {
                carType = "Luxury";
            } else if (inputCar == 2) {
                carType = "Sport";
            } else if (inputCar == 3) {
                carType = "Family";
            }
            for (int i = 0; i < cars.size(); i++) {
                if (cars.get(i).carType.cartypeDescription.equals(carType)) {
                    System.out.printf("Model: " + cars.get(i).getBrand() + " - " + cars.get(i).getOdometer() + " - CAR ID: "
                            + cars.get(i).getCarId() + "%n Type: " + cars.get(i).carType + "%n");
                }
            }
            System.out.println("Enter the CAR ID of the desired car");
            int inputCarId = console.nextInt();
            preparedStmt.setInt(3, inputCarId);
            console.nextLine();
            System.out.println("Enter the starting date for the rental DD-MM-YYYY");
            String inputStart = console.nextLine();
            String[] rentStart  = inputStart.split("-");
            String sqlRentStart = rentStart[2] + rentStart[1] + rentStart[0];
            preparedStmt.setString(5, sqlRentStart);
            LocalDate d1 = LocalDate.of(parseInt(rentStart[2]), parseInt(rentStart[1]), parseInt(rentStart[0]));
            System.out.println("From day: " + d1);

            System.out.println("Enter the ending date for the rental DD-MM-YYYY");
            String inputEnd = console.nextLine();
            String[] rentEnd = inputEnd.split("-");
            String sqlRentEnd = rentEnd[2] + rentEnd[1] + rentEnd[0];
            preparedStmt.setString(6, sqlRentEnd);
            LocalDate d2 = LocalDate.of(parseInt(rentEnd[2]), parseInt(rentEnd[1]), parseInt(rentEnd[0]));
            System.out.println("From day: " + d2);

            int carTokenSlot = 0;
            int rentersTokenSlot = 0;

            for (int i = 0; i < cars.size(); i++) {
                if (cars.get(i).getCarId() == inputCarId) {
                    carTokenSlot = i;
                    odometerStart = cars.get(i).getOdometer();
                    preparedStmt.setString(4, odometerStart);
                }
            }
            for (int i = 0; i < renters.size(); i++) {
                if (renters.get(i).getRenterID() == inputRenterId) {
                    rentersTokenSlot = i;
                }
            }

            preparedStmt.setInt(1,contracts.size()+1);
            preparedStmt.execute();

            Contract obj = new Contract(contracts.size() + 1, cars.get(carTokenSlot), renters.get(rentersTokenSlot), odometerStart, d1, d2);
            contracts.add(obj);
            con.close();

        }
        catch(SQLException sqlex) {
            try {
                System.out.println(sqlex.getMessage());
                con.close();
                System.exit(1);  // terminate program
            }
            catch(SQLException sql){}
        }
        catch (ClassNotFoundException noClass) {
            System.err.println("Driver Class not found");
            System.out.println(noClass.getMessage());
            System.exit(1);  // terminate program
        }
    }
    public static void getContracts(ArrayList<Car> car, ArrayList<CarType> carTypes, ArrayList<Renters> renters, ArrayList<Contract> contracts){
        try {
            con = null;
            Statement s = null;
            Class.forName(JDBC_DRIVER);

            con = DriverManager.getConnection(DATABASE_URL, "root", password);
            s = con.createStatement();

            ResultSet rs = s.executeQuery("SELECT contract_id, renter_id, car_id, car_odometer_start, contract_start, contract_end FROM contract");
            if (rs != null)
                //Dette er et while loop, for at køre igennem database tabellen og tilføje data til at arrayliste
                //som kan bruges i java
                while (rs.next()) {
                    int contractId = rs.getInt("contract_id");

                    int renterId = rs.getInt("renter_id");
                    int renterIdToken = 0;
                        //find hvilken obj i renters array der har matching renterID
                        for(int i = 0; i < renters.size(); i++){
                            if(renters.get(i).getRenterID() == renterId){
                                renterIdToken = i;
                            }
                        }

                    int carId = rs.getInt("car_id");
                    int carIdToken = 0;
                        for(int i = 0; i < car.size(); i++){
                            if(car.get(i).getCarId() == carId){
                                carIdToken = i;
                            }
                        }

                    String odometerStart = rs.getString("car_odometer_start");
                    String contractStart = rs.getString("contract_start");
                    String contractEnd = rs.getString("contract_end");

                    String[] contractStartTokens = contractStart.split("-");
                    String[] contractEndTokens = contractEnd.split("-");

                    LocalDate contractStartObj = LocalDate.of(parseInt(contractStartTokens[0]), parseInt(contractStartTokens[1]) , parseInt(contractStartTokens[2]));
                    LocalDate contractEndObj = LocalDate.of(parseInt(contractEndTokens[0]), parseInt(contractEndTokens[1]), parseInt(contractEndTokens[2]));

                    //nu laves objektet
                    Contract obj = new Contract(contracts.size()+1, car.get(carIdToken), renters.get(renterIdToken), odometerStart, contractStartObj, contractEndObj);
                    contracts.add(obj);



                }
            s.close();
            con.close();



        }
        catch(SQLException sqlex) {
            try {
                System.out.println(sqlex.getMessage());
                con.close();
                System.exit(1);  // terminate program
            }
            catch(SQLException sql){}
        }
        catch (ClassNotFoundException noClass) {
            System.err.println("Driver Class not found");
            System.out.println(noClass.getMessage());
            System.exit(1);  // terminate program
        }
    }
    public static void deleteCar(ArrayList<Car> cars){
        Scanner in = new Scanner(System.in);
        try {
            con = null;
            Statement s = null;
            Class.forName(JDBC_DRIVER);

            con = DriverManager.getConnection(DATABASE_URL, "root", password);
            s = con.createStatement();

            String query = "delete from car where car_id=?";
            PreparedStatement PreparedStm = con.prepareStatement(query);

            System.out.println("Which car do you wish to delete from the database? \nChoose from carID number");
            int a = in.nextInt();
            PreparedStm.setInt(1, a);
            PreparedStm.executeUpdate();

            System.out.println("Record deleted succesfully!");

        s.close();
        con.close();
    }
        catch(SQLException sqlex) {
        try {
            System.out.println(sqlex.getMessage());
            con.close();
            System.exit(1);  // terminate program
        }
        catch(SQLException sql){}
    }
        catch(ClassNotFoundException noClass) {
        System.err.println("Driver Class not found");
        System.out.println(noClass.getMessage());
        System.exit(1);  // terminate program
    }
}

    public static void updateCar(ArrayList<Car> cars) {
        Scanner console = new Scanner(System.in);
        try {
            con = null;
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(DATABASE_URL, "root", password);

            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

            System.out.printf("Press 1 to view luxury cars%n Press 2 to view sport cars%n Press 3 to view family cars%n");
            int inputCar = console.nextInt();
            String carType = "";
            if (inputCar == 1) {
                carType = "Luxury";
            } else if (inputCar == 2) {
                carType = "Sport";
            } else if (inputCar == 3) {
                carType = "Family";
            }
            for (int i = 0; i < cars.size(); i++) {
                if (cars.get(i).carType.cartypeDescription.equals(carType)) {
                    System.out.printf("Model: " + cars.get(i).getBrand() + " - " + cars.get(i).getOdometer() + " - CAR ID: "
                            + cars.get(i).getCarId() + "%n Type: " + cars.get(i).carType + "%n");
                }
            }
            System.out.println("Enter the CAR ID of the car you would like to change");
            int inputCarId = console.nextInt();
            console.nextLine();
            System.out.println("What is the updated odometer number?");
            String newOdometer = console.nextLine();

            for (int i = 0; i < cars.size(); i++) {
                if (inputCarId == cars.get(i).getCarId()) {
                    cars.get(i).setOdometer(newOdometer);
                }
            }

            PreparedStatement preparedStmt = con.prepareStatement("UPDATE car SET car_how_much = ? WHERE car_id = ?");
            preparedStmt.setString(1, newOdometer);
            preparedStmt.setInt(2, inputCarId);

            preparedStmt.execute();
            preparedStmt.close();


            con.close();

        } catch (SQLException sqlex) {
            try {
                System.out.println(sqlex.getMessage());
                con.close();
                System.exit(1);  // terminate program
            } catch (SQLException sql) {
            }
        } catch (ClassNotFoundException noClass) {
            System.err.println("Driver Class not found");
            System.out.println(noClass.getMessage());
            System.exit(1);  // terminate program
        }
    }
    public static void contractEdit(ArrayList<Contract> contracts, ArrayList<Car> cars){
        Scanner in = new Scanner(System.in);
        System.out.println("Which of these contracts do you want to edit?");
        int i = 0;
        for(i=0; i < contracts.size(); i++){
            System.out.println("Press #"+i+ " for " +contracts.get(i));
        }
        int contractDecider = in.nextInt();
        System.out.println("If you want to edit which car is in the contract press #1");
        System.out.println("If you want to edit how lang the car contract is running press #2");
        int contractIf = in.nextInt();
        try {
            con = null;

            Class.forName(JDBC_DRIVER);

            con = DriverManager.getConnection(DATABASE_URL, "root", password);
            if(contractIf == 1){
                System.out.println("Which car do you want to be in the contract?");
                int j = 0;
                for(j = 0; j<cars.size();j++){
                    System.out.println("Press # "+j+ "for " + cars.get(j));
                }
                int carDecider = in.nextInt();
                PreparedStatement ps = con.prepareStatement("UPDATE contracts SET car_id = ?, WHERE contract_id = ?");
                ps.setInt(2, contractDecider);
                ps.setInt(1, carDecider);
                ps.executeUpdate();

                contracts.get(contractDecider).setContractCar(cars.get(carDecider));
            }else if(contractIf == 2){
                System.out.println("How many days do you want to extend the contracts with?");
                int manyDays = in.nextInt();
                LocalDate tempdate = contracts.get(contractDecider).getContractEnd();
                LocalDate newEndDate = tempdate.plusDays(manyDays);
                System.out.println("The contract is now running till " + newEndDate);
                PreparedStatement ps = con.prepareStatement("UPDATE contracts SET contract_end = ?, WHERE contract_id = ? ");
                ps.setInt(2, contractDecider);
                ps.setDate(1, java.sql.Date.valueOf(newEndDate));

                contracts.get(contractDecider).setContractEnd(newEndDate);
            }


            con.close();

        }
        catch(SQLException sqlex) {
            try {
                System.out.println(sqlex.getMessage());
                con.close();
                System.exit(1);  // terminate program
            }
            catch(SQLException sql){}
        }
        catch (ClassNotFoundException noClass) {
            System.err.println("Driver Class not found");
            System.out.println(noClass.getMessage());
            System.exit(1);  // terminate program
        }
    }

}
