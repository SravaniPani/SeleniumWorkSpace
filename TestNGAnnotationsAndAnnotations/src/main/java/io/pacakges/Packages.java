package io.pacakges;

import org.testng.annotations.Test;

public class Packages {

	@Test
	public static void Demo() {
		System.out.println("Demo1");
	}
	
	@Test(groups=("together"))
	public static void Demo1() {
		System.out.println("Demo2");
	}
}
