package com.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.DataTable;

public class Login {

	private WebDriver driver;
	
	private By email=By.xpath("//input[@id='Email']");
	private By Pasword=By.xpath("//input[@id='Password']");
	private By Enter=By.xpath("//input[@type='submit' and @value='Log in']");
	private By login=By.xpath("//a[@class='ico-login']");
	

	public Login(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void enteringUsernamePassword(DataTable data)
	{
		List<List<String>> testdata=data.raw();
 		
		driver.findElement(email).sendKeys(testdata.get(0).get(0));
		driver.findElement(Pasword).sendKeys(testdata.get(0).get(1));
	
	}
	
	public void ent()
	{
		driver.findElement(Enter).click();
	}
	
	public void Login()
	{
		driver.findElement(login).click();
	}
	
}
