package com.autotesting.framework.utils;
    
import java.io.File;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import com.autotesting.framework.data.PropertiesReader;
    
public class WebDriverRunner {
	
	private static final Logger log = Logger.getLogger(WebDriverRunner.class);
	private static WebDriver driver;
	private static ChromeDriverService service;
	
	private static final  String PATH_TO_CHROMEDRIVER = "src/main/resources//chromedriver.exe";
	
	
	WebDriverRunner() {
		try {
		
			service = new ChromeDriverService.Builder().usingChromeDriverExecutable(new File(PATH_TO_CHROMEDRIVER)).usingAnyFreePort().build();
			service.start();
			driver = new ChromeDriver(service);
		} catch (Exception e) {
			log.error("Error while creating Web Driver", e);
		}
		
		try {
			PropertiesReader.getInstance();
			}
			
			catch (Exception e) {
				
				
			}
	
	
	
	}
	
		
		
	public static WebDriver getDriver() {
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
