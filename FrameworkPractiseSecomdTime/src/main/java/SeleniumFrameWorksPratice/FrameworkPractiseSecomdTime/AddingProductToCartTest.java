package SeleniumFrameWorksPratice.FrameworkPractiseSecomdTime;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFrameWorksPratice.FrameworkPractiseSecomdTime.Abstract.AbstractClassTestForWaits;

public class AddingProductToCartTest extends AbstractClassTestForWaits {
	WebDriver driver;
	public AddingProductToCartTest(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	
//	List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
    @FindBy(css=".mb-3")
    List<WebElement> productsList;
    @FindBy(css=".ng-animating")
    WebElement spinner;
    
    By productsBy = By.cssSelector(".mb-3");
    By addToCart= By.cssSelector(".card-body button:last-of-type");
    By toastMessage= By.cssSelector("#toast-container");
    
    public List<WebElement> productsListData() {
    	ImplictWaitForAddToCart(productsBy);
    	return productsList;
    	
    }
    
    public WebElement productByname(String ProductName) {
    	WebElement desiredProduct =	productsListData().stream().filter(product->
	    product.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst().orElse(null);
    	return desiredProduct;

    	
    }
    
    public void AddProductToCart(String ProductName) {
    	WebElement desiredProduct= productByname(ProductName);
    	desiredProduct.findElement(addToCart).click();
    	ImplictWaitForAddToCart(toastMessage);
    	invisibleBy(spinner);

    }
    
    
	

}
