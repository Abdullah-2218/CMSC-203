/* Class: CMSC203 CRN 30295 

 Program: Assignment 3 

 Instructor: Grigority A Grinberg 

 Summary of Description: This assignment focuses on encryption and decryption of data  

 Due Date: 3/2/2026 

 Integrity Pledge: I pledge that I have completed the programming assignment independently. 

 I have not copied the code from a student or any source. 

Name: Abdullah Khan */

 

/**
 * This is a utility class that encrypts and decrypts a phrase using three
 * different approaches. 
 * 
 * The first approach is called the Vigenere Cipher.Vigenere encryption 
 * is a method of encrypting alphabetic text based on the letters of a keyword.
 * 
 * The second approach is Playfair Cipher. It encrypts two letters (a digraph) 
 * at a time instead of just one.
 * 
 * The third approach is Caesar Cipher. It is a simple replacement cypher. 
 * 
 * @author Huseyin Aygun
 * @version 8/3/2025
 */
import java.util.*;
public class CryptoManager { 

    private static final char LOWER_RANGE = ' ';
    private static final char UPPER_RANGE = '_';
    private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;
    // Use 64-character matrix (8X8) for Playfair cipher  
    private static final String ALPHABET64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 !\"#$%&'()*+,-./:;<=>?@[\\]^_";

    public static boolean isStringInBounds(String plainText) {
        for (int i = 0; i < plainText.length(); i++) {
            if (!(plainText.charAt(i) >= LOWER_RANGE && plainText.charAt(i) <= UPPER_RANGE)) {
                return false;
            }
        }
        return true;
    }

	/**
	 * Vigenere Cipher is a method of encrypting alphabetic text 
	 * based on the letters of a keyword. It works as below:
	 * 		Choose a keyword (e.g., KEY).
	 * 		Repeat the keyword to match the length of the plaintext.
	 * 		Each letter in the plaintext is shifted by the position of the 
	 * 		corresponding letter in the keyword (A = 0, B = 1, ..., Z = 25).
	 */   

    public static String vigenereEncryption(String plainText, String key) {
    	if (!isStringInBounds(plainText))
    		return "The selected string is not in bounds, Try again."; 	
    	StringBuilder result = new StringBuilder();
    	
    	for(int i=0; i< plainText.length(); i++) {
    		
    		char p = plainText.charAt(i);
    		char k = key.charAt(i % key.length());
    		
    		int shift = k - 'A';
    		
    		int value = (p - LOWER_RANGE + shift) % RANGE;
    		char encrypted = (char) (value + LOWER_RANGE);
    		result.append(encrypted);
    		
    	}
    	return result.toString();
    }

    // Vigenere Decryption
    public static String vigenereDecryption(String encryptedText, String key) {
        	if (!isStringInBounds(encryptedText))
        		return "The selected string is not in bounds, Try again.";
        	StringBuilder result = new StringBuilder();
        	for(int i=0; i< encryptedText.length(); i++) {
        		char e = encryptedText.charAt(i);
        		char k = key.charAt(i % key.length());
        		
        		int shift = k - 'A';
        		int value = (e - LOWER_RANGE - shift) % RANGE;
        		
        		if (value < 0)
        			value += RANGE;
        		
        		char decrypted = (char) (value + LOWER_RANGE);
        		result.append(decrypted);
        			
        	}
        	return result.toString();
    }


	/**
	 * Playfair Cipher encrypts two letters at a time instead of just one.
	 * It works as follows:
	 * A matrix (8X8 in our case) is built using a keyword
	 * Plaintext is split into letter pairs (e.g., ME ET YO UR).
	 * Encryption rules depend on the positions of the letters in the matrix:
	 *     Same row: replace each letter with the one to its right.
	 *     Same column: replace each with the one below.
	 *     Rectangle: replace each letter with the one in its own row but in the column of the other letter in the pair.
	 */    
private static char[][] buildMatrix (String key) {
	LinkedHashSet<Character> set = new LinkedHashSet<>();
	
	for (char c : key.toCharArray())
		if (ALPHABET64.indexOf(c) != -1)
				set.add(c);
	
	for (char c : ALPHABET64.toCharArray()) {
		if (set.size() == 64)
			break;
	
		set.add(c);
	}
	
	char[][] matrix = new char [8][8];
	Iterator <Character> it = set.iterator();
	
	for (int i = 0; i<8; i++) {
		for (int j=0; j<8; j++) {
			if(!it.hasNext())
				throw new IllegalStateException("Matrix not filled correctly");
			matrix[i][j] = it.next();
		}
	}	
	
	return matrix;
}
        		
	
private static int[] findPosition(char[][] matrix, char c) {
	
	for (int i = 0; i<8; i++)
		for (int j=0; j<8; j++)
			if (matrix[i][j]==c)
				return new int[] {i, j};
	return null;
}

