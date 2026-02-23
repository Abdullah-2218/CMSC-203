
public class Patient {
	
	// Fields
	
	private String firstName;
	private String middleName;
	private String lastName;
	private String streetAddress;
	private String city;
	private String state;
	private String zipCode;
	private String phoneNumber;
	private String emergencyName;
	private String emergencyPhone;
	
	// No-arg constructor
	public Patient() {
}
	// Constructor with first, Middle and Last Name
	public Patient(String firstName, String middleName, String lastName) {
		this.firstName=firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}
	//Constructor with all the attributes
	public Patient(String firstName,String middleName, String lastName,
			String streetAddress, String city,String state, String zipCode,
			String phoneNumber, String emergencyName, String emergencyPhone) {
	
	this.firstName = firstName;
	this.middleName = middleName;
	this.lastName = lastName;
	this.streetAddress = streetAddress;
	this.city= city;
	this.state= state;
	this.zipCode = zipCode;
	this.phoneNumber = phoneNumber;
	this.emergencyName= emergencyName;
	this.emergencyPhone= emergencyPhone;
	}
	
	//Accessors and Mutators
	
	public String getFirstName() {return firstName;}
	public void setFirstName (String firstName) {this.firstName= firstName;}
	
	public String getMiddleName() {return middleName;}
	public void setmiddleName (String middleName) {this.middleName= middleName;}
	
	public String getlastName() {return lastName;}
	public void setlastName (String lastName) {this.lastName= lastName;}
	
	public String getStreetAddress() {return streetAddress;}
	public void setStreetAddress (String streetAddress) {this.streetAddress= streetAddress;}
	
	public String getCity() {return city;}
	public void setCity (String city) {this.city= city;}
	
	public String getState() {return state;}
	public void setState (String state) {this.state= state;}
	
	public String getZipCode() {return zipCode;}
	public void setzipCode (String zipCode) {this.zipCode= zipCode;}
	
	public String getPhoneNumber() {return phoneNumber;}
	public void setphoneNumber (String phoneNumber) {this.phoneNumber= phoneNumber;}
	
	public String getEmergencyName() {return emergencyName;}
	public void setEmergencyName (String emergencyName) {this.emergencyName= emergencyName;}
	
	public String getEmergencyPhone() {return emergencyPhone;}
	public void setEmergencyPhone (String emergencyPhone) {this.emergencyPhone= emergencyPhone;}
	
	//Build Methods
	
	public String buildFullName() {
		return firstName + " " + middleName + " " + lastName;
	}
	
	public String buildAddress () {
		return streetAddress + " " + city + " " + state + " " + zipCode;
	}
	
	public String buildEmergencyContact() {
		return emergencyName + " " + emergencyPhone;
	}
	
	public String toString() {
		return "Patient Name: " + buildFullName() +
				"\nAddress: " + buildAddress()+
				"\nPhone: " + getPhoneNumber() +
				"\nEmergency Contact: " + buildEmergencyContact();
				
	}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

