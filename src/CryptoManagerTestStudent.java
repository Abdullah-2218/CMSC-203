/* Class: CMSC203 CRN 30295 

 Program: Assignment 3 

 Instructor: Grigority A Grinberg 

 Summary of Description: This assignment focuses on encryption and decryption of data  

 Due Date: 3/2/2026 

 Integrity Pledge: I pledge that I have completed the programming assignment independently. 

 I have not copied the code from a student or any source. 

Name: Abdullah Khan */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CryptoManagerTestStudent {
	
	String plainText;
	String keyText;
	int key;
	
	@BeforeEach
	public void setUp () {
		
		plainText = "HELLO CLASS";
		keyText = "SECRET";
		key = 5;
	}
	/* isStringInBounds Student Tests */
	
	@Test
	public void testStringWithinBounds() {
		assertTrue (CryptoManager.isStringInBounds("JAVA PROGRAMMING"));
		
	}
	
	@Test 
	public void testStringOutsideBounds() {
		assertFalse(CryptoManager.isStringInBounds("java"));
	}
	
	/* Caesar Cipher Student Tests*/
	
	@Test
	public void testCaesarEncryptDecrypt() {
		String encrypted= CryptoManager.caesarEncryption(plainText, key);
		String decrypted= CryptoManager.caesarDecryption(encrypted, key);
		
		assertEquals(plainText, decrypted);
	}
	
	@Test
	public void testCaesarBoundaryWrap() {
		String encrypted= CryptoManager.caesarEncryption("_", 2);
		assertEquals ("!", encrypted);
	}
	
@Test
public void testCaesarInvalidString() {
	String result = CryptoManager.caesarEncryption("hello", 3);
	assertEquals("The selected string is not in bounds, Try again.", result);
}
/* Vigenere Cipher Student Tests */

@Test
public void testVigenereEncryptDecrypt() {
	String encrypted= CryptoManager.vigenereEncryption("NETWORK SECURITY", keyText);
	String decrypted= CryptoManager.vigenereDecryption(encrypted, keyText);
	
	assertEquals("NETWORK SECURITY", decrypted);
}

@Test
public void testVigenereSingleLetter() {
	String encrypted = CryptoManager.vigenereEncryption("Z", "B");
	String decrypted= CryptoManager.vigenereDecryption(encrypted, "B");
	
	assertEquals("Z", decrypted);
}

@Test
public void testVigenereInvalidInput() {
	String result = CryptoManager.vigenereEncryption("test", "KEY");
	assertEquals("The selected string is not in bounds, Try again.", result);
}

/* PLayfair Cipher Student Tests */

public void testPlayfairEncryptDEcrypt() {
	String text = "CYBER SECURITY";
	String key = "Matrix";
	
	String encrypted = CryptoManager.playfairEncryption(text, key);
	String decrypted = CryptoManager.playfairDecryption(encrypted, key);
	
	assertEquals(text, decrypted);
	
}

@Test
public void testPlayfairOddLengthText() {
	String text = "DOG";
	String key = "KEYWORD";
	
	String encrypted = CryptoManager.playfairEncryption(text, key);
	String decrypted = CryptoManager.playfairDecryption(encrypted, key);
	
	assertEquals(text, decrypted);
}

@Test
public void testPLayfairSingleCharacter() {
	
	String text = "X";
	String key = "PLAY";
	
	String encrypted = CryptoManager.playfairEncryption(text, key);
	String decrypted = CryptoManager.playfairDecryption(encrypted, key);
	
	assertEquals(text, decrypted);
}

@Test
public void testPlayfairSymbols() {
	String text = "@#";
	String key = "CIPHER";
	
	String encrypted = CryptoManager.playfairEncryption(text, key);
	String decrypted = CryptoManager.playfairDecryption(encrypted, key);
	
	assertEquals(text, decrypted);
	
    }
}


