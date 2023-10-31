package com.qa.opencart.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void accountPageSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	}

	@Test(priority = 1)
	public void verifyAccountsPageTilteTest() {
		String actualTitle = accPage.AccountsPageTitle();
		// Assert.assertEquals(actualTitle, "My Account");
		Assert.assertEquals(actualTitle, AppConstants.ACCOUNTS_PAGE_TITLE_VALUE);
	}

	@Test(priority = 2)
	public void verifyAccountUrlTest() {
		String actualUrl = accPage.getAccountsUrl();
		Assert.assertTrue(actualUrl.contains(AppConstants.ACCOUNTS_PAGE_URL_FRACTION_VALUE));
	}

	@Test(priority = 3)
	public void logoutlinkExistTest() {
		Assert.assertTrue(accPage.isLogoutLinkExists());
	}

	@Test(priority = 4)
	public void accountHeaderTest() {
		List<String> actualAccPageHeaderList = accPage.getAccountsPageHeaderList();
		Assert.assertEquals(actualAccPageHeaderList.size(), AppConstants.ACCOUNTS_PAGE_HEADERS_COUNT);

	}

	@Test(priority = 4)
	public void accountHeadervalueTest() {
		List<String> actualAccPageHeaderList = accPage.getAccountsPageHeaderList();
		System.out.println(actualAccPageHeaderList);
		System.out.println(AppConstants.EXPECTED_ACCOUNT_HEADER_LIST);
		Assert.assertEquals(actualAccPageHeaderList, AppConstants.EXPECTED_ACCOUNT_HEADER_LIST);

	}

	@DataProvider
	public Object[][] getproductData() {
		return new Object[][] { { "MacBook Pro" },
			{ "iMac"  },
			{ "MacBook Air" },
			{ "Apple"  },
			{ "Samsung"  },
			{"Test"}
				 };
	}

	@Test(dataProvider = "getproductData")
	public void searchProductCountTest(String searchKey) {
		searchPage = accPage.performSearch(searchKey);
		Assert.assertTrue(searchPage.getSearchProductCount() > 0);
	}

	@DataProvider
	public Object[][] getproductTestData() {
		return new Object[][] { { "MacBook Pro", "MacBook Pro" },
			{ "iMac", "iMac" },
			{ "MacBook Air","MacBook Air" },
		//	{ "Apple Cinema 30" ,"Apple Cinema 30\"" },
		//	{ "Samsung" ,"Samsung Galaxy Tab 10.1" },
				 };
				 
	}
	@Test(dataProvider = "getproductTestData")
	public void searchProductTest(String searchKey, String productName) {
		searchPage = accPage.performSearch(searchKey);

		if (searchPage.getSearchProductCount() > 0) {
			productInfoPage = searchPage.selectProduct(searchKey);
			String actProductHeader = productInfoPage.getProductHeaderValue();
			Assert.assertEquals(actProductHeader, productName);
		}
	}
	
	
	
	

}