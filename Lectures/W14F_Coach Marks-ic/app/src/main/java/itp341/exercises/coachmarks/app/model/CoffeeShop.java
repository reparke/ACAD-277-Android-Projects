package itp341.exercises.coachmarks.app.model;

import java.io.Serializable;

public class CoffeeShop implements Serializable { // serializable added later

	//Instance variables
	private long _id;
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
	public CoffeeShop() {
		super();
	}

	/**Overload constructor
	 * @param String name
	 * @param String address
	 * @param String city
	 * @param String state
	 * @param String zip
	 * @param String phone
	 * @param String website
	 * @param double rating
	 */
	public CoffeeShop(Long id, String name, String address, String city, String state,
			String zip, String phone, String website, double rating) {
		super();
		this._id = id;
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
	 * @return the _id
	 */
	public long get_id() {
		return _id;
	}

	/**
	 * @param _id the _id to set
	 */
	public void set_id(long _id) {
		this._id = _id;
	}

	/**
	 * 
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


	public String toString() {
		return this.name + " (" + city + ")";
	}

}