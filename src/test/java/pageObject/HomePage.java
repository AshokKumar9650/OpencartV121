package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {  // object class creation
	
	
	
	// constructor
	public HomePage(WebDriver driver)
	{
		super(driver);   // driver used from Base class
	}
	
	
	// Locators
	@FindBy(xpath="//span[normalize-space()='My Account']")  // 
	 WebElement lnkMyaccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement lnkRegister;
	
	@FindBy(xpath ="//a[normalize-space()='Login']")
	WebElement linkLogin;

	
	
	// Action method
	
	public void clickMyAccount()
	{
	    lnkMyaccount.click();
	}
	
	
	public void clickRegister()
	{
		lnkRegister.click();
	}
	
	public void clickLogin()
	{
		linkLogin.click();
	}
	
}
