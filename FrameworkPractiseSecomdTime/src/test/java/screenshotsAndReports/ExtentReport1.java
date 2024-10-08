package screenshotsAndReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReport1 {
	//ExtentReports class is used to drive the excecution
	//Declaring it gloabally to use in further tests in the class
	
	ExtentReports extent;
	
	@BeforeTest
	public void config() {
		//ExtentSparkReporter class is used to config
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Extent Report Pratice Session");
		reporter.config().setDocumentTitle("Extent Reports");
		
		
		//using global declaration
		extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Sravani Pani");
		extent.createTest("Test created"); // this is something we need to use everytime ao we will declare it in listners class
		
	}
}
