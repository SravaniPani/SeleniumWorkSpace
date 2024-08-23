package io.dependsOn;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DepdensOn {
	
	@Test(timeOut=4000)
	public static void ZlastMethod() {
		System.out.println("It has to execute first!!");
		
	}
	
	@Test(dependsOnMethods= {"ZlastMethod"})
	//@Test
	public static void PlastMethod() {
		System.out.println("In general it will execute first!!");
		
	}
	
	

	@Test(dependsOnMethods= {"BlastMethod","B1lastMethod"})
	//@Test
	public static void ClastMethod() {
		System.out.println("It has to execute second!!");
		
	}
	
	@Test
	public static void BlastMethod() {
		System.out.println("In general it will execute SecondA!!");
		
	}
	
	@Test
	public static void B1lastMethod() {
		System.out.println("In general it will execute SecondB!!");
		
	}
	
	@Test(enabled=false)
	public static void Failure() {
		System.out.println("failed");
		
	}
	
	
	@Parameters({"url","extension"})
	@Test()
	public static void para(String urlResult, String extensionValue) {
		System.out.println(urlResult);
		System.out.println("parameter from different section");
		System.out.println(extensionValue);
		
	}

	
}
