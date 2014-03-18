package com.autotesting.framework.screens;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

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

	
	private WebElement login;
	
	


	
	
	public LoginPageScreen openLoginPageScreen() {
		log.info(String.format("Открываем в браузере страницу логина по адресу %s", LOGIN_PAGE_URL));
		
		wrapper.getPage(LOGIN_PAGE_URL);
		
		return this;		
	}
	
	public String getHeaderText() {
		log.info(String.format("Получаем значение текста из хедера страницы логина по id = '%s'", LOGIN_PAGE_HEADER_ID));
		
		String result = wrapper.getTextByXpath(LOGIN_PAGE_HEADER_ID);
		log.info(String.format("Результат => '%s'", result));
		return result;
	}   
        
	public HomePageScreen successLogIn() {
		
		
		wrapper.typeByXpath(XPATH_LOGIN, TEXT_LOGIN);
		
		wrapper.typeByXpath(XPATH_PASSWORD, TEXT_PASSWORD);
		
		
		wrapper.clickByXpath(XPATH_BUTTON);
		
		
	    		
		return new HomePageScreen();
	}
    
	
	public String emptyFields() { 
		
		
		wrapper.clickByXpath(XPATH_BUTTON);
			
				
		String result = wrapper.getTextByXpath(XPATH_TEXT_ERROR_LOG_LOGIN_PAGE);
		return result;
		
		
	}   
    
	 
	
	



}
