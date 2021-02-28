package com.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;



import cucumber.api.DataTable;

public class CheckOutPage {

	public WebDriver ldriver;
	
	@FindBy(xpath="//select[@name='billing_address_id']")
	WebElement address;
	
	@FindBy(xpath="//select[@name='shipping_address_id']")
	WebElement shippingadress;
	
	@FindBy(xpath="//input[@id='PickUpInStore' and @name='PickUpInStore']")
	WebElement instorepickup;
	
	@FindBy(xpath="//div[@id='shipping-buttons-container']/p[@class='back-link']")
	WebElement back;
	
	@FindBy(xpath="//input[@onclick='Billing.save()']")
	WebElement billingaddresscontinuebutton;
	
	@FindBy(xpath="//input[@id='shippingoption_1']")
	WebElement shippingMethod;
	
	@FindBy(xpath="//input[@onclick='Shipping.save()']")
	WebElement Shippingaddresscontinue;
	
	@FindBy(xpath="//label[text()='Cash On Delivery (COD) (7.00)']")
	WebElement paymentmethod;
	
	@FindBy(xpath="//input[@onclick='ShippingMethod.save()']")
	WebElement ShippingMethodcontinue;
	
	@FindBy(xpath="//p[text()='You will pay by COD']")
	WebElement codmessage;
	
	@FindBy(xpath="//input[@onclick='PaymentMethod.save()']")
	WebElement PaymentMethodcontinue;
	
	@FindBy(xpath="//input[@onclick='PaymentInfo.save()']")
	WebElement PaymentInfocontinue;
	
	@FindBy(xpath="//table[@class='cart']//following-sibling::tbody//tr[1]//td[3]")
	WebElement cartitemdetails;
	
	@FindBy(xpath="//table[@class='cart-total']//tbody//tr//td[@class='cart-total-right']")
	WebElement amounttable;
	
	@FindBy(xpath="//input[@onclick='ConfirmOrder.save()']")
	WebElement Confirmcontinue;
	
	
	@FindBy(xpath="//div[@class='section order-completed']//div//strong")
	WebElement confirmationmessage;
	
	@FindBy(xpath="//div[@class='page-title']//h1")
	WebElement thankyoumessage;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_Company']")
	WebElement company;
	
	@FindBy(xpath="//select[@id='BillingNewAddress_CountryId']")
	WebElement country;
	
	@FindBy(xpath="//select[@id='BillingNewAddress_StateProvinceId']")
	WebElement state;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_City']")
	WebElement city;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_Address1']")
	WebElement address1;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_Address2']")
	WebElement address2;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_ZipPostalCode']")
	WebElement postalcode;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_PhoneNumber']")
	WebElement phonenumber;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_FaxNumber']")
	WebElement fax;
	
	
	
	public CheckOutPage(WebDriver driver)
	{
		ldriver=driver;
		PageFactory.initElements(driver, this);
	}

	public void enterNewAddress(DataTable data)
	{
		Select s=new Select(address);
		s.selectByVisibleText("New Address");
		
		List<List<String>> testdata=data.raw();
 		
		company.sendKeys(testdata.get(0).get(0));
		Select s1=new Select(country);
		s1.selectByVisibleText("Canada");
		Select s2=new Select(state);
		s2.selectByVisibleText("Prince Edward Island");
		city.sendKeys(testdata.get(0).get(1));
		address1.sendKeys(testdata.get(0).get(2));
		address2.sendKeys(testdata.get(0).get(3));
		postalcode.sendKeys(testdata.get(0).get(4));
		phonenumber.sendKeys(testdata.get(0).get(5));
		billingaddresscontinuebutton.click();
		
		
	}
	
	public void selectAddress()
	{
		Select s2=new Select(shippingadress);
		s2.selectByValue("1831286");
		Shippingaddresscontinue.click();
		
	}
	
	public void shippingMethod()
	{
		shippingMethod.click();
		ShippingMethodcontinue.click();
	}
	
	public void payMethod()
	{
		paymentmethod.click();
		
		JavascriptExecutor js=(JavascriptExecutor) ldriver;
		js.executeScript("window.scrollBy(0,280)");
		
		PaymentMethodcontinue.click();
	}
	
	public void PaymentInformation()
	{
		String textofthemessage=codmessage.getText();
		Assert.assertEquals(textofthemessage, "You will pay by COD");
		PaymentInfocontinue.click();
	}
	
	int i;
	public void totalCalculation()
	{
		
		/*
		
		List<WebElement> li=ldriver.findElements(By.xpath("//table[@class='cart-total']//tbody//tr//td[@class='cart-total-right']"));
		
		int noofrows=li.size();
		
		int sum=0;
		for(int i=0;i<noofrows-1;i++)
		{
			
			System.out.println(li);
			int value=Integer.parseInt(li.get(i).getText());
			
			 sum=sum+value;
			
		}
		
		WebElement total=ldriver.findElement(By.xpath("(//table[@class='cart-total']//tbody//tr//td[@class='cart-total-right'])[6]"));
		
		int totalvalue=Integer.parseInt(total.getText());
		
		Assert.assertEquals(sum, totalvalue);
		
		JavascriptExecutor js=(JavascriptExecutor) ldriver;
		js.executeScript("window.scrollBy(0,500)");
		
		*/
		
		Confirmcontinue.click();
		
	}
	
	public void confirmationScreen()
	{
		thankyoumessage.isDisplayed();
		Assert.assertEquals(thankyoumessage, "Thank you");
		confirmationmessage.isDisplayed();
		Assert.assertEquals(confirmationmessage, "Your order has been successfully processed!");
	}
	
	
	
	
}
