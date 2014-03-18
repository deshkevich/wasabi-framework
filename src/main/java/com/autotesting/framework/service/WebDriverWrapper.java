package com.autotesting.framework.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
    

import java.util.concurrent.TimeUnit;
    


import com.autotesting.framework.utils.WebDriverRunner;
    
	
public class WebDriverWrapper {
	
	private WebDriver driver = WebDriverRunner.getDriver();
	private static final Logger log = Logger.getLogger(WebDriverRunner.class);
	private static final int TIMEOUT_TO_WAIT_ELEMENT = 3; 
			
    public WebDriver getDriver() {
    	
    	return driver;
    }
	
	
	public void getPage(String url) {
    	
    	driver.get(url);
    }
	
       
    public String getTextByXpath(String xpath) {
    	
    	String result = driver.findElement(By.xpath(xpath)).getText();
    	return result;
    }                 
// Логирование на уровне дебага и ожидание для элементов реализовал на примере данного метода	
	public void clickByXpath(String xpath) {
	    log.debug("Логирование на уровне дебага: ожидание элемента для нажатия");		
		
	    waitForElementPresentAndVisible(xpath, TIMEOUT_TO_WAIT_ELEMENT);
        
	    driver.findElement(By.xpath(xpath)).click();
		
	}   
    
    
	public void typeByXpath(String xpath, String text) {
		
	driver.findElement(By.xpath(xpath)).sendKeys(text);
		
	}
	
	    
    public void waitForElementPresentAndVisible(String locator, int timeout) {
    
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        	
    	
    }	
     
    
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    