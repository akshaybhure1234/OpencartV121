package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_01_AccountRegistrationTest extends BaseClass
{
	
	@Test(groups = {"Regression","Master"})
	public void verify_account_registration()
	{
		try 
		{
			logger.info("***** Starting TC_01_AccountRegistrationTest *****");
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("***** Clicked on MyAccount Link *****");
			hp.clickResister();
			logger.info("***** Clicked on Resister Link *****");
			
			AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
			logger.info("***** Providing customer details*****");
			regPage.setFirstName(randomString().toUpperCase());
			regPage.setLastName(randomString().toUpperCase());
			regPage.setEmail(randomString()+"@gmail.com");
			regPage.setTelephone(randomNumber());
			
			String password = randomAlphaNumeric();
			regPage.setPassword(password);
			regPage.setConfirmPassword(password);
			
			regPage.setPrivacyPolict();
			regPage.clickContinue();
			
			logger.info("***** Validating expected message *****");
			String confmsg = regPage.getConfirmationMessage();
			
			Assert.assertEquals(confmsg, "Your Account Has Been Created!");	
		} 
		catch (Exception e)
		{
			logger.error("***** Test failed *****");
			logger.debug("***** Debug logs *****");
			Assert.fail();
		}
		
		logger.info("***** Finished TC_01_AccountRegistrationTest *****");
		
	}
	

	
}
