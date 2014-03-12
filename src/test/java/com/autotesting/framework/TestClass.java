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
	private static final String LOGIN_LABEL = ".//*[@id='form']/table/tbody/tr[1]/td/label";
	private static final String EXPECTED_LOGIN_LABEL = "Логин";
	private static final String PASSWORD_LABEL = ".//*[@id='form']/table/tbody/tr[2]/td/label";
	private static final String EXPECTED_PASSWORD_LABEL = "Пароль";
	private static final String LOGIN_VVOD_ID = "name";
	private static final String PASSWORD_VVOD_ID = "password";

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
		driver.get("http://10.0.12.78/contingent/");
		Assert.assertEquals(driver.findElement(By.id(LOGIN_PAGE_HEADER_ID))
				.getText(), EXPECTED_TEXT_LOGIN_PAGE_HEADER);
		Assert.assertEquals(
				driver.findElement(By.xpath(LOGIN_LABEL)).getText(),
				EXPECTED_LOGIN_LABEL);
		Assert.assertEquals(driver.findElement(By.xpath(PASSWORD_LABEL))
				.getText(), EXPECTED_PASSWORD_LABEL);
		Assert.assertEquals(driver.findElement(By.id(LOGIN_VVOD_ID))
				.isEnabled(), true);
		Assert.assertEquals(driver.findElement(By.id(PASSWORD_VVOD_ID))
				.isEnabled(), true);

	}

	@AfterClass
	public static void createAndStopService() {
		driver.quit();
		service.stop();
	}
}
