package Pojo3;

import java.util.*;//imported for List type

public class AddPlacePOJOclass {
	
	private locationPojoClass location;// Type of varibable should be the class name
	private int accuracy;
	private String name;
	private String phone_number;
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	private String Address;
	private List<String> types;// Returning list of String or we can array of strings
	private String website;
	private String language;
	
	public locationPojoClass getLocation() {
		return location;
	}
	public void setLocation(locationPojoClass location) {
		this.location = location;
	}
	public int getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public List<String> getTypes() {
		return types;
	}
	public void setTypes(List<String> types) {
		this.types = types;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}

	

	
	
	
}
