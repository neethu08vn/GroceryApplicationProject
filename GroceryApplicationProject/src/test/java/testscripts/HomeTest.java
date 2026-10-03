package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {
	
	HomePage home;
	
	@Test(description = "Validating successful logout of user",retryAnalyzer = retrymechanism.Retry.class)
	public void VerifyUserAbletoSuccessfullyLogout() throws IOException
	{
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		home = login.clickOnLoginButton();
		
		//HomePage home = new HomePage(driver);
		home.clickOnAdminbutton();
		login = home.clickOnLogouButton();
		String actual = home.getPageText();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected,"UnsuccessfulLogoutError");
	}

}
