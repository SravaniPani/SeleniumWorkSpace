package io.dependsOn;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class parameters {
	@Parameters({"url"})
	@Test
	public static void parameterTest1(String urlValue)
	{
		System.out.println("This is parameter 1");
		System.out.println(urlValue);
	}
	
	@Test(priority=0)
	public static void zparameterTest2()
	{
		System.out.println("priority is important");
	}
	
	@Test(priority=1)
	public static void parameterTest2()
	{
		System.out.println("This is parameter 2");
	}
	

	@Test(priority=3)
	public static void aparameterTest3()
	{
		System.out.println("This is parameter 3");
	}
	
	@Test(dataProvider="getData")
	public static void Datarpovider(String first, String password){
		System.out.println(first);
		System.out.println(password);
		
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data =new Object[3][2];
		data[0][0] ="first name";
		data[0][1] ="first password";
		
		data[1][0] ="second name";
		data[1][1] ="second password";
		
		
		data[2][0] ="third name";
		data[2][1] ="third password";

		return data;

		
		
		
	}
	
	
}
