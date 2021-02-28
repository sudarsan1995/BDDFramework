package com.pageobjects;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;



public class OrderProducts {

	public WebDriver ldriver;

	@FindBy(xpath="//ul[@class='top-menu']//li//a[contains(text(),'Books')]")
	WebElement bookslink;
	
	@FindBy(xpath="//ul[@class='top-menu']//li//a[contains(text(),'Computer')]")
	WebElement computerslink;
	
	@FindBy(xpath="//ul[@class='top-menu']//li//a[contains(text(),'Electronics')]")
	WebElement electroniclink;
	
	@FindBy(xpath="//ul[@class='top-menu']//li//a[contains(text(),'Apparel')]")
	WebElement apparellink;
	
	@FindBy(xpath="//ul[@class='top-menu']//li//a[contains(text(),'Digital')]")
	WebElement digitaldownloadlink;
	
	@FindBy(xpath="//ul[@class='top-menu']//li//a[contains(text(),'Jewelry')]")
	WebElement jewelry;
	
	@FindBy(xpath="//ul[@class='top-menu']//li//a[contains(text(),'Gift')]")
	WebElement giftcards;
	
	@FindBy(xpath="//select[@name='products-orderby']")
	WebElement sortBy;
	
	@FindBy(xpath="//select[@name='products-pagesize']")
	WebElement displayperpage;
	
	@FindBy(xpath="//select[@name='products-viewmode']")
	WebElement viewas;
	
	@FindBy(xpath="//h2[@class='product-title']")
	WebElement booknamelist;
	
	@FindBy(xpath="(//div[@class='item-box']//div[@class='product-item']//following-sibling::div[2]//following-sibling::div[3]//div[2]//input)[3]")
	WebElement addtocart;
	
	@FindBy(xpath="//p[contains(text(),'The product has been added to your ')]")
	WebElement addtocartconfirmationmsg;
	
	@FindBy(xpath="//a[contains(text(),'shopping cart')]")
	WebElement shoppingcartlink;
	
	@FindBy(xpath="(//a[@class='ico-cart'][1])")
	WebElement shoppingcart;
	
	
	public OrderProducts(WebDriver driver)
	{
		ldriver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void sortByDisplayViewAs()
	{
		
		String value="http://demowebshop.tricentis.com/books?viewmode=list";
		bookslink.click();
		Select s=new Select(sortBy);
		s.selectByVisibleText("Name: A to Z");
		
		Select s1=new Select(displayperpage);
		s1.selectByIndex(2);
		
	}
	
	public void orderingBooks()
	{
		
		String bookname="Health Book";
		
		List <WebElement> listofbooknames=ldriver.findElements(By.xpath("//h2[@class='product-title']"));
		int noofbookspresent=listofbooknames.size();
		
		for(int i=0;i<=noofbookspresent;i++)
		{
			String nameofthebooks=listofbooknames.get(i).getText();
			System.out.println(nameofthebooks);
			if(nameofthebooks.contains(bookname))
			{
				Assert.assertTrue(true);
				addtocart.click();
				break;
			} 
			
		}
		
		/*
		
		String textofthemessage=addtocartconfirmationmsg.getText();
		
		if(textofthemessage.contains("The product has been added to your "))
		{
			Assert.assertTrue(true);
			addtocartconfirmationmsg.isDisplayed();
			
		}
		
		
		shoppingcartlink.click();
	
		*/
		
		shoppingcart.click();
		
 	}
	
	public void selectingMultipleProducts()
	{
		String[] listofbooks= {"Computing and Internet","Fiction","Science"};
		List <WebElement> lis=ldriver.findElements(By.xpath("//h2[@class='product-title']"));
		
		
		int noofbookspresent=lis.size();
		
		for(int i=0;i<=noofbookspresent;i++)
		{
			String nameofthebook=lis.get(i).getText();	
		}
		
		List arraylistofbooknames=Arrays.asList(listofbooks);
		
		int i=0;
		if(arraylistofbooknames.contains(noofbookspresent))
		{
			System.out.println(noofbookspresent);
			
			addtocart.click();
			i++;
		}
			while(i==3)
		{
			break;
		} 
		
	
}}
