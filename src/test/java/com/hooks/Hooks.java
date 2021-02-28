package com.hooks;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import com.factoryclass.DriverFactory;
import com.utils.ConfigReader;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;




public class Hooks {

	private DriverFactory driverfactory;
	private WebDriver driver;
	private ConfigReader config;
	Properties pro;
	
	@Before(order = 0)
	public void getPropertyOfBroswser() throws IOException
	
	{
		config=new ConfigReader();
		pro=config.init_prop();
				
	}
	
	@Before (order = 1)
	public void launchbrowser()
	{
		String nameofbroswser=pro.getProperty("browser");
		driverfactory=new DriverFactory();
		driver=driverfactory.init_driver(nameofbroswser);
	}
	
	@After(order=1)
	public void quitBrowser()
	{
		//driver.quit();
	}
	
	

	@After (order=2)
	public void takeScreenshot(Scenario scenario)
	{
		if(scenario.isFailed()) {
			scenario.getName();
			String screenshotName=scenario.getName().replaceAll("", "_");
			byte[] sourcepath=((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			
			scenario.embed(sourcepath, "image/png");
			
			System.out.println("screenshot taken");
		}
	}
	


}
