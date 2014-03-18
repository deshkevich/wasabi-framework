package com.autotesting.framework.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWrapper extends ChromeDriver {

	public static final int TIMEOUT_FOR_ACTION_SECONDS = 3;
	protected static final Logger log = Logger.getLogger(WebDriverRunner.class);

	public WebDriverWrapper(ChromeDriverService service) {
		    super(service, DesiredCapabilities.chrome());
	}
	
	public void clickByXpath(String xpath) {
    	    log.debug("[ACTION]: Click element by xpath: '" + xpath + "'");
    	    waitForElementPresentAndVisible(xpath, TIMEOUT_FOR_ACTION_SECONDS);
    	    findElement(By.xpath(xpath)).click();
 	 }

 	public void waitForElementPresentAndVisible(String locator, int timeout) {
    	    WebDriverWait wait = new WebDriverWait(this, timeout);
    	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
  	}

}
