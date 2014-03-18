package screen;
 
 public class HomePage extends BaseScreen {
 
 	private static final String LOGO_CLASS = "//a[@class='mosgerb']";
 
 	public boolean logoIsDisplayed() {
 		log.info(String.format("Получаем информацию о видимости лого",
 				LOGO_CLASS));
 		return driverWrapper.elementIsDisplayed(LOGO_CLASS);
 	}
 
 }