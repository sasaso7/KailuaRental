import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        //DBaccess.getDB();
        ArrayList<CarType> carTypes = new ArrayList();
        DBaccess.getCarType(carTypes);
        ArrayList<Car> cars = new ArrayList();
        ArrayList<Renters> renters = new ArrayList();
        DBaccess.getCars(cars, carTypes);
        DBaccess.getRenters(renters);
        ArrayList<Contract> contracs = new ArrayList();
        DBaccess.getContracts(cars, carTypes, renters, contracs);
        DBaccess.createContract(renters, cars, carTypes, contracs);

        //DBaccess.insertCar(cars, carTypes);
       // System.out.println(cars);
       // System.out.println(carTypes);
       // ArrayList<Renters> renters = new ArrayList();
       // DBaccess.getRenters(renters);
       // for(Renters i: renters){
       //     System.out.println(i);
       // }
    }
}

