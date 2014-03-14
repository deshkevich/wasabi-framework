package com.autotesting.screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class HomePage extends BaseScreen {
	
	@FindBy(how = How.XPATH, using = LOGO_CLASS)
	public WebElement homePageLogo;

	private static final String LOGO_CLASS = "//a[@class='mosgerb']";
	
	
}
