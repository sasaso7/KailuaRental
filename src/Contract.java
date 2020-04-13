import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Contract {
    private int contractId;
    private Car contractCar;
    private Renters contractRenters;
    private String carOdometer;
    private LocalDate contractStart;
    private LocalDate contractEnd;

    public Contract(int contractId, Car contractCar, Renters contractRenters, String carOdometer, LocalDate contractStart, LocalDate contractEnd) {
        this.contractId = contractId;
        this.contractCar = contractCar;
        this.contractRenters = contractRenters;
        this.carOdometer = carOdometer;
        this.contractStart = contractStart;
        this.contractEnd = contractEnd;
    }

    public static void createContract(ArrayList<Renters> renters, ArrayList<Car> cars, ArrayList<CarType> carTypes) {
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


}
