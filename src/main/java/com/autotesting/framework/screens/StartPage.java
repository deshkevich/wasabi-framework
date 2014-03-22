package com.autotesting.framework.screens;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.autotesting.framework.utils.WebDriverBaseActions;
import com.autotesting.framework.utils.WebDriverRunner;


public class StartPage extends BaseScreen {
	private static final String BUTTON_EXIT = "//span[text() = 'Выход']"; //кнопка выхода
	private static WebDriverBaseActions action = new WebDriverBaseActions();
	private static final String EXPECTED_TEXT_SUCCESS_LOGIN = "//div[@id='top-username']"; //определение какой юзер
	
	//определение под каким юзером зашли
	public String getUserLocatorText () {
		String result = driver.findElement(By.xpath(EXPECTED_TEXT_SUCCESS_LOGIN)).getText();
		return result;
	}
	
	public StartPage pressExit() {
		action.clickByXpath(BUTTON_EXIT);
		return this;
	}
}
