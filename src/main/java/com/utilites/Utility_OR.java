package com.utilites;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.configfile.Constants;

public class Utility_OR {
	public static String getProperty(String key) {
		String value =null;
		//String path=System.getProperty("User.dir");
		//System.out.println(path);
		
		try {
			Constants.fis=new FileInputStream("D:/MavenScript/MavenFirstScript/src/main/resources/OR.properties");
			Constants.pro=new Properties();
			Constants.pro.load(Constants.fis);
			value=Constants.pro.getProperty(key);
		} catch (FileNotFoundException e) {
			System.out.println("Object Repository not found");
			
		} catch(IOException e) {
			System.out.println("Unable to load properties file");
			e.printStackTrace();
		}
		return value;
	}
	
	public static String getproperty(String key, String filePath) {
		String value=null;
		
		try {
			Constants.fis=new FileInputStream(filePath);
			Constants.pro=new Properties();
			Constants.pro.load(Constants.fis); 
			value=Constants.pro.getProperty(key);
		} catch (FileNotFoundException e) {
			System.out.println("File "+filePath+" not found");
			
		} catch(IOException e) {
			System.out.println("Unable to load file: "+filePath);
			e.printStackTrace();
		}
		
		return value;
	}
	
	public static String[] getLocator(String key) {
		String[] values=null;
		try {
			Constants.fis=new FileInputStream("D:\\framework\\Testing\\src\\main\\resources\\OR.properties");
			Constants.pro=new Properties();
			Constants.pro.load(Constants.fis);
			String part=Constants.pro.getProperty(key);
			values=part.split("##");
			System.out.println("Locator Type: "+values[0]);
			System.out.println("Locator value: "+values[1]);
		} catch (IOException e) {
			System.out.println("Unable to open Object Repository");
			e.printStackTrace();
		}
		return values;
	}
	

}
