package testCases;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC003_DDT_LoginTest extends BaseTest {

	
	@Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class,groups = {"DDT"})
	public void  Verify_DDT_LoginTest(String email,String pass,String status) throws Exception {
		
		
			try{	
				
				HomePage homePage=new HomePage(driver, waitDriver);
				homePage.clickMyAccount();
				homePage.clickLoginButton();
				
				LoginPage loginPage=new LoginPage(driver, waitDriver);
				
				loginPage.SetEmail(email);
				loginPage.SetPassword(pass);
				loginPage.ClickLogin();
				
				
				MyAccountPage myAccPage=new MyAccountPage(driver, waitDriver);
				Boolean IsAccountPageOpend=myAccPage.IsMyAccountPageDisplayed();
				
				if(status.equalsIgnoreCase("valid")) {
					
					assertTrue(IsAccountPageOpend);
					homePage.clickMyAccount();
					myAccPage.ClickLogOut();
			
					logger.info("Test Passed and logOut Is Donee..");
					
				}else {
					assertFalse(IsAccountPageOpend);
					
					
				}
				
				Thread.sleep(2000);
				}
				catch(AssertionError e) {
					logger.error("Assertioon failed of "+email+" because .."+e.getMessage()+"Value of status is "+status);
					throw e;
					
				}catch(Exception e) {
					logger.error("Exception Happend .."+e.getMessage());
					throw e;
				}
			
		}  
	
	
}
