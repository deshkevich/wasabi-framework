package com.rstyle.driver;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;






public class WebDriverRunner extends RemoteWebDriver{
	public enum Browser {CHROME, FIREFOX}; 
	private static Logger logger = LoggerFactory.getLogger(WebDriverRunner.class);
	private static WebDriver driver = null; 
	
	private static ChromeDriverService service;
	private static final String PATH_TO_CHROMEDRIVER = "src//main//resources//chromedriver.exe";

	
	public WebDriverRunner(){
			
		initChromeDriver();		
		setSettings();
		
	}
	
	private static void initChromeDriver(){
	
		try {
			service = new ChromeDriverService.Builder()
					.usingChromeDriverExecutable(new File(PATH_TO_CHROMEDRIVER))
					.usingAnyFreePort().build();
			service.start();
			driver = new ChromeDriver(service);		
			
		} catch (Exception e) {
			logger.error("Ошибка создания сущности драйвера", e);
		}
	}
	
	
	private void setSettings(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	
	public static WebDriver getDriver(){
		if(driver == null){
			initChromeDriver();
		}
		
		return driver;
	}
	
	
	public static void createAndStopService() {
		
		driver.quit();	
		service.stop();
	}
	
}
