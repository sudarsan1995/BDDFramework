Feature: Order the product

Scenario: order the product
Given User is on home page
And enter username and password 
|test14.test@test.com|1234567890|
And click on Login
Then validate current user information
Then Go to Books Section
And Order a book from the list of books
Then Given the addresses and proceed checkout
And validate the confirmation message
And logout from application