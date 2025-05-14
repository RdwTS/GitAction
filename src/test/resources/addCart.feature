@addCart
Feature: addCart

#  validLogin for run all addCart feature
  Background:
    Given user is on login page
    And user input username with "standard_user"
    And user input password with "secret_sauce"
    When user click login button
    Then user will be on homepage

  @addChart
  Scenario: Add Backpack to cart
    Given user is on homepage
    When user clicks "Add to cart" button for Backpack
    Then the button should change to "Remove"
    And cart count should increase by 1