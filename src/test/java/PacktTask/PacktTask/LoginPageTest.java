package PacktTask.PacktTask;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.io.FileInputStream;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class LoginPageTest extends Base {
	  LoginPage loginPage;
	  public WebDriver driver;
	  HomePage homePage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeTest
	public void initialize() throws IOException
	{
	//Initialized web driver
		driver=intializeDrivers();
		loginPage=new LoginPage(driver);
		 	
	}
	
	@Test(priority=1)
	
	public void login() throws IOException
	{
				
		//Return Home Page
		homePage=loginPage.Login(prop.getProperty("username"),prop.getProperty("pwd"));
						
	}

	

	@AfterTest
	public void teardown()
	{
		
		driver.quit();
	
		
	}
	
	
}
