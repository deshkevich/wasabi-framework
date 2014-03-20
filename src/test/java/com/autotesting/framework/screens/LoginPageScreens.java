package com.autotesting.framework.screens;

import com.autotesting.framework.utils.PropertiesReader;

public class LoginPageScreens extends BaseScreens {

	private final String LOGIN_PAGE_HEADER_ID = "ui-dialog-title-dialog";
	private final String LOGIN_PAGE_URL = PropertiesReader.getHost();
	private static final String LOGIN_ID = ".//*[@id='form']/table/tbody/tr[1]/td/label";
	private static final String PAROL_ID = ".//*[@id='form']/table/tbody/tr[2]/td/label";

	public LoginPageScreens openLoginPageSkreen() {
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
		String result = driverWrapper.getElement(LOGIN_PAGE_HEADER_ID)
				.getText();
		log.info(String.format("Результат => '%s'", result));
		return result;
	}

	public String getLoginText() {
		return driverWrapper.getElementText(LOGIN_ID);
	}

	public String getPasswordText() {
		return driverWrapper.getElementText(PAROL_ID);
	}

	public boolean loginLabelIsDisplayed() {
		return driverWrapper.elementIsDisplayed(LOGIN_ID);
	}

	public boolean passwordLabelIsDisplayed() {
		return driverWrapper.elementIsDisplayed(PAROL_ID);
	}
}
