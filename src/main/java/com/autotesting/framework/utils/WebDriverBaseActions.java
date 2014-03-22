package com.autotesting.framework.utils;

import org.openqa.selenium.By;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.autotesting.framework.screens.BaseScreen;

public class WebDriverBaseActions {
	
	public static final int TIMEOUT_WAIT = 3;
	protected static final Logger log = Logger.getLogger(WebDriverBaseActions.class);
	//private static WebDriver driver;
	//ПРОЯСНИТЬ КАК ВСЕ-ТАКИ ЗДЕСЬ СДЕЛАТЬ КРАСИВО. ЧТО БЫ СОЗДАВАЛСЯ ЛЮБОЙ ДРАЙВЕР!!!!
	//создавать конструктор для объекта драйвер
	
	public void clickByXpath (String xpath) {
	    log.debug("[ACTION]: Click element by xpath: '" + xpath + "'");
	    waitForElementVisible (xpath, TIMEOUT_WAIT);
		//click(driver.findElement(By.xpath(xpath))); - не работает. просит описание метода click
	    BaseScreen.driver.findElement(By.xpath(xpath)).click();
	    log.debug("[ACTION]: Clicked on element by xpath: '" + xpath + "'");
	}
	
	public void setField (String xpathField,String valueField){
		log.debug("[ACTION]: Set in field by xpath: '" + xpathField + " value " + valueField);
		BaseScreen.driver.findElement(By.xpath(xpathField)).sendKeys(valueField);
		log.debug("[ACTION]: Seted in field by xpath: '" + xpathField + " value " + valueField);
	}
	
	public void waitForElementVisible (String locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(BaseScreen.driver, timeout);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));		
	}

}
