package com.autotesting.framework.utils;

import java.io.File;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class WebDriverRunner {
	
	private static final Logger log = Logger.getLogger(WebDriverRunner.class);
	private static WebDriverWrapper driver;
	private static ChromeDriverService service;
	
	private static final String PATH_TO_CHROMEDRIVER = "resource//chromedriver.exe";
	
	WebDriverRunner() {
		try {
			service = new ChromeDriverService.Builder().usingChromeDriverExecutable(new File(PATH_TO_CHROMEDRIVER)).usingAnyFreePort().build();
			service.start();
			driver = new WebDriverWrapper(service);
		} catch (Exception e) {
			log.error("Error while creating Web Driver", e);
		}
	}
	
	public static WebDriverWrapper getDriver() {
		if(driver == null) {
			new WebDriverRunner();
		}
		return driver;
	}
	
	public static void stopWebDriver() {
		driver.quit();
		service.stop();
	}
	

}
