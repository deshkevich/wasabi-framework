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
	private static final String PATH_TO_CHROMEDRIVER = "resource//chromedriver";
	private static final String LOGIN_PAGE_HEADER_ID = "ui-dialog-title-dialog";
	private static final String EXPECTED_TEXT_LOGIN_PAGE_HEADER = "Вход в систему";

	@BeforeClass
	public static void createAndStartService() throws IOException {
		service = new ChromeDriverService.Builder().usingChromeDriverExecutable(new File(PATH_TO_CHROMEDRIVER)).usingAnyFreePort().build();
		service.start();
		driver = new ChromeDriver(service);
	}

	@Test
	public void simpleTest() throws InterruptedException {
		driver.get("http://185.26.52.130:7808/contingent/");
		Assert.assertEquals(driver.findElement(By.id(LOGIN_PAGE_HEADER_ID)).getText(), EXPECTED_TEXT_LOGIN_PAGE_HEADER);
	}

	@AfterClass
	public static void createAndStopService() {
		driver.quit();
		service.stop();
	}
//for commit
}
