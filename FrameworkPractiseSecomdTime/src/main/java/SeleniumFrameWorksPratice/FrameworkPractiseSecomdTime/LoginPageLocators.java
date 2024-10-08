package SeleniumFrameWorksPratice.FrameworkPractiseSecomdTime;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFrameWorksPratice.FrameworkPractiseSecomdTime.Abstract.AbstractClassTestForWaits;

public class LoginPageLocators  extends AbstractClassTestForWaits{
	WebDriver driver;
	
	//Writing constructor cause it will invoke first
	public LoginPageLocators(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="userEmail")
	WebElement usname;
	@FindBy(id="userPassword")
	WebElement password;
	@FindBy(id="login")
	WebElement login;
	
	//error handling
	@FindBy(css="[class*='flyOut']")
	WebElement errorMessage;
	
	public void  goToLogin() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public void loggingIn(String username, String pass ) {
		usname.sendKeys(username);
		password.sendKeys(pass);
		login.click();
		
	}
	
	
	public String getErrorMessage() {
	errorMessages(errorMessage);
	return  errorMessage.getText();
	}
	
	
	

}
