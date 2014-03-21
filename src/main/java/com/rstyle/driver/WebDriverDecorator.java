package com.rstyle.driver;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rstyle.utils.PropertiesReader;

public class WebDriverDecorator implements WebDriver {
	RemoteWebDriver innerDriver = null;

	public WebDriverDecorator(RemoteWebDriver remoteDriver) {
		innerDriver = remoteDriver;
	}

	public static final int TIMEOUT_FOR_ACTION_SECONDS = Integer
			.parseInt(PropertiesReader.getTimeoutWaitForElement());

	
	public void clickByXpath(String xpath) {
		waitForElementPresentAndVisible(xpath, TIMEOUT_FOR_ACTION_SECONDS);
		innerDriver.findElement(By.xpath(xpath)).click();
	}

	public void waitForElementPresentAndVisible(String locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(this, timeout);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(locator)));
	}

	@Override
	public void get(String url) {
		innerDriver.get(url);
	}

	@Override
	public String getCurrentUrl() {
		return innerDriver.getCurrentUrl();
	}

	@Override
	public String getTitle() {
		return innerDriver.getTitle();
	}

	@Override
	public List<WebElement> findElements(By by) {
		return innerDriver.findElements(by);
	}

	@Override
	public WebElement findElement(By by) {
		return innerDriver.findElement(by);
	}

	@Override
	public String getPageSource() {
		return innerDriver.getPageSource();
	}

	@Override
	public void close() {
		innerDriver.close();
	}

	@Override
	public void quit() {
		innerDriver.quit();

	}

	@Override
	public Set<String> getWindowHandles() {
		return innerDriver.getWindowHandles();
	}

	@Override
	public String getWindowHandle() {
		return innerDriver.getWindowHandle();
	}

	@Override
	public TargetLocator switchTo() {
		return innerDriver.switchTo();
	}

	@Override
	public Navigation navigate() {
		return innerDriver.navigate();
	}

	@Override
	public Options manage() {
		return innerDriver.manage();
	}

}
