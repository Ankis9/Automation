package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddNewComputerPageObjects {
	public WebDriver driver;

	public AddNewComputerPageObjects(WebDriver driver) {
		
		this.driver = driver;
	}
	
	By newComputerName = By.cssSelector("#name");
	By introducedDate = By.id("introduced");
	By discontinuedDate = By.id("discontinued");
	By companySelect = By.id("company");
	By cancelButton = By.xpath("/html[1]/body[1]/section[1]/form[1]/div[1]/a[1]");
	By createNewComputer = By.xpath("//form/div/input[1]");
	By computerNameValidationError = By.xpath("//span[contains(text(),'Failed to refine type : Predicate isEmpty() did no')]");
	
	public WebElement createNewComputer()
	{
		return driver.findElement(createNewComputer);
	}
	public WebElement computerNameValidationError()
	{
		return driver.findElement(computerNameValidationError);
	}
	public WebElement newComputerName()
	{
		return driver.findElement(newComputerName);
	}
	public WebElement cancelButton()
	{
		return driver.findElement(cancelButton);
	}
	public WebElement introducedDate()
	{
		return driver.findElement(introducedDate);
	}
	
	public WebElement discontinuedDate()
	{
		return driver.findElement(discontinuedDate);
	}
	public WebElement companySelect()
	{
		return driver.findElement(companySelect);
	}
	
	

}
