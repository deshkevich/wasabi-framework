package com.autotesting.framework.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertiesReader {
	protected static final Logger log = Logger
			.getLogger(WebDriverWrapper.class);
	private static final String CONFIG_FILE_PATH = "config.properties";
	private static Properties PROPERTIES;

	static {
		PROPERTIES = new Properties();

		try {
			PROPERTIES.load(new FileInputStream(new File(CONFIG_FILE_PATH)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getHost() {
		return PROPERTIES.getProperty("host");
	}

	public static String getLogin() {
		return PROPERTIES.getProperty("login");
	}

	public static String getPassword() {
		return PROPERTIES.getProperty("password");
	}
}
