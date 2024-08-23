package io.annotations;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestAnnotations {
	@AfterTest
	public static void After() {
		System.out.println("Test Exceution Ends Here!!");
	}
	@Test
	public static void Test1() {
		System.out.println("Line1");
	}
	
	
	@Test
	public static void Test2() {
		System.out.println("Line2");
	}
	
	@Test
	public static void Test3() {
		System.out.println("Line3");
	}
	
	@Test
	public static void Test4() {
		System.out.println("-------------------------------------");
	}
	
	@Test
	public static void WAuto() {
		System.out.println("Auto1");
	}
	
	@Test(groups=("together"))
	public static void Auto1() {
		System.out.println("Auto2");
		Assert.assertFalse(true);
	}
	
	@org.testng.annotations.BeforeMethod
	public static void BeforeMethod() {
		System.out.println("Sugar-Exceution starts here!!");
	}
	
	@BeforeSuite
	public static void WSupreme() {
		System.out.println("The first message");
	}
	

	@AfterSuite
	public static void Extreme() {
		System.out.println("The last message");
	}


}
