package com.stepDefinition;

import org.junit.Assert;

import com.factoryclass.DriverFactory;
import com.pageobjects.CheckOutPage;
import com.pageobjects.Login;
import com.pageobjects.OrderProducts;
import com.pageobjects.ShoppingCart;

import cucumber.api.DataTable;
import cucumber.api.java.en.*;

public class OrderProduct {

private OrderProducts op=new OrderProducts(DriverFactory.getDriver());
private ShoppingCart sc=new ShoppingCart(DriverFactory.getDriver());
private CheckOutPage cop=new CheckOutPage(DriverFactory.getDriver());

@Given("^User is on home page$")
public void user_is_on_home_page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions

	DriverFactory.getDriver().get("http://demowebshop.tricentis.com/");
	Registration.lgin.Login();
	
	
}

@Then("^Go to Books Section$")
public void go_to_Books_Section() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	op.sortByDisplayViewAs();
	
}

@Then("^Order a book from the list of books$")
public void order_a_book_from_the_list_of_books() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	op.orderingBooks();
	
}

@Then("^Given the addresses and proceed checkout$")
public void given_the_addresses_and_proceed_checkout() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	sc.enterQuantity();
	sc.enterandApplyCoupon();
	sc.validateapplyCouponMessage();
	sc.getSubTotal();
	sc.selectCountryState();
	sc.proceedCheckout();
	
}

@Then("^validate the confirmation message$")
public void validate_the_confirmation_message(DataTable dt) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	
	cop.enterNewAddress(dt);
	cop.shippingMethod();
	cop.payMethod();
	cop.PaymentInformation();
	cop.totalCalculation();
	cop.confirmationScreen();
}
	
	
	
}
