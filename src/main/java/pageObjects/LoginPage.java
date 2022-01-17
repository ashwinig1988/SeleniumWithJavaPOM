package pageObjects;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.Base;

public class LoginPage extends Base  {
	public WebDriver driver;
	By email=By.id("login-input-email");
	By pwd=By.id("login-input-password");
	By logBtn=By.xpath("//button[@type='submit']//span[text()='Sign In']");
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	//Done user login and return home page
	public HomePage Login(String un,String password)
	{
		 driver.findElement(email).sendKeys(un);;
		 driver.findElement(pwd).sendKeys(password);
		 driver.findElement(logBtn).click();
		return new HomePage(driver);
	}
}
