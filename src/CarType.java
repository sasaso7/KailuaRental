public class CarType {

    public int cartypeID;
    public String cartypeDescription;
    public String Gear;
    public String motorpower;
    public String cruisecontrol;
    public String aircon;
    public String seats;


    //constructor
    public CarType(int cartypeID, String cartypeDescription, String gear, String motorpower, String cruisecontrol, String aircon, String seats) {
        this.cartypeID = cartypeID;
        this.cartypeDescription = cartypeDescription;
        this.Gear = gear;
        this.motorpower = motorpower;
        this.cruisecontrol = cruisecontrol;
        this.aircon = aircon;
        this.seats = seats;
    }

}
