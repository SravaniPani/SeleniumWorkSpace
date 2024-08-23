package SeleniumFrameWorks.FrameWork1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.internal.invokers.ExpectedExceptionsHolder;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProductCatalogTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		LandingPage lp = new LandingPage(driver);
		driver.manage().window().maximize();
		driver.findElement(By.id("userEmail")).sendKeys("sravanipani1234@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Sravani@123");
		driver.findElement(By.id("login")).click();
		ProductCatalog pb= new ProductCatalog(driver);
		List<WebElement> products = pb.productsList();
		
		WebElement desiredProduct =	products.stream().filter(product->
	    product.findElement(By.cssSelector("b")).getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);
		desiredProduct.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
     	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		
		
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating"))); --- It's taking time so to voercome we are writing next step.
		//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
    	driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
    	List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));		
    	Boolean match = cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase("ADIDAS ORIGINAL"));
    	Assert.assertTrue(match);
    	driver.findElement(By.cssSelector(".totalRow button")).click();
    	
    	JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
    	Actions a= new Actions(driver);
    	a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.xpath("(//button[contains(@class, 'ta-item')])[2]")).click();
    	
    	
//    	Actions a = new Actions(driver);
//    	a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();
//       	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
//       	driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
    	driver.findElement(By.cssSelector(".action__submit")).click();
       	String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
    	Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    	driver.close();
	
	}

	
}
