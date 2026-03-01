
public class Procedure {
	private String procedureName;
	private String procedureDate;
	private String practitionerName;
	private double charges;
	
	//No arg Constructor
	public Procedure() {		
	}
	
	//Constructor with name and date
	
	public Procedure (String procedureName, String procedureDate) {
	this.procedureName= procedureName;
	this.procedureDate = procedureDate;
}

	//Constructor with all Attributes
	public Procedure(String procedureName, String procedureDate,
			String practitionerName, double charges) {
		this.procedureName = procedureName;
		this.procedureDate = procedureDate;
		this.practitionerName = practitionerName;
	    this.charges = charges;
	}
	
	//Gettlers and Settlers
	public String getProcedureName() { return procedureName;}
	public void setProcedureName(String procedureName) { this.procedureName = procedureName; }
	
	public String getProcedureDate() { return procedureDate;}
	public void setProcedureDate(String procedureDate) { this.procedureDate = procedureDate; }
	
	public String getPractitionerName() { return practitionerName;}
	public void setPractitionerName(String practitionerName) { this.practitionerName = practitionerName;}
	
	public double getCharges() {return charges; }
	public void setCharges (double charges) {this.charges = charges; }
	
	public String toString() {
		return procedureName + "\t" + procedureDate + "\t" +
	    practitionerName + "\t$" + String.format("%.2f", charges);
		
	}
}
	
	
	
	