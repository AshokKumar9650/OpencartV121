package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportDemo {
	 
	ExtentReports extent;
	ExtentSparkReporter htmlReporter;
	WebDriver driver;
	
	


     @BeforeSuite()
	public void setup()
	{

		// start reporters
		 htmlReporter = new ExtentSparkReporter("extent.html");
		// create ExtentReports and attach reporter(s)
        extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		
		
		 
	}
     
     @BeforeClass()
     public void setupTest()
     {
    	   String projectpath 	= System.getProperty("user.dir");
 	    System.getProperty("webdriver.chrome.driver"+projectpath+"/driver");
 	    driver=new ChromeDriver();
     }
	
	
     
     @Test()
	public void test()
	{    
    	// creates a toggle for the given test, adds all log events under it    
         ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
         
    	       
    	       driver.get("https://google.com");
    	       test.pass("Navigated to https://google.com");
    	 
    	 
         // log(Status, details)
         test.log(Status.INFO, "This step shows usage of log(status, details)");

         // info(details)
         test.info("This step shows usage of info(details)");
         
         // log with snapshot
         test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
         
         // test with snapshot
         test.addScreenCaptureFromPath("screenshot.png");
	}

     @AfterTest()
     public void teardownTest()
     {
    	     driver.close();
    	     driver.quit();
    	     System.out.println("Test successfully executed..");
     }
     
	
     @AfterSuite()
	public void teardown()
	{
		 
    	// calling flush writes everything to the log file
         extent.flush();
	}
	
	
	
}
