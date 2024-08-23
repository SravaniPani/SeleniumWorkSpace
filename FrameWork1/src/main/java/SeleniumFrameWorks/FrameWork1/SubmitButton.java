package SeleniumFrameWorks.FrameWork1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubmitButton extends AbstractClass{
	WebDriver driver;
	
	//The use of constructor is it will invole first whenever the object of the class calls
	public SubmitButton(WebDriver driver) {
		super(driver);
		//Delcaring this in StandAloneTest to invoke the driver object nad we are assigning it to local driver object.
		this.driver=driver;
		//WebElement wb = driver.findElement(By.id("userEmail"));  ---> like this we will write in general
		PageFactory.initElements(driver, this);
		
		// the initElements method will take 2 objects one is driver and another one is this
	}
	
	// so there's another way of declaring it that is called page factory.. it will hep us to reduce the syntax and code.
		@FindBy(id="userEmail")
		WebElement useName;
		
		// you may be wondering that, how it will work.. how it takes web element and all
		// the reason is it will take initElements method which we will declare first..
		// If we click on "@FindBy", you will get declaration of other syntaxes.

		@FindBy(id="userPassword")
		WebElement password;
		
		@FindBy(id="login")
		WebElement loginButton;
		
		
//--------------------------------------------------------------------------------------------------------------------------------------------------------
		
		//1. Writing everything in one method
//		public void loginDetailsAction() {
//			useName.sendKeys("sravanipani1234@gmail.com");
//			password.sendKeys("Sravani@123");
//			loginButton.click();
//		}
		
		//2.
		
		public void loginDetailsAction(String usname, String pass) {
			useName.sendKeys(usname);
			password.sendKeys(pass);
			loginButton.click();
		}
		
		public void getUrl() {
			driver.get("https://rahulshettyacademy.com/client");
		}
		

}
