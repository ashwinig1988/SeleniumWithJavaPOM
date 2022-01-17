package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	public WebDriver driver;
	By search=By.xpath("//input[@placeholder=' Search...']");
	By title=By.xpath("//h2[text()='Advance your knowledge in tech']");
	By logo=By.xpath("//img[@class='logo']");
	By searchbtn=By.xpath("//button[@class='search-bar__button']");
	By mainMenu=By.xpath("//li[@class='menu__item']");
	By downArrow=By.xpath("//i[@class='fa fa-caret-down']");
	By downArrowlibrary=By.xpath("//span[contains(text(),'My Library')]//i[@class='fa fa-caret-down']");
	By clearAll=By.xpath("//span[@class='badge badge-primary' and text()='Clear all ']");
	By chk21=By.xpath("//input[@type='checkbox' and @id='2021']");
	By searchText=By.id("search-input");
			
	By serBtn=By.xpath("//button[@type='submit' and contains(text(),' Search')]");
	By data=By.xpath("//span[normalize-space()='Data']");
	
	//By data=By.cssSelector("div[class='row categories-list categories-list-avtive'] span");
	By playList=By.xpath("//span[normalize-space()='Playlists']");
	By viewAllBooks=By.xpath("//li[normalize-space()='View All Books']");
	By crousal=By.xpath("//div[@class='main-card-header card-header']");
	By show=By.xpath("//div[@class='collapse show']");
	
	By navBarColor=By.xpath("//nav[@id='primary-navigation']");
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	public WebElement validateLogo()
	
	{
		return  driver.findElement(logo);
		
	}
	public WebElement getSearch()
	{
		return driver.findElement(search);
	}
	public WebElement clickSearch()
	{
		return driver.findElement(searchbtn);
	}
	
	public List<WebElement> getMainOption()
	{
		List<WebElement> arr=  driver.findElements(mainMenu);
		return arr;
		
	}
	public WebElement clickDownArrow()
	{
		return driver.findElement(downArrow);
		//return arr;
		
	}
	public WebElement clickdownArrowlibrary()
	{
		return driver.findElement(downArrowlibrary);
		//return arr;
		
	}
	public WebElement clearAllFilter()
	{
		return driver.findElement(clearAll);
	}
	
	public WebElement clickCheckBox()
	{
		return driver.findElement(chk21);
	}
	
	public WebElement enterSearchOption()
	{
		return driver.findElement(searchText);
	}
	public WebElement clickSearchOption()
	{
		return driver.findElement(serBtn);
	}
	public WebElement clickData()
	{
		return  driver.findElement(data);
	}
	public WebElement clickPlayList()
	{
		return  driver.findElement(playList);
	}
	public WebElement clickViewAllBooks()
	{
		return  driver.findElement(viewAllBooks);
	}
	public List<WebElement> clickCorousel()
	{
		return  driver.findElements(crousal);
	}
	public WebElement shadow()
	{
		return  driver.findElement(show);
	}
	public WebElement getNavBar()
	{
		return  driver.findElement(navBarColor);
	}
}
