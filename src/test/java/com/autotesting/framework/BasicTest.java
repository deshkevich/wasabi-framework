package com.autotesting.framework;



import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.rstyle.driver.WebDriverRunner;

public class BasicTest extends Assert {

	
	
	@BeforeTest
	public void dosmth(){		
		
	}
	
	
	@AfterTest
	public void stop(){
		WebDriverRunner.createAndStopService();
	}
	
}
