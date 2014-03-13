package Screens;

import main.BaseScreens;

import org.openqa.selenium.By;

public class LoginPageScreens extends BaseScreens {
	
	private final String LOGIN_PAGE_HEADER_ID = "ui-dialog-title-dialog";
	private final String LOGIN_PAGE_URL = "http://10.0.12.78/contingent/";
	
	public LoginPageScreens openLoginPageSkreen(){
		log.info(String.format("Открываем в браузере страницу логина по адресу %s", LOGIN_PAGE_URL));
		driver.get(LOGIN_PAGE_URL);
		return this;
	}
	public String getHeaderText(){
		log.info(String.format("Получаем значение текста из хедера страницы логина по id = '%s'", LOGIN_PAGE_HEADER_ID));
		String result = driver.findElement(By.id(LOGIN_PAGE_HEADER_ID)).getText();
		log.info(String.format("Результат => '%s'", result));
		return result;
}
}
