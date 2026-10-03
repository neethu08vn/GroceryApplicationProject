package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import automationcore.Base;
import constants.Constant;

import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base {

	HomePage home;
	AdminUsersPage admin;
	
	@Test(priority = 1, description = "Validating new user entry")
	public void VerifyUserAbletoAddNewUsersInAdminUsersPage() throws IOException {
		FakerUtility faker = new FakerUtility();
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		home = login.clickOnLoginButton();

		//HomePage home = new HomePage(driver);
		admin = home.clickOnAdminUsers();

		//AdminUsersPage admin = new AdminUsersPage(driver);
		admin.clickOnNewButtoninAdminUserspage();
		// String newusername = ExcelUtility.readStringData(1, 0, "AdminUserPage");
		// String newpassword = ExcelUtility.readStringData(1, 1, "AdminUserPage");
		String newusername = faker.createRandomUsername();
		String newpassword = faker.createRandomPassword();
		admin.enterUsernameInUsernamefieldInNew(newusername).enterPasswordInPasswordFieldInNew(newpassword).selectAValueFromUsertypedropdownField("Delivery Boy").clickOnSaveButtoninNew();
		
		// Assertions
		boolean alertDisplay = admin.isAlertDisplayed();
		Assert.assertEquals(alertDisplay, "UserEntryError");

	}

	@Test(priority = 2, description = "Validating user details search")
	public void verifyUserAbletoSearchTheAddedNewUsernameInAdminUserPage() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		home = login.clickOnLoginButton();

		//HomePage home = new HomePage(driver);
		admin = home.clickOnAdminUsers();

		//AdminUsersPage admin = new AdminUsersPage(driver);
		admin.clickOnSearchbutton();
		String newusername = ExcelUtility.readStringData(1, 0, "AdminUserPage");
		admin.enterUsernameInSearch(newusername).selectUserTypeInSearch("Admin").clickOnSearchButtonInSearch();
		
		// Assertions
		boolean usersList = admin.adminUsersList();
		Assert.assertEquals(usersList, "UserSearchError");
	}

	@Test(priority = 3, description = "Validating user's Reset Button")
	public void verifyResetButton() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		home = login.clickOnLoginButton();

		//HomePage home = new HomePage(driver);
		admin = home.clickOnAdminUsers();

		//AdminUsersPage admin = new AdminUsersPage(driver);
		admin.clickOnResetButton();
		
		// Assertions
		boolean resetList = admin.adminUsersList();
		Assert.assertTrue(resetList, "UserResetError");
	}

}
