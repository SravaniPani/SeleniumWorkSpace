package SeleniumFrameWorksPratice.FrameworkPractiseSecomdTime;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InitialSetUp {
	 public WebDriver driver;
	public LoginPageLocators lp;
	public WebDriver IntilaValues() throws IOException {

		// Properties class to use properties
		Properties prop = new Properties();

		// file path for every user and your local path, make sure to use "//" than only
		// jabva will recognise it as a path.
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\main\\java\\SeleniumFrameWorksPratice\\properties\\global.properties");
		// to load properties
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup(); // to call it by default
			driver = new ChromeDriver(); // creating object to access chrome driver
		} else if (browserName.equalsIgnoreCase("firefox")) {

		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // wait at global level
		driver.manage().window().maximize(); // Maximize the screen

		return driver;

	}

	@BeforeTest(alwaysRun = true)
	public LoginPageLocators launchApplication() throws IOException {
		driver = IntilaValues();
		//LoginPageLocators lp = new LoginPageLocators(driver); ---> declaring it globally 
		lp = new LoginPageLocators(driver);
		lp.goToLogin();
		// keeping it generic to avoid from test
		return lp;
	}
	
	@AfterTest
	public void close() {
		driver.close();
	}

}
