package com.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class ShoppingCart{

	public WebDriver ldriver;
	
	@FindBy(xpath="//input[@name='discountcouponcode']")
	WebElement couponcode;
	
	@FindBy(xpath="//input[@name='applydiscountcouponcode']")
	WebElement couponcodeapplybutton;
	
	@FindBy(xpath="//input[@name='giftcardcouponcode']")
	WebElement giftcode;
	
	@FindBy(xpath="//input[@class='qty-input']")
	WebElement quantity;
	
	@FindBy(xpath="//tbody//tr[@class='cart-item-row']//td")
	WebElement productTable;
	
	@FindBy(xpath="//select[@name='CountryId']")
	WebElement country;
	
	@FindBy(xpath="//select[@name='StateProvinceId']")
	WebElement state;
	
	@FindBy(xpath="//input[@name='ZipPostalCode']")
	WebElement postalcode;
	
	@FindBy(xpath="//input[@name='termsofservice']")
	WebElement termsandconditions;
	
	@FindBy(xpath="(//table[@class='cart-total']//tbody//tr//td/following-sibling::td)[1]")
	WebElement bookPrice;
	
	@FindBy(xpath="(//table[@class='cart-total']//tbody//tr//td/following-sibling::td)[4]")
	WebElement discountprice;
	
	@FindBy(xpath="//button[@name='checkout']")
	WebElement checkout;
	
	@FindBy(xpath="//div[@class='message']")
	WebElement couponmessage;
	
	public ShoppingCart(WebDriver driver)
	{
		ldriver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//discount coupon :AutomationDiscount2
	
	public void enterQuantity()
	{
		quantity.clear();
		quantity.sendKeys("4");
		quantity.sendKeys(Keys.ENTER);
		
		
	}
	
	public void enterandApplyCoupon()
	{
		couponcode.sendKeys("AutomationDiscount2");
		couponcodeapplybutton.click();
		
		
	}
	
	public void validateapplyCouponMessage()
	{
		String textofthemessage=couponmessage.getText();
		Assert.assertEquals(textofthemessage, "The coupon code was applied");
		
	}
	
	public void selectCountryState() throws InterruptedException
	{
		Select s=new Select(country);
		s.selectByVisibleText("Canada");
		Thread.sleep(3000);
		Select s1=new Select(state);
		s1.selectByVisibleText("Newfoundland and Labrador");
	}
	
	public void getSubTotal()
	{
		String subtotal=bookPrice.getText();
		String disprice=discountprice.getText();
		
	}
	
	public void proceedCheckout()
	{
		termsandconditions.click();
		checkout.click();
	}
}
