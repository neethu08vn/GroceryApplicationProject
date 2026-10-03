package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUsersPage {
	
public WebDriver driver;
PageUtility page = new PageUtility();
	
	public AdminUsersPage(WebDriver driver) 
	{
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@onclick='click_button(1)']") WebElement newbutton;
	@FindBy(id="username") WebElement newusernamefield;
	@FindBy(id="password") WebElement newpasswordfield;
	@FindBy(xpath = "//select[@id='user_type']") WebElement usertypedropdown;
	@FindBy(xpath="//button[@type='submit' and contains(@name, 'Create')]") WebElement savebutton;
	@FindBy(xpath="//a[@onclick='click_button(2)']") WebElement searchbutton;
	@FindBy(id="un") WebElement searchusername;
	@FindBy(id="ut") WebElement usertypeinsearch;
	@FindBy(xpath="//button[@name=\"Search\"]") WebElement searchbuttoninsearch;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and contains(@class, 'btn btn-rounded btn-warning')]") WebElement resetbutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement AlertMsg;//assertion
	@FindBy(xpath = "//h4[text()='Admin Users']") WebElement usersList;//assertion
	
	
	public AdminUsersPage clickOnNewButtoninAdminUserspage()
	{
		newbutton.click();
		return this;
	}
	
	public AdminUsersPage enterUsernameInUsernamefieldInNew(String newusername)
	{
		
		newusernamefield.sendKeys(newusername);
		return this;
	}
	
	public AdminUsersPage enterPasswordInPasswordFieldInNew(String newpassword)
	{
		newpasswordfield.sendKeys(newpassword);
		return this;
	}
	
	public AdminUsersPage selectAValueFromUsertypedropdownField(String type)
	{
		page.selectDropdownWithIndex(usertypedropdown, 2);
		//Select select = new Select(usertypedropdown);
		//select.selectByContainsVisibleText(type);
		return this;
	}
	
	
	public AdminUsersPage clickOnSaveButtoninNew()
	{
		savebutton.click();
		return this;
	}
	
	public AdminUsersPage clickOnSearchbutton()
	{
		searchbutton.click();
		return this;
	}
	
	public AdminUsersPage enterUsernameInSearch(String username)
	{
		searchusername.sendKeys(username);
		return this;
	}
	
	public AdminUsersPage selectUserTypeInSearch(String type)
	{
		Select select = new Select(usertypeinsearch);
		select.selectByContainsVisibleText(type);
		return this;
	}
	
	public AdminUsersPage clickOnSearchButtonInSearch()
	{
		searchbuttoninsearch.click();
		return this;
	}
	
	public AdminUsersPage clickOnResetButton()
	{
		resetbutton.click();
		return this;
	}
	
	//Assertion
	public boolean isAlertDisplayed() {
		return AlertMsg.isDisplayed();
	}

	public boolean adminUsersList() {
		return usersList.isDisplayed();
	}

}
