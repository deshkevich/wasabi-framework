package com.autotesting.framework.screens;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.autotesting.framework.service.WebDriverWrapper;
import com.autotesting.framework.utils.WebDriverRunner;

public class BaseScreen {
	
	protected static final Logger log = Logger.getLogger(WebDriverRunner.class);
	protected WebDriverWrapper wrapper = new WebDriverWrapper();


	public static Logger getLog() {
		return log;
	}

	
	
	
	
	
	public BaseScreen closeBrowser() {
		log.debug("Закрываем браузер.");
		WebDriverRunner.stopWebDriver();
		return this;
	}
	
}
