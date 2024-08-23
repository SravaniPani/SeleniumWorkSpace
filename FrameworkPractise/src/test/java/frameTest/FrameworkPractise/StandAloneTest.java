package frameTest.FrameworkPractise;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {
	
	//Artifcat  - Project name;
	//Group Id - Project No
	//Required dependencies - TestNG, maven, selenium, webDriver Manager
	
	//By using WebDriver Manger we can call it directly.
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		//driver.manage().window().maximize();
		driver.findElement(By.id("userEmail")).sendKeys("sravanipani1234@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Sravani@123");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait2= new WebDriverWait(driver, Duration.ofSeconds(5));
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		//Taking all the products into list.
		List<WebElement> productsList = driver.findElements(By.cssSelector(".mb-3"));
		
		//In that list we are filtering the particular product
		String deriedProduct = "ADIDAS ORIGINAL"; // product what we want
		
		WebElement product = productsList.stream().filter(products-> 
		products.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		
		
		//Adding it to cart
		product.findElement(By.cssSelector(".card-body button:last-of-type")).click();

		
		// so here we are using explicit wait until the message got displayed.. further clicking on cart button
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		//if not using element located by then have to use driver. ....
		// not using ElementLocatedBy to increase the speed
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		// we can use regualr expressions to locate the elements as well..
		driver.findElement(By.cssSelector("[routerLink*='cart']")).click();
		
		
		
		//now we are confirming that our product is there in list or not
		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
    Boolean match=	cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase("ZARA COAT 3"));
      Assert.assertTrue(match);
	    driver.findElement(By.cssSelector(".totalRow button")).click();
	    
	    
	
	


	}
	

}
