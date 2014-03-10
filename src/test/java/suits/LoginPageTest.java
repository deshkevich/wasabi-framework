package suits;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.LoginPageScreen;

public class LoginPageTest {

	private static final String EXPECTED_TEXT_LOGIN_PAGE_HEADER = "Вход в систему";
	private static final String ERROR_MESSAGE = "Указан неверный логин или пароль. Попробуйте ещё раз.";


	@Test(description = "Проверяем наличие основных элементов на странице логина.")
	public void simpleTest() throws InterruptedException {
		LoginPageScreen loginPageScreen = new LoginPageScreen().openLoginPageScreen();
		Assert.assertEquals(loginPageScreen.getHederText(), EXPECTED_TEXT_LOGIN_PAGE_HEADER, "Текст заголовка страницы логина"
				+ " не соответствует ожидаемому.");
	}

	@Test(description = "Попытка войти в систему с неверным логином", dependsOnMethods = {"simpleTest"})
	public void LoginIncorrect() {
		LoginPageScreen loginPageScreen = new LoginPageScreen().enterInvolidLogin().enterPassword().klickEnter();	
		Assert.assertEquals(loginPageScreen.readErrorText(), ERROR_MESSAGE, "Тест на неверный логин не пройден");
		loginPageScreen.closeBrowser();
	}
}