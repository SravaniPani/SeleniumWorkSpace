package SeleniumFrameworksPratice.jsonObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SeleniumFrameWorksPratice.FrameworkPractiseSecomdTime.InitialSetUp;
import SeleniumFrameWorksPratice.FrameworkPractiseSecomdTime.LoginPageLocators;

public class DataProviderHashMap extends InitialSetUp {
	
	
	//If we have to send more no of parameters has map is better
	
	
	@Test(dataProvider ="Test2")
	public  void TestLogin(HashMap<String, String> input) throws IOException  {
	
		LoginPageLocators ll= launchApplication();
		ll.loggingIn(input.get("email"), input.get("password") );
		
	}
	
	@DataProvider
	public Object[][] Test2() throws IOException {
//		
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("email", "sravanipani123@gmail.com");
//		map.put("password", "Sravani@123");
//		
//		
//		HashMap<String, String> map1 = new HashMap<String, String>();
//		map1.put("email", "sravanipani123@gmail.com");
//		map1.put("password", "Sravani@123");
		
		//Modifying above code as json file
		JsonDataProviderHashMap jsp = new JsonDataProviderHashMap();
		List<HashMap<String,String>> data  = jsp.getJsonData(System.getProperty("user.dir")+ "//src//test//java//SeleniumFrameworksPratice//jsonObject//dataprovider.json");
		return new Object[][] { {data.get(0)} ,{data.get(1) } } ; 
	}
}
