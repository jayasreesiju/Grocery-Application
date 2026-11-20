package testscript;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import Utilities.ExcelUtility;
import constant.Constant;


public class LoginTest extends Base{
HomePage hp;
	
	@Test(priority=1,description="user is trying to login with valid credentials",groups= {"smoke"})
	
	public void verifyuserloginwithvalidcredentials() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(0, 0, "login");
		String passwordvalue=ExcelUtility.getStringData(0, 1, "login");
		LoginPage lp=new LoginPage(driver);
		lp.enteruserNameonUserNamefield(usernamevalue).enterPasswordonPasswordfield(passwordvalue);
		hp=lp.Submit();
		boolean dashboardvalue=lp.verifyWhetherDashboardIsDisplayed();
		Assert.assertTrue(dashboardvalue, Constant.VALIDCREDENTIALERROR);
		
			
	}
	
	@Test(priority=2,description="user is trying to login with valid username and invalid password",retryAnalyzer=retry.Retry.class)
	public void verifyuserloginwithvalidusernameandinvalidpassword() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(1, 0, "login");
		String passwordvalue=ExcelUtility.getStringData(1, 1, "login");
		LoginPage lp=new LoginPage(driver);
		lp.enteruserNameonUserNamefield(usernamevalue).enterPasswordonPasswordfield(passwordvalue).Submit();
		String actual=lp.verifLoginTextIsDisplayed();
		String expected= "7rmart supermarket";
		Assert.assertEquals(actual, expected,"User is able to login with valid user name and invalid password");
	}
	@Test(priority=3,description="user is trying to login with invalid username and valid password")
	
	public void verify_userlogin_with_invalidusername_and_validpassword() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(2, 0, "login");
		String passwordvalue=ExcelUtility.getStringData(2, 1, "login");
		LoginPage lp=new LoginPage(driver);
		lp.enteruserNameonUserNamefield(usernamevalue).enterPasswordonPasswordfield(passwordvalue).Submit();
		String actual=lp.verifLoginTextIsDisplayed();
		String expected= "7rmart supermarket";
		Assert.assertEquals(actual, expected,"User is able to login with invalid user name and valid password");
	}	
	
	
	@Test(priority=4,description="user is trying to login with invalid credentials",groups= {"smoke"},dataProvider="logindata")
	public void verifyuserloginwithinvalidcredentials(String usernamevalue,String passwordvalue) throws IOException
	{
		//String usernamevalue=ExcelUtility.getStringData(3, 0, "login");
		//String passwordvalue=ExcelUtility.getStringData(3, 1, "login");
		LoginPage lp=new LoginPage(driver);
		lp.enteruserNameonUserNamefield(usernamevalue).enterPasswordonPasswordfield(passwordvalue).Submit();
		
		String actual=lp.verifLoginTextIsDisplayed();
		String expected= "7rmart supermarket";
		Assert.assertEquals(actual, expected,"User is able to login with invalid credentials");
	}
	
	@DataProvider(name="logindata")
	
	public Object[][] getDataFromDataProvider(){
		return new Object[][] {
			new Object[] {"Admin","Admin123"},new Object[] {"Admin2","Admin2"},
			
		};
	}
	
	


}
