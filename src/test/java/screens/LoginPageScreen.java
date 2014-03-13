package screens;

import org.openqa.selenium.WebDriver;

import utils.WebDriverRunner;

import com.autotesting.framework.BaseScreen;

public class LoginPageScreen extends BaseScreen {
	private static final String LOGIN_PAGE_HEADER = "//span[@id='ui-dialog-title-dialog']";
	private static final String LOGIN = "//input[@id='name']";
	private static final String PASSWORD = "//input[@id='password']";
	private static final String BUTTON_ENTER = "//button[@value='Войти']";
	private static final String ERROR_FIND = "//div[@class='error']";
	private static final String TEXT_LOGIN_INCORRECT = "koty";
	private static final String TEXT_PASSWORD = "all";
	private static final String TEXT_LOGIN = "all";
	private static final String TEXT_PASSWORD_INCORRECT = "koty";
	private static final String LINK_ENTER_LOGIN = "//span[@class='ui-menuitem-text'][.='Выход']";

	public WebDriver driver = WebDriverRunner.getDriver();

	// входим на страницу логина
	public LoginPageScreen openLoginPageScreen() {
		// driver.get("http://10.0.12.78/contingent/");
		driver.get("http://185.26.52.130:7808/contingent/");
		return this;
	}

	// проверяем наличие заголовка на странице
	public String getHederText() {
		String result = getTextFromElementByXpath(LOGIN_PAGE_HEADER);
		return result;
	}

	// ввод некорректного логина
	public LoginPageScreen enterInvolidLogin() {
		enterByXpath(LOGIN, TEXT_LOGIN_INCORRECT); // вводим некорректный логин
		return this;
	}

	// ввод корректного логина
	public LoginPageScreen enterLogin() {
		enterByXpath(LOGIN, TEXT_LOGIN); // вводим некорректный логин
		return this;
	}

	// ввод корректного пароля
	public LoginPageScreen enterPassword() {
		enterByXpath(PASSWORD, TEXT_PASSWORD);// корректный пароль
		return this;
	}

	// ввод некорректного пароля
	public LoginPageScreen enterIncorrectPassword() {
		enterByXpath(PASSWORD, TEXT_PASSWORD_INCORRECT);// корректный пароль
		return this;
	}

	// нажатие кнопки Войти
	public LoginPageScreen klickEnter() {
		clickByXpath(BUTTON_ENTER);// добавляем просто локатор, с учетом того,
									// что уже ранее написали метод
		return this;
	}

	// проверяем наличие ошибки на форме логина (должна быть, при неверном вводе
	// параметров)
	public String readErrorText() {
		String result = getTextFromElementByXpath(ERROR_FIND);
		return result;
	}

	// проверка успешного логина
	public LoginPageScreen findLoginElement() {
		findByXpath(LINK_ENTER_LOGIN);
		return this;
	}

}
