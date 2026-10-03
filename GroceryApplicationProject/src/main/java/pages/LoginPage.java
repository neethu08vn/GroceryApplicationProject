package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {
	
	public WebDriver driver;
	WaitUtility wait = new WaitUtility();
	
	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="username") WebElement usernamefield;
	@FindBy (name="password") WebElement passwordfield;
	@FindBy (xpath = "//button[@type='submit']") WebElement loginbutton;
	@FindBy(xpath = "//p[text()='Dashboard']") WebElement dashboard;
	@FindBy(xpath ="//b[text()='7rmart supermarket']") WebElement pagetitle;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']") WebElement errormessage;
	
	public LoginPage enterUsernameOnUsernameField(String username)
	{
		usernamefield.sendKeys(username);
		return this;
	}
	
	public LoginPage enterPasswordOnPasswordField(String password)
	{
		passwordfield.sendKeys(password);
		return this;
	}
	
	public HomePage clickOnLoginButton()
	{
		wait.waitUntilElementToBeClickable(driver, loginbutton);
		loginbutton.click();
		return new HomePage(driver);
	}
	
	//assertion
	public Boolean isDashboardDisplayed()
	{
		return dashboard.isDisplayed();
	}
	
	public String getPageTitle()
	{
		return pagetitle.getText();
	}
	
	public Boolean isErrorMessageDisplayed()
	{
		return errormessage.isDisplayed();
	}
	

}
