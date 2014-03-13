package utils;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class WebDriverRunner {

	private static final Logger log = Logger.getLogger(WebDriverRunner.class);
	private static WebDriver driver;
	private static final String PATH_TO_CHROMEDRIVER = "resource//chromedriver.exe";

	public static WebDriver getDriver() {
		if(driver == null) {
				System.setProperty("webdriver.chrome.driver", PATH_TO_CHROMEDRIVER);
				driver = new ChromeDriver();
		}
		return driver;
	}

	public static void stopWebDriver() {
		log.info("Закрываем браузер");
		driver.quit();
	}


}