package com.rstyle.screens;

import org.openqa.selenium.By;

import com.rstyle.struct.UserData;
import com.rstyle.utils.PropertiesReader;

public class LoginPageScreen extends BasicScreen {
	private static final String LOGIN_URL = PropertiesReader.getApplicationURL();			
	

	private String loginTextFieldXpath = "//*[@id='name']";
	private String passwordTextFieldXpath = "//*[@id='password']";
	private String submitButtonXpath = "//*[@class='ui-button-text']";

	
	
	
	public LoginPageScreen openLoginPageScreen() {
		driver.manage().deleteAllCookies();
		driver.get(LOGIN_URL);
		return this;

	}

	
	
	
	
	public BasicScreen login(UserData userData) {
		driver.findElement(By.xpath(loginTextFieldXpath)).sendKeys(userData.getUserName());
		driver.findElement(By.xpath(passwordTextFieldXpath)).sendKeys(
				userData.getUserPassword());
		driver.findElement(By.xpath(submitButtonXpath)).submit();

		if (isOnLoginPage()) {
			return new LoginPageScreen();
		} else {
			return new HomePageScreen();
		}

	}

	private boolean isOnLoginPage() {
		boolean isNotLogined = false;
		try {
			isNotLogined = LOGIN_URL.equals(getURL());
		} catch (Exception e) {

		}

		return isNotLogined;
	}

}
