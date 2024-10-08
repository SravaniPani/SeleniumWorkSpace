
@tag
Feature: Login in to the Application
  I want to use this template for my feature file


	Background:
	Given I landed on Eccomerce page


  @tag2
  Scenario Outline: Positive Test of logging in to the Application
    Given Login in to the Application with <name> and password <password>
    When I add product <productName> to cart 
    Then I verify the  in step

    Examples: 
      | name                             | password    |  productName     |
      | sravanipani1234@gmail.com        | Sravani@123 |  ADIDAS ORIGINAL |
  
