/*
 * Class: CMSC203 
 * Instructor: Professor Grinberg
 * Description: This project uses arrays and files to analyze sales
 * Due: 4/20/2026
 * Platform/compiler:Javac-21
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: _Abdullah Khan_________
*/

import java.util.Scanner;

public class SalesAppDriver {

	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		
		System.out.print("Enter input file: ");
		String input = scanner.nextLine();

		System.out.print("Enter output file: ");
		String output = scanner.nextLine();
		
		try {
			double[][] data = SalesFileIO.readSalesData(input);
			
			System.out.println("Total: " + SalesDataUtility.getTotal(data));
			System.out.println("Average: " + SalesDataUtility.getAverage(data));
			
			SalesFileIO.writeSummary(output, data);
			System.out.println("Summary written to file.");
			}
		catch(Exception e) {
			System.out.println("Error:" + e.getMessage());
		}
		scanner.close();
	}

}
