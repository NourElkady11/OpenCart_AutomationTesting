package testCases;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC002_LoginTest extends BaseTest {
	
	
	@Test(groups = { "Sanity","Master"})
	public void Veriy_Login() {
		
		try{
			
			HomePage homePage=new HomePage(driver, waitDriver);
			homePage.clickMyAccount();
			homePage.clickLoginButton();
			
			LoginPage loginPage=new LoginPage(driver, waitDriver);
			loginPage.SetEmail(p.getProperty("email"));
			loginPage.SetPassword(p.getProperty("pass"));
			loginPage.ClickLogin();
			
			MyAccountPage myAccPage=new MyAccountPage(driver, waitDriver);
			Boolean IsAccountPageOpend=myAccPage.IsMyAccountPageDisplayed();
			
			
			assertTrue(IsAccountPageOpend);
			logger.info("Test Passed..");
		}catch(AssertionError e) {
			logger.error("Assertioon failed because .."+e.getMessage());
			throw e;
			
		}catch(Exception e) {
			logger.error("Exception Happend .."+e.getMessage());
			throw e;
		}
		
		
		
	}
	
	
	

}
