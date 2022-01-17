package PacktTask.PacktTask;

import org.openqa.selenium.support.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePageTest extends Base{
	

	public WebDriver driver;
	public static Logger log =LogManager.getLogger(Base.class.getName());
	LoginPage loginPage;
	HomePage homePage;
	
	public HomePageTest()
	{
		super();
	}
	@BeforeTest
	public void initialize() throws IOException
	{
		//Initialized web driver
		 driver=intializeDrivers();
		 loginPage=new LoginPage(driver);
		 homePage=new HomePage(driver);
		 //Call Login function to user login
		 homePage=loginPage.Login(prop.getProperty("username"),prop.getProperty("pwd"));
	}
	@Test(priority=1)
	
	// Check the title of the section present in below nav bar 
	public void validateAppTitle() throws IOException
	{
		
		String title=homePage.getTitle().getText();
		Assert.assertEquals(title, "Advance your knowledge in tech","Home page Text not matche");
		 log.info("Successfully validated Text message");
		
		 	
	}
	
	//Check Logo is displayed or not 
	@Test(priority=2)
	public void checkLogo() throws IOException
	{
		WebElement img=homePage.validateLogo();
			
		Assert.assertTrue(img.isDisplayed());
		
	}
	/*@Test(priority=3)
	// Check for search button with passing  "Java" text in  search textbox
	public void clickSearch()
	{
		homePage.getSearch().sendKeys("Java");
		homePage.clickSearch().click();
	}*/
	@Test(priority=3)
	public void checkNavBarcolor()
	{
		WebElement n=homePage.getNavBar();
		//obtain color in rgba
		 //String propertyName;
		String s = n.getCssValue("background-color");
		//get the actual color of navigation bar
		 String actual = Color.fromString(s).asHex();
		 //assign expected color 
		 String expected="#3c3c3b";
		 //compare the navigation bar background color
		 Assert.assertEquals(actual, expected,"Color Matched");
	     
	}
	@Test(priority=4)
	public void checkNavBarHeight()
	{
		WebElement navBar=homePage.getNavBar();
		//Get width of element.
        int ImageWidth = navBar.getSize().getWidth();
       // System.out.println("Image width Is "+ImageWidth+" pixels");

        //Get height of element.
        int actual = navBar.getSize().getHeight(); 
        int expected=75;
        Assert.assertEquals(actual, expected,"Nav bar height Matched");
       // System.out.println("Image height Is "+ImageHeight+" pixels");
		
	}
	@Test(priority=5)
	public void checkOptionForMainMenu() throws InterruptedException
	{
		List<WebElement> menu=homePage.getMainOption();
		Actions act=new Actions(driver);
		log.info("click on Nav Bar Option");
		for (WebElement m:menu)
		{	
			
		if (m.getText().equals("Browse  "))
		{
			
			homePage.clickDownArrow().click();	
			log.info("click Data Option");
			//List<WebElement> t=driver.findElements(By.xpath("//span[]"));
			//System.out.println("eerrr"+t.size());
			//log.info(t.size());
			homePage.clickData().click();
		}
	
				
		
		if (m.getText().equals("My Library  "))
		{
			homePage.clickdownArrowlibrary().click();
			log.info("Click on My Library ");
			log.info("click on PlayList Option");
			homePage.clickPlayList().click();
		}	
		
		}
	}
	
	
	@Test(priority=6)
	public void viewAllBooks()
	{
		List<WebElement> menu=homePage.getMainOption();
		//log.info(menu.size());
		Actions act=new Actions(driver);
		
		for (WebElement m:menu)
		{
		
		if (m.getText().equals("Browse  "))
		{
			homePage.clickDownArrow().click();
			homePage.clickViewAllBooks().click();
			log.info("Get View all Books");
			/*homePage.clearAllFilter().click();
			homePage.clickCheckBox().click();
			String opt[]= {"Python","Paint"};
			for(int i=0 ;i<opt.length-1;i++)
			{
			homePage.enterSearchOption().sendKeys(opt[i]);
			homePage.clickSearchOption().click();
			
			}*/
	
		}
		}
		//menu.selectByValue("");
	}
		
	
	@Test(priority=7)
	public void checkCarouselclick()
	{
		List<WebElement> c=homePage.clickCorousel();
		for (int i=0;i<c.size();i++)
		{
			String str=c.get(i).getText();
			if(str.contains("Speaking C#"))
			{
			c.get(i).click();
			homePage.shadow().click();
			break;
			}
		}
		
	}
	
	@AfterTest
	public void teardown()
	{
		
		driver.quit();
	
		
	}
	
	
	
}
