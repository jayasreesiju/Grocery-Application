package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility {

	public void getScreenshot(WebDriver driver, String failedTestCaseMethodname) throws IOException 
	{
	TakesScreenshot scrShot = (TakesScreenshot) driver;
	File screenShot = scrShot.getScreenshotAs(OutputType.FILE);
	String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
	File f1 = new File(System.getProperty("user.dir") + "/OutputScreenShot");// create file in directory
	//System-inbuilt class, user.dir- the project local directory path
	//OutputScreenShot is the filename that is going to be created 
	if (!f1.exists()) 
	{
	f1.mkdirs();
	//mkdirs- make directory
	}
	String destination = System.getProperty("user.dir") + "/outputScreenShot/" + failedTestCaseMethodname + timeStamp+ ".png";
	File finalDestination = new File(destination);
	FileHandler.copy(screenShot, finalDestination);
	}








}
