package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	
	// this method is load and return the propert
	
	private Properties pro;
	
	public Properties init_prop() throws IOException  
	{
		pro=new Properties();
		try {
			FileInputStream ip=new FileInputStream("./src/test/resources/com/config/config.properties");
			pro.load(ip);
		} 
		
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
	return pro;
	}
}
