package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
	
	private static PropertiesReader instance;
	private static Properties properties;
	private static String PATH_TO_PROPERTIES_FILE = "resource//configuration.properties";
	
	public static synchronized PropertiesReader getInstance() {   
	      return (instance != null) ? instance : new PropertiesReader();
	   }  
	
	private PropertiesReader(){
	    synchronized (PropertiesReader.class) {  
	    	if (instance != null) {  
	        	throw new IllegalStateException();  
	    	}
	    	properties = new Properties();
	    	try {
				properties.load(new FileInputStream(new File(PATH_TO_PROPERTIES_FILE)));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
	}
	    
	public String getBaseUrl(){
		return properties.getProperty("baseUrl");
	}
	
	public String getCorrectLogin(){
		return properties.getProperty("loginCorrect");
	}  
	
	public String getCorrectPassword(){
		return properties.getProperty("passwordCorrect");
	}  
	
	public String getIncorrectLogin(){
		return properties.getProperty("loginIncorrect");
	}  
	
	public String getIncorrectPassword(){
		return properties.getProperty("passwordIncorrect");
	}  
}
