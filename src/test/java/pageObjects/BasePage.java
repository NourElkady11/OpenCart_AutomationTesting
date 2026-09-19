package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	WebDriver driver;
	WebDriverWait waitDriver;
	
	public BasePage(WebDriver driver,WebDriverWait waitDriver) {
		this.driver=driver;
		this.waitDriver=waitDriver;
		PageFactory.initElements(driver, this);
		
		
	}	
	
	
	
	  protected void click(WebElement element) {
		   waitDriver.until(ExpectedConditions.visibilityOf(element)).click();
	}

}
