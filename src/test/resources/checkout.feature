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
    And user clicks the cart icon
    Then user should be on the cart page


  @checkout-start
  Scenario: User proceeds to checkout
    Given user is on the cart page
    When user clicks the Checkout button
    Then user should be on the checkout information page
    And user enters first name "Ridwan"
    And user enters last name "Tegar Setiawan"
    And user enters postal code "12000"
    When user clicks the Continue button
    Then user should be on the checkout overview page
    When user clicks the Finish button
    Then user should see a confirmation message "Thank you for your order!"

  @checkout-info-invalid-firstname
  Scenario: User fills firstname blank in checkout information
    Given user is on the cart page
    When user clicks the Checkout button
    Then user should be on the checkout information page
    And user enters first name ""
    And user enters last name "Tegar Setiawan"
    And user enters postal code "12000"
    When user clicks the Continue button
    Then user should see a error message "Error: First Name is required"

  @checkout-info-invalid-lastname
  Scenario: User fills lastname blank in checkout information
    Given user is on the cart page
    When user clicks the Checkout button
    Then user should be on the checkout information page
    And user enters first name "Ridwan"
    And user enters last name ""
    And user enters postal code "12000"
    When user clicks the Continue button
    Then user should see a error message "Error: Last Name is required"

  @checkout-info-invalid-zipcode
  Scenario: User fills zipcode blank in checkout information
    Given user is on the cart page
    When user clicks the Checkout button
    Then user should be on the checkout information page
    And user enters first name "Ridwan"
    And user enters last name "Tegar Setiawan"
    And user enters postal code ""
    When user clicks the Continue button
    Then user should see a error message "Error: Postal Code is required"


#  @checkout-info
#  Scenario: User fills in checkout information
#    Given user is on the checkout information page
#    And user enters first name "Ridwan"
#    And user enters last name "Tegar Setiawan"
#    And user enters postal code "12000"
#    When user clicks the Continue button
#    Then user should be on the checkout overview page

#  @checkout-info-invalid-firstname
#  Scenario: User fills in checkout information
#    Given user is on the checkout information page
#    And user enters first name ""
#    And user enters last name "Tegar Setiawan"
#    And user enters postal code "12000"
#    When user clicks the Continue button
#    Then user should see a error message "Error: First Name is required"

#  @checkout-info-invalid-lastname
#  Scenario: User fills in checkout information
#    Given user is on the checkout information page
#    And user enters first name "Ridwan"
#    And user enters last name ""
#    And user enters postal code "12000"
#    When user clicks the Continue button
#    Then user should see a error message "Error: Last Name is required"
#
#  @checkout-info-invalid-postalcode
#  Scenario: User fills in checkout information
#    Given user is on the checkout information page
#    And user enters first name "Ridwan"
#    And user enters last name "Tegar Setiawan"
#    And user enters postal code ""
#    When user clicks the Continue button
#    Then user should see a error message "Error: Postal Code is required"


#  @checkout-finish
#  Scenario: User completes the checkout
#    Given user is on the checkout overview page
#    When user clicks the Finish button
#    Then user should see a confirmation message "Thank you for your order!"
