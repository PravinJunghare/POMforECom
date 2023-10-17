package com.qa.opencart.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;

public class BaseTest {

	DriverFactory df;
	WebDriver driver;
	protected LoginPage loginPage;// only child classes can access 
	protected AccountsPage accPage;


	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		driver = df.initBrowser("chrome"); // driver as holding parameter
		loginPage=new LoginPage(driver);// all pages objects are created in base test
	} 

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
