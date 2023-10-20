package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {
	private WebDriver driver;
	private ElementUtil eleUtil;// for each class sep Elementutil object is created

	// 1.private by locators
	private By emaiId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPasswordLink = By.linkText("Forgotten Password");

	// 2 Page Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);// created object of element util so that same driver can be used
	}

	// 3 Page actions

	public String loginPageTitle() {
		// String title = driver.getTitle();
		// String title = eleUtil.waitForTitleContainsAndFetch(100, "Account Login");

		// ***********replace harcoded values with app constants**********//
		String title = eleUtil.waitForTitleContainsAndFetch(AppConstants.DEFAULT_MEDIUM_TIMEOUT,
				AppConstants.LOGIN_PAGE_TITLE_VALUE);
		System.out.println("Loginpage Title" + title);
		return title;
	}

	public String loginPageUrl() {
		// String url = driver.getCurrentUrl();
		// String url = eleUtil.waitForURLContainsAndFetch(10, "route=account/login");

		// ***********replace harcoded values with app constants**********//
		String url = eleUtil.waitForURLContainsAndFetch(AppConstants.DEFAULT_MEDIUM_TIMEOUT,
				AppConstants.LOGIN_PAGE_URL_FRACTION_VALUE);
		System.out.println("Loginpage url" + url);
		return url;
	}

	public boolean isForgotPassswordLinkExist() {
		// return driver.findElement(forgotPasswordLink).isDisplayed();
		return eleUtil.waitForElementVisible(forgotPasswordLink, 30).isDisplayed();
	}

	public AccountsPage doLogin(String un, String pwd) {
		/*
		 * driver.findElement(emaiId).sendKeys(un);
		 * driver.findElement(password).sendKeys(pwd);
		 * driver.findElement(loginBtn).click();// after clicking we are going to
		 * account page henece methods responsiblity to return landing page object
		 */
		// this is called TDD test driven approach
		// Page Object Model

		// Replace the method by utilites created
		
		System.out.println("App credentials  " +un+ ":" +pwd);
		eleUtil.waitForElementVisible(emaiId, 30).sendKeys(un);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);
		return new AccountsPage(driver);

	}

}
