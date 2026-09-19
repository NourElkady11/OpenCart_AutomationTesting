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
	
	@FindBy(xpath = "//h1[normalize-space()='Canon EOS 5D']")
	WebElement ExpexctedText;
	
	@FindBy(xpath = "//button[@onclick=\"cart.add('30', '1');\"]//span[normalize-space()='Add to Cart']")
	 WebElement AddToCartBtn;
	
	@FindBy(xpath="//div[@class=\"collapse navbar-collapse navbar-ex1-collapse\"]//a[@href=\"https://tutorialsninja.com/demo/index.php?route=product/category&path=18\"and @class=\"dropdown-toggle\"]")
	WebElement LapTopAndNoteBooksTab;
	
	@FindBy(xpath = "//a[normalize-space()='Windows (0)']")
	WebElement WindowsBtn;
	
	@FindBy(xpath = "//a[normalize-space()='Cameras (2)']")
	WebElement Cameras;
	

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement MyAccountButton;
	
	@FindBy(xpath = "//ul[@class=\"dropdown-menu dropdown-menu-right\"]//a[normalize-space()='Register']")
	WebElement RegisterButton;
	
	@FindBy(xpath = "//ul[@class=\"dropdown-menu dropdown-menu-right\"]//a[normalize-space()='Login']")
	WebElement LoginButton;
	
	//a[contains(normalize-space(),'sss')]
	////ul[@class="nav navbar-nav"]//a[normalize-space()='Tablets']
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
