package com.autotesting.framework;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.autotesting.screens.LoginPageScreen;

public class LoginPageTest {

	private static final String EXPECTED_TEXT_LOGIN_PAGE_HEADER = "Вход в систему";
	private static final String EXPECTED_LOGIN_LABEL = "Логин";
	private static final String EXPECTED_PASSWORD_LABEL = "Пароль";

	@Test(description = "Проверяем наличие основных элементов на странице логина.")
	public void elementsOnThePageTest() throws InterruptedException {

		LoginPageScreen loginPageScreen = new LoginPageScreen()
				.openLoginPageScreen();

		Assert.assertNotEquals(loginPageScreen.getHeaderText(), null,
				"Element login header not found");
		Assert.assertNotEquals(loginPageScreen.getLoginText(), null,
				"Element Login not found");
		Assert.assertNotEquals(loginPageScreen.getPasswordText(), null,
				"Element password not found");
		Assert.assertNotEquals(loginPageScreen.loginField, null,
				"Login field not found");
		Assert.assertNotEquals(loginPageScreen.passwordField, null,
				"Password field not found");
		Assert.assertNotEquals(loginPageScreen.loginButton, null,
				"Login Button not found");

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

	@Test(description = "Проверки на доступность полей ввода логина и пароля и кнопки Войти")
	public void checkFieldsAndLoginButtonEnable() throws InterruptedException {

		LoginPageScreen loginPageScreen = new LoginPageScreen()
				.openLoginPageScreen();

		Assert.assertEquals(loginPageScreen.loginField.isEnabled(), true,
				"Field Login is disabled");
		Assert.assertEquals(loginPageScreen.passwordField.isEnabled(), true,
				"Field Password is disabled");
		Assert.assertEquals(loginPageScreen.loginButton.isEnabled(), true,
				"Button is disabled");

		loginPageScreen.closeBrowser();
	}

}
