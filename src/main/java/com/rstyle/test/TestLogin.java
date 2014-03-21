package com.rstyle.test;

import org.testng.annotations.Test;

import com.rstyle.driver.WebDriverRunner;
import com.rstyle.driver.WebDriverDecorator;
import com.rstyle.screens.BasicScreen;
import com.rstyle.screens.HomePageScreen;
import com.rstyle.screens.LoginPageScreen;
import com.rstyle.struct.UserData;
import com.rstyle.testdata.LoginData;
import com.rstyle.utils.Photographer;

public class TestLogin extends BasicTest {
	private LoginPageScreen loginPage = new LoginPageScreen();
	
	
	
	@Test
	public void testNewFunctionsOfDriver(){
		WebDriverDecorator driver  = WebDriverRunner.getDriver();
		driver.get("http://google.com");
		Photographer.doScreenshot("hello!");
//		driver.clickByXpath();
	}
	
	
	
	@Test(dataProvider = "loginTestData", dataProviderClass = LoginData.class, enabled = false)
	public void loginTest(UserData userData, boolean mustBeLogin) {

		loginPage.openLoginPageScreen();
		BasicScreen pageAfterAttemptToLogin = loginPage.login(userData);

		if (mustBeLogin) {
			assertTrue(
					pageAfterAttemptToLogin.getClass() == HomePageScreen.class,
					"Must be login with data [" + userData.getUserName()
							+ "]/[" + userData.getUserPassword() + "]. But not logined.");
		} else {
			assertTrue(pageAfterAttemptToLogin.getClass() == LoginPageScreen.class,
					"Must not be login with data [" + userData.getUserName()
					+ "]/[" + userData.getUserPassword() + "]. But logined.");
		}

	}
}
