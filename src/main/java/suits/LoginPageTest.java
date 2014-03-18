package suits;
 
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
//import org.testng.annotations.Test;
//import org.apache.log4j.Logger;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;

//import utils.WebDriverRunner;
import screen.BaseScreen;
import screen.HomePage;
import screen.LoginPageScreen;
 
 @Test
public class LoginPageTest {
 
	 public void checkFieldsAndLoginButtonEquels() throws InterruptedException {
		 AssertJUnit.assertEquals(LoginPageScreen.loginFieldIsEnabled(), 
				 "Field Login is disabled");
				AssertJUnit.assertEquals(LoginPageScreen.passwordFieldIsEnabled(),
						true,
				"Field Password is disabled");
				AssertJUnit.assertEquals(LoginPageScreen.enterButtonIsEnabled(), 
				 true,
				"Button is disabled");

BaseScreen.closeBrowser();
	 }
	 
	 public void checkFieldsAndLoginButtonEnable() throws InterruptedException {
	AssertJUnit.assertEquals(LoginPageScreen.loginFieldIsEnabled(), 
	true,
	"Field Login is disabled");
	AssertJUnit.assertEquals(LoginPageScreen.passwordFieldIsEnabled(
	), true,
	"Field Password is disabled");
	AssertJUnit.assertEquals(LoginPageScreen.enterButtonIsEnabled(), 
	true,
		"Button is disabled");

		BaseScreen.closeBrowser();
}
	

@Test(description = "Корректный логин")
public void correctLogin() throws InterruptedException {
	LoginPageScreen loginPageScreen = new LoginPageScreen()
	 .openLoginPageScreen();

		HomePage homePage = loginPageScreen.correctLogin();
		Assert.assertEquals(homePage.logoIsDisplayed(), true,
				"Логотипа нет, логин неуспешен");

BaseScreen.closeBrowser();
}
}