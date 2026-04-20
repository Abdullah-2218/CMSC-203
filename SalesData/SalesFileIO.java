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

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SalesFileIO {
	
public static double [][] readSalesData(String filename) throws FileNotFoundException {
	ArrayList<double[]> rows = new ArrayList<>();
	Scanner scanner = new Scanner (new File (filename));
	
	while (scanner.hasNextLine()) {
		String line = scanner.nextLine().trim();
		if (line.isEmpty())continue;
		
		String [] parts = line.split("\\s+");
		double[] row = new double[parts.length];
		
		for (int i=0; i<parts.length; i++) {
			row[i] = Double.parseDouble(parts[i]);
		}
		rows.add(row);
	}
	scanner.close();
	
	double[][] data = new double [rows.size()][];
	for (int i =0; i<rows.size(); i++) {
		data[i]=rows.get(i);
		
	}
	return data;
}


public static void writeSummary (String filename, double[][] data) throws IOException{
	PrintWriter writer = new PrintWriter (new FileWriter(filename));
	
	writer.printf("Total sales: %.2f%n", SalesDataUtility.getTotal(data));
	writer.printf("Average sale: %.2f%n", SalesDataUtility.getAverage(data));
	
	for(int i=0; i<data.length; i++) {
		writer.printf("Row %d total: %.2f%n", i,
				SalesDataUtility.getRowTotal(data, i));
	}

// Column totals (ragged handling)
int maxCols = 0;
for (double[] row : data) {
	if(row.length > maxCols) maxCols = row.length;
}
for (int c = 0; c<maxCols; c++) {
	writer.printf("Column %d total: %.2f%n", c,
			SalesDataUtility.getColumnTotal(data, c));
}

writer.printf("Highest sale: %.2f%n",
SalesDataUtility.getHighestInArray(data));
writer.printf("Lowest sale: %.2f%n", 
		SalesDataUtility.getLowestInArray(data));

writer.close();
}
}


