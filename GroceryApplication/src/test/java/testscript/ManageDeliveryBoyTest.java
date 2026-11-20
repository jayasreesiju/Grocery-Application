package testscript;

import java.io.IOException;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Utilities.ExcelUtility;
import Utilities.RandomDataUtility;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageDeliveryBoyPage;

public class ManageDeliveryBoyTest extends Base{
	HomePage hp;
	ManageDeliveryBoyPage mdb;
	@Test
	
	public void verifyWhetherUserIsAbletoAddNewDeliveryBoy() throws IOException
	{
		 String usernamevalue=ExcelUtility.getStringData(0, 0, "login");
			String passwordvalue=ExcelUtility.getStringData(0, 1, "login");
			LoginPage lp=new LoginPage(driver);
			lp.enteruserNameonUserNamefield(usernamevalue).enterPasswordonPasswordfield(passwordvalue);
			hp=lp.Submit();
			
			
			mdb=hp.homeadeliveryboymoreinfo();
		
		
		mdb.ManageDeliveryBoyNewClick();
		RandomDataUtility rdu=new RandomDataUtility();
		String  DeliveryBoyname=rdu.generateRandomFullname();
		String  DeliveryBoyEmail=rdu.generateRandomEmailid();
		String  DeliveryBoyPhone=rdu.generateRandomPhonenumber();
		String  DeliveryBoyAddress=rdu.generateRandomAddress();
		String  DeliveryBoyusername=rdu.genrateRandomUsername();
		String  DeliveryBoypassword=rdu.generateRandomPassword();
		
		mdb.enterDeliveryfullname(DeliveryBoyname).enterDeliveryemail(DeliveryBoyEmail).enterDeliveryphone(DeliveryBoyPhone).enterDeliveryAddress(DeliveryBoyAddress).enterDeliveryUsername(DeliveryBoyusername).scrollPage().enterDeliveryPassword(DeliveryBoypassword).DeliverySubmitClick();
		
		}
}
