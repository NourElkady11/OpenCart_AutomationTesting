package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegisterPage extends BasePage {

	public AccountRegisterPage(WebDriver driver, WebDriverWait waitDriver) {
		super(driver, waitDriver);
	
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstname;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastname;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txtTelephone;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtConfirmPassword;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement checkBoxdPolicy;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btnContinue;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	//////////////////Actions/////////////////////////////
	
	
	public void setFirstName(String firstName) {
	    txtFirstname.clear();
	    txtFirstname.sendKeys(firstName);
	}

	public void setLastName(String lastName) {
	    txtLastname.clear();
	    txtLastname.sendKeys(lastName);
	}

	public void setEmail(String email) {
	    txtEmail.clear();
	    txtEmail.sendKeys(email);
	}

	public void setTelephone(String telephone) {
	    txtTelephone.clear();
	    txtTelephone.sendKeys(telephone);
	}

	public void setPassword(String password) {
	    txtPassword.clear();
	    txtPassword.sendKeys(password);
	}

	public void setConfirmPassword(String confirmPassword) {
	    txtConfirmPassword.clear();
	    txtConfirmPassword.sendKeys(confirmPassword);
	}

	public void setPrivacyPolicy(boolean accept) {
	    if (checkBoxdPolicy.isSelected() != accept) {
	    	checkBoxdPolicy.click();
	    }
	}

	public void clickContinue() {
		waitDriver.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
	    //btnContinue.click();
	}

	public String getConfirmationMessage() {
		
		try {
			 return msgConfirmation.getText();
		} catch (Exception e) {
			return e.getMessage();
		}
	   
	}
	
	

}
