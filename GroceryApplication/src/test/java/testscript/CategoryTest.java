package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.ExcelUtility;
import pages.CategoryPage;
import pages.HomePage;
import pages.LoginPage;

public class CategoryTest extends Base{
	HomePage hp;
	CategoryPage CP;
	@Test
	public void verifyWhetherUserIsabletoAddNewcategory() throws IOException
	{
	String usernamevalue=ExcelUtility.getStringData(0, 0, "login");
	String passwordvalue=ExcelUtility.getStringData(0, 1, "login");
	LoginPage lp=new LoginPage(driver);
	lp.enteruserNameonUserNamefield(usernamevalue).enterPasswordonPasswordfield(passwordvalue);
	hp=lp.Submit();
	
	
	CP=hp.CategoryMoreInfoclick();
	
	CP.categoryNewClick();
	
     String varcategory=ExcelUtility.getStringData(0, 0,"Category");
	CP.entercategory(varcategory).choosecategory().scrollPage().choosefile().submit();
	String actual=CP.newcategoryalert();
	System.out.println(CP.newcategoryalert());
	String expected="×\nAlert!\n             Category Created Successfully    ";
	Assert.assertEquals(actual, expected,"Category is not created");
	
	
	
	//verifyWhetherUserIsabletoAddNewcategory
	//category-read from excel
	//verifyWhetherIsAbletoSearchTheNewlyAddedcategory
	}
	@Test
	public void verifyWhetherUserIsabletoSearchNewcategory() throws IOException
	{
	String usernamevalue=ExcelUtility.getStringData(0, 0, "login");
	String passwordvalue=ExcelUtility.getStringData(0, 1, "login");
	LoginPage lp=new LoginPage(driver);
	lp.enteruserNameonUserNamefield(usernamevalue).enterPasswordonPasswordfield(passwordvalue);
	hp=lp.Submit();
	
	
	CP=hp.CategoryMoreInfoclick();
	
	//CP.categoryNewClick();
    
	CP.searchCategory();
	 String searchcategoryfromexcel=ExcelUtility.getStringData(0, 0,"Category");
	
		CP.entersearchcategoryfield(searchcategoryfromexcel).submitsearchcategoryfield();
	//verifyWhetherUserIsabletoAddNewcategory
	//category-read from excel
	//verifyWhetherIsAbletoSearchTheNewlyAddedcategory
		
	
		
	}
	
	
}
