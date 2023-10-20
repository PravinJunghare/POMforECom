package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;

public class BaseTest {

	DriverFactory df;
	WebDriver driver;
	protected Properties prop;
	protected LoginPage loginPage;// only child classes can access
	protected AccountsPage accPage;

	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		prop = df.initProp();// this will return properties reference so can be stored in prop

		driver = df.initBrowser(prop);// here we are passing prop in constructor so in initBrowser() thrers should be
										// Holding Properties prop is require
		// driver = df.initBrowser("chrome"); // driver as holding parameter
		loginPage = new LoginPage(driver);// all pages objects are created in base test
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
