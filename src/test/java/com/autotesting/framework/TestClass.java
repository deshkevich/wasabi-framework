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
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class TestClass {
	private static ChromeDriverService service;
	private static WebDriver driver;
	private static final String PATH_TO_CHROMEDRIVER = "resource//chromedriver.exe";
	private static final String LOGIN_PAGE_HEADER_ID = "ui-dialog-title-dialog";
	private static final String EXPECTED_TEXT_LOGIN_PAGE_HEADER = "Вход в систему";
	private static final String EXPECTED_TEXT_SUCCESS_LOGIN = "admin [all]";
	private static final String EXPECTED_LOGIN_ERROR = "Указан неверный логин или пароль. Попробуйте ещё раз.";
	private static final String URL = "http://185.26.52.130:7808/contingent/";
	

	@BeforeClass
	public static void createAndStartService() throws IOException {
		service = new ChromeDriverService.Builder().usingChromeDriverExecutable(new File(PATH_TO_CHROMEDRIVER)).usingAnyFreePort().build();
		service.start();
		driver = new ChromeDriver(service);
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
	
	@Test
	public void simpleTest() throws InterruptedException {
		driver.get(URL);
		Assert.assertEquals(driver.findElement(By.id(LOGIN_PAGE_HEADER_ID)).getText(), EXPECTED_TEXT_LOGIN_PAGE_HEADER);
	}
	
	//из-за не работающей аннотации приходится использовать кривые зависимости. и первыми гнать тесты на неверные логины
	//тест на верный логин и что смогли залогиниться
	@Test (dependsOnMethods = {"testIncorrectLogin", "testIncorrectPassword"})
	public void testLogin() {
		driver.get(URL);
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("all"); //поле логина
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("all"); //поле пароля
		driver.findElement(By.xpath("//form[@id='form']//button[@value='Войти']")).click(); //кнопка
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='top-username']")).getText(), EXPECTED_TEXT_SUCCESS_LOGIN, "НЕ ВОШЛИ");
	}
	
	//простой тест вобще кнопка есть или нет. ибо если нет - нет смысла в остальных тестах
	@Test
	public void testButton () {
		if (driver.findElement(By.xpath("//form[@id='form']//button[@value='Войти']")).isDisplayed()==false) {
			Assert.fail("BUTTON IS NOT DISPLAYED");
		}
	}
	
	//тест на неверный логин
		@Test (dependsOnMethods = {"simpleTest","testButton"})
		public void testIncorrectLogin() {
			driver.findElement(By.xpath("//input[@id='name']")).sendKeys("alldd"); //поле логина
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("all"); //поле пароля
			driver.findElement(By.xpath("//form[@id='form']//button[@value='Войти']")).click();
			Assert.assertEquals(driver.findElement(By.xpath("//div[@class='error']")).getText(), EXPECTED_LOGIN_ERROR, "LOG IN WITH WRONG NAME - WE CAN LOG IN!!!");
		}
		
		@Test (dependsOnMethods = {"simpleTest","testButton"})
		public void testIncorrectPassword() {
			driver.findElement(By.xpath("//input[@id='name']")).sendKeys("all"); //поле логина
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("alldd"); //поле пароля
			driver.findElement(By.xpath("//form[@id='form']//button[@value='Войти']")).click();
			Assert.assertEquals(driver.findElement(By.xpath("//div[@class='error']")).getText(), EXPECTED_LOGIN_ERROR, "LOG IN WITH WRONG PASSWORD - WE CAN LOG IN!!!");
		}
		
		//тест с пустым паролем но верным логином
		@Test (dependsOnMethods = {"simpleTest","testButton"})
		public void testEmptyPassword() {
			driver.findElement(By.xpath("//input[@id='name']")).sendKeys("all"); //поле логина
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(""); //поле пароля
			driver.findElement(By.xpath("//form[@id='form']//button[@value='Войти']")).click();
			Assert.assertEquals(driver.findElement(By.xpath("//div[@class='error']")).getText(), EXPECTED_LOGIN_ERROR, "LOG IN WITHOUT PASSWORD - WE CAN LOG IN!!!");
		}
		
		//тест с пустым логином но верным паролем
		@Test (dependsOnMethods = {"simpleTest","testButton"})
		public void testEmptyLogin() {
			driver.findElement(By.xpath("//input[@id='name']")).sendKeys(""); //поле логина
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("all"); //поле пароля
			driver.findElement(By.xpath("//form[@id='form']//button[@value='Войти']")).click();
			Assert.assertEquals(driver.findElement(By.xpath("//div[@class='error']")).getText(), EXPECTED_LOGIN_ERROR, "LOG IN WITHOUT PASSWORD - WE CAN LOG IN!!!");
		}

	@AfterClass
	public static void createAndStopService() {
		driver.quit();
		service.stop();
	}
}
