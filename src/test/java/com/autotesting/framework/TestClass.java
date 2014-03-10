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
	private static final String OSHIBKA_LOGINA = "Указан неверный логин или пароль. Попробуйте ещё раз.";

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
	
	@Test (dependsOnMethods = {"simpleTest"})//попытка отправить пустую форму
	public void PustayaForma() {
		driver.findElement(By.xpath("//button[@value='Войти']")).click();//нажимаем кнопку Войти
		Assert.assertEquals(driver.findElement(By.className("error")).getText(), OSHIBKA_LOGINA, "Тест на пустую форму не пройден");
	}
	
	@Test (dependsOnMethods = {"simpleTest"})//вход с некорректным логином
	public void LoginNekorrect() {
		driver.findElement(By.id("name")).sendKeys("koty"); //вводим некорректный логин
		driver.findElement(By.id("password")).sendKeys("all"); //корректный пароль
		driver.findElement(By.xpath("//button[@value='Войти']")).click();//нажимаем кнопку Войти
		Assert.assertEquals(driver.findElement(By.className("error")).getText(), OSHIBKA_LOGINA, "Тест на неверный логин не пройден");
	}
	
	@Test (dependsOnMethods = {"simpleTest"})//вход с некорректным паролем
	public void ParolNekorrect() {
		driver.findElement(By.id("name")).sendKeys("all"); //вводим корректный логин
		driver.findElement(By.id("password")).sendKeys("koty"); //некорректный пароль
		driver.findElement(By.xpath("//button[@value='Войти']")).click();//нажимаем кнопку Войти
		Assert.assertEquals(driver.findElement(By.className("error")).getText(), OSHIBKA_LOGINA, "Тест на неверный пароль не пройден");
	}
	
	@Test (dependsOnMethods = {"simpleTest", "LoginNekorrect", "ParolNekorrect", "PustayaForma"})//вход в систему
	public void VhodKorrect() {
		driver.findElement(By.id("name")).sendKeys("all"); //вводим корректный логин
		driver.findElement(By.id("password")).sendKeys("all"); //вводим корректный пароль
		driver.findElement(By.xpath("//button[@value='Войти']")).click();//нажимаем кнопку Войти
		driver.findElement(By.xpath("//span[@class='ui-menuitem-text'][.='Выход']"));//проверяем залогинились
	}
		
	@AfterClass
	public static void createAndStopService() {
		driver.quit();
		service.stop();
	}
}
