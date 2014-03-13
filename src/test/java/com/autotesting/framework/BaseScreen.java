package com.autotesting.framework;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.PropertiesReader;
import utils.WebDriverRunner;

public class BaseScreen {

	protected static final Logger log = Logger.getLogger(WebDriverRunner.class);
	protected WebDriver driver = WebDriverRunner.getDriver();
	protected final static PropertiesReader reader = PropertiesReader.getInstance();
	public static final int TIMEOUT_FOR_ACTION_SECONDS = 30; 

	//обертка вызова кнопки
	protected void clickByXpath(String xpath) {
	    log.debug("[ACTION]: Click element by xpath: '" + xpath + "'");
	    waitForElementPresentAndVisible(xpath, TIMEOUT_FOR_ACTION_SECONDS);
	    driver.findElement(By.xpath(xpath)).click();
	}
	//устанавливаем задержку
	public void waitForElementPresentAndVisible(String locator, int timeout) {
	    WebDriverWait wait = new WebDriverWait(driver, timeout);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}
	
	//обертка нахождения поля
	protected void findByXpath(String xpath) {
		 log.debug("[ACTION]: Click element by xpath: '" + xpath + "'");
		    waitForElementPresentAndVisible(xpath, TIMEOUT_FOR_ACTION_SECONDS);
		driver.findElement(By.xpath(xpath));
		
	}
	//обертка нахождения поля и ввода в нее текста
	protected void enterByXpath(String xpath, String text) {
		 log.debug("[ACTION]: Click element by xpath: '" + xpath + "'");
		    waitForElementPresentAndVisible(xpath, TIMEOUT_FOR_ACTION_SECONDS);
		driver.findElement(By.xpath(xpath)).sendKeys(text);
	}
	//обертка нахождения и возврата текста 
	protected String getTextFromElementByXpath(String xpath) {
		 log.debug("[ACTION]: Click element by xpath: '" + xpath + "'");
		    waitForElementPresentAndVisible(xpath, TIMEOUT_FOR_ACTION_SECONDS);
		    return driver.findElement(By.xpath(xpath)).getText();
	}
	
	

}