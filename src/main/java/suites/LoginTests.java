package suites;



import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import screens.BaseScreen;
import screens.LoginPageScreen;
import screens.StartPage;


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
	
	@Test (dependsOnMethods = {"testLoginIncorrectPassword","testLoginIncorrectLogin","testLoginEmptyPassword","testLoginEmptyLogin"})
	public void testLoginAsAdmin() {
		//здесь можно дергать один метод, с этими строками. метод сам будет создан на уровне скрина класса
		loginPage.loginAction("all", "all");
		Assert.assertEquals(startPage.getUserLocatorText(), EXPECTED_TEXT_SUCCESS_LOGIN, "НЕ ВОШЛИ");
	}
	
	@Test (dependsOnMethods = {"simpleTest","testButton"})
	public void testLoginIncorrectPassword() {
		loginPage.loginAction("all", "al1");
		Assert.assertEquals(loginPage.getErrorText(), EXPECTED_LOGIN_ERROR, "ТЕСТ С НЕВЕРНЫМ ПАРОЛЕМ - СМОГЛИ ВОЙТИ В СИСТЕМУ! ОШИБКА!");
	}
	
	@Test (dependsOnMethods = {"simpleTest","testButton"})
	public void testLoginIncorrectLogin() {
		loginPage.loginAction("all1", "all");
		Assert.assertEquals(loginPage.getErrorText(), EXPECTED_LOGIN_ERROR, "ТЕСТ С НЕВЕРНЫМ ЛОГИНОМ - СМОГЛИ ВОЙТИ В СИСТЕМУ! ОШИБКА!");
	}
	
	@Test (dependsOnMethods = {"simpleTest","testButton"})
	public void testLoginEmptyLogin() {
		loginPage.loginAction("", "all");
		Assert.assertEquals(loginPage.getErrorText(), EXPECTED_LOGIN_ERROR, "ТЕСТ С ПУСТЫМ ЛОГИНОМ - СМОГЛИ ВОЙТИ В СИСТЕМУ! ОШИБКА!");
	}
	
	@Test (dependsOnMethods = {"simpleTest","testButton"})
	public void testLoginEmptyPassword() {
		loginPage.loginAction("all", "");
		Assert.assertEquals(loginPage.getErrorText(), EXPECTED_LOGIN_ERROR, "ТЕСТ С ПУСТЫМ ПАРОЛЕМ - СМОГЛИ ВОЙТИ В СИСТЕМУ! ОШИБКА!");
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
