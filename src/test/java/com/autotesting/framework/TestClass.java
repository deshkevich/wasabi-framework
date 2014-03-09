package com.autotesting.framework;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestClass {
	private static ChromeDriverService service;
	private static WebDriver driver;

	private static final String PATH_TO_CHROMEDRIVER = "resource//chromedriver.exe";
	private static final String LOGIN_PAGE_HEADER_ID = "ui-dialog-title-dialog";
	private static final String EXPECTED_TEXT_LOGIN_PAGE_HEADER = "Вход в систему";
	private static final String LOGIN_LABEL = "//label[@class='ui-outputlabel' and contains(., 'Логин')]";
	private static final String EXPECTED_LOGIN_LABEL = "Логин";
	private static final String PASSWORD_LABEL = "//label[@class='ui-outputlabel' and contains(., 'Пароль')]";
	private static final String EXPECTED_PASSWORD_LABEL = "Пароль";
	private static final String LOGIN_INPUT_ID = "name";
	private static final String PASSWORD_INPUT_ID = "password";
	private static final String BUTTON_VALUE = "//button[@value='Войти']";

	@BeforeClass
	public static void createAndStartService() throws IOException {
		service = new ChromeDriverService.Builder()
				.usingChromeDriverExecutable(new File(PATH_TO_CHROMEDRIVER))
				.usingAnyFreePort().build();
		service.start();
		driver = new ChromeDriver(service);
	}

	@Test
	public void simpleTest() throws InterruptedException {
		driver.get("http://185.26.52.130:7808/contingent/");
		// Проверка на наличие элементов на странице
		Assert.assertNotEquals(driver.findElement(By.id(LOGIN_PAGE_HEADER_ID)),
				null, "Element with" + LOGIN_PAGE_HEADER_ID + "not found");
		Assert.assertNotEquals(driver.findElement(By.xpath(LOGIN_LABEL)), null,
				"Element with" + LOGIN_LABEL + "not found");
		Assert.assertNotEquals(driver.findElement(By.xpath(PASSWORD_LABEL)),
				null, "Element with" + PASSWORD_LABEL + "not found");
		Assert.assertNotEquals(driver.findElement(By.id(LOGIN_INPUT_ID)), null,
				"Element with" + LOGIN_INPUT_ID + "not found");
		Assert.assertNotEquals(driver.findElement(By.id(PASSWORD_INPUT_ID)),
				null, "Element with" + PASSWORD_INPUT_ID + "not found");
		Assert.assertNotEquals(driver.findElement(By.xpath(BUTTON_VALUE)),
				null, "Element with" + BUTTON_VALUE + "not found");

		// проверки на соответствие ожидаемых элементов и фактических
		Assert.assertEquals(driver.findElement(By.id(LOGIN_PAGE_HEADER_ID))
				.getText(), EXPECTED_TEXT_LOGIN_PAGE_HEADER,
				"Error in the element" + EXPECTED_TEXT_LOGIN_PAGE_HEADER);
		Assert.assertEquals(
				driver.findElement(By.xpath(LOGIN_LABEL)).getText(),
				EXPECTED_LOGIN_LABEL, "Error in the element"
						+ EXPECTED_LOGIN_LABEL);
		Assert.assertEquals(driver.findElement(By.xpath(PASSWORD_LABEL))
				.getText(), EXPECTED_PASSWORD_LABEL, "Error in the element"
				+ EXPECTED_PASSWORD_LABEL);

		// проверки на доступность полей ввода логина и пароля
		Assert.assertEquals(driver.findElement(By.id(LOGIN_INPUT_ID))
				.isEnabled(), true, "Field Login is disabled");
		Assert.assertEquals(driver.findElement(By.id(PASSWORD_INPUT_ID))
				.isEnabled(), true, "Field Password is disabled");

		// проверка на доступность кнопки
		Assert.assertEquals(
				driver.findElement(By.xpath(BUTTON_VALUE)).isEnabled(), true,
				"Button is disabled");

	}

	@AfterClass
	public static void createAndStopService() {
		driver.quit();
		service.stop();
	}
}
