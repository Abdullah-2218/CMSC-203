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

public class ManagementCompany {
private String name;
private String taxId;
private Property[] properties;
private int propertyCount;

public static final int MAX_PROPERTIES = 5;

// Constructor
public ManagementCompany (String name, String taxId) {
	this.name = name;
	this.taxId = taxId;
	properties = new Property[MAX_PROPERTIES];
	propertyCount = 0;
}

// Copy constructor (Deep Copy)
public ManagementCompany(ManagementCompany otherCompany) {
	if (otherCompany != null) {
		this.name = otherCompany.name;
		this.taxId = otherCompany.taxId;
		this.propertyCount = otherCompany.propertyCount;
		
		this.properties = new Property[MAX_PROPERTIES];
		
		for (int i= 0; i<propertyCount; i++) {
			this.properties[i] = new Property(otherCompany.properties[i]);
			
		}
	}
}

//Add property
public int addProperty(Property p) {
	if (propertyCount >= MAX_PROPERTIES || p== null) {
		return -1;
	}
	properties [propertyCount] = new Property (p); //store copy
	propertyCount++;
	return propertyCount -1;
}

// Total rent
public double totalRent() {
	double total = 0.0;
	
	for (int i=0; i<propertyCount; i++) {
		total += properties[i].getRentAmount();
	}
	return total;
}

// Get property Count
public int getPropertyCount() {
	return propertyCount;
}

//Get property at index
public Property getProperty(int index) {
	if (index>= 0 && index< propertyCount) {
		return properties[index];
	}
	return null;
}

//Getters
public String getName() {
	return name;
}

public String getTaxId() {
	return taxId;
}

// toString
public String toString() {
	String result = "Management Company: " + name + " TaxID: " + taxId + "\n";
	
	for (int i = 0; i< propertyCount; i++) {
		result += properties[i].toString() + "\n";
	}
	result += "Total Rent: " + totalRent();
	return result;
}
}
