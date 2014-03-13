
package com.autotesting.autotesting;
 
 	
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
 	// private static final String LOGIN_PAGE_HEADER_ID = "ui-dialog-title-dialog"; 
 	// private static final String EXPECTED_TEXT_LOGIN_PAGE_HEADER = "Вход в систему"; 
 	// private static final String EXPECTED_TEXT_LOGIN_PAGE_BUTTON = "Войти";
	//private static final String EXPECTED_TEXT_SUCCESS_LOGIN = null;
	private static final String EXPECTED_LOGIN_ERROR = null; 
 	 
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
 	 		public void testIncorrectL() {
 	 			driver.get("http://10.0.12.78/contingent/");
 	 			driver.findElement(By.xpath("//input[@id='name']")).sendKeys("allll"); 
 	 			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("all");
 	 			driver.findElement(By.xpath("//form[@id='form']//button[@value='Войти']")).click();
 	 			Assert.assertEquals(driver.findElement(By.xpath("//div[@class='error']")).getText(), EXPECTED_LOGIN_ERROR, "LOG IN WITH WRONG NAME - WE CAN LOG IN!!!");
 	 		}
 	 		
 	 		@Test
 	 		public void testIncorrectP() {
 	 			driver.get("http://10.0.12.78/contingent/");
 	 			driver.findElement(By.xpath("//input[@id='name']")).sendKeys("all"); 
 	 			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("allll"); 
 	 			driver.findElement(By.xpath("//form[@id='form']//button[@value='Войти']")).click();
 	 			Assert.assertEquals(driver.findElement(By.xpath("//div[@class='error']")).getText(), EXPECTED_LOGIN_ERROR, "LOG IN WITH WRONG PASSWORD - WE CAN LOG IN!!!");
 	 		}
 	 		
 	 		
 	 		@Test 
 	 		public void testEmptyP() {
 	 			driver.get("http://10.0.12.78/contingent/");
 	 			driver.findElement(By.xpath("//input[@id='name']")).sendKeys("all"); //поле логина
 	 			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(""); //поле пароля
 	 			driver.findElement(By.xpath("//form[@id='form']//button[@value='Войти']")).click();
 	 			Assert.assertEquals(driver.findElement(By.xpath("//div[@class='error']")).getText(), EXPECTED_LOGIN_ERROR, "LOG IN WITHOUT PASSWORD - WE CAN LOG IN!!!");
 	 		}
 	 
 	 
 	 		@Test 
 	 		public void testEmptyL() {
 	 			driver.get("http://10.0.12.78/contingent/");
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
