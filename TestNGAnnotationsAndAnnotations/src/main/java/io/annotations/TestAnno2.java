package io.annotations;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestAnno2 {
	@BeforeTest
	public static void Before() {
		System.out.println("Exceution starts here!!");
	}
	@Test(groups=("together"))
	public static void test() {
		System.out.println("Testing");
		
	}

}
