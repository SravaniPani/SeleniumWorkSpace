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

import SeleniumFrameWorksPratice.FrameworkPractiseSecomdTime.AddingProductToCartTest;
import SeleniumFrameWorksPratice.FrameworkPractiseSecomdTime.LoginPageLocators;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {
	public static void main(String[] args) {
		
	
		String ProductName ="ADIDAS ORIGINAL";
		
		WebDriverManager.chromedriver().setup(); // to call it by default
		WebDriver driver= new ChromeDriver(); // creating object to access chrome driver
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // wait at global level
		driver.manage().window().maximize(); //Maximize the screen
		
//		driver.get("https://rahulshettyacademy.com/client");
//		driver.findElement(By.id("userEmail")).sendKeys("sravanipani1234@gmail.com");
//		driver.findElement(By.id("userPassword")).sendKeys("Sravani@123");
//		driver.findElement(By.id("login")).click();
		
		
		//now modify above code using pom
		LoginPageLocators ll =new LoginPageLocators(driver);
		ll.goToLogin();  
		ll.loggingIn("sravanipani1234@gmail.com", "Sravani@123");
		
		
		
		//getting all elements into list
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
//		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		
		
		
		
		//Modifying the above code
		AddingProductToCartTest apt =  new AddingProductToCartTest(driver);
		apt.productsListData();
		
		
		//Adding product to cart
		
//		WebElement desiredProduct =	products.stream().filter(product->
//	    product.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst().orElse(null);
//		desiredProduct.findElement(By.cssSelector(".card-body button:last-of-type")).click();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating"))); --- It's taking time so to voercome we are writing next step.
//		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		

		
		
		
		//Modifying above code
		apt.AddProductToCart(ProductName);
		
		
		//clicking on cart symbol
		
		
    	// driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
		
		
		
		//Modifying the above code
		apt.clickOnCartSybol();
		

		
		
		
		
		
		
		
		
		
		
	}

}
