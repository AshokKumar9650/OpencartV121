package testCases;

import org.testng.Assert;

import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;
import pageObject.AccountRegistrationPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {  // here Testcase will be writen
	
	
	
	
	
	@Test( groups= {"Regression", "Master"})                            
	public void 	verify_account_registration()     // here we will be using the other class after obj creation
	
	
	{
		
		logger.info("*****Starting TC001_AccountRegistrationTest *******"); // using log4j2 File for logs generation
		try
		{
		HomePage hp = new HomePage(driver);   // accessing HomePage class using object creation
		hp.clickMyAccount();
		logger.info("*****Clicked on My Account *******");
		hp.clickRegister();
		logger.info("*****Clicked on Register *******");
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		
		logger.info("*****Providing customer details *******");
		regpage.setFirstName(randomString());
		regpage.setLastName(randomString());
		regpage.setEmail(randomString()+"@gmail.com");  // random emailid generated thourh new method
		regpage.setTelephone(randomnum());
		regpage.setPassword("Ashok@123");
		regpage.setConfirmPassword("Ashok@123");
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		logger.info("*****Validating Expected Message *******");
		String confmsg=regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg,"Your Account Has Been Created!");
		
	     } catch(Exception e)
	            {
	         	logger.error("Test Failed");
		        logger.debug("Debug logs..");
		        Assert.fail();
	            }
	 
	  }	
	
	
	
	

}
