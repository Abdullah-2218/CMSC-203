/*
 * Class: CMSC203 
 * Instructor: Grigority Grinberg
 * Description: This program is about managing properties
 * Due: 03/30/2026
 * Platform/compiler: Javadoc 21
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Abdullah Khan */

public class Property {
	private String propertyName;
	private String city;
	private double rentAmount;
	private String owner;
	
	// Default constructor
	public Property() {
		propertyName = "";
		city = "";
		rentAmount = 0.0;
		owner = "";
	}
	
// Parameterized constructor
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
	}
	
// Copy COnstructor
	public Property(Property otherProperty) {
		if (otherProperty != null) {
			this.propertyName = otherProperty.propertyName;
			this.city = otherProperty.city;
			this.rentAmount = otherProperty.rentAmount;
			this.owner = otherProperty.owner;
		}
	}
	
// Getters
	public String getPropertyName() {
		return propertyName;
	}
	
	public String getCity() {
		return city;
	}
	
	public double getRentAmount() {
		return rentAmount;
	}
	
	public String getOwner() {
		return owner;
	}
	
	//Setters
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	
	public void setCity (String city) {
	    this.city = city;
	}
	
	public void setRentAmout(double rentAmount) {
		this.rentAmount = rentAmount;
	}
	
	public void setOwner (String owner) {
		this.owner = owner;
	}
	
	// toString
	public String toString() {
		return  propertyName + ", "  + city + ","+ "Rent: $" + rentAmount + "," + "Owner: " + owner;
	}
	

}
