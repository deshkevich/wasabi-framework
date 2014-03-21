package com.rstyle.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PropertiesReader {
	private static Logger  logger = LoggerFactory.getLogger(PropertiesReader.class);
	private static final String CONFIG_FILE_PATH="src//main//resources//config.properties";
	private static Properties PROPERTIES;
	
	
	static{
		PROPERTIES = new Properties();
		
		try{
		PROPERTIES.load(new FileInputStream(new File(CONFIG_FILE_PATH)));
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	
	
	public static String getSnapshootPath(){
		return getProperty("screenshot.path");
	}
	
	public static String getApplicationURL(){
		return getProperty("application.url");
	}
	
	public static String getLoginAdmin(){
		return getProperty("application.admin.login");
	}
	
	public static String getPasswordAdmin(){
		return getProperty("application.admin.password");
	}
	
	public static int getTimeoutWaitForElement(){
		return Integer.parseInt(getProperty("driver.options.timeoutWaitForAction"));
	}
	
	private static String getProperty(String key){		
		String propertyValue = PROPERTIES.getProperty(key); 
		logger.info("Getting a property with key ["+key+"] --> return value ["+propertyValue+"]");
		return propertyValue;
	}
	
	
	
	
}
