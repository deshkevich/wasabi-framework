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
	 private static final String EXPECTED_TEXT_LOGIN_PAGE_BUTTON = "Войти"; 
	 
	 @BeforeClass 
	 public static void createAndStartService() throws IOException { 
	 service = new ChromeDriverService.Builder() 
	 .usingChromeDriverExecutable(new File(PATH_TO_CHROMEDRIVER)) 
	 .usingAnyFreePort() 
	 .build(); 
	 service.start(); 
	 driver = new ChromeDriver(service); 
	 } 
	 
	 @Test 
	 public void simpleTest() throws InterruptedException { 
	 driver.get("http://10.0.12.78/contingent/"); 
	 Assert.assertEquals(driver.findElement(By.id(LOGIN_PAGE_HEADER_ID)).getText(), 
	 EXPECTED_TEXT_LOGIN_PAGE_HEADER); 
	 
	 Assert.assertEquals(driver.findElement(By.className("ui-button-text")).getText(),EXPECTED_TEXT_LOGIN_PAGE_BUTTON);
	 Assert.assertEquals(driver.findElement(By.className("ui-outputlabel")).getText(),"Логин");
	 Assert.assertEquals(driver.findElement(By.xpath("//*[@id='password']//preceding-sibling::*")).getText(),"Пароль");
	 Assert.assertEquals(driver.getTitle(),"АИС «Зачисление в Профтех» Вход в систему");
	 Assert.assertEquals(driver.findElement(By.className("error")).getText(),"");	
	  
	 } 
	 
	 @Test
	 public void workButton() {
			 
		 driver.get("http://10.0.12.78/contingent/");
		 driver.findElement(By.className("ui-button-text")).click();
		 Assert.assertEquals(driver.findElement(By.className("error")).getText(),"Указан неверный логин или пароль. Попробуйте ещё раз.");
		 
	 }
	 
	 
	 
	 @AfterClass 
	 public static void createAndStopService() { 
	 driver.quit(); 
	 service.stop(); 
	 } 
	} 

	


