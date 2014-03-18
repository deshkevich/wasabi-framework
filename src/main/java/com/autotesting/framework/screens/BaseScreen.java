package com.autotesting.framework.screens;

import org.apache.log4j.Logger;
import com.autotesting.framework.utils.WebDriverRunner;
import com.autotesting.framework.utils.WebDriverWrapper;

public class BaseScreen {

	protected static final Logger log = Logger.getLogger(WebDriverRunner.class);
	WebDriverWrapper driverWrapper = new WebDriverWrapper();
	
	public BaseScreen closeBrowser() {
		log.debug("Закрываем браузер.");
		WebDriverRunner.stopWebDriver();
		return this;
	}

}
