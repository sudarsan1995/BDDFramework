package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Registrationpage {
	
	private WebDriver driver;
	
	private By register=By.xpath("//a[@class='ico-register']");
	private By male=By.xpath("//label[@for='gender-male']");
	private By female=By.xpath("//label[@for='gender-female']");
	private By firstname=By.xpath("//input[@name='FirstName']");
	private By lastname=By.xpath("//input[@name='LastName']");
	private By email=By.xpath("//input[@name='Email']");
	private By password=By.xpath("//input[@name='Password']");
	private By confirmpassword=By.xpath("//input[@name='ConfirmPassword']");
	private By ok=By.xpath("//input[@value='Register']");
	private By regsitercompletionmesage=By.xpath("//div[@class='result']");
	private By currentuserinfo=By.xpath("(//a[@class='account'])[1]");
	private By logout=By.xpath("//a[@class='ico-logout']");
	
	public Registrationpage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean isRegisterLinkPresented()
	{
		return driver.findElement(register).isDisplayed();
	}
	
	public void clickOnMale()
	{
		driver.findElement(male).click();
	}
	
	public void clickonRegister()
	{
	 driver.findElement(register).click();
	}
	
	public void enterfirstname(String firstnme)
	{
		driver.findElement(firstname).sendKeys(firstnme);
	
		
	}
	
	public void enterlastname(String lastame)
	{
		driver.findElement(lastname).sendKeys(lastame);
		
	
	}
	
	public void enteremail(String emailid)
	{
		
		driver.findElement(email).sendKeys(emailid);
		
		
	}
	
	public void enterpassword(String passswrd)
	{
		
	
		driver.findElement(password).sendKeys(passswrd);

	
		
	}
	
	public void enterconformpassword(String Confirmpasswrd)
	{
		
		driver.findElement(confirmpassword).sendKeys(Confirmpasswrd);

		
	}
	
	
	
	
	
	public void clickOnOk()
	{
		driver.findElement(ok).click();
	}
	
	public void validateRegisterSuccessMessage()
	{
		String textofthemessage= driver.findElement(regsitercompletionmesage).getText().trim();
		if(textofthemessage.contains("Your registration completed"))
		{
			System.out.println("registration successfull");
		}
		
	}
	
	public  void validateCurrentUser()
	{
		String currentuser= driver.findElement(currentuserinfo).getText();
		if(currentuser.contains("test.com"))
		{
			System.out.println("current user logged in successfull");
		}
		
	}
	
	public void logout()
	{
		driver.findElement(logout).click();;
	}
	
	
	
	
	
	
	
}
