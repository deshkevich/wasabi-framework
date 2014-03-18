package com.autotesting.framework.suites;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.autotesting.framework.screens.HomePage;
import com.autotesting.framework.screens.LoginPageScreen;

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
		Assert.assertNotEquals(loginPageScreen.loginFieldIsDisplayed(), true,
				"Login field not found");
		Assert.assertNotEquals(loginPageScreen.passwordFieldIsDisplayed(),
				true, "Password field not found");
		Assert.assertNotEquals(loginPageScreen.enterButtonIsDisplayed(), true,
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

		Assert.assertEquals(loginPageScreen.loginFieldIsEnabled(), true,
				"Field Login is disabled");
		Assert.assertEquals(loginPageScreen.passwordFieldIsEnabled(), true,
				"Field Password is disabled");
		Assert.assertEquals(loginPageScreen.enterButtonIsEnabled(), true,
				"Button is disabled");

		loginPageScreen.closeBrowser();
	}

	@Test(description = "Корректный логин")
	public void correctLogin() throws InterruptedException {

		LoginPageScreen loginPageScreen = new LoginPageScreen()
				.openLoginPageScreen();

		HomePage homePage = loginPageScreen.correctLogin();

		/**
		 * поскольку запретили заходить на профтех, то делаю проверку успешного
		 * логина по отобразившемуся лого, т.к. это единственный xpath, который
		 * у меня есть на текущий момент с HomePage
		 */
		Assert.assertEquals(homePage.logoIsDisplayed(), true,
				"Логотипа нет, логин неуспешен");

		loginPageScreen.closeBrowser();
	}

}
