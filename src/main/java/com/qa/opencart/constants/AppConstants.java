package com.qa.opencart.constants;

import java.util.Arrays;
import java.util.List;

public class AppConstants {
	
	public static final int DEFAULT_SHORT_TIMEOUT=10;
	public static final int DEFAULT_MEDIUM_TIMEOUT=20;
	public static final int DEFAULT_LONG_TIMEOUT=30;

	public static final String LOGIN_PAGE_TITLE_VALUE = "Account Login";
	public static final String LOGIN_PAGE_URL_FRACTION_VALUE = "route=account/login";

	public static final String ACCOUNTS_PAGE_TITLE_VALUE = "My Account";
	public static final String ACCOUNTS_PAGE_URL_FRACTION_VALUE = "route=account/account";
	public static final int ACCOUNTS_PAGE_HEADERS_COUNT = 4;
	
	public static final List<String>EXPECTED_ACCOUNT_HEADER_LIST=Arrays.asList("My Account","My Orders","My Affiliate Account","Newsletter");
	
}
