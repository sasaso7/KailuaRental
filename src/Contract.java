import java.util.ArrayList;
import java.util.Scanner;

public class Contract {
    Car contractCar;
    Renters contractRenters;

    public Contract(Car contractCar, Renters contractRenters){
        this.contractCar = contractCar;
        this.contractRenters = contractRenters;
    }

    public Car getContractCar() {
        return contractCar;
    }

    public void setContractCar(Car contractCar) {
        this.contractCar = contractCar;
    }

    public Renters getContractRenters() {
        return contractRenters;
    }

    public void setContractRenters(Renters contractRenters) {
        this.contractRenters = contractRenters;
    }

    public static void createContract(ArrayList<Renters> renters, ArrayList<Car> cars, ArrayList<CarType> carTypes){
        Scanner console = new Scanner(System.in);
        System.out.println("You have choosen to create a new contract");
        System.out.println("Would you like to add a new customer? y/n");
        String input = console.nextLine();
        if(input.equals("y")){
            DBaccess.insertRenters(renters);
        } else if(input.equals("n")){
            System.out.println("Enter the first name of the customer");
            String inputName = console.nextLine();
            for(int i = 0; i < renters.size(); i++){
                if(inputName.equals(renters.get(i).renterFirstName)){
                    System.out.println(renters.get(i).renterFirstName + " " + renters.get(i).renterLastName + " - " + renters.get(i).phone + " - RENTER ID: " + renters.get(i).renterID);
                }
            }
            System.out.println("Enter the Renter ID of the desired customer");
            int inputRenterId = console.nextInt();
            for(int j = 0; j < renters.size(); j++){
                if(inputRenterId == renters.get(j).renterID){
                    System.out.println(renters.get(j));
                }
            }
        }
    }

}
