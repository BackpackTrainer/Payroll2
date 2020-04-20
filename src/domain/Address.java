package domain;

public class Address {
	private String street;
	private String line2;
	private String city;
	private String state;
	
	public Address(String street, String line2, String city, String state)  {
		this.street = street;
		this.line2 = line2;
		this.city = city;
		this.state = state;				
	}
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getLine2() {
		return line2;
	}
	public void setLine2(String line2) {
		this.line2 = line2;
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

}
