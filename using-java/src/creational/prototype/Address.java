package creational.prototype;

public class Address implements Prototype<Address> {
    private String city;
    private String zip;

    public Address(String city, String zip) {
        this.city = city;
        this.zip = zip;
    }

    @Override
    public Address clone() {
        return new Address(this.city, this.zip);
    }

    @Override
    public String toString() {
        return "Address: " + city + " - " + zip;
    }
}

