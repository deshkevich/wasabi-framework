package com.rstyle.utils;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.RemoteWebDriver;






public class WebDriverRunner extends RemoteWebDriver{
	public enum Browser {CHROME, FIREFOX}; 
	private static WebDriver driver = null; 
	
	private static ChromeDriverService service;
	private static final String PATH_TO_CHROMEDRIVER = "resource//chromedriver.exe";

	
	public WebDriverRunner(){
			
		initChromeDriver();		
		setSettings();
		
	}
//	
	private static void initChromeDriver(){
		try {
			service = new ChromeDriverService.Builder()
					.usingChromeDriverExecutable(new File(PATH_TO_CHROMEDRIVER))
					.usingAnyFreePort().build();
			service.start();
			driver = new ChromeDriver(service);		
			
		} catch (Exception e) {
//			log.error("Ошибка создания сущности драйвера", e);
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
