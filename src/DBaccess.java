import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DBaccess {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/cars";
    static Connection con;

    public static void getDB(){
        try {
            con = null;
            Statement s = null;
            Class.forName(JDBC_DRIVER);

            con = DriverManager.getConnection(DATABASE_URL, "root", "ElfenbenNisse19");
            s = con.createStatement();

            ResultSet rs = s.executeQuery("SELECT renter_name,  renter_city  from renters");
            if (rs != null)
                while (rs.next()) {
                    System.out.printf("Data from name: %-34s ",rs.getString("renter_name"));
                    System.out.printf("%s\n ",rs.getString("renter_city"));
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

        //Nu bliver der lavet getRenters metoden, som skal hive alle renters ud af vores database
        public static void getRenters(ArrayList<Renters> renters){
            try {
                con = null;
                Statement s = null;
                Class.forName(JDBC_DRIVER);

                con = DriverManager.getConnection(DATABASE_URL, "root", "ElfenbenNisse19");
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
            con = DriverManager.getConnection(DATABASE_URL, "root", "ElfenbenNisse19");

            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());


            String query =  "insert into users (renter_first_name, renter_last_name, renter_phone, renter_mail, renter_adress, renter_city, renter_zip, renter_licence_number, renter_license_since)" + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
}
