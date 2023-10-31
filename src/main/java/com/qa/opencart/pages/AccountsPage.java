package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// 1 Class Constructor
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// 2. private locators
	private By logoutlink = By.linkText("Logout");
	private By accountPageHeader = By.xpath("//div[@id ='content']/h2");
	private By search = By.name("search");
	private By searchIcon = By.cssSelector("#search button");



	public String AccountsPageTitle() {
		// String title = driver.getTitle();
		// String title = eleUtil.waitForTitleContainsAndFetch(100, "My Account");
		// ***********replace harcoded values with app constants**********//
		String title = eleUtil.waitForTitleContainsAndFetch(AppConstants.DEFAULT_MEDIUM_TIMEOUT,
				AppConstants.ACCOUNTS_PAGE_TITLE_VALUE);
		System.out.println("AccountsPage Title" + title);
		return title;
	}

	public String getAccountsUrl() {
		// String accPageUrl = driver.getCurrentUrl();
		// String url = eleUtil.waitForURLContainsAndFetch(10, "route=account/account");

		// ***********replace harcoded values with app constants**********//
		String url = eleUtil.waitForURLContainsAndFetch(AppConstants.DEFAULT_MEDIUM_TIMEOUT,
				AppConstants.ACCOUNTS_PAGE_URL_FRACTION_VALUE);
		System.out.println("Acc page Tile: " + url);
		return url;
	}

	public boolean isLogoutLinkExists() {
		// return driver.findElement(logoutlink).isDisplayed();
		return eleUtil.waitForElementVisible(search, 10).isDisplayed();
	}

	public List<String> getAccountsPageHeaderList() {

		// List<WebElement> accHeaderList = driver.findElements(accountPageHeader);

		List<WebElement> accHeaderList = eleUtil.waitForElementsVisible(accountPageHeader, 10);
		List<String> accHeaderValueList = new ArrayList<String>();

		for (WebElement e : accHeaderList) {
			String text = e.getText();
			accHeaderValueList.add(text);
		}
		return accHeaderValueList;
	}

	public void getSearchProductsCount() {

	}

	// for search the product
	public SearchPage performSearch(String key) {
		eleUtil.doSendKeys(search, key);
		eleUtil.doClick(searchIcon);
		return new SearchPage(driver);
	}

}
