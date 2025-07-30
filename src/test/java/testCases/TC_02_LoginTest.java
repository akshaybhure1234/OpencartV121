package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_02_LoginTest extends BaseClass
{
	@Test(groups = {"Sanity","Master"})
	public void verify_login()
	{
		try
		{
			logger.info("***** Starting TC_02_LoginTest *****");
			
			//HomePage
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			//LoginPage
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();
			
			//MyAccuntPage
			MyAccountPage macp = new MyAccountPage(driver);
			boolean targetPage = macp.isMyAccountPageExists();
			
			Assert.assertTrue(targetPage);
			
			logger.info("***** Finished TC_02_LoginTest *****");
			
		} 
		catch (Exception e)
		{
			Assert.fail();
		}
		
	}
	
}
