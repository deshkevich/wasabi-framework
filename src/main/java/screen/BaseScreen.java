package screen;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.WebDriverRunner;
import utils.WebDriverWrapper;

public class BaseScreen {

	protected static final Logger log = Logger.getLogger(WebDriverRunner.class);
	WebDriver driver = WebDriverRunner.getDriver();
	WebDriverWrapper driverWrapper = new WebDriverWrapper();
	
	public static BaseScreen closeBrowser() {
		log.debug("Закрываем браузер.");
		WebDriverRunner.stopWebDriver();
		return this;
	}

}