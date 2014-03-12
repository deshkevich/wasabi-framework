package com.autotesting.framework.screens;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.autotesting.framework.utils.WebDriverRunner;

public class BaseScreen {
	
	protected static final Logger log = Logger.getLogger(WebDriverRunner.class);
	WebDriver driver = WebDriverRunner.getDriver();
	
	public BaseScreen closeBrowser() {
		log.debug("Закрываем браузер.");
		WebDriverRunner.stopWebDriver();
		return this;
	}
	
}
