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

public class CategoryPage {
	
	public WebDriver driver;
	public CategoryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger' and @onclick='click_button(1)']")WebElement CategoryNew;
	@FindBy(xpath="//input[@id='category']")WebElement enterCategory;
	@FindBy(xpath="//li[@id='1-selectable']") WebElement chooseCategory;
	@FindBy(xpath="//input[@id='main_img']") WebElement choosefile;
	@FindBy(xpath="//button[@type='submit']") WebElement submit;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")WebElement CategorySearch;
	@FindBy(xpath="//input[@name='un']") WebElement entersearchcategory;
	@FindBy(xpath="//button[@type='submit']") WebElement SearchCategorysubmit;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement newCategoryAlert;
	public String newcategoryalert()
	{
		return newCategoryAlert.getText();
	}

	
	public CategoryPage submitsearchcategoryfield()
	
	{
	SearchCategorysubmit.click();
	return this;
	}
	
	
	public CategoryPage entersearchcategoryfield(String enterseacrhcategoryfromexcel)
	
	{
		entersearchcategory.sendKeys(enterseacrhcategoryfromexcel);
		return this;
	}
	
	public CategoryPage searchCategory()
	{
		CategorySearch.click();
		return this;
	}
	
	
	
	public CategoryPage entercategory(String varcategory)
	{
		enterCategory.sendKeys(varcategory);
		return this;
	}
	
	public CategoryPage choosecategory()
	{
		chooseCategory.click();	
		return this;
	}
	
	public CategoryPage choosefile()
	{
		choosefile.sendKeys("/Users/nevaeh/Downloads/test1.jpg");	
		return this;
	}
	
	public CategoryPage submit()
	{
		submit.click();
		return this;
	}
	public CategoryPage scrollPage()
	{
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,900)","");
		return this;
		//^^^- go down
		
		//js.executeScript("window.scrollBy(0,-300)","");
		
		//^^---go up	
		
	}
public CategoryPage categoryNewClick()
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.elementToBeClickable(CategoryNew)).click();
    return this;
	//CategoryNew.click();	
}
}
