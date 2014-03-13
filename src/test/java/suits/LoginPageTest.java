package suits;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import screens.LoginPageScreen;
import utils.WebDriverRunner;

public class LoginPageTest {

	private static final String EXPECTED_TEXT_LOGIN_PAGE_HEADER = "Вход в систему";
	private static final String ERROR_MESSAGE = "Указан неверный логин или пароль. Попробуйте ещё раз.";
	
	@Test(description = "Проверяем наличие основных элементов на странице логина.")
	public void simpleTest() throws InterruptedException {
		LoginPageScreen loginPageScreen = new LoginPageScreen()
				.openLoginPageScreen();
		Assert.assertEquals(loginPageScreen.getHederText(),
				EXPECTED_TEXT_LOGIN_PAGE_HEADER,
				"Текст заголовка страницы логина"
						+ " не соответствует ожидаемому.");
	}

	@Test(description = "Попытка войти в систему с неверным логином", dependsOnMethods = { "simpleTest" })
	public void LoginIncorrect() {
		LoginPageScreen loginPageScreen = new LoginPageScreen()
				.enterInvolidLogin().enterPassword().klickEnter();
		Assert.assertEquals(loginPageScreen.readErrorText(), ERROR_MESSAGE,
				"Тест на неверный логин не пройден");
	}

	@Test(description = "Попытка войти в систему с неверным паролем", dependsOnMethods = { "simpleTest" })
	public void PasswordIncorrect() {
		LoginPageScreen loginPageScreen = new LoginPageScreen().enterLogin()
				.enterIncorrectPassword().klickEnter();
		Assert.assertEquals(loginPageScreen.readErrorText(), ERROR_MESSAGE,
				"Тест на неверный пароль не пройден");
	}

	@Test(description = "Попытка отправки пустой формы", dependsOnMethods = { "simpleTest" })
	public void EmptyForm() {
		LoginPageScreen loginPageScreen = new LoginPageScreen().klickEnter();
		Assert.assertEquals(loginPageScreen.readErrorText(), ERROR_MESSAGE,
				"Тест на отправку пустой формы не пройден");
	}

	@Test(description = "Залогиниться с верными параметрами", dependsOnMethods = {
			"simpleTest", "EmptyForm", "PasswordIncorrect", "LoginIncorrect" })
	public void CorrectLogin() {
		new LoginPageScreen().enterLogin().enterPassword().klickEnter()
				.findLoginElement();
	}
	
	@AfterSuite
	public void closeBrowser() {
		WebDriverRunner.stopWebDriver();
	}

}