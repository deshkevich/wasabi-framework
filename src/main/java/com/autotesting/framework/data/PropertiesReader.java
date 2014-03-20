package com.autotesting.framework.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Savepoint;
import java.util.Properties;

public class PropertiesReader {
	
	private static PropertiesReader instance;
	private static Properties properties;
	private static String PATH_TO_PROPERTIES_FILE = "configuration.properties";
	public static synchronized PropertiesReader getInstance() throws Exception { 
	return (instance != null) ? instance : new PropertiesReader();
	} 
	PropertiesReader() throws FileNotFoundException, IOException {
	synchronized (PropertiesReader.class) { 
	if (instance != null) { 
	throw new IllegalStateException(); 
	}
	properties = new Properties();
	properties.load(new FileInputStream(new File(PATH_TO_PROPERTIES_FILE)));
	}
	
	}
	public static String getHost(){
	return properties.getProperty("host");
	} 
	
	public static String getLogin(){
		return properties.getProperty("login");
		} 
	
	public static String getPassword(){
		return properties.getProperty("password");
		} 
	
	
	
	
	
}
