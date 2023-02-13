Feature: Search product from all department

  Scenario: navigate to product list page 1
    Given I am on Home page
    When I click on menu "Shoes"
    Then I see the product list of this category "Shoes"

  Scenario: navigate to product list page 2
    Given I am on Home page
    When I click on menu "Accessories"
    Then I see the product list of this category "Accessories"

#  Scenario: navigate to product list page 3
#    Given I am on Home page
#    When I click on menu "Women->Bestsellers"
#    Then I see the product list of this category "Women's Bestsellers"
#
#  Scenario: navigate to product list page 4
#    Given I am on Home page
#    When I click on menu "Men->Bestsellers"
#    Then I see the product list of this category "Men's Bestsellers"