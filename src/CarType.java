public class CarType {

    public int cartypeID;
    public String cartypeDescription;
    public String Gear;
    public String motorpower;
    public String cruisecontrol;
    public String aircon;
    public String seats;


    @Override
    public String toString() {
        return  String.format ("Car type ID: %-6s Car type: %-9s Gear: %-9s Motor power: %-10s Cruise control: %-8s Aircon: %-8s Seats: %-8s",
                getCartypeID(), getCartypeDescription(), getGear(), getMotorpower(), getCruisecontrol(), getAircon(), getSeats());
    }

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

    public int getCartypeID() {
        return cartypeID;
    }

    public void setCartypeID(int cartypeID) {
        this.cartypeID = cartypeID;
    }

    public String getCartypeDescription() {
        return cartypeDescription;
    }

    public void setCartypeDescription(String cartypeDescription) {
        this.cartypeDescription = cartypeDescription;
    }

    public String getGear() {
        return Gear;
    }

    public void setGear(String gear) {
        Gear = gear;
    }

    public String getMotorpower() {
        return motorpower;
    }

    public void setMotorpower(String motorpower) {
        this.motorpower = motorpower;
    }

    public String getCruisecontrol() {
        return cruisecontrol;
    }

    public void setCruisecontrol(String cruisecontrol) {
        this.cruisecontrol = cruisecontrol;
    }

    public String getAircon() {
        return aircon;
    }

    public void setAircon(String aircon) {
        this.aircon = aircon;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }
}
