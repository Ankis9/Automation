package testPackage;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;

import pageObjects.HomePageObjects;
import resources.ExtentReportsTestNG;
import resources.baseClass;

public class HomePageTest extends baseClass {

	public WebDriver driver;
	ExtentReports extent= ExtentReportsTestNG.extent;
	
	@Test(groups = { "regression", "smoke" })
	public void openUrl() throws IOException
	{
		driver =initializeDriver();
	}

	@Test(groups = { "regression", "smoke" })
	public void filterResults() throws IOException
	{
		driver =initializeDriver();

		HomePageObjects hpo = new HomePageObjects(driver);

		//Typing a string with which we want filtered out results
		hpo.filterSearchBox().sendKeys("ank");
		hpo.filterSubmit().click();


		String noOfComputers = hpo.noOfComputersHeader().getText();
		int computerCount ;
		if(noOfComputers.contains("No computer"))
		{
			computerCount =0;
		}
		else
		{
			String[] extractComputerCount = noOfComputers.split(" ");

			computerCount = Integer.parseInt(extractComputerCount[0]);
			System.out.println(computerCount);
		}
		int computerSum=0;

		do {

			if(computerCount ==0)
			{
				Assert.assertEquals(computerCount, computerSum);
				break;
			}
			List<WebElement> filteredComputerNames = hpo.computerNames();


			computerSum = computerSum + filteredComputerNames.size();
			hpo.nextPage().click();
			if(filteredComputerNames.size() < 10)
			{
				Assert.assertEquals(computerCount, computerSum);
				break;
			}

		}while(computerSum < computerCount);

	}
	
	@Test(groups = { "regression", "smoke" })
	public void validateByComputerNameInAscendingOrder() throws IOException
	{
		driver =initializeDriver();
        HomePageObjects hpo = new HomePageObjects(driver);
        List<WebElement> filteredComputerNames = hpo.computerNames();
        List<String> originalList= filteredComputerNames.stream().map(s -> s.getText()).collect(Collectors.toList());
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(originalList, sortedList);
        
    }
	
	@Test(groups = { "regression" })
	public void validateByComputerNameInDescendingOrder() throws IOException
	{
		driver =initializeDriver();
        HomePageObjects hpo = new HomePageObjects(driver);
        hpo.headerComputerName().click();
        List<WebElement> ComputerNames = hpo.computerNames();
        List<String> originalList= ComputerNames.stream().map(s -> s.getText()).collect(Collectors.toList());
        Collections.reverse(originalList);
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(originalList, sortedList);
        
    }
	
	@Test(groups = { "regression" })
	public void validateByIntroducedInDateInAscendingOrder() throws IOException, ParseException
	{
		driver =initializeDriver();
        HomePageObjects hpo = new HomePageObjects(driver);
        hpo.headerIntroduced().click();	
        List<WebElement> IntroducedInDate = hpo.introducedIn();
        List<String> originalList= IntroducedInDate.stream().map(s -> s.getText()).collect(Collectors.toList());
        List<Date> datesList = new ArrayList<Date>();
        for(String sDates : originalList)
        {
        	Date date1=new SimpleDateFormat("dd MMM yyyy").parse(sDates);
        	datesList.add(date1);
        }
        List<Date> sortedList = datesList.stream().sorted().collect(Collectors.toList());
    //  Assert.assertEquals(datesList, sortedList);
        
        
	}
	
	@Test(groups = { "regression" })
	public void validateByIntroducedInDateInDescendingOrder() throws IOException, ParseException
	{
		driver =initializeDriver();
        HomePageObjects hpo = new HomePageObjects(driver);
        hpo.headerIntroduced().click();
        hpo.headerIntroduced().click();
        List<WebElement> IntroducedInDate = hpo.introducedIn();
        List<String> originalList= IntroducedInDate.stream().map(s -> s.getText()).collect(Collectors.toList());
        List<Date> datesList = new ArrayList<Date>();
        for(String sDates : originalList)
        {
        	
        	Date date1=new SimpleDateFormat("dd MMM yyyy").parse(sDates);
        	datesList.add(date1);
        }
        Collections.reverse(datesList);
        List<Date> sortedList = datesList.stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(datesList, sortedList);
        
        
	}
	
	@Test(groups = { "regression" })
	public void validateByDiscontinuedInDateInAscendingOrder() throws IOException, ParseException
	{
		driver =initializeDriver();
        HomePageObjects hpo = new HomePageObjects(driver);
        hpo.headerDiscontinued().click();	
        List<WebElement> DiscontinuedInDate = hpo.discontinuedIn();
        List<String> originalList= DiscontinuedInDate.stream().map(s -> s.getText()).collect(Collectors.toList());
        List<Date> datesList = new ArrayList<Date>();
        for(String sDates : originalList)
        {
        	Date date1=new SimpleDateFormat("dd MMM yyyy").parse(sDates);
        	datesList.add(date1);
        }
        List<Date> sortedList = datesList.stream().sorted().collect(Collectors.toList());
      //  Assert.assertEquals(datesList, sortedList);
     }
	
	@Test(groups = { "regression" })
	public void validateByDiscontinuedInDateInDescendingOrder() throws IOException, ParseException
	{
		driver =initializeDriver();
        HomePageObjects hpo = new HomePageObjects(driver);
        hpo.headerDiscontinued().click();
        hpo.headerDiscontinued().click();
        List<WebElement> DiscontinuedInDate = hpo.discontinuedIn();
        List<String> originalList= DiscontinuedInDate.stream().map(s -> s.getText()).collect(Collectors.toList());
        List<Date> datesList = new ArrayList<Date>();
        for(String sDates : originalList)
        {
        	
        	Date date1=new SimpleDateFormat("dd MMM yyyy").parse(sDates);
        	datesList.add(date1);
        }
        Collections.reverse(datesList);
        List<Date> sortedList = datesList.stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(datesList, sortedList);
        
        
	}
	
	@Test(groups = { "regression" })
	public void validateByCompanyNameInAscendingOrder() throws IOException
	{
		driver =initializeDriver();
        HomePageObjects hpo = new HomePageObjects(driver);
        hpo.headerCompany().click();
        List<WebElement> CompanyNames = hpo.comapanyName();
        List<String> originalList= CompanyNames.stream().map(s -> s.getText()).collect(Collectors.toList());
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(originalList, sortedList);
        
    }
	
	@Test(groups = { "regression" })
	public void validateByCompanyNameInDescendingOrder() throws IOException
	{
		driver =initializeDriver();
        HomePageObjects hpo = new HomePageObjects(driver);
        hpo.headerCompany().click();
        hpo.headerCompany().click();
        List<WebElement> CompanyNames = hpo.comapanyName();
        List<String> originalList= CompanyNames.stream().map(s -> s.getText()).collect(Collectors.toList());
        Collections.reverse(originalList);
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(originalList, sortedList);
        
        
    }
	
	@AfterMethod
	public void closeTab()
	{
		
		driver.close();
	}



}
