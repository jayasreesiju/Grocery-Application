package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;
	
	 public HomePage(WebDriver driver)
	 {
		 
		 this.driver=driver;
		 PageFactory.initElements(driver, this);	

	 }

	 @FindBy(xpath="//a[@data-toggle='dropdown']") WebElement admin;
	 
	 @FindBy(xpath="//i[@class='ace-icon fa fa-power-off']") WebElement logout;
	 @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']") WebElement homeadmintilemoreinfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy' and @class='small-box-footer']")WebElement ManageDeliveryBoyMoreInfo;
	 @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']") WebElement CategoryMoreInfo;
	 public ManageDeliveryBoyPage homeadeliveryboymoreinfo()
	 {
		 ManageDeliveryBoyMoreInfo.click();
		 return new ManageDeliveryBoyPage(driver);
	 }
	 public AdminUserPage homeadmintilemoreinfo()
	 {
		 homeadmintilemoreinfo.click();
		 return new  AdminUserPage(driver);
	 }
	 
	 public CategoryPage CategoryMoreInfoclick()
	 {
		 CategoryMoreInfo.click();
		 return new CategoryPage(driver);
	 }
	 
	 
	 public HomePage adminclick()
	 {
		 
		 admin.click();	
		 return this;
		 }
	 
	 public LoginPage logout()
	 {
		 
		 logout.click();
		 return new LoginPage(driver);
		 }
	 
	 
}