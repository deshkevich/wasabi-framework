package screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WebDriverRunner;

public class LoginPageScreen {
	private static final String LOGIN_PAGE_HEADER_ID = "ui-dialog-title-dialog";
	private static final String LOGIN = "name";
	private static final String PASSWORD = "password";
	private static final String BUTTON_ENTER = "//button[@value='Войти']";
	private static final String ERROR_FIND = "error";
	private static final String TEXT_LOGIN_INCORRECT = "name";
	private static final String TEXT_PASSWORD = "password";
	
	public WebDriver driver = WebDriverRunner.getDriver();
	
	//входим на страницу логина
	public LoginPageScreen openLoginPageScreen() {
	driver.get("http://10.0.12.78/contingent/");
	//driver.get("http://185.26.52.130:7808/contingent/");
	return this;
	}
	
	//проверяем наличие заголовка на странице 
	public String getHederText() {
	String result = driver.findElement(By.id(LOGIN_PAGE_HEADER_ID)).getText();
	return result;
	}
	
	//ввод некорректного логина
	public LoginPageScreen enterInvolidLogin() {
		driver.findElement(By.id(LOGIN)).sendKeys(TEXT_LOGIN_INCORRECT); //вводим некорректный логин
		return this;
		}
	//ввод корректного пароля
		public LoginPageScreen enterPassword() {
			driver.findElement(By.id(PASSWORD)).sendKeys(TEXT_PASSWORD); //корректный пароль
			return this;
			}
	//нажатие кнопки Войти
			public LoginPageScreen klickEnter() {
			driver.findElement(By.xpath(BUTTON_ENTER)).click();//нажимаем кнопку Войти
			return this;
			}
	
	//проверяем наличие ошибки на форме логина (должна быть, при неверном вводе параметров)
	public String readErrorText() {
	String result = driver.findElement(By.className(ERROR_FIND)).getText();
	return result;
	}
	
	//закрываем браузер
	public LoginPageScreen closeBrowser() {
		WebDriverRunner.stopWebDriver();
		return this;
	}
}
