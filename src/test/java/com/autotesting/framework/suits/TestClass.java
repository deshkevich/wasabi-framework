package com.autotesting.framework.suits;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.autotesting.framework.screens.LoginPageScreens;

public class TestClass {

	private static final String EXPECTED_TEXT_LOGIN_PAGE_HEADER = "Вход в систему";

	private static final String LABLE = "Логин";

	private static final String POLE = "Пароль";

	@Test(description = "Проверяем наличие основных элементов на странице логина.")
	public void simpleTest() throws InterruptedException {
		LoginPageScreens loginPageScreen = new LoginPageScreens()
				.openLoginPageSkreen();

		Assert.assertEquals(loginPageScreen.getHeaderText(),
				EXPECTED_TEXT_LOGIN_PAGE_HEADER,
				"Текст заголовка страницы логина"
						+ " не соответствует ожидаемому.");

		Assert.assertEquals(loginPageScreen.getLoginText(), LABLE);
		Assert.assertEquals(loginPageScreen.getPasswordText(), POLE);

		Assert.assertEquals(loginPageScreen.loginLabelIsDisplayed(), true,
				"логин не отображается");
		Assert.assertEquals(loginPageScreen.passwordLabelIsDisplayed(), true,
				"пароль не отображается");
		loginPageScreen.closeBrowser();
	}

	// дальше сделать не смогла - забрали стенд

}