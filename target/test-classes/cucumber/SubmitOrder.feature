@tag
Feature: Purchase the order from Ecommerce Website
   I want to use this template for my feature file
   
   Background:
   Given i landed on Ecommerce page
   
   
   @tag2
   Scenario Outline:Title of Your  scenariio outline
   Given Logged in with username<name> and password <password>
   When add the product <productName> in step
   And Checkout <productName>
   Then  "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage
   
   Examples:
   name                     password        productName
   rajuautomatio@gmail.com  Raju@143        ZARA COAT 3
  