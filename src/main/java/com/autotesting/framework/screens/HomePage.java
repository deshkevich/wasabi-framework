package com.autotesting.framework.screens;

public class HomePage extends BaseScreen {

	private static final String LOGO_XPATH = "//a[@class='mosgerb']";

	public boolean isLogoDisplayed() {
		log.info(String.format("Получаем информацию о видимости лого",
				LOGO_XPATH));
		return driverWrapper.elementIsDisplayed(LOGO_XPATH);
	}

}
