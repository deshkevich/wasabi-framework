package main;

 
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.WebDriverRunner;

public class BaseScreens {

	protected static final Logger log = Logger.getLogger(WebDriverRunner.class);
	protected WebDriver driver = WebDriverRunner.getDriver();
		
	 public BaseScreens closeBrowser() {
	 	log.debug("Закрываем браузер.");
	 	WebDriverRunner.stopWebDriver();
	 	return this;
	 	}
}
