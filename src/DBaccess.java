import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBaccess {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/ap";
    static Connection con;

    public DBaccess(){
        try {
            con = null;
            Statement s = null;
            Class.forName(JDBC_DRIVER);

            con = DriverManager.getConnection(DATABASE_URL, "root", "1234");
            s = con.createStatement();

            ResultSet rs = s.executeQuery("Put sql kode ind her")
            if (rs != null)
                while (rs.next()) {
                    System.out.printf("Data from name: %-34s ",rs.getString("vendor_name"));
                    System.out.printf("%s\n ",rs.getString("vendor_city"));
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
}
