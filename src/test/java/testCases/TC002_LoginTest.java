package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest  extends BaseClass{
	
	
	@Test(groups= {"Sanity", "Master"})
	public void verify_login()
	{
		logger.info("*****Starting TC002_LoginTest Case *****");
		
		try
		{
		//Home Page object
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//Login page object
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		// MyAccount page object
		
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetPage = macc.isMYAccountPageExists();
		Assert.assertEquals(targetPage,true, "Login Failed");
		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("*****Finished TC002_LoginTest Case *****");
		
		
		
	}
	

}
