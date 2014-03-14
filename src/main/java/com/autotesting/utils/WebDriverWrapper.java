package com.autotesting.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverWrapper extends RemoteWebDriver {

	public static final int TIMEOUT_FOR_ACTION_SECONDS = 3;
	private static final Logger log = Logger.getLogger(WebDriverRunner.class);
	private static WebDriver driver;

	public void clickByXpath(String xpath) {
		log.debug("[ACTION]: Click element by xpath: '" + xpath + "'");
		waitForElementPresentAndVisible(xpath, TIMEOUT_FOR_ACTION_SECONDS);
		driver.findElement(By.xpath(xpath)).click();
	}

	public void waitForElementPresentAndVisible(String locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(this, timeout);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(locator)));
	}

	public boolean elementIsEnable(String xpath) {
		log.debug("[ACTION]: Check element is Enabled by xpath: '" + xpath
				+ "'");
		WebElement e = driver.findElement(By.xpath(xpath));
		e.isEnabled();
		return e.isEnabled();
	}

	public boolean elementIsDisplayed(String xpath) {
		log.debug("[ACTION]: Check element is Displayed by xpath: '" + xpath
				+ "'");
		WebElement e = driver.findElement(By.xpath(xpath));
		e.isDisplayed();
		return e.isDisplayed();
	}
}
