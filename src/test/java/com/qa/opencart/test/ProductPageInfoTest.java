package com.qa.opencart.test;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class ProductPageInfoTest extends BaseTest {
	@BeforeClass
	public void productInfoPageSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		// loginpage
	}

	@DataProvider
	public Object[][] getproductImageTestData() {
		return new Object[][] { { "MacBook Pro", "MacBook Pro", 4 }, { "iMac", "iMac", 3 },
				{ "MacBook Air", "MacBook Air", 4 },
				// { "Apple Cinema 30" ,"Apple Cinema 30\"" },,
				// { "Samsung" ,"Samsung Galaxy Tab 10.1" },
		};
	}

	@Test(dataProvider = "getproductImageTestData")
	public void productImageCountTest(String searchKey, String productName, int prodcutImageCount) {
		// AccountPage>>>SearchPage
		searchPage = accPage.performSearch(searchKey);
		// SearchPage>>>ProductInfoPage
		productInfoPage = searchPage.selectProduct(productName);

		int actImageCount = productInfoPage.getImagesCount();
		Assert.assertEquals(actImageCount, prodcutImageCount);
	}

}
