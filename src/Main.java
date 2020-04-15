

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the password to MYSQL");
        String password = in.nextLine();
        DBaccess.setPassword(password);
        CarMenu.Menu();
    }
}

