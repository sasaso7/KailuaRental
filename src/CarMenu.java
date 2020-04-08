import java.util.ArrayList;
import java.util.Scanner;

public class CarMenu {
    public static void Menu(){
        Scanner console = new Scanner(System.in);
        boolean isRunning = true;

        //Creates Arrays, Reads files, Creates objects, fills Array


        do{
            System.out.println("1. For at printe liste ud");
            System.out.println("2. For at tilføje en bil");
            int menuChoice = console.nextInt();

            switch(menuChoice){
                case 1:
                 //   printList(luxuryArray);
                    break;
                case 2:
                   // Luxury.createLuxury(luxuryArray);
                    break;
                case 3:
                    isRunning = false;
                    break;
            }
            break;


        }while(isRunning);
    }
    public static void printList(ArrayList<?> list){
        for (Object e: list){
            System.out.println(e);
        }
    }
}
