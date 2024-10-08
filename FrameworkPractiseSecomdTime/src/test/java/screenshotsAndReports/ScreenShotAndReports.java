package screenshotsAndReports;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import SeleniumFrameWorksPratice.FrameworkPractiseSecomdTime.AddingProductToCartTest;
import SeleniumFrameWorksPratice.FrameworkPractiseSecomdTime.InitialSetUp;
import SeleniumFrameWorksPratice.FrameworkPractiseSecomdTime.LoginPageLocators;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShotAndReports extends InitialSetUp{
	@org.testng.annotations.Test
	public  void Test() throws IOException  {
		String ProductName ="ADIDAS ORIGINAL";
		LoginPageLocators ll=launchApplication();
		ll.loggingIn("sravanipani1234@gmail.com", "Sravani@123");
							
	}
	
	public String getScrennshot(String testCase) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//reports//"+testCase+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//reports//"+testCase+".png";
	}

}
