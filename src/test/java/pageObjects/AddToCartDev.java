package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartDev extends BasePage  {

	public AddToCartDev(WebDriver driver, WebDriverWait waitDriver) {
		super(driver, waitDriver);
	
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
	
	
	
	public void clickOnLapTopsAndNoteBooks_GoToWindows_GoToCameras() {
		super.click(LapTopAndNoteBooksTab);
		super.click(WindowsBtn);
		super.click(Cameras);
		
	}
	
	public void clickAddToCart() {
		super.click(AddToCartBtn);
		
	}
	
	public WebElement GetActualTextEelemnt() { return ExpexctedText;}
	

}
