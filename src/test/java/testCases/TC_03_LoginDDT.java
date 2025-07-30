package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.dataProviders;

/*
 Data is valid -- login success -- test pass -- logout
 Data is valid -- login failed -- test fail 
 
 Data is invalid -- login success -- test fail -- logout
 Data is invalid -- login failed -- test pass  
 */
public class TC_03_LoginDDT extends BaseClass
{
	@Test(dataProvider = "LoginData" , dataProviderClass = dataProviders.class , groups = "DataDriven") //getting dataProvider from different class
	public void verify_LoginDDt(String email , String password , String result) throws InterruptedException
	{
		logger.info("***** Starting TC_03_LoginDDT *****");
		try
		{
			//HomePage
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
					
			//LoginPage
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(password);
			lp.clickLogin();
					
			//MyAccuntPage
			MyAccountPage macp = new MyAccountPage(driver);
			boolean targetPage = macp.isMyAccountPageExists();
			
			if (result.equalsIgnoreCase("Valid")) 
			{
				if (targetPage==true)
				{
					macp.clickLogout();
					Assert.assertTrue(true);			
				}
				else
				{
					Assert.assertTrue(false);
				}
			} 
			if (result.equalsIgnoreCase("Invalid")) 
			{
				if (targetPage==true)
				{
					macp.clickLogout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			} 
		}
		catch (Exception e)
		{
			Assert.fail();
		}
		Thread.sleep(3000);
		logger.info("***** Finished TC_03_LoginDDT *****");
	}
}
