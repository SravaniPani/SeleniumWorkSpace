package SeleniumFrameworksPratice.FrameWorkPractiseSecondTime;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import SeleniumFrameWorksPratice.FrameworkPractiseSecomdTime.AddingProductToCartTest;
import SeleniumFrameWorksPratice.FrameworkPractiseSecomdTime.InitialSetUp;
import SeleniumFrameWorksPratice.FrameworkPractiseSecomdTime.LoginPageLocators;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EroorHandlingProperties extends InitialSetUp{
	@org.testng.annotations.Test
	public  void Test() throws IOException  {
		String ProductName ="ADIDAS ORIGINAL";
		LoginPageLocators ll=launchApplication();
		ll.loggingIn("sravanipani1234@gmail.com", "Sravani@123");
		AddingProductToCartTest apt =  new AddingProductToCartTest(driver);
		apt.productsListData();
		apt.AddProductToCart(ProductName);
		apt.clickOnCartSybol();
		
		

	}

}
