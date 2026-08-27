package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
	
	
	public LoginPage(WebDriver driver, WebDriverWait waitDriver) {
		super(driver, waitDriver);
	}

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement emailFeild;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement PasswordFeild;
	
	@FindBy(xpath = "//form[@enctype=\"multipart/form-data\"]//input[@type=\"submit\"]")
	WebElement LoginBtn;
	
	
	public void SetEmail(String email) {
		emailFeild.clear();
		emailFeild.sendKeys(email);
	}
	
	public void SetPassword(String Password) {
		PasswordFeild.clear();
		PasswordFeild.sendKeys(Password);
	}
	
	public void ClickLogin() {
		waitDriver.until(ExpectedConditions.elementToBeClickable(LoginBtn)).click();
		//LoginBtn.click();
	}
	
	
	

}
