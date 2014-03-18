package com.autotesting.framework.screens;

import com.autotesting.framework.utils.WebDriverRunner;

public class HomePageScreen extends BaseScreen {
    
	private final String HOME_PAGE_TITLE = "//title";
	
	
	public String getTitleHomePage() {
		
		
		return wrapper.getTextByXpath(HOME_PAGE_TITLE);
	 }

	

	
	
	
	
	
	
	
	
	
	
}
