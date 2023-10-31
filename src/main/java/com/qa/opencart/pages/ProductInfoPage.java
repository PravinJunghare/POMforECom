package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {

	private WebDriver driver;
	private ElementUtil eleUtil;// for each class sep Elementutil object is created

	private By productHeader = By.tagName("h1");
	private By ProductImage = By.cssSelector("ul.thumbnails img");

	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String getProductHeaderValue() {
		String productHeaderValue = eleUtil.doElementGetText(productHeader);
		System.out.println("ProductHeaderValue" + productHeaderValue);

		return productHeaderValue;
	}

	public int getImagesCount() {
		int imageCount = eleUtil.waitForElementsVisible(ProductImage, AppConstants.DEFAULT_MEDIUM_TIMEOUT).size();
		System.out.println("Total Images of product:" + imageCount);
		return imageCount;
	}

}
