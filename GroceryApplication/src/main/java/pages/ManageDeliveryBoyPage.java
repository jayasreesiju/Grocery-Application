package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManageDeliveryBoyPage {
	
	public WebDriver driver;
	public ManageDeliveryBoyPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement ManageDeliveryBoyNew;
	@FindBy(xpath="//input[@id='name']") WebElement DeliveryBoyName;
	@FindBy(xpath="//input[@id='email']") WebElement DeliveryEmail;
	@FindBy(xpath="//input[@id='phone']") WebElement DeliveryPhone;
	@FindBy(xpath="//textarea[@id='address']") WebElement DeliveryAddress;
	@FindBy(xpath="//input[@id='username']") WebElement DeliveryUsername;
	@FindBy(xpath="//input[@id='password']") WebElement DeliveryPassword;
	@FindBy(xpath="//button[@name='create']") WebElement DeliverySubmit;	
	
	public ManageDeliveryBoyPage ManageDeliveryBoyNewClick()
	{
		ManageDeliveryBoyNew.click();
		return this;
	}
	
	public ManageDeliveryBoyPage DeliverySubmitClick()
	{
	
		WebDriverWait wb=new WebDriverWait(driver,Duration.ofSeconds(5));
		wb.until(ExpectedConditions.elementToBeClickable(DeliverySubmit));
		
		   DeliverySubmit.click();
		   return this;
		   //^^ here normal click, action click and javascript executer all works , but need to wait for all the three
		    // Try standard click first, or use JavascriptExecutor if a footer blocks it
		   // JavascriptExecutor js = (JavascriptExecutor) driver;
		    //js.executeScript("arguments[0].click();", DeliverySubmit);
		
		
		
		//Actions objAC=new Actions(driver);
		//objAC.click(DeliverySubmit).perform();;
	}
	public ManageDeliveryBoyPage scrollPage()
	{
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)","");
		//^^^- go down
		
		//js.executeScript("window.scrollBy(0,-300)","");
		
		//^^---go up
		return this;
		
	}
	public ManageDeliveryBoyPage enterDeliveryfullname(String fullname)
	{
		DeliveryBoyName.sendKeys(fullname);
		return this;
	}
	public ManageDeliveryBoyPage enterDeliveryemail(String email)
	{
		DeliveryEmail.sendKeys(email);
		return this;
	}
	public ManageDeliveryBoyPage enterDeliveryphone(String phone)
	{
		DeliveryPhone.sendKeys(phone);
		return this;
	}
	public ManageDeliveryBoyPage enterDeliveryAddress(String address)
	{
		DeliveryAddress.sendKeys(address);
		return this;
	}
	public ManageDeliveryBoyPage enterDeliveryUsername(String username)
	{
		DeliveryUsername.sendKeys(username);
		return this;
	}	
	public ManageDeliveryBoyPage enterDeliveryPassword(String password)
	{
		DeliveryPassword.sendKeys(password);
		return this;
	}	
}
