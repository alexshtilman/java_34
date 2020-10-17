package telran.persons.dto;

public class Child extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String garten;

	public Child() {

	}

	public Child(String garten) {
		super();
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
		return "Child [garten=" + garten + "]";
	}

}
