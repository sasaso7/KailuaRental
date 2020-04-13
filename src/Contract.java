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

    @Override
    public String toString() {
        return String.format ("Contract ID: %-4s Car model: %-19s First name: %-9s Last name: %-14s Cars odometer: %-12s Date start: %-12s Date end: %-12s",
                getContractId(), getContractCar().getBrand(), getContractRenters().getRenterFirstName(), getContractRenters().getRenterLastName(), getContractCar().getOdometer(),
                getContractStart(), getContractEnd());
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getCarOdometer() {
        return carOdometer;
    }

    public void setCarOdometer(String carOdometer) {
        this.carOdometer = carOdometer;
    }

    public LocalDate getContractStart() {
        return contractStart;
    }

    public void setContractStart(LocalDate contractStart) {
        this.contractStart = contractStart;
    }

    public LocalDate getContractEnd() {
        return contractEnd;
    }

    public void setContractEnd(LocalDate contractEnd) {
        this.contractEnd = contractEnd;
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
