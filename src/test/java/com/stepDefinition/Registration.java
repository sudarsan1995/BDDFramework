package com.stepDefinition;

import com.factoryclass.DriverFactory;
import com.pageobjects.Login;
import com.pageobjects.Registrationpage;

import cucumber.api.java.en.*;
import org.junit.Assert;

public class Registration {

	private Registrationpage reg=new Registrationpage(DriverFactory.getDriver());
	public static Login lgin=new Login(DriverFactory.getDriver());

	 @Given("^user landed in registration page \"([^\"]*)\"$")
	    public void user_landed_in_registration_page_something(String titleofthewebsite) throws Throwable {
	    
		DriverFactory.getDriver().get("http://demowebshop.tricentis.com/");
		
		String titleofpage=reg.getPageTitle(); 
		System.out.println("the title of the page is : " +titleofpage);
		Assert.assertTrue(titleofpage.contains(titleofthewebsite));
		reg.clickonRegister();
		
	    }
	
    @When("^entering the password \"([^\"]*)\"$")
    public void entering_the_password_something(String pwd) throws Throwable {
      
    	reg.enterpassword(pwd);
    
    }

    @When("^click on the register$")
    public void click_on_the_register() throws Throwable {
     
    	reg.clickOnOk();
    }

    @Then("^click on the option male$")
    public void click_on_the_option_male() throws Throwable {
    	
    	reg.clickOnMale();
    }

    @Then("^enter the lastname \"([^\"]*)\"$")
    public void enter_the_lastname_something(String ln) throws Throwable {
       
    	reg.enterlastname(ln);
    }

    @Then("^confirming the password \"([^\"]*)\"$")
    public void confirming_the_password_something(String cnpwd) throws Throwable {
      
    	reg.enterconformpassword(cnpwd);
    }

    @Then("^validate the resgitration success message$")
    public void validate_the_resgitration_success_message() throws Throwable {
    	reg.validateRegisterSuccessMessage();
    
    	
    }

    @Then("^validate current user information$")
    public void validate_the_current_user_information() throws Throwable {
    	
    	reg.validateCurrentUser();
    }

    @And("^enter the firstname \"([^\"]*)\"$")
    public void enter_the_firstname_something(String fn) throws Throwable {
     
    	reg.enterfirstname(fn);
    }

    @And("^enter the emailid \"([^\"]*)\"$")
    public void enter_the_emailid_something(String id) throws Throwable {
       
    	reg.enteremail(id);
    	
    }

    @And("^click on continue$")
    public void click_on_continue() throws Throwable {
      
    	
    }

    @And("^logout from application$")
    public void logout_from_application() throws Throwable {
       
    	reg.logout();
    }
    
    @Given("^user landed in loginpage$")
    public void user_landed_in_loginpage() throws Throwable {
      
    	DriverFactory.getDriver().get("http://demowebshop.tricentis.com/");
    	
    	lgin.Login();
		
    }
    

    @And("^click on Login$")
    public void click_on_login() throws Throwable {
    
    	lgin.ent();
    }
    
    @Then("^enter username and password$")
    public void enter_username_and_password(cucumber.api.DataTable data)
    {
    	lgin.enteringUsernamePassword(data);
    }


    
}
