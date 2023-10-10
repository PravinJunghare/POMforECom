package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;

	// 1.private by locators
	private By emaiId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPasswordLink = By.linkText("Forgotten Password");

	// 2 Page Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3 Page actions

	public String loginPageTitle() {
		String title = driver.getTitle();
		System.out.println("Loginpage Title" + title);
		return title;
	}

	public String loginPageUrl() {
		String url = driver.getCurrentUrl();
		System.out.println("Loginpage url" + url);
		return url;
	}
	
	public boolean isForgotPassswordLinkExist() {
		return driver.findElement(forgotPasswordLink).isDisplayed();
	}
	
	public void doLogin(String un,String pwd)
	{
		driver.findElement(emaiId).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginBtn).click();
	}

}
