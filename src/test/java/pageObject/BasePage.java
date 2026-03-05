package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage { // parent class webdriver for all  ---only for constrctor then will be exended by all 
	
	
	WebDriver driver;
	
	public BasePage(WebDriver driver) // constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
