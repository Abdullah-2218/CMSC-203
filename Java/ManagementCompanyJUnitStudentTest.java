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

public class ManagementCompanyJUnitStudentTest {

	  @Test
	  public void testAddProperty() {
		  ManagementCompany mc = new ManagementCompany ("TestCo", "111");
		  
		  Property p = new Property("Apt1", "City", 1000,"Owner");
		  int result = mc.addProperty(p);
		  
		  assertEquals(0, result);
		  assertEquals(1, mc.getPropertyCount());
	  }
	  
	  @Test
	  public void testTotalRent() {
		  ManagementCompany mc = new ManagementCompany("TestCo", "111");
		  
		  mc.addProperty(new Property("A", "City", 1000,"0"));
		  mc.addProperty(new Property("B", "City", 2000,"0"));
		  
		  assertEquals(3000.0, mc.totalRent(), 0.001);
	  }
	  
	  @Test
	  public void testAddWhenFull() {
		  ManagementCompany mc = new ManagementCompany("TestCo", "111");
		  
		  for(int i = 0; i< ManagementCompany.MAX_PROPERTIES; i++) {
			  mc.addProperty(new Property("P" + i, "City", 1000, "0"));
		  }
		  
		  int result = mc.addProperty(new Property("Extra", "City", 5000, "0"));
		  assertEquals(-1, result);
	  }
	  
	  @Test
	  public void testCopyConstructor() {
		  ManagementCompany mc1 = new ManagementCompany("TestCo", "111");
		  mc1.addProperty(new Property("A", "City", 1000, "0"));
		  
		  ManagementCompany mc2 = new ManagementCompany(mc1);
		  
		  assertEquals(mc1.getPropertyCount(), mc2.getPropertyCount());
		  assertNotSame(mc1.getProperty(0), mc2.getProperty(0));
	  }
 }

