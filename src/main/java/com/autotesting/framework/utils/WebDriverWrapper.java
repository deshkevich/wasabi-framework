package com.autotesting.framework.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverWrapper {

	public static final int TIMEOUT_FOR_ACTION_SECONDS = 3;

	protected static WebDriverRunner driverRunner;

	protected static final Logger log = Logger
			.getLogger(WebDriverWrapper.class);

	protected WebDriver driver;

	public WebDriverWrapper() {
		driver = getDriver();
	}

	public static WebDriver getDriver() {
		return WebDriverRunner.getDriver();
	}

	public static void stopWebDriver() {
		WebDriverRunner.stopWebDriver();
	}

	public void clickByXpath(String xpath) {
		log.debug("[ACTION]: Click element by xpath: '" + xpath + "'");
		waitForElementPresentAndVisible(xpath, TIMEOUT_FOR_ACTION_SECONDS);
		getElement(xpath).click();
	}

	public void waitForElementPresentAndVisible(String locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(locator)));
	}

	public boolean elementIsEnabled(String xpath) {
		WebElement e = getElement(xpath);
		log.debug("[ACTION]: Check element is Enabled by xpath: '" + xpath
				+ "'");
		return e.isEnabled();
	}

	public boolean elementIsDisplayed(String xpath) {
		WebElement e = getElement(xpath);
		log.debug("[ACTION]: Check element is Displayed by xpath: '" + xpath
				+ "'");
		return e.isDisplayed();
	}

	public String getElementText(String xpath) {
		WebElement e = getElement(xpath);
		String result = e.getText();
		log.debug("[ACTION]: Get element text by xpath: '" + xpath + "'");
		return result;
	}

	public void openScreen(String url) {
		log.info(String.format(
				"Открываем в браузере страницу логина по адресу %s", url));
		driver.get(url);
	}

	public WebElement getElement(String xpath) {
		log.info(String.format("Получаем элемент", xpath));
		return driver.findElement(By.xpath(xpath));
	}

	public void sendKeysToField(String xpath, String text) {
		log.info(String.format("Получаем текст для ввода в поле", text));
		getElement(xpath).sendKeys(text);
	}

}
