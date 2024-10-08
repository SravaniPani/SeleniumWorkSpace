package SeleniumFrameWorksPratice.FrameworkPractiseSecomdTime.Abstract;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractClassTestForWaits {
	
	WebDriver driver;
	public AbstractClassTestForWaits(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	// driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();

	@FindBy(css="button[routerlink*='cart']")
	WebElement cartIcon;
	
	public void ImplictWaitForAddToCart(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void invisibleBy(WebElement findBy2) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.invisibilityOf(findBy2));
	}
	
	public void errorMessages(WebElement findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	

    public void clickOnCartSybol() {
    	cartIcon.click();
    }
	
	
	
}
