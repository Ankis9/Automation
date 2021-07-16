package testPackage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.net.UrlChecker;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

import pageObjects.AddNewComputerPageObjects;
import pageObjects.HomePageObjects;
import resources.ExtentReportsTestNG;
import resources.baseClass;

public class AddNewComputerTest extends baseClass {
	
	public WebDriver driver;
	
	
	@Test(groups = { "regression" })
	public void validateCancelButton() throws IOException, InterruptedException
	{
		driver =initializeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		HomePageObjects hpo = new HomePageObjects(driver);
		hpo.addNewComputer().click();
		AddNewComputerPageObjects anc = new AddNewComputerPageObjects(driver);
		
		anc.cancelButton().click();
		
		driver.navigate().refresh();
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.urlToBe("https://computer-database.gatling.io/computers"));
		String currUrl =driver.getCurrentUrl();
		System.out.println(currUrl);
	   Assert.assertEquals(currUrl, "https://computer-database.gatling.io/computers");
		
		
	}
	
	@Test(groups = { "regression", "smoke" })
	public void createNewComputer() throws IOException
	{
		driver =initializeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		HomePageObjects hpo = new HomePageObjects(driver);
		hpo.addNewComputer().click();
		AddNewComputerPageObjects anc = new AddNewComputerPageObjects(driver);
		
		anc.newComputerName().sendKeys("Windows Apple");
		anc.introducedDate().sendKeys("2012-10-15");
		anc.discontinuedDate().sendKeys("2020-11-18");
		
		Select s = new Select (anc.companySelect());
		s.selectByValue("10");
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(anc.createNewComputer()));
		anc.createNewComputer().click();
		WebDriverWait wait2 = new WebDriverWait(driver,20);
		wait2.until(ExpectedConditions.visibilityOf(hpo.successMessage()));
		boolean isDisplayed = hpo.successMessage().isDisplayed();
		
		//Determining whether success message is displayed or not
    	Assert.assertTrue(isDisplayed);
		
		
	}
	
	@Test(groups = { "regression" })
	public void createNewComputerValidation() throws IOException
	{
		driver =initializeDriver();
		HomePageObjects hpo = new HomePageObjects(driver);
		hpo.addNewComputer().click();
		AddNewComputerPageObjects anc = new AddNewComputerPageObjects(driver);
		anc.introducedDate().sendKeys("2012-10-15");
		anc.discontinuedDate().sendKeys("2020-11-18");
		Select s = new Select (anc.companySelect());
		s.selectByIndex(10);
		
		anc.createNewComputer().click();
		boolean isDisplayed = driver.findElement(By.xpath("//span[contains(text(),'Failed to refine type ')]")).isDisplayed();
		Assert.assertTrue(isDisplayed);
	}
	
	@Test(groups = { "regression" })
	public void introducedDateValidation() throws IOException
	{
		driver = initializeDriver();
		HomePageObjects hpo = new HomePageObjects(driver);
		hpo.addNewComputer().click();
		AddNewComputerPageObjects anc = new AddNewComputerPageObjects(driver);
		anc.newComputerName().sendKeys("Windows Apple");
		anc.introducedDate().sendKeys("ASD");
		anc.discontinuedDate().sendKeys("2020-11-18");
		Select s = new Select (anc.companySelect());
		s.selectByIndex(10);
		anc.createNewComputer().click();
		boolean isDisplayed = driver.findElement(By.xpath("//section[@id='main']/form[1]/fieldset[1]/div[2]/div[1]/span[1]")).isDisplayed();
		Assert.assertTrue(isDisplayed);
		
		
	}
	
	@Test(groups = { "regression" })
	public void discontinuedDateValidation() throws IOException
	{
		driver = initializeDriver();
		HomePageObjects hpo = new HomePageObjects(driver);
		hpo.addNewComputer().click();
		AddNewComputerPageObjects anc = new AddNewComputerPageObjects(driver);
		anc.newComputerName().sendKeys("Windows Apple");
		anc.introducedDate().sendKeys("2020-11-18");
		anc.discontinuedDate().sendKeys("ASD");
		Select s = new Select (anc.companySelect());
		s.selectByIndex(10);
		anc.createNewComputer().click();
		boolean isDisplayed = driver.findElement(By.xpath("//section[@id='main']/form[1]/fieldset[1]/div[3]/div[1]/span[1]")).isDisplayed();
		Assert.assertTrue(isDisplayed);
		
		
	}
	
	@AfterMethod
	public void closeTab()
	{
		
		driver.close();
		
	}
	
	

}
