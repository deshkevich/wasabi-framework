package com.rstyle.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;




import org.testng.log4testng.Logger;

import com.rstyle.driver.WebDriverRunner;

public abstract class BasicScreen {
	
	protected Logger logger = Logger.getLogger(this.getClass());
//	protected Logger resultsLog = Logger.getLogger("testResult." + this.getClass());
	
	protected static  WebDriver driver =  WebDriverRunner.getDriver();	
	protected String loginPageHeaderXpath = "";
	
	
	public String getHeaderText(){
		String result = null;		
		
		logger.info("Getting header text with xpath = ["+loginPageHeaderXpath+"]" + " from class " + this.toString() );		
		try {
			result = driver.findElement(By.xpath(loginPageHeaderXpath)).getText();
		} catch (Exception e) {		
			logger.error("Cannot get header Text = ["+loginPageHeaderXpath+"]");
		}
		
		
		return result;
	}
	
}
