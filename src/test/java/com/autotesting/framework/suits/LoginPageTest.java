package com.autotesting.framework.suits;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.autotesting.framework.data.PropertiesReader;
import com.autotesting.framework.screens.HomePageScreen;
import com.autotesting.framework.screens.LoginPageScreen;
import com.autotesting.framework.utils.WebDriverRunner;

public class LoginPageTest {

	private static final String EXPECTED_TEXT_LOGIN_PAGE_HEADER = "Вход в систему";
	private static final String TEXT_ERROR_LOG_LOGIN_PAGE = "Указан неверный логин или пароль. Попробуйте ещё раз.";
	private static final String TITLE_HOME_PAGE = "АИС «Зачисление в Профтех»";
	
	
	private LoginPageScreen loginPageScreen;
	private HomePageScreen homePageScreen;
	
	@Test(description = "Проверяем наличие основных элементов на странице логина.")
	public void OpenLoginPageAndVerifyElement()  {
		
	
		loginPageScreen = new LoginPageScreen().openLoginPageScreen();
		
		
		
		Assert.assertEquals(loginPageScreen.getHeaderText(), EXPECTED_TEXT_LOGIN_PAGE_HEADER, "Текст заголовка страницы логина"
				+ " не соответствует ожидаемому.");
		
		
	}
     
	
	@Test(description = "Некорректное логирование без пароля ")
	public void tlogInWithEmptyFields() {
		
	
	Assert.assertEquals(loginPageScreen.emptyFields(), TEXT_ERROR_LOG_LOGIN_PAGE, "Текст сообщения о логировании при входе без логина и пароля");
	
	
	}
	
	@Test(description = "Успешное логирование под администратором ")
	public void workingsuccessLogInAsAdmin() {
		
		
		homePageScreen = loginPageScreen.successLogIn();
				
		Assert.assertEquals(homePageScreen.getTitleHomePage(), TITLE_HOME_PAGE, "Заголовок страницы HomePage не соответствует ожидаемому");
					
		
					
		}
	
		
		
	@AfterTest(description = "Закрытие браузера ")
	public void exitBrowser() {
		
        
		homePageScreen.closeBrowser();
	}
	 
	 	
	}
	
	
	

	

