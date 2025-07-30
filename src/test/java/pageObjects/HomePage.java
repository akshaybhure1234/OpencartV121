package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{

	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "//span[text() ='My Account']")
	private WebElement lnkMyaccount;
	
	@FindBy(xpath = "//a[text() ='Register']")
	private WebElement lnkResister;
	
	@FindBy(xpath = "//a[text() = 'Login']")
	private WebElement linkLogin;
	
	public void clickMyAccount()
	{
		lnkMyaccount.click();
	}
	public void clickResister()
	{
		lnkResister.click();
	}
	public void clickLogin()
	{
		linkLogin.click();
	}
	
}
