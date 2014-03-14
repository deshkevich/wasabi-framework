package com.rstyle.screens;

import org.openqa.selenium.By;
import com.rstyle.struct.UserData;
import com.rstyle.utils.ConfigProperties;

public class LoginPageScreen extends BasicScreen {
	private static final String LOGIN_URL = ConfigProperties
			.getProperty("application.url");
	private static final String LOGIN_PAGE_HEADER = "Вход в систему";

	// xpath source for LoginPage in "By" way;

	private By loginTextFieldBy = By.xpath("//*[@id='name']");
	private By passwordTextFieldBy = By.xpath("//*[@id='password']");
	private By submitButtonBy = By.xpath("//*[@class='ui-button-text']");

	public LoginPageScreen() {
		loginPageHeaderXpath = "//*[@id='ui-dialog-title-dialog']";
	}

	public LoginPageScreen openLoginPageScreen() {
		driver.manage().deleteAllCookies();
		driver.get(LOGIN_URL);
		return this;

	}

	/**
	 * @return Page Header text
	 */

	public BasicScreen login(UserData userData) {
		driver.findElement(loginTextFieldBy).sendKeys(userData.getUserName());
		driver.findElement(passwordTextFieldBy).sendKeys(
				userData.getUserPassword());
		driver.findElement(submitButtonBy).submit();

		if (isOnLoginPage()) {
			return new LoginPageScreen();
		} else {
			return new HomePageScreen();
		}

	}

	private boolean isOnLoginPage() {
		boolean isNotLogined = false;
		try {
			isNotLogined = LOGIN_PAGE_HEADER.equals(getHeaderText());
		} catch (Exception e) {

		}

		return isNotLogined;
	}

}