    public static String playfairEncryption(String plainText, String key) {
         if (!isStringInBounds (plainText))
        	return "The selected string is not in bounds. Try again.";
         
         char[][] matrix = buildMatrix(key);
         if (plainText.length() % 2 != 0)
        	 plainText += " ";
         
         StringBuilder result = new StringBuilder();
         for (int i = 0; i< plainText.length(); i+=2) {
        	 
        	 char a = plainText.charAt(i);
        	 char b = plainText.charAt(i + 1);
        	 
        	 int[] posA = findPosition(matrix, a);
        	 int[] posB = findPosition(matrix, b);
        	 
        	 int r1 = posA[0], c1 = posA[1];
        	 int r2 = posB[0], c2 = posB[1];
        	 
        	 if (r1 == r2) {
        		 result.append(matrix[r1][(c1 + 1) % 8]);
        		 result.append(matrix[r2][(c2 + 1) % 8]);
        		 
        	 } else if (c1 == c2) {
        		 result.append(matrix[(r1+ 1) % 8] [c1]);
        		 result.append(matrix[(r2+ 1) % 8] [c2]);
        	 } else {
        		 result.append(matrix[r1] [c2]);
        		 result.append(matrix[r2] [c1]);
        	 }
        	 
         }
         return result.toString();
        
    }

    // Vigenere Decryption
    public static String playfairDecryption(String encryptedText, String key) {
    	 if (!isStringInBounds (encryptedText))
         	return "The selected string is not in bounds, Try again.";
    	 
    	 char[][] matrix = buildMatrix(key);
    	 StringBuilder result = new StringBuilder();
    	 
    	 for (int i = 0; i< encryptedText.length(); i+=2) {
    		 char a = encryptedText.charAt(i);
        	 char b = encryptedText.charAt(i + 1);
        	 
        	 int[] posA = findPosition(matrix, a);
        	 int[] posB = findPosition(matrix, b);
        	 
        	 int r1 = posA[0], c1 = posA[1];
        	 int r2 = posB[0], c2 = posB[1];
        	 
        	 if (r1 == r2) {
        		 result.append(matrix[r1][(c1 - 1 + 8) % 8]);
        		 result.append(matrix[r2][(c2 - 1 + 8) % 8]);
        		 
        	 } else if (c1 == c2) {
        		 result.append(matrix[(r1 - 1 + 8) % 8] [c1]);
        		 result.append(matrix[(r2 - 1 + 8) % 8] [c2]);
        	 } else {
        		 result.append(matrix[r1] [c2]);
        		 result.append(matrix[r2] [c1]);
        	 }
        	 
    	 }
    	 if (result.length() > 0 && result.charAt(result.length() - 1) == ' ')
    		 result.deleteCharAt(result.length()-1);
    	 
    	 return result.toString();
    }

    /**
     * Caesar Cipher is a simple substitution cipher that replaces each letter in a message 
     * with a letter some fixed number of positions down the alphabet. 
     * For example, with a shift of 3, 'A' would become 'D', 'B' would become 'E', and so on.
     */    
 
    public static String caesarEncryption(String plainText, int key) {
	if (!isStringInBounds(plainText))
		return "The selected string is not in bounds, Try again.";
	StringBuilder result = new StringBuilder();
	for(int i=0; i< plainText.length(); i++) {
		char c = plainText.charAt(i);
		int shifted = (c- LOWER_RANGE + key) % RANGE;
		char encrypted = (char) (shifted + LOWER_RANGE);
		result.append(encrypted);
		
	}
	return result.toString() ;
	
	
	}
		
	
    

    // Caesar Decryption
    public static String caesarDecryption(String encryptedText, int key) {
    	if (!isStringInBounds(encryptedText))
    		return "The selected string is not in bounds, Try again.";
    	StringBuilder result = new StringBuilder();
    	for(int i=0; i<encryptedText.length(); i++) {
    		char c = encryptedText.charAt(i);
    		int shifted = (c- LOWER_RANGE - key) % RANGE;
    		if (shifted < 0)
    			shifted += RANGE;
    		char decrypted = (char) (shifted + LOWER_RANGE);
    		result.append(decrypted);
    		}
    	return result.toString();
    }    

}
