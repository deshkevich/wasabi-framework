package com.autotesting.framework.screens;

public class LoginPageScreen extends BaseScreens {

	private final String LOGIN_PAGE_HEADER_ID = "ui-dialog-title-dialog";
	// private final String LOGIN_PAGE_URL = "http://10.0.12.78/contingent/";
	private final String LOGIN_PAGE_URL = "http://185.26.52.130:7808/contingent/";
	private static final String LOGIN_INPUT_ID = "//input[@id='name']";
	private static final String PASSWORD_INPUT_ID = "//input[@id='password']";
	private static final String BUTTON_VALUE = "//button[@value='Войти']";
	private static final String LOGIN_LABEL = "//label[@class='ui-outputlabel' and contains(., 'Логин')]";
	private static final String PASSWORD_LABEL = "//label[@class='ui-outputlabel' and contains(., 'Пароль')]";
	

	public LoginPageScreen openLoginPageScreen() {
		log.info(String.format(
				"Открываем в браузере страницу логина по адресу %s",
				LOGIN_PAGE_URL));
		driverWrapper.openScreen(LOGIN_PAGE_URL);
		return this;
	}

	public String getHeaderText() {
		log.info(String
				.format("Получаем значение текста из хедера страницы логина по id = '%s'",
						LOGIN_PAGE_HEADER_ID));
		String result = driverWrapper.getElementText(LOGIN_PAGE_HEADER_ID);
		log.info(String.format("Результат => '%s'", result));
		return result;
	}

	public String getLoginText() {
		String result = driverWrapper.getElementText(LOGIN_LABEL);
		log.info(String.format(
				"Получаем значение текста из поля Логина логина по id = '%s'",
				LOGIN_LABEL));
		log.info(String.format("Результат => '%s'", result));
		return result;
	}

	public String getPasswordText() {
		String result = driverWrapper.getElementText(PASSWORD_LABEL);
		log.info(String.format(
				"Получаем значение текста из поля Пароля логина по id = '%s'",
				PASSWORD_LABEL));
		log.info(String.format("Результат => '%s'", result));
		return result;
	}

	

	public boolean loginFieldIsDisplayed() {
		log.info(String.format("Получаем информацию о видимости поля Логина",
				LOGIN_INPUT_ID));
		return driverWrapper.elementIsDisplayed(LOGIN_INPUT_ID);
	}

	public boolean passwordFieldIsDisplayed() {
		log.info(String.format("Получаем информацию о видимости поля Пароля",
				PASSWORD_INPUT_ID));
		return driverWrapper.elementIsDisplayed(PASSWORD_INPUT_ID);
	}

	public boolean enterButtonIsDisplayed() {
		log.info(String.format("Получаем информацию о видимости кнопки Войти",
				BUTTON_VALUE));
		return driverWrapper.elementIsDisplayed(BUTTON_VALUE);
	}

}
