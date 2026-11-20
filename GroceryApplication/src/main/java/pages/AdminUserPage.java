package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.PageUtility;

public class AdminUserPage {

public WebDriver driver;
PageUtility pu=new PageUtility();

public AdminUserPage(WebDriver driver)
{
this.driver=driver;	
PageFactory.initElements(driver, this);

}
@FindBy(xpath="//a[contains(text(),'New')]") WebElement newbutton;
@FindBy(xpath="//input[@id='username']")WebElement adminusername;
@FindBy(xpath="//input[@id='password']") WebElement adminpassword;
@FindBy(xpath="//button[@name='Create']") WebElement admitsubmit;
@FindBy(xpath="//select[@id='user_type']") WebElement admindropdown;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement newuseralert;
@FindBy(xpath="//a[@onclick='click_button(2)']") WebElement searchmain;
@FindBy(xpath="//input[@id='un']") WebElement searchusername;
@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]") WebElement adminUserTableCell;
@FindBy(xpath="//select[@id='ut']") WebElement adminseachdropdoown;
@FindBy(xpath="//button[@type='submit' and @name='Search']")WebElement adminsearchusersubmit;

public AdminUserPage adminUserSearchSubmit()
{
	adminsearchusersubmit.click();
	return this;
	}

public AdminUserPage selectSearchAdminUserType()
{
Select obj=new Select(adminseachdropdoown);
obj.selectByIndex(2);
return this;
}


public AdminUserPage enteradminUserTableCell()
{
String adminsearchuser1=adminUserTableCell.getText();
searchusername.sendKeys(adminsearchuser1);
return this;

}

public AdminUserPage getSearchusernameFromTable()
{
	String SearchusernameFromTable=adminUserTableCell.getText();
	return this;
}


public AdminUserPage searchuser()
{
	searchmain.click();	
	return this;
	}


public String newUseralertisDisplayed()
{
	return newuseralert.getText();
}



public AdminUserPage newbuttonclick()
{
	WebDriverWait wb=new WebDriverWait(driver,Duration.ofSeconds(5));
	wb.until(ExpectedConditions.elementToBeClickable(newbutton));
	newbutton.click();
	return this;
	
}

public AdminUserPage enteradminuser(String adminusernamefromexcel)
{
	adminusername.sendKeys(adminusernamefromexcel);
	return this;
}

public AdminUserPage enteradminpassword(String adminpasswordvalue1)
{
	adminpassword.sendKeys(adminpasswordvalue1);
	return this;
	}

public AdminUserPage adminselectdropdown()
{
//Select obj=new Select(admindropdown);
//obj.selectByVisibleText("Admin");
	pu.selectDropdownWithVisibleText(admindropdown, "Admin");
	return this;

}

public AdminUserPage adminsubmit()
{
	admitsubmit.click();
	return this;
	
}


}
