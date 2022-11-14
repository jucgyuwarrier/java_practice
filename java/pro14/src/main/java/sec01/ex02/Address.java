package sec01.ex02;

public class Address {
private String city;
private String zipcode;

public Address() {
}

public Address (String city, String zipcode){
	this.city = city;
	this.zipcode = zipcode;
}
	public String getcity() {
		return city;
	}
	public void setcity(String city) {
		this.city = city;
	}
	
	public String getzipcode() {
		return zipcode;
	}
	public void setzipcode(String zipcode) {
		this.zipcode = zipcode;
	}
}

