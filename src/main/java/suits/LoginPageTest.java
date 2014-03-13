package suits;

import org.testng.Assert;
import org.testng.annotations.Test;

import screen.LoginPageScreen;

public class LoginPageTest {

	private static final String EXPECTED_TEXT_LOGIN_PAGE_HEADER = "Вход в систему";

	@Test(description = "Выполняется проверка наличия основных элементов на странице логина.")
	public void simpleTest() throws InterruptedException {
		LoginPageScreen loginPageScreen = new LoginPageScreen().openLoginPageScreen();
		Assert.assertEquals(loginPageScreen.getHeaderText(), EXPECTED_TEXT_LOGIN_PAGE_HEADER, "Текст заголовка страницы логина"
				+ " не соответствует ожидаемому 'Вход в систему'");
		loginPageScreen.closeBrowser();
	}

}
