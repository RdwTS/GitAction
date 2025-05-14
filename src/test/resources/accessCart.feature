@checkout
Feature: checkout

#  validLogin for run addCart feature
  Background:
    Given user is on login page
    And user input username with "standard_user"
    And user input password with "secret_sauce"
    When user click login button
    Then user will be on homepage
    And user clicks "Add to cart" button for Backpack
    Then the button should change to "Remove"
    And cart count should increase by 1

  @access-cart
  Scenario: User can access the cart page
    Given user clicks the cart icon
    Then user should be on the cart page