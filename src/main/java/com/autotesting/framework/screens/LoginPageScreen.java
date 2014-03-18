package com.autotesting.framework.screens;


import org.openqa.selenium.By;
import org.apache.log4j.Logger;


import com.autotesting.framework.utils.WebDriverBaseActions;

public class LoginPageScreen extends BaseScreen {
	private WebDriverBaseActions action = new WebDriverBaseActions();
	protected static final Logger log = Logger.getLogger(LoginPageScreen.class);
	private static final String LOGIN_PAGE_HEADER_ID = "ui-dialog-title-dialog";
	private static final String LOGIN_FIELD = "//input[@id='name']";
	private static final String PASSWORD_FIELD = "//input[@id='password']";
	private static final String BUTTON_LOGIN = "//button[@value='Войти']";
	private static final String ERROR_MESSAGE = "//div[@class='error']";

	public LoginPageScreen openLoginPageScreen() {
		driver.get("http://10.0.12.78/contingent/");
		return this;
	}
	
	public LoginPageScreen setLogin(String login) {
		action.setField(LOGIN_FIELD, login);
		return this;
	}
	
	public LoginPageScreen setPassword(String password) {
		action.setField(PASSWORD_FIELD, password);
		return this;
	}
	
    public LoginPageScreen pressButtonLogin () {
    	action.clickByXpath(BUTTON_LOGIN);
    	return this;
    }
    
    public LoginPageScreen loginAction (String login, String password) {
    	setLogin(login).setPassword(password).pressButtonLogin();
    	return this;
    }
    
    public String getErrorText() {
    	String result = driver.findElement(By.xpath(ERROR_MESSAGE)).getText();
    	return result;
    }
	
	public String getHeaderText() {
		String result = driver.findElement(By.id(LOGIN_PAGE_HEADER_ID)).getText();
		return result;
	}
	
	public boolean ButtonIsPresent(){
		return driver.findElement(By.xpath(BUTTON_LOGIN)).isDisplayed();
	}

}