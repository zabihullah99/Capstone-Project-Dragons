@Regression
Feature: Retail Account Page

  Background: 
    Given User is on retail website
    When User click on Sign in option
    And User enter email 'zatwr@gmail.com' and password 'Kabuljan@123'
    And User click on login button
    And User should be logged in into Account
    When User click on Account option

  @Regression
  Scenario: Verify User can update Profile Information
    And User update Name 'Zabihullah' and Phone '530-709-6109'
    And User click on Update button
    Then user profile information should be updated

  @Regression
  Scenario: Verify User can add a payment method
    And User click on Add a payment method link
    And User fill Debit or credit card information
      | cardNumber       | nameOnCard        | expirationMonth | expirationYear | securityCode |
      | 0000999234567800 | Ahmadi Zabihullah |               6 |           2023 |          321 |
    And User click on Add your card button
    Then a message should be displayed ‘Payment Method added successfully’

  @Regression
  Scenario: Verify User can edit Debit or Credit card
    And User click on Card to Eidt
    And User click on Edit option of card section
    And user edit information with below data
      | cardNumber       | nameOnCard | expirationMonth | expirationYear | securityCode |
      | 4350935761098473 | Zabihullah |               5 |           2023 |          006 |
    And user click on Update Your Card button
    Then a message should be displayed ‘Payment Method updated Successfully’

  @Regression
  Scenario: Verify User can remove Debit or Credit card
    And User click on Card to remove
    And User click on remove option of card section
    Then payment details should be removed

  @Regression
  Scenario: Verify User can add an Address
    And User click on Add address option
    And user fill new address form with below information
      | country       | fullName          | phoneNumber  | streetAddress | apt | city  | state      | zipCode |
      | United States | Ahmadi Zabihullah | 530-709-6109 | 1657 kenny dr |   1 | Linda | California |   95901 |
    And User click Add Your Address button
    Then a message should be displayed ‘Address Added Successfully’

  @Retail @Regression
  Scenario: Verify User can edit an Address added on account
    And User click on edit address option
    And user fill  edit address form with below information
      | country       | fullName   | phoneNumber  | streetAddress   | apt | city | state      | zipCode |
      | United States | Zabihullah | 530-821-1459 | 1535 Alfred way |   9 | Yuba | California |   95993 |
    And User click update Your Address button
    Then a message should be displayed ‘Address Updated Successfully

  @Retail @Regression
  Scenario: Verify User can remove Address from Account
    And User click on remove option of Address section
    Then Address details should be removed
