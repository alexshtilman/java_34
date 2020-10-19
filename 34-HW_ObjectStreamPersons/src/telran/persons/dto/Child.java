package telran.persons.dto;

import java.time.LocalDate;

public class Child extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String garten;

	public Child() {

	}

	public Child(int id, Address address, String name, LocalDate birthDate, String garten) {
		super(id, address, name, birthDate);
		this.garten = garten;
	}

	public String getGarten() {
		return garten;
	}

	public void setGarten(String garten) {
		this.garten = garten;
	}

	@Override
	public String toString() {
		return "Child [garten=" + garten + ", id=" + getId() + ", address=" + getAddress() + ", name=" + getName()
				+ ", birthDate=" + getBirthDate() + "]";
	}

}
