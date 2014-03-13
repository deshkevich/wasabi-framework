package suits;

import org.testng.Assert;
import org.testng.annotations.Test;

import screen.LoginPageScreen;


public class ErrorLoginTest {
	
	private static final String ERROR_MESSAGE = "Указан неверный логин или пароль. Попробуйте ещё раз.";
			
	@Test(description = "Попытка войти в систему с неверным логином", dependsOnMethods = {"simpleTest"})
	 	public void LoginNevern() {
	 		LoginPageScreen loginPageScreen = new LoginPageScreen().enterInvolidLogin().enterPassword().klickEnter();	
	 		Assert.assertEquals(loginPageScreen.readErrorText(), ERROR_MESSAGE, "Тест на неверный логин не пройден");
	 		loginPageScreen.closeBrowser();
	}

}

