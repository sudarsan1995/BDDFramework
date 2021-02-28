package com.factoryclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tldriver=new ThreadLocal<>();
	
	public WebDriver init_driver(String browser)
	{
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver());
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			tldriver.set(new FirefoxDriver());
		}
		
		else if(browser.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			tldriver.set(new EdgeDriver());
		}
		
		else {
			System.out.println("please pass the correct browser value :" +browser);
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		
		return getDriver();
	}

	
	public static synchronized WebDriver getDriver()
	{
		return tldriver.get();
		
	}
	
}
