package com.autotesting.framework.screens;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.autotesting.framework.service.WebDriverWrapper;
import com.autotesting.framework.utils.WebDriverRunner;

public class BaseScreen {
	
	protected static final Logger log = Logger.getLogger(WebDriverRunner.class);
	protected WebDriverWrapper wrapper = new WebDriverWrapper();


	public static Logger getLog() {
		return log;
	}

	/*
	public String isPageOpen(String xpath) {
		
		String result = wrapper.getTitle();
		
		return result;
	}
	
	*/
 /*   
	public BaseScreen openPage() {
		getDriver()
		}
*/
	public BaseScreen closeBrowser() {
		log.debug("Закрываем браузер.");
		WebDriverRunner.stopWebDriver();
		return this;
	}
	
}
