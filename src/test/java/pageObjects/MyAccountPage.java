package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver, WebDriverWait waitDriver) {
		super(driver, waitDriver);
		
	}
	
	@FindBy(xpath = "//div[@id=\"content\"]//h2[normalize-space()='My Account']")
	WebElement MyAccountText;
	
	@FindBy(xpath = "//ul[@class=\"dropdown-menu dropdown-menu-right\"]//a[normalize-space()='Logout']")
	WebElement LogOutButton;
	
	public Boolean IsMyAccountPageDisplayed() {
		
		try{
			return waitDriver.until(ExpectedConditions.visibilityOf(MyAccountText)).isDisplayed();
		}
		catch(Exception ex){
			return false;
		}
		
	}
	
	public void ClickLogOut() {
		waitDriver.until(ExpectedConditions.elementToBeClickable(LogOutButton)).click();
		//LogOutButton.click();
		
	}
	
	
}
