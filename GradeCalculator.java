/*
 * Class: CMSC203 
 * Instructor:  Dr. Grigority A Grinberg
 * Description: It is project in which I made a grading calculator utilizing data
                from file and writing to a file
 * Due: 02/09/2026
 * Platform/compiler: Eclipse / JDK 17
 * I pledge that I have completed the programming assignment 
  independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Abdullah Khan
*/

package mycalculator;

import java.util.Scanner;
import java.io.*;

public class GradeCalculator {

	public static void main(String[] args) {
		final String CONFIG_FILE = "gradeconfig.txt";
        final String INPUT_FILE = "grades_input.txt";
        final String OUTPUT_FILE = "grades_report.txt";
        
        //Default configuration
        String courseName= "CMSC203 Computer Science";
        int numCategories = 3;
        int totalWeight=0;
        
        String category1= "Projects";
        String category2= "Quizzes";
        String category3= "Exams";
        
        int weight1= 40;
        int weight2= 30;
        int weight3= 30;
        
        boolean usedDefault = false;
        
        //Read Configuration File
        try {
        	File configurationFile = new File(CONFIG_FILE);
        	Scanner configurationScanner = new Scanner (configurationFile);
        	courseName = configurationScanner.nextLine();
        	numCategories = Integer.parseInt(configurationScanner.nextLine());
        	
        	if (numCategories == 3) {
        		
        		category1 = configurationScanner.next();
        		weight1 = configurationScanner.nextInt();
        		
        		category2 = configurationScanner.next();
        		weight2 = configurationScanner.nextInt();
        		
        		category3 = configurationScanner.next();
        		weight3 = configurationScanner.nextInt();
        		
        	    totalWeight = weight1 + weight2 + weight3;
        		
        		if (totalWeight != 100) {
        			throw new Exception("Weights must equal 100.");}
        	}else {
        			throw new Exception("Only 3 categories supported");}
        		
        	
        	configurationScanner.close();
        	}
        	
        	catch (Exception e) {
        		System.out.println("Configuration file missing or invalid.");
        		System.out.println ("Using default configuration.");
        		usedDefault = true;
        	}
        
        // Read student Input File
        
        String firstName = "";
        String lastName = "";
        
        double average1= 0;
        double average2= 0;
        double average3= 0;
        
        try {
        	File inFile = new File(INPUT_FILE);
        	Scanner inScanner = new Scanner(inFile);
        	
        	firstName = inScanner.nextLine();
        	lastName= inScanner.nextLine();
        	
        	int processedCategories = 0;
        	
        	while (inScanner.hasNext() && processedCategories <3 ) {
        		 
        		String nameCategory = inScanner.next();
        		int scores = inScanner.nextInt();
        		inScanner.nextLine();
        		
        		String scoresLine = inScanner.nextLine();
        		Scanner scoreScanner = new Scanner (scoresLine);
        		
        		double sum= 0;
        		int count= 0;
        		
        		while (scoreScanner.hasNextDouble() && count< scores) {
        			double score= scoreScanner.nextDouble();
        			
        			if (score>=0 && score<= 100) {
        				sum+=score;
        				count++;
        			}
        		}
        		scoreScanner.close();
        		
        		double average=0;
        		if(count>0) {
        			average= sum/count;
        		}
        		
        		
        		// Matching the category
        		
        		if (nameCategory.equals(category1)) 
        			average1=average;
        		else if (nameCategory.equals(category2))
        			average2=average;
        		else if (nameCategory.equals(category3))
        			average3 = average;
        		else 
        			System.out.println ("Unknown category: " + nameCategory + " not used");
        		
        		processedCategories++;
        	}
        	
        	inScanner.close();
        }
        
        catch (Exception e) {
        	
        	System.out.println("Error reading student input file.");
        	return;
        }
        
        // calculating the final Average
        
        double finalAverage= (average1 * weight1/ 100.0) +
        		             (average2 * weight2 / 100.0)+
        		             (average3 * weight3 / 100.0);
        
        String gradeLetter;
        String baseLetter;
        
       
        if (finalAverage >= 90)
        	baseLetter ="A";
        else if (finalAverage >= 80)
        	baseLetter ="B";
        else if (finalAverage >= 70)
        	baseLetter ="C";
        else if (finalAverage >= 60)
        	baseLetter ="D";
        else
        	baseLetter ="F";
        
        gradeLetter=baseLetter;
        
        //+/- Grading 
        
        Scanner keyboard= new Scanner (System.in);
        String choice;
        
        do {
        	System.out.print("Do you want to apply +/- grading?(Y/N):");
        	choice = keyboard.nextLine().trim();
        }
        while (!choice.equalsIgnoreCase("Y") && !choice.equalsIgnoreCase("N"));
        
        if (choice.equalsIgnoreCase("Y") && !baseLetter.equals("F")) {
        	if (finalAverage >= 97) gradeLetter = "A+";
        	else if (finalAverage >= 93) gradeLetter = "A";
        	else if(finalAverage >= 90) gradeLetter = "A-";
        	
        	else if(finalAverage >= 87) gradeLetter = "B+";
        	else if(finalAverage >= 83) gradeLetter = "B";
        	else if(finalAverage >= 80) gradeLetter = "B-";
        	
        	else if(finalAverage >= 77) gradeLetter = "C+";
        	else if(finalAverage >= 73) gradeLetter = "C";
        	else if(finalAverage >= 70) gradeLetter = "C-";
        	
        	else if(finalAverage >= 67) gradeLetter = "D+";
        	else if(finalAverage >= 63) gradeLetter = "D";
        	else if(finalAverage >= 60) gradeLetter = "D-";
        }
        	
        		 
        
        keyboard.close();
        
        // Writing to output file
        
        try {
        	PrintWriter writer= new PrintWriter (OUTPUT_FILE);
        	
        	
        	
        	String report = "";
        	report += "Loading configuration from " + CONFIG_FILE + "...\n";
        	if (usedDefault)
        		report +="Configuration file missing or invalid. Using default configuration. \n";
        	else
        		report+= "Configuration loaded successfully. \n";
        	
        	report += "\n Using input file: " + INPUT_FILE + "\n";
        	report+=  "\n Using output file: " + OUTPUT_FILE + "\n\n";
        	
        	report += "Reading student scores...\n\n";
        	report += "Course: " + courseName + "\n";
        	report += "Student: " + firstName + " " + lastName + "\n\n";
        	
        	report += "Category Results: \n";
        	report += category1 + " Average: " + String.format("%.2f" , average1)+ 
        			"( Weight: "+ weight1 + "%)\n";
        	
        	report += category2 + " Average: " + String.format("%.2f" , average2)+ 
        			"( Weight: "+ weight2 + "%)\n";
        	
        	report += category3 + " Average: " + String.format("%.2f" , average3)+ 
        			"( Weight: "+ weight3 + "%)\n";
        	
        	report += "\n Overall Numeric Average: "
        			+ String.format("%.2f", finalAverage) + "\n";
        	report += "Base letter grade: " + baseLetter + "\n";
        	
        	report += "Final Letter Grade: " + gradeLetter + "\n\n";
        	
        	report += "Summary writtern to " + OUTPUT_FILE + "\n";
        	report +="Program complete. Goodbye! \n";
        	
        	System.out.println("\n===========================================\n");
        	System.out.println(" CMSC203 Project 1 - Grade Calculator\n");
        	System.out.println("===========================================\n");
        	//Print to console
        	System.out.println (report);
        	
        	//Write to file
        	writer.print(report);
        	writer.close();
        }
        
        catch (Exception e) {
        	System.out.println ("Error writing output file.");
        	
        }
	}
}
        	
        	
        	
        	
        
        		             
        	
        
        			
        			
        		
        			
        	
        	
        	
        		
        	