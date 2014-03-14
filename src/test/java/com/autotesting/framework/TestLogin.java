package com.autotesting.framework;


import org.testng.annotations.Test;

import com.rstyle.screens.BasicScreen;
import com.rstyle.screens.LoginPageScreen;
import com.rstyle.struct.LoginData;
import com.rstyle.struct.UserData;


public class TestLogin extends BasicTest {
	LoginPageScreen loginPage = new LoginPageScreen();

	private static final String EXPECTED_TEXT_LOGIN_PAGE_HEADER = "Вход в систему";
	private static final String EXPECTED_TEXT_SUCCESS_LOGIN = "Автоматизированная информационная система";

	@Test(enabled = true)
	public void isHeaderTextCorrect() {
		loginPage.openLoginPageScreen();
		assertEquals(loginPage.getHeaderText(), EXPECTED_TEXT_LOGIN_PAGE_HEADER);
	}

	@Test(dataProvider = "loginTestData", dataProviderClass = LoginData.class, enabled = true)
	public void loginTest(UserData userData, boolean mustBeLogin) {

		loginPage.openLoginPageScreen();
		BasicScreen homePage = loginPage.login(userData);
		
		if (!mustBeLogin) {
			assertEquals(homePage.getHeaderText(),
					EXPECTED_TEXT_LOGIN_PAGE_HEADER);
		} else {
			assertEquals(homePage.getHeaderText(),
					EXPECTED_TEXT_SUCCESS_LOGIN);
		}

	}
}
