package com.autotesting.framework.suites;



import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import com.autotesting.framework.screens.BaseScreen;
import com.autotesting.framework.screens.LoginPageScreen;
import com.autotesting.framework.screens.StartPage;
import com.autotesting.framework.utils.PropertiesReader;


public class LoginTests {
	private static final String EXPECTED_TEXT_LOGIN_PAGE_HEADER = "Вход в систему";
	private static final String EXPECTED_TEXT_SUCCESS_LOGIN = "admin [all]";
	private static final String EXPECTED_LOGIN_ERROR = "Указан неверный логин или пароль. Попробуйте ещё раз.";
	LoginPageScreen loginPage = new LoginPageScreen();
	StartPage startPage = new StartPage();
	BaseScreen baseScreen = new BaseScreen();
	//надо создавать объекты для каждой страницы которая будет использоваться в тесте

	@Test
	public void simpleTest() throws InterruptedException {
		loginPage.openLoginPageScreen().getHeaderText();
		Assert.assertEquals(loginPage.getHeaderText(), EXPECTED_TEXT_LOGIN_PAGE_HEADER);
	}
	
	@Test (dependsOnMethods = {"simpleTest"})
	public void testButton () {
		if (loginPage.ButtonIsPresent()==false) {
			Assert.fail("BUTTON IS NOT DISPLAYED");
		}
	}
	
	
	@Test (dependsOnMethods = {"simpleTest","testButton"})
	public void testLoginIncorrectPassword() {
		loginPage.loginAction(PropertiesReader.getProperty("username"), "all");
		Assert.assertEquals(loginPage.getErrorText(), EXPECTED_LOGIN_ERROR, "ТЕСТ С НЕВЕРНЫМ ПАРОЛЕМ - СМОГЛИ ВОЙТИ В СИСТЕМУ! ОШИБКА!");
	}
	
	@Test (dependsOnMethods = {"simpleTest","testButton"})
	public void testLoginIncorrectLogin() {
		loginPage.loginAction("all1", PropertiesReader.getProperty("password"));
		Assert.assertEquals(loginPage.getErrorText(), EXPECTED_LOGIN_ERROR, "ТЕСТ С НЕВЕРНЫМ ЛОГИНОМ - СМОГЛИ ВОЙТИ В СИСТЕМУ! ОШИБКА!");
	}
	
	@Test (dependsOnMethods = {"simpleTest","testButton"})
	public void testLoginEmptyLogin() {
		loginPage.loginAction("", PropertiesReader.getProperty("password"));
		Assert.assertEquals(loginPage.getErrorText(), EXPECTED_LOGIN_ERROR, "ТЕСТ С ПУСТЫМ ЛОГИНОМ - СМОГЛИ ВОЙТИ В СИСТЕМУ! ОШИБКА!");
	}
	
	@Test (dependsOnMethods = {"simpleTest","testButton"})
	public void testLoginEmptyPassword() {
		loginPage.loginAction(PropertiesReader.getProperty("username"), "");
		Assert.assertEquals(loginPage.getErrorText(), EXPECTED_LOGIN_ERROR, "ТЕСТ С ПУСТЫМ ПАРОЛЕМ - СМОГЛИ ВОЙТИ В СИСТЕМУ! ОШИБКА!");
	}
	
	@Test (dependsOnMethods = {"testLoginIncorrectPassword","testLoginIncorrectLogin","testLoginEmptyPassword","testLoginEmptyLogin"})
	public void testLoginAsAdmin() {
		//здесь можно дергать один метод, с этими строками. метод сам будет создан на уровне скрина класса
		loginPage.loginAction(PropertiesReader.getProperty("username"), PropertiesReader.getProperty("password"));
		Assert.assertEquals(startPage.getUserLocatorText(), EXPECTED_TEXT_SUCCESS_LOGIN, "НЕ ВОШЛИ КАК АДМИНИСТРАТОР");
	}
	
	@AfterClass	
	public void finishAllTests() {
		baseScreen.closeBrowser();
	}
	
	
	//не могу понять почему не работает данная аннотация. почему-то после первого теста нет сравнения
/*	@AfterTest 
	public static void logout() {
	System.out.println("@AfterTest");
		if (driver.findElement(By.xpath("//div[@id='form:j_idt103']//a[@href='/contingent/j_spring_security_logout']")).isDisplayed()==true){
			driver.findElement(By.xpath("//div[@id='form:j_idt103']//a[@href='/contingent/j_spring_security_logout']")).click();
			System.out.println("CLICKNULI");
		}
	} 
	*/
	
	//из-за не работающей аннотации приходится использовать кривые зависимости. и первыми гнать тесты на неверные логины
	//тест на верный логин и что смогли залогиниться	

}  
