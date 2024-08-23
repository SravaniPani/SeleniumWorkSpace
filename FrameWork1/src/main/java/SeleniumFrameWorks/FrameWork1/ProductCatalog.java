package SeleniumFrameWorks.FrameWork1;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCatalog extends AbstractClass {
	WebDriver driver;
	public ProductCatalog(WebDriver driver) {
		super(driver); // Used to send anything from child to parent
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	

		
		
		
 //List<WebElement> products = driver.findElements(By.cssSelector(".mb-3")); -- changing product catalog
	@FindBy(css=".mb-3")
	List<WebElement> products;
//WebElement product;
	By productNames = By.cssSelector(".mb-3");
	//desiredProduct.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	//By add = By.cssSelector(".card-body button:last-of-type"); 
	
	public List<WebElement> productsList() {
		WaitForElementsToAppear(productNames);
		return  products;
		
	}
	
	
	public WebElement checkProducts(String ProductName) {
		WebElement pro= productsList().stream().filter(product->
	    product.findElement(By.cssSelector("b")).getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);
		return pro;
	}
	
//	public void AddToCart(String productt) {
//		WebElement pro = checkProducts(ProductName);
//		pro.findElement(By.cssSelector(".card-body button:last-of-type")).click();
//
//		
//		
//	}
//		

}
