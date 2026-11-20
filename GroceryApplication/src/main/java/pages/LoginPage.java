package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.WaitUtility;

public class LoginPage {
	public WebDriver driver;
	WaitUtility wu=new WaitUtility();
	 
	 public LoginPage(WebDriver driver)
	 {
		 
		 this.driver=driver;
		PageFactory.initElements(driver,this);

	 //the above line will initialise the driver
	 }
	 //Login using correct credentials
	 @FindBy(xpath="//input[@name='username']") WebElement username;
	 
	 @FindBy(xpath="//input[@name='password']") WebElement password;
	 @FindBy(xpath="//button[@class='btn btn-dark btn-block']") WebElement login;
	 @FindBy(xpath="//p[text()='Dashboard']") WebElement dashboard;
	 @FindBy(xpath="//b[text()='7rmart supermarket']") WebElement loginpagetext;
	 
	 
	 
	 public LoginPage enteruserNameonUserNamefield(String usernamevalue)
	 {
		 username.sendKeys(usernamevalue);
		 return this;
		 
	 }
	 
	 public LoginPage enterPasswordonPasswordfield(String passwordvalue)
	 {
		 password.sendKeys(passwordvalue);
		 return this;
	 }
	 
	 public HomePage Submit()
	 {
		
		 wu.waitUntilElementToBeClickable(driver, login);
		 login.click();
		 return new HomePage(driver);
	 }
	 
	 public boolean verifyWhetherDashboardIsDisplayed()
	 {
		 return dashboard.isDisplayed();
	 }
	 
	 public String verifLoginTextIsDisplayed()
	 {
		 return loginpagetext.getText();
		 
	 }	 
}
