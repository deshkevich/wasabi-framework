package com.autotesting.framework.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

//import org.apache.log4j.Logger;

public class PropertiesReader {
	//private static Logger logger = LoggerFactory.getLogger(PropertiesReader.class);
	private static final String CONFIG_FILE_PATH = "configuration.properties";
	private static Properties PROPERTIES;

	static {
		PROPERTIES = new Properties();

		try {
			PROPERTIES.load(new FileInputStream(new File(CONFIG_FILE_PATH)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// берет url
	// в файлу конфигов должно выглядеть
	// application.url=0.0.0.0
	public static String getApplicationURL() {
		return getProperty("application.url");
	}

	public static String getApplicationLogin() {
		return getProperty("username");
	}
	
	public static String getApplicationPassword() {
		return getProperty("password");
	}
	
	// берет конфиги по ключу
	public static String getProperty(String key) {
		String propertyValue = PROPERTIES.getProperty(key);
		return propertyValue;
	}

}
