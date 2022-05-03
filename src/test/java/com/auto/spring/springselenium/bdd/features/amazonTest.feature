@amazon
Feature: Amazon product search
  Scenario: I want to search for the nth highest priced television
    Given I am on the amazon site
    When I select "Televisions" right extension submenu from "shop by department" heading's "TV, Appliances, Electronics" submenu's
    And I filter for "Samsung" product under "Brands" category
    Then I should see "Samsung" brand products

    When I click on the 1 highest priced product
    Then I should see the individual product page

    When I scroll to feature bullet content
    And I should see feature bullet content for the product