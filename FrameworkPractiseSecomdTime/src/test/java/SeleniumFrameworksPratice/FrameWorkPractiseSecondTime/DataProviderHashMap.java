package SeleniumFrameworksPratice.FrameWorkPractiseSecondTime;

import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SeleniumFrameWorksPratice.FrameworkPractiseSecomdTime.InitialSetUp;
import SeleniumFrameWorksPratice.FrameworkPractiseSecomdTime.LoginPageLocators;

public class DataProviderHashMap extends InitialSetUp {
	
	
	//If we have to send more no of parameters has map is better
	
	
	@Test(dataProvider ="Test2")
	public  void TestLogin(HashMap<String, String> input) throws IOException  {
		//String ProductName ="ADIDAS ORIGINAL";
		LoginPageLocators ll= launchApplication();
		ll.loggingIn(input.get("email"), input.get("password") );
		//Error Handling -->checkout Login Method
		//Assert.assertEquals("Incorrect email or password.", ll.getErrorMessage());

	}
	
	@DataProvider
	public Object[][] Test2() {
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("email", "sravanipani123@gmail.com");
		map.put("password", "Sravani@123");
		
		
		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("email", "sravanipani123@gmail.com");
		map1.put("password", "Sravani@123");
		return new Object[][] {{map} ,{map1}} ; 
	}
}
