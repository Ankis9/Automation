package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class baseClass {
	public WebDriver driver;

	public WebDriver initializeDriver() throws IOException
	{
		
		
		String firefoxPath = System.getProperty("user.dir")+"\\src\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", firefoxPath);
		driver= new FirefoxDriver();

        driver.get("https://computer-database.gatling.io/computers");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	
	public void getScreenshotOnFail(String methodName,WebDriver driver) throws IOException
	{
		TakesScreenshot scrsht = (TakesScreenshot) driver;
		File source = scrsht.getScreenshotAs(OutputType.FILE);
		String destSource = System.getProperty("user.dir") + "\\Reports\\" + methodName + ".png";
		FileUtils.copyFile(source, new File(destSource));
	}

}
