package SeleniumFrameworksPratice.FrameWorkPractiseSecondTime;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import SeleniumFrameWorksPratice.FrameworkPractiseSecomdTime.InitialSetUp;
import SeleniumFrameWorksPratice.FrameworkPractiseSecomdTime.LoginPageLocators;

public class DataProvider extends InitialSetUp {
	
	@Test(dataProvider ="Test2")
	public  void TestLogin(String username, String password) throws IOException  {
		//String ProductName ="ADIDAS ORIGINAL";
		LoginPageLocators ll= launchApplication();
		ll.loggingIn(username, password );
		//Error Handling -->checkout Login Method
		//Assert.assertEquals("Incorrect email or password.", ll.getErrorMessage());

	}
	
	@org.testng.annotations.DataProvider
	public Object[][] Test2() {
		return new Object[][]  {{"sravanipani1234@gmail.com","Sravani@123"},{"sravanipani1234@gmail.com","Sravani@123"}};
	}
}
