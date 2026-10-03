package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import automationcore.Base;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	
	HomePage home;
	
	@Test(priority=1,description="Validating user login with valid credentials",groups={"smokes"})
	public void verifyUserLoginWithValidCredentials() throws IOException
	{
				
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		home = login.clickOnLoginButton();
		boolean dashboarddisplay = login.isDashboardDisplayed();
		Assert.assertTrue(dashboarddisplay, Constant.ValidCredsError);
				
	}
	
	@Test(priority=2, description="Validating user login with valid username and invalid password")
	public void verifyUserLoginWithValidUsernameAndInvalidPassword() throws IOException
	{
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnLoginButton();
		String actualtitle = login.getPageTitle();
		String expectedtitle = "7rmart supermarket";
		Assert.assertEquals(actualtitle, expectedtitle,"User was able to login with invalid username");
				
	}
	
	@Test(priority=3, description="Validating user login with invalid username and valid password")
	public void verifyUserLoginWithInvalidUsernameAndValidPassword() throws IOException
	{
		String username = ExcelUtility.readStringData(2, 0, "LoginPage");
		String password = ExcelUtility.readStringData(2, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnLoginButton();
		String actualtitle = login.getPageTitle();
		String expectedtitle = "7rmart supermarket";
		Assert.assertEquals(actualtitle, expectedtitle,"User was able to login with invalid password");
				
	}
	
	@Test(priority=4, description="Validating user login with invalid credentials", groups={"smokes"}, dataProvider = "loginProvider")
	public void verifyUserLoginWithInvalidCredentials(String username, String password) throws IOException
	{
		//String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		//String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnLoginButton();
		boolean errordisplay = login.isErrorMessageDisplayed();
		Assert.assertTrue(errordisplay, "User was able to login with invalid credentials");
				
	}
	
	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {

		return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
				// new Object[] {ExcelUtility.getStringData(3,
				// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
		};
		
	}

}
