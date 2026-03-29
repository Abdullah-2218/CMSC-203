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

public class PropertyDriver {
public static void main(String[] args) {
	ManagementCompany mc = new ManagementCompany("Campus Reality", "123-45-6789");
	
	Property p1 = new Property ("Apt 1", "Rockville", 1200.0, "Bob");
	Property p2 = new Property("Apt 2", "Rockville", 1500.0, "Carol");
	
	mc.addProperty(p1);
	mc.addProperty(p2);
	
	System.out.println(mc.toString());
	
	//Test copy constructor
	ManagementCompany copy = new ManagementCompany(mc);
	System.out.println("\nCopied Company:");
	System.out.println(copy.toString());
}
}
