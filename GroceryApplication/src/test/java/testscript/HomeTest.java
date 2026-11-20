package testscript;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.ExcelUtility;
import pages.HomePage;
import pages.LoginPage;

public class HomeTest extends Base{
	
	HomePage hp;

@Test

public void VerifywhetherUserisabletosuccessfulyyloggedout() throws IOException
{
	String usernamevalue=ExcelUtility.getStringData(0, 0, "login");
	String passwordvalue=ExcelUtility.getStringData(0, 1, "login");
	LoginPage lp=new LoginPage(driver);
	lp.enteruserNameonUserNamefield(usernamevalue).enterPasswordonPasswordfield(passwordvalue);
	hp=lp.Submit();
	
	
	hp.adminclick();
	lp=hp.logout();
	String actual=lp.verifLoginTextIsDisplayed();
	String expected= "7rmart supermarket";
	Assert.assertEquals(actual, expected,"User is unable to logout");


}

}
