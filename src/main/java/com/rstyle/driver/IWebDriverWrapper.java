package com.rstyle.driver;

import org.openqa.selenium.WebDriver;

public interface IWebDriverWrapper extends WebDriver{

	public void clickByXpath(String xpath);
	public void waitForElementPresentAndVisible(String locator,int timeout);
	
	
	public void clickByListBox(String xpath, int index);
	
	
	public void clickByRadioButton(String xpathOfGroup, String labelToClick);
	
	
}
