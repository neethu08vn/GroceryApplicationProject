package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
public WebDriver driver;
	
	public HomePage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//a[@data-toggle='dropdown']") WebElement adminbutton;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout'and contains(@class,'dropdown-item')]") WebElement logoutbutton;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and contains(@class,'small-box-footer')]") WebElement adminusers;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='active nav-link']")WebElement manageNewsIcon;
	@FindBy(xpath = "//b[text()='7rmart supermarket']") WebElement pageText; //Assertion
	
	public HomePage clickOnAdminbutton()
	{
		adminbutton.click();
		return this;
	}
	
	public LoginPage clickOnLogouButton()
	{
		logoutbutton.click();
		return new LoginPage(driver);
	}
	
	public AdminUsersPage clickOnAdminUsers()
	{
		adminusers.click();
		return new AdminUsersPage(driver);
	}
	
	public ManageNewsPage clickManageNewsIcon() 
	{
		manageNewsIcon.click();
		return new ManageNewsPage(driver);
		
	}
	
	//assertion
	public String getPageText() 
	{
		return pageText.getText();

}

}
