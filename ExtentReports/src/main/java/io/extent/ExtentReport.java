package io.extent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReport {
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
		
	}
	
	
	
	@Test
	public void FirstTestReport() {
	//extent.createTest("First test report");
	
	// Writing object for the test, which will be responsible for further actions, by using extent class
	ExtentTest test=  extent.createTest("First test report");	//Entry for particular test
				
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/client");
	System.out.println(driver.getTitle());
	driver.close();  // Make sure to close the driver
	
	}
	
	
	//Flush and Close the Report:
	//ExtentReports requires you to flush and close the report properly to ensure the report is written to disk.
	//You should call extent.flush() in an @AfterTest method or similar to ensure this
	@AfterTest
	public void teardown() {
	    extent.flush();
	}

}
