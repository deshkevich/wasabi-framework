package com.autotesting.framework.screens;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.autotesting.framework.service.WebDriverWrapper;
import com.autotesting.framework.utils.WebDriverRunner;

public class LoginPageScreen extends BaseScreen {
    
	private final String LOGIN_PAGE_HEADER_ID = "//*[@id='ui-dialog-title-dialog']";
	private final String LOGIN_PAGE_URL = "http://10.0.12.78/contingent/";
	private final String XPATH_TEXT_ERROR_LOG_LOGIN_PAGE = "//*[@id='form']/div[1]";
	private final String XPATH_LOGIN = "//*[@id='name']";
	private final String TEXT_LOGIN = "all"; 
	private final String XPATH_PASSWORD = "//*[@id='password']";
	private final String TEXT_PASSWORD = "all";
	private final String XPATH_BUTTON = "//*[@id='form']//button";
//	private final String
//	private final String
	
	private WebElement login;
	//private WebDriverRapper wrapper = new WebDriverRapper();
	//private WebElement password;
	//private WebElement buttonEnter;
	
public LoginPageScreen openLoginPageScreen() {
		log.info(String.format("Открываем в браузере страницу логина по адресу %s", LOGIN_PAGE_URL));
		
		wrapper.getPage(LOGIN_PAGE_URL);
		//driver.get(LOGIN_PAGE_URL);
		//getDriver().get("http://10.0.12.78/contingent/");
		return this;		
	}
	
	public String getHeaderText() {
		log.info(String.format("Получаем значение текста из хедера страницы логина по id = '%s'", LOGIN_PAGE_HEADER_ID));
		//String result = driver.findElement(By.id(LOGIN_PAGE_HEADER_ID)).getText();
		String result = wrapper.getTextByXpath(LOGIN_PAGE_HEADER_ID);
		log.info(String.format("Результат => '%s'", result));
		return result;
	}   
        
	public HomePageScreen successLogIn() {
		// TODO Auto-generated method stub
		 
		// Assert.assertEquals(driver.findElement(By.className("ui-outputlabel")).getText(),"Логин");
		// Assert.assertEquals(driver.findElement(By.xpath("//*[@id='password']//preceding-sibling::*")).getText(),"Пароль");
			
		//driver.findElement(By.className("ui-outputlabel")).clear();
		//driver.findElement(By.className("ui-outputlabel")).sendKeys(textLogin);
				//wrapper.clickByXpath("//*[@id='name']");
		
		wrapper.typeByXpath(XPATH_LOGIN, TEXT_LOGIN);
		//driver.findElement(By.xpath("//*[@id='name']")).sendKeys("all");
		wrapper.typeByXpath(XPATH_PASSWORD, TEXT_PASSWORD);
		//driver.findElement(By.xpath("//*[@id='password']")).sendKeys("all");
		
		wrapper.clickByXpath(XPATH_BUTTON);
		//wrapper.clickByXpath("//*[@id='form']//button");
//    		driver.findElement(By.xpath("//*[@id='form']//button")).click();
		 
		//login.sendKeys("all");
		//password.sendKeys("all");
	    		
		return new HomePageScreen();
	}
    
	
	public String emptyFields() { 
		// TODO Auto-generated method stub
		
		wrapper.clickByXpath(XPATH_BUTTON);
		//wrapper.getTextByXpath("");		
				
		String result = wrapper.getTextByXpath(XPATH_TEXT_ERROR_LOG_LOGIN_PAGE);
		return result;
		
		//return result;
	}   
    
	 
	
	



}
