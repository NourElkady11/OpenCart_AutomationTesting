package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver,WebDriverWait waitDriver) {
		
		super(driver,waitDriver);
		
	}
	
	
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement MyAccountButton;
	
	@FindBy(xpath = "//ul[@class=\"dropdown-menu dropdown-menu-right\"]//a[normalize-space()='Register']")
	WebElement RegisterButton;
	
	@FindBy(xpath = "//ul[@class=\"dropdown-menu dropdown-menu-right\"]//a[normalize-space()='Login']")
	WebElement LoginButton;
	
	
	
	public void clickLoginButton() {
		
		waitDriver.until(ExpectedConditions.elementToBeClickable(LoginButton)).click();
		//LoginButton.click();
	}
	
	public void clickMyAccount() {
		waitDriver.until(ExpectedConditions.elementToBeClickable(MyAccountButton)).click();
		//MyAccountButton.click();
		
	}
	
	public void clickRegister() {
		
		waitDriver.until(ExpectedConditions.elementToBeClickable(RegisterButton)).click();
		//RegisterButton.click();
		
	}
	
	

}
