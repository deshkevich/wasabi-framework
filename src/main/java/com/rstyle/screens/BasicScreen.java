package com.rstyle.screens;


import org.openqa.selenium.WebDriver;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rstyle.driver.WebDriverRunner;

public abstract class BasicScreen {
	
	private Logger logger = LoggerFactory.getLogger(BasicScreen.class);	
	protected static  WebDriver driver =  WebDriverRunner.getDriver();
	
		
	public String getURL(){		
		String url = driver.getCurrentUrl();
		logger.info("Get url of currentPage "+"["+url+"]");
		return url;
	}
	
}
