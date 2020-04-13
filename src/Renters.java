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
    //Getters and Setters
    public int getRenterID() {
        return renterID;
    }

    public void setRenterID(int renterID) {
        this.renterID = renterID;
    }

    public String getRenterFirstName() {
        return renterFirstName;
    }

    public void setRenterFirstName(String renterFirstName) {
        this.renterFirstName = renterFirstName;
    }

    public String getRenterLastName() {
        return renterLastName;
    }

    public void setRenterLastName(String renterLastName) {
        this.renterLastName = renterLastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public Date getLicenceSince() {
        return licenceSince;
    }

    public void setLicenceSince(Date licenceSince) {
        this.licenceSince = licenceSince;
    }

    @Override
    public String toString() {
        return String.format ("FirstName: %-8s LastName: %-14s Telephone: %-12s Email: %-24s Address: %-21s City: %-12s Zipcode: %-6s DLN: %-8s DLS: %-10s"
                ,getRenterFirstName(),getRenterLastName(),getPhone(),getMail(),getAddress(),getCity(),getZip(),getLicenceNumber(),getLicenceSince());


    }
}
