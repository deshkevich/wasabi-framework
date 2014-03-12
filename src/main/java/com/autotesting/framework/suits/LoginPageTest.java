package com.autotesting.framework.suits;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.autotesting.framework.screens.LoginPageScreen;

public class LoginPageTest {

	private static final String EXPECTED_TEXT_LOGIN_PAGE_HEADER = "Вход в систему";

	@Test(description = "Проверяем наличие основных элементов на странице логина.")
	public void simpleTest() throws InterruptedException {
		LoginPageScreen loginPageScreen = new LoginPageScreen().openLoginPageScreen();
		Assert.assertEquals(loginPageScreen.getHeaderText(), EXPECTED_TEXT_LOGIN_PAGE_HEADER, "Текст заголовка страницы логина"
				+ " не соответствует ожидаемому.");
		loginPageScreen.closeBrowser();
	}

}
