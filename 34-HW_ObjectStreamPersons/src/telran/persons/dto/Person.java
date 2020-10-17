package telran.persons.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Address address;
	private String name;
	private LocalDate birthDate;

	public Person() {

	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", address=" + address + ", name=" + name + ", birthDate=" + birthDate + "]";
	}

	public Person(int id, Address address, String name, LocalDate birthDate) {
		super();
		this.id = id;
		this.address = address;
		this.name = name;
		this.birthDate = birthDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public Address getAddress() {
		return address;
	}

	public String getName() {
		return name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
