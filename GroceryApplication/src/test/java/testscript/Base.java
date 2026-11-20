package testscript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Utilities.ScreenshotUtility;
import constant.Constant;

public class Base {
	
public WebDriver driver;
Properties prop;
FileInputStream fis;
	
	@BeforeMethod(alwaysRun=true)
	
	public void initialisebrowser() throws IOException
	
	{
		prop=new Properties();
		fis=new FileInputStream(Constant.CONFIGFILE);
		prop.load(fis);
		driver=new ChromeDriver();
	
	
	/*@Parameters("browsers")
	public void initiallisebrowser(String browsers)
	{
		if(browsers.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browsers.equalsIgnoreCase("safari"))
		{
			driver=new SafariDriver();
		}
		
		else if(browsers.equalsIgnoreCase("edge"))
				{
					driver=new EdgeDriver();
				}
				
				*/
			
		//driver=new SafariDriver();
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		//^^^ Implicit wait for the URL Launch
		//driver.manage().window().minimize();		//driver=new SafariDriver();
		
	}	
	//@AfterMethod(alwaysRun=true)
	public void closeBrowser(ITestResult itestresult) throws IOException
	//ITestResult is an interface which is used to manage the lifecycle of a testcase(pass/fail/skip), testcase status manage
	{
	if(itestresult.getStatus()==ITestResult.FAILURE) 
	{
	ScreenshotUtility screenshotutility=new ScreenshotUtility();
	screenshotutility.getScreenshot(driver, itestresult.getName());
	}
	// driver.close();
	//driver.quit();
	}

}
