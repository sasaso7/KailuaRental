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
        Contract.createContract(renters, cars, carTypes);

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

