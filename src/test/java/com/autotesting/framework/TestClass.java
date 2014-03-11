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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.autotesting.framework.login.LoginData;
import com.autotesting.framework.login.UserData;

public class TestClass {
	private static ChromeDriverService service;
	private static WebDriver driver;
	private static final String PATH_TO_CHROMEDRIVER = "resource//chromedriver.exe";
	private static final String LOGIN_PAGE_HEADER_ID = "ui-dialog-title-dialog";
	private static final String EXPECTED_TEXT_LOGIN_PAGE_HEADER = "Вход в систему";
	private static final String EXPECTED_TEXT_SUCCESS_LOGIN = "Автоматизированная информационная система";
	private static final String LOGIN_URL = "http://10.0.12.78/contingent/";
	
	private By loginTextFieldBy = By.xpath("//*[@id='name']");
	private By passwordTextFieldBy = By.xpath("//*[@id='password']");
	private By submitButtonBy = By.xpath("//*[@class='ui-button-text']");
	
	@BeforeClass
	public static void createAndStartService() throws IOException {
		service = new ChromeDriverService.Builder().usingChromeDriverExecutable(new File(PATH_TO_CHROMEDRIVER)).usingAnyFreePort().build();
		service.start();
		driver = new ChromeDriver(service);
	}

	@Test
	public void simpleTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.get(LOGIN_URL);
		Assert.assertEquals(driver.findElement(By.id(LOGIN_PAGE_HEADER_ID)).getText(), EXPECTED_TEXT_LOGIN_PAGE_HEADER);
	}

		
	
	@Test(dataProvider="loginTestData",dataProviderClass = LoginData.class)
	public void loginTest(UserData userData, boolean mustBeLogin){
		driver.manage().deleteAllCookies();
		driver.get(LOGIN_URL);
		driver.findElement(loginTextFieldBy).sendKeys(userData.getUserName());
		driver.findElement(passwordTextFieldBy).sendKeys(userData.getUserPassword());
		driver.findElement(submitButtonBy).submit();
		
		
		
		if(!mustBeLogin){
			Assert.assertEquals(driver.findElement(By.id(LOGIN_PAGE_HEADER_ID)).getText(), EXPECTED_TEXT_LOGIN_PAGE_HEADER);
		} else {	
			Assert.assertEquals(driver.findElement(By.xpath("//*[@id='form:j_idt103']//a[@class='ui-menuitem-link ui-corner-all link']/span")).getText(), EXPECTED_TEXT_SUCCESS_LOGIN);						
		}
		
		
		
		

		
		
	}
	
	
	@AfterClass
	public static void createAndStopService() {
		driver.quit();
		service.stop();
	}
}
