package telran.persons.dto;

import java.io.Serializable;

public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String city;
	private String street;
	private int aprt;

	public Address() {

	}

	public Address(String city, String street, int aprt) {
		super();
		this.city = city;
		this.street = street;
		this.aprt = aprt;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", street=" + street + ", aprt=" + aprt + "]";
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCity() {
		return city;
	}

	public String getStreet() {
		return street;
	}

	public int getAprt() {
		return aprt;
	}

}
