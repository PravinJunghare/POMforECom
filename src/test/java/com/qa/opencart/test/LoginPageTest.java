package com.qa.opencart.test;

import org.testng.annotations.Test;
import com.qa.opencart.base.BaseTest;

import dev.failsafe.internal.util.Assert;

public class LoginPageTest extends BaseTest {

	@Test
	public void LoginPageTitleTest() {
		String actualTitle = loginpage.loginPageTitle();
		org.testng.Assert.assertEquals(actualTitle, "Account Login");
	}

	@Test
	public void LoginUrtTest() {
		String actualurl = loginpage.loginPageUrl();
		org.testng.Assert.assertTrue(actualurl.contains("route=account/login"));
	}

	@Test
	public void forgotPassworLinkTest() {
		org.testng.Assert.assertTrue(loginpage.isForgotPassswordLinkExist());
	}

	@Test
	public void loginTest() {
		loginpage.doLogin("pravinjunghare01@gmail.com", "Test@1234");
	}

	
	
}
