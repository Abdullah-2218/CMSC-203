/*
 * Class: CMSC203 
 * Instructor:Dr Grinberg
 * Description: This program develops patient driver app
 * Due: 02/23/2026
 * Platform/compiler:jdk-17
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here:Abdullah Khan
*/
import java.util.Scanner;


public class PatientDriverApp{
static Patient patient;
static Procedure p1, p2, p3;
static double total;
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		//User input
		System.out.print("Enter First Name: ");
		String firstName = keyboard.nextLine();
		
		System.out.print("Enter Middle Name: ");
		String middleName = keyboard.nextLine();
		
		System.out.print("Enter Last Name: ");
		String lastName = keyboard.nextLine();
		
		System.out.print("Enter Street Address: ");
		String streetAddress = keyboard.nextLine();
		
		System.out.print("Enter City: ");
		String city = keyboard.nextLine();
		
		System.out.print("Enter State: ");
		String state = keyboard.nextLine();
		
		System.out.print("Enter Zip Code: ");
		String zipCode = keyboard.nextLine();
		
		System.out.print("Enter Phone Number: ");
		String phone = keyboard.nextLine();
		
		System.out.print("Enter Emergency Contact Name: ");
		String emergencyName = keyboard.nextLine();
		
		System.out.print("Enter Emergency Contact Phone: ");
		String emergencyPhone = keyboard.nextLine();
		
		
		
		//Create Patient using full constructor
		
		 Patient patient = new Patient(firstName, middleName, lastName,
				streetAddress,city,state,zipCode,phone, emergencyName,emergencyPhone);
		
		
		//Procedure 1 - No-arg constructor
		Procedure p1= new Procedure();
		p1.setProcedureName("Physical Exam");
		p1.setProcedureDate("06/12/2023");
		p1.setPractitionerName("Dr. Adams");
		p1.setCharges(250.00);
		
		//Procedure 2- Two-arg constructor
		Procedure p2 = new Procedure ("X-Ray", "06/12/2023");
		p2.setPractitionerName("Dr.Lee");
		p2.setCharges(500.00);
		
		//Procedure 3- Full Constructor
		Procedure p3 = new Procedure(
				"Blood Test",
				"06/12/2023",
				"Dr. Brown",
				200.00);
		
		//display output
		System.out.println();
		System.out.println("The program was developed by Abdullah Khan 02/23/2026");
		System.out.println();
		
		displayPatient(patient);
		System.out.println();
		
		displayProcedure(p1);
		displayProcedure(p2);
		displayProcedure(p3);
		
		double total= calculateTotalCharges(p1, p2, p3);
		
			System.out.printf("%nTotal Charges: $ %,.2f%n", total);
				
		keyboard.close();
		
	}
		
		//Required Methods
		
		public static void displayPatient(Patient patient) {
			System.out.println(patient.toString());
		}
		
		public static void displayProcedure (Procedure procedure) {
			System.out.println(procedure.toString());
		}
		
		public static double calculateTotalCharges(Procedure p1, Procedure p2, Procedure p3) {
			return p1.getCharges() + p2.getCharges() +p3.getCharges();
			
	
		}
	}
		
		
		
		
				
			

	


