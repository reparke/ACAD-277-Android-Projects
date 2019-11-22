package itp341.exercises.week9_list_singleton.app.model;


public class CoffeeShop { // serializable added later

    //Instance variables
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String website;
    private double rating;


    //constructor used for testing
    public CoffeeShop() {
        super();

    }


    public CoffeeShop(String name, String address, String city, String state,
                      String zip, String phone, String website, double rating) {
        super();
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.website = website;
        this.rating = rating;
    }



    public String getCity() {
        return city;
    }


    public void setCity(String city) {
        this.city = city;
    }


    public String getState() {
        return state;
    }


    public void setState(String state) {
        this.state = state;
    }


    public String getZip() {
        return zip;
    }


    public void setZip(String zip) {
        this.zip = zip;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public String getPhone() {
        return phone;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getWebsite() {
        return website;
    }


    public void setWebsite(String website) {
        this.website = website;
    }


    public double getRating() {
        return rating;
    }



    public void setRating(double rating) {
        this.rating = rating;
    }


    //TODO toString()
    public String toString() {

        return "Need to write toString!";
    }

}