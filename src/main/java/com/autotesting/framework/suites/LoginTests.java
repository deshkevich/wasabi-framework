package com.autotesting.framework.suites;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.autotesting.framework.screens.LoginPageScreen;

public class LoginTests {

	private static final String EXPECTED_TEXT_LOGIN_PAGE_HEADER = "Вход в систему";

	private static final String EXPECTED_LOGIN_LABEL = "Логин";

	private static final String EXPECTED_PASSWORD_LABEL = "Пароль";

	@Test(description = "Проверяем наличие основных элементов на странице логина.")
	public void elementsOnThePageTest() throws InterruptedException {

		LoginPageScreen loginPageScreen = new LoginPageScreen()
				.openLoginPageScreen();

		Assert.assertNotEquals(loginPageScreen.getHeaderText(), null,
				"Хедер страницы не найден");
		Assert.assertNotEquals(loginPageScreen.getLoginText(), null,
				"Логин не найден");
		Assert.assertNotEquals(loginPageScreen.getPasswordText(), null,
				"Название Пароль не найдено");
		Assert.assertNotEquals(loginPageScreen.loginFieldIsDisplayed(), true,
				"Поле Логин не найдено");
		Assert.assertNotEquals(loginPageScreen.passwordFieldIsDisplayed(),
				true, "Поле Пароль не найдено");
		Assert.assertNotEquals(loginPageScreen.enterButtonIsDisplayed(), true,
				"Кнопка Войти не найдена");

		loginPageScreen.closeBrowser();
	}

	@Test(description = "Проверяем соответствие ожидаемых элементов и фактических")
	public void comparingActualAndExpectedElements()
			throws InterruptedException {

		LoginPageScreen loginPageScreen = new LoginPageScreen()
				.openLoginPageScreen();

		Assert.assertEquals(loginPageScreen.getHeaderText(),
				EXPECTED_TEXT_LOGIN_PAGE_HEADER,
				"Текст заголовка страницы логина не соответствует ожидаемому.");
		Assert.assertEquals(loginPageScreen.getLoginText(),
				EXPECTED_LOGIN_LABEL,
				"Название поля логина не соответствует ожидаемому.");
		Assert.assertEquals(loginPageScreen.getPasswordText(),
				EXPECTED_PASSWORD_LABEL,
				"Название поля пароля не соответствует ожидаемому.");

		loginPageScreen.closeBrowser();
	}
}
