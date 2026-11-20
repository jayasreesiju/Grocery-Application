package testscript;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.ExcelUtility;
import Utilities.RandomDataUtility;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;

public class AdminUserTest extends Base{
	
	//public WebDriver driver;
//verifyWhetherUserIsAbletoAddnewAdminUser

	HomePage hp;
	AdminUserPage ap;
	@Test
	public void verifyWhetherUserIsAbletoAddnewAdminUser() throws IOException
	{
	    String usernamevalue=ExcelUtility.getStringData(0, 0, "login");
		String passwordvalue=ExcelUtility.getStringData(0, 1, "login");
		LoginPage lp=new LoginPage(driver);
		lp.enteruserNameonUserNamefield(usernamevalue).enterPasswordonPasswordfield(passwordvalue);
		hp=lp.Submit();
		
		
		ap=hp.homeadmintilemoreinfo();
		
		
		ap.newbuttonclick();
        RandomDataUtility rdu=new RandomDataUtility();
        String adminusername=rdu.genrateRandomUsername();
        String adminpassword=rdu.generateRandomPassword();
		//String adminusername=ExcelUtility.getStringData(0, 0,"adminuser");
		//String adminpassword=ExcelUtility.getStringData(0, 1, "adminuser");
		ap.enteradminuser(adminusername).enteradminpassword(adminpassword).adminselectdropdown().adminsubmit();
		
		String actual=ap.newUseralertisDisplayed();
		System.out.println(ap.newUseralertisDisplayed());
		String expected="×\nAlert!\nUser Created Successfully";
		Assert.assertEquals(actual, expected,"User is not created");
		
		
		
	}
	
	@Test
	
	public void verifyWhetherUserIsAbletoSearchAdminUser() throws IOException
	{
	    String usernamevalue=ExcelUtility.getStringData(0, 0, "login");
		String passwordvalue=ExcelUtility.getStringData(0, 1, "login");
		LoginPage lp=new LoginPage(driver);
		lp.enteruserNameonUserNamefield(usernamevalue);
		lp.enterPasswordonPasswordfield(passwordvalue);
		lp.Submit();
		
		HomePage hp=new HomePage(driver);
		hp.homeadmintilemoreinfo();
		
		AdminUserPage ap=new AdminUserPage(driver);
		ap.searchuser();
		ap.enteradminUserTableCell();
		ap.selectSearchAdminUserType();
		ap.adminUserSearchSubmit();
		
	
	}
	
	
	
}
