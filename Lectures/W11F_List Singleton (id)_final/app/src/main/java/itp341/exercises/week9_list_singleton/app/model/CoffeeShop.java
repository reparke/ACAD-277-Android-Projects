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


    /**
     * No-argument constructor
     */
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


    /**
     * @return String city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param String city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return String state
     */
    public String getState() {
        return state;
    }

    /**
     * @param String state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return String zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * @param String zip
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * @param String name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param String address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return String phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param String phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return String website
     */
    public String getWebsite() {
        return website;
    }

    /**
     * @param String website
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * @return double rating
     */
    public double getRating() {
        return rating;
    }


    /**
     * @param double rating
     */
    public void setRating(double rating) {
        this.rating = rating;
    }


    //TODO toString()
    public String toString() {
        return this.name + " (" + city + ")";
    }

}