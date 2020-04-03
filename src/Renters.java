import java.util.Date;

public class Renters {
    public int renterID;
    public String renterFirstName;
    public String renterLastName;
    public String phone;
    public String mail;
    public String address;
    public String city;
    public String zip;
    public String licenceNumber;
    public Date licenceSince;


    public Renters(int renterID, String renterFirstName, String renterLastName, String phone, String mail, String address, String city, String zip, String licenceNumber, Date licenceSince) {
        this.renterID = renterID;
        this.renterFirstName = renterFirstName;
        this.renterLastName = renterLastName;
        this.phone = phone;
        this.mail = mail;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.licenceNumber = licenceNumber;
        this.licenceSince = licenceSince;
    }

    @Override
    public String toString() {
        return(
                "Firstname: " + renterFirstName +
                "\nLastname: " + renterLastName +
                "\nTelephone: " + phone +
                "\nEmail: " + mail +
                "\nAddress: " + address +
                "\nCity: " + city +
                "\nZipcode: " + zip +
                "\nDrivers licence number:  " + licenceNumber +
                "\nDrivers licence since: " + licenceSince + "\n"
        );
    }

}
