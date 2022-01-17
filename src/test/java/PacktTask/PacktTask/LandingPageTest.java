package PacktTask.PacktTask;


import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
//import pageObjects.LandingPage;
import resources.Base;

public class LandingPageTest extends Base{
	
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		//Initialized web driver
		 driver =intializeDrivers();
		 log.info("Initialized web driver");
		 driver.get("https://subscription.packtpub.com/");
		 log.info("Navigated to home page");
	}
	
	@Test(priority=1)
	//Verify Sign in button working or not
	public void verifySignClick() throws IOException
	{
				
		
		LandingPage l=new LandingPage(driver);
		l.getLogin().click();
		 log.info("successfully click on signin button");
								
	}

	@AfterTest
	public void teardown()
	{
		
		driver.quit();
	
		
	}

}
