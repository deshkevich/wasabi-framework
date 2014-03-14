package com.rstyle.utils;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

public class ConfigProperties {
	private static Properties PROPERTIES;
	
	
	
	
	static{
		PROPERTIES = new Properties();
		
		try{
		PROPERTIES.load(new FileInputStream(new File("resource//config.properties")));
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	
	public static String getProperty(String key){
		return PROPERTIES.getProperty(key);
	}
}
