package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class LoginPageTest extends BaseTest {

	@Test(priority = 1)
	public void LoginPageTitleTest() {
		String actualTitle = loginPage.loginPageTitle();
		// Assert.assertEquals(actualTitle, "Account Login");
		Assert.assertEquals(actualTitle, AppConstants.LOGIN_PAGE_TITLE_VALUE);
	}

	@Test(priority = 2)
	public void LoginUrtTest() {
		String actualurl = loginPage.loginPageUrl();

		Assert.assertTrue(actualurl.contains(AppConstants.LOGIN_PAGE_URL_FRACTION_VALUE));
	}

	@Test(priority = 3)
	public void forgotPassworLinkTest() {
		org.testng.Assert.assertTrue(loginPage.isForgotPassswordLinkExist());
	}

	@Test(priority = 4)
	public void loginTest() {
		accPage = loginPage.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
		Assert.assertTrue(accPage.isLogoutLinkExists());

	}

}
