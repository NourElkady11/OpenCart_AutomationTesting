package testCases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageObjects.AddToCartDev;

public class TC004_AddToCartTest extends BaseTest {

	
	@Test(groups = { "Master"})
	public void AddToCartTestCase() {
		
		try{
			
			AddToCartDev AddToCartObj=new AddToCartDev(driver, waitDriver);
			AddToCartObj.clickOnLapTopsAndNoteBooks_GoToWindows_GoToCameras();
			AddToCartObj.clickAddToCart();
			WebElement ActualText=AddToCartObj.GetActualTextEelemnt();
			String actual=ActualText.getText();
			assertEquals(actual, "Canon EOS 5D");
			logger.info("Added To Cart Successfully...");
		}catch(AssertionError e){
			logger.error("The Test failedd because "+e.getMessage());
			throw e;
			
			
		}catch(Exception ex) {
			
			logger.error("Exception occurred "+ex.getMessage());
			throw ex;
		}
		
		
	}
	
	
	
}
