package resources;




import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;



public class ExtentReportsTestNG {
	
	  
	  
	  public static ExtentTest test;
	  public static ExtentReports extent;
	  
	
	
	public static void getExtentReports()
	{
		//String path = System.getProperty("user.dir")+"\\src\\ReportResults.html";
		extent = new ExtentReports(System.getProperty("user.dir")+"\\Reports\\ReportResults.html", true);
		
		
		extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
		
		
	}

}
