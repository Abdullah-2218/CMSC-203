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

import static org.junit.Assert.*;
import org.junit.Test;

public class PropertyJUnitStudentTest {
	
	@Test
	public void testDefaultConstructor() {
		Property p = new Property();
		assertEquals("", p.getPropertyName());
		assertEquals("", p.getCity());
		assertEquals(0.0, p.getRentAmount(), 0.001);
		assertEquals("", p.getOwner());
	}
	
	@Test
	public void testParameterizedConstructor() {
		Property p = new Property ("Apt", "NYC", 2000.0, "Ali");
		assertEquals("Apt", p.getPropertyName());
		assertEquals("NYC", p.getCity());
		assertEquals(2000.0, p.getRentAmount(), 0.001);
		assertEquals("Ali", p.getOwner());
	}
	
	@Test
	public void testCopyConstructor() {
		Property p1 = new Property("Apt", "NYC", 2000.0, "ALi");
		Property p2 = new Property (p1);
		
		assertEquals(p1.getPropertyName(), p2.getPropertyName());
		assertEquals(p1.getCity(), p2.getCity());
		assertEquals(p1.getRentAmount(), p2.getRentAmount(), 0.001);
		assertEquals(p1.getOwner(), p2.getOwner());
	}
}
