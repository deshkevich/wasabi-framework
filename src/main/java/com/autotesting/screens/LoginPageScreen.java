package com.autotesting.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageScreen extends BaseScreen {

	private final String LOGIN_PAGE_HEADER_ID = "ui-dialog-title-dialog";
	private final String LOGIN_PAGE_URL = "http://10.0.12.78/contingent/";
	// private final String LOGIN_PAGE_URL =
	// "http://185.26.52.130:7808/contingent/"
	private static final String LOGIN_INPUT_ID = "name";
	private static final String PASSWORD_INPUT_ID = "password";
	private static final String BUTTON_VALUE = "//button[@value='Войти']";
	private static final String LOGIN_LABEL = "//label[@class='ui-outputlabel' and contains(., 'Логин')]";
	private static final String PASSWORD_LABEL = "//label[@class='ui-outputlabel' and contains(., 'Пароль')]";

		
	@FindBy(how = How.ID, using = LOGIN_INPUT_ID)
	public WebElement loginField=null;

	
	
	@FindBy(how = How.ID, using = PASSWORD_INPUT_ID)
	public WebElement passwordField;

	@FindBy(how = How.XPATH, using = BUTTON_VALUE)
	public WebElement loginButton;

	public LoginPageScreen openLoginPageScreen() {
		log.info(String.format(
				"Открываем в браузере страницу логина по адресу %s",
				LOGIN_PAGE_URL));
		driver.get(LOGIN_PAGE_URL);
		return this;
	}

	public String getHeaderText() {
		log.info(String
				.format("Получаем значение текста из хедера страницы логина по id = '%s'",
						LOGIN_PAGE_HEADER_ID));
		String result = driver.findElement(By.id(LOGIN_PAGE_HEADER_ID))
				.getText();
		log.info(String.format("Результат => '%s'", result));
		return result;
	}

	public String getLoginText() {
		log.info(String.format(
				"Получаем значение текста из поля Логина логина по id = '%s'",
				LOGIN_LABEL));
		String result = driver.findElement(By.xpath(LOGIN_LABEL)).getText();
		log.info(String.format("Результат => '%s'", result));
		return result;
	}

	public String getPasswordText() {
		log.info(String.format(
				"Получаем значение текста из поля Пароля логина по id = '%s'",
				PASSWORD_LABEL));
		String result = driver.findElement(By.xpath(PASSWORD_LABEL)).getText();
		log.info(String.format("Результат => '%s'", result));
		return result;
	}

	public HomePage correctLogin() {
		loginField.sendKeys("all");
		passwordField.sendKeys("all");
		loginButton.click();
		return new HomePage();
	}
}