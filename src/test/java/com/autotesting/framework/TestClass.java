package com.autotesting.framework;


import org.testng.Assert;
import org.testng.annotations.Test;
import Screens.LoginPageScreens;

public class TestClass {s
	
	private static final String EXPECTED_TEXT_LOGIN_PAGE_HEADER = "Вход в систему";
	
	private static final String LOGIN_ID = ".//*[@id='form']/table/tbody/tr[1]/td/label";
	private static final String LABLE = "Логин";
	
	private static final String PAROL_ID = ".//*[@id='form']/table/tbody/tr[2]/td/label";
	private static final String POLE = "Пароль";
	
	
	

	@Test (description = "Проверяем наличие основных элементов на странице логина.")
	public void simpleTest() throws InterruptedException {
		LoginPTestClassPageScreen = new LoginPTestClassnLoginPageScreen();
		
		Assert.assertEquals(driver.findElement(By.id(LOGIN_PAGE_HEADER_ID)).getText(), EXPECTED_TEXT_LOGIN_PAGE_HEADER, "Текст заголовка страницы логина" + " не соответствует ожидаемому.");
		
		loginPageScreen.closeBrowser();
		Assert.assertEquals(driver.findElement(By.id(LOGIN_ID)).getText(), LABLE);
		Assert.assertEquals(driver.findElement(By.id(PAROL_ID)).getText(), POLE);
	}

	

}