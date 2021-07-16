package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObjects {
	
	public WebDriver driver;

	public HomePageObjects(WebDriver driver) {
		
		this.driver = driver;
	}
	
	By successMessage = By.xpath("//section[@id='main']/div[1]");
	By filterSearchBox = By.id("searchbox");
	By filterSubmit = By.id("searchsubmit");
	By headerComputerName = By.linkText("Computer name");
	By headerIntroduced = By.linkText("Introduced");
	By headerDiscontinued = By.linkText("Discontinued");
	By headerCompany = By.linkText("Company");
	By nextPage = By.xpath("//a[contains(text(),'Next →')]");
	By previousPage = By.linkText("← Previous");
	By addNewComputer = By.cssSelector("#add");
	By computerNames = By.xpath("//table/tbody/tr/td[1]");
	By introducedIn = By.xpath("//table/tbody/tr/td[2]");
	By discontinuedIn = By.xpath("//table/tbody/tr/td[3]");
	By comapanyName = By.xpath("//table/tbody/tr/td[4]");
	By noOfComputersHeader = By.xpath("//section[@id='main']/h1");
	
	public WebElement noOfComputersHeader()
	{
		return driver.findElement(noOfComputersHeader);
	}
	public WebElement successMessage()
	{
		return driver.findElement(successMessage);
	}
	
	public WebElement addNewComputer()
	{
		return driver.findElement(addNewComputer);
	}
	
	public WebElement nextPage()
	{
		return driver.findElement(nextPage);
	}
	
	public WebElement previousPage()
	{
		return driver.findElement(previousPage);
	}
	
	public List<WebElement> computerNames()
	{
		return driver.findElements(computerNames);
	}
	public List<WebElement> comapanyName()
	{
		return driver.findElements(comapanyName);
	}
	public List<WebElement> introducedIn()
	{
		return driver.findElements(introducedIn);
	}
	public List<WebElement> discontinuedIn()
	{
		return driver.findElements(discontinuedIn);
	}
	
	public WebElement headerIntroduced()
	{
		return driver.findElement(headerIntroduced);
	}
	public WebElement headerDiscontinued()
	{
		return driver.findElement(headerDiscontinued);
	}
	public WebElement headerCompany()
	{
		return driver.findElement(headerCompany);
	}
	
	public WebElement filterSearchBox()
	{
		return driver.findElement(filterSearchBox);
	}
	
	
	
	public WebElement filterSubmit()
	{
		return driver.findElement(filterSubmit);
	}
	
	public WebElement headerComputerName()
	{
		return driver.findElement(headerComputerName);
	}
	
		
	
	
	
	

}
