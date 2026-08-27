package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegisterPage;
import pageObjects.HomePage;
import utilities.Randomss;

public class TC001_AccountRegisterTest extends BaseTest {
	

	//If we specify 2 groups for 1 method 
	//we are using Master for all test cases to execute all tests but the other name we will use it to specify only this test in the Xml file  
	@Test(groups = { "Regression","Master"})
	public void verify_Account_Registerartion() {
		
		try {
			HomePage homePage=new HomePage(driver,waitDriver);
			homePage.clickMyAccount();
			homePage.clickRegister();
		
			AccountRegisterPage registerPage=new AccountRegisterPage(driver,waitDriver);
			registerPage.setFirstName(Randomss.randomAlphaCharcters().toUpperCase());
			registerPage.setLastName(Randomss.randomAlphaCharcters().toUpperCase());
			registerPage.setEmail(Randomss.randomAlphaCharcters()+"@gmail.com");
			registerPage.setTelephone("010"+Randomss.randomNumbers(9));
	
			
			String randomPass=Randomss.RandomMixedChars_WithSpecialChars_WithNumbers_WithUpperAndLowerCases();
			
			registerPage.setPassword(randomPass);
			registerPage.setConfirmPassword(randomPass);
			
			registerPage.setPrivacyPolicy(true);
			registerPage.clickContinue();
			
			
			String ConfirmMssg=registerPage.getConfirmationMessage();
			Assert.assertEquals("Your Account Has Been Created!", ConfirmMssg);
			logger.info("Register Test Case Passed ya bashaa...");
			
		}catch(AssertionError e) {
			logger.error("The Test failedd because "+e.getMessage());
			throw e;
		}
		catch(Exception ex) {
			logger.error("Exception occurred "+ex.getMessage());
			throw ex;
			
		}
			
		
	}
	
	



}
