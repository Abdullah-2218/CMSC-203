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

/** Utility class for processing ragged 2D sales arrays */

public class SalesDataUtility {
	
	public static double getTotal(double[][] data) {
		double total= 0;
		for (int i=0; i<data.length; i++) {
			for (int j = 0;j< data[i].length; j++) {
				total += data[i][j];
			
			}
		}
		return total;
	}
	
public static double getAverage(double[][] data) {
	double total = 0;
	int count = 0;
	
	for (int i=0; i<data.length; i++) {
		for(int j = 0; j<data[i].length; j++) {
			total += data[i][j];
			count ++;
		}
	}
	return total / count;
}

public static double getRowTotal(double[][] data, int row) {
double total = 0;
for (int j =0; j<data[row].length;j++) {
	total += data[row][j];
}
 return total;
}


public static double getColumnTotal(double[][] data, int col) {
	double total = 0;
	for (int i = 0; i < data.length; i++) {
		if (col < data[i].length) {
			total += data[i][col];
		}
	}
	return total;
}

public static double getHighestInRow(double[][] data, int row) {
	double max = data[row][0];
	for (int j =1; j<data[row].length; j++) {
		if (data[row][j] > max) {
			max = data[row][j];
		}
	}
	return max;
}

public static double getLowestInRow(double[][] data, int row) {
	double min = data[row][0];
	for (int j = 1; j <data[row].length; j++) {
		if (data[row][j] < min) {
			min = data[row][j];
		
		}
	}
	return min;
}

public static double getHighestInArray(double[][] data) {
	double max = data[0][0];
	for (int i=0; i<data.length; i++) {
		for (int j=0; j<data[i].length; j++) {
			if (data[i][j] > max) {
				max = data[i][j];
			}
		}
	}
	return max;
}

public static double getLowestInArray(double [][] data) {
	double min = data[0][0];
	for (int i = 0; i<data.length; i++) {
		for(int j=0; j<data[i].length; j++) {
			if (data[i][j] < min) {
				min = data [i][j];
			}
		}
	}
	return min;
}







}
