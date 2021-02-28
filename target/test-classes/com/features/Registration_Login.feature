Feature: Registration and login into demowebshop

Scenario: clickevents

Given user landed in registration page "Demo Web Shop"
Then click on the option male
And enter the firstname "test1000"
Then enter the lastname "test"
And enter the emailid "test14.test@test.com"
When entering the password "1234567890" 
Then confirming the password "1234567890"
When click on the register
Then validate the resgitration success message
And click on continue
Then validate current user information
And logout from application


Scenario: userlogin with authorized user

Given user landed in loginpage
Then enter username and password 
|test14.test@test.com|1234567890|
And click on Login
Then validate current user information
And logout from application
