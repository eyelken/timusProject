@createAccount
  Feature: User should be able to create an account
    Background: Given the user is on the login page
    Scenario: Creating account for user
      When the user clicks on create account
      Then the user will enter the desired credentials
      And the user will accept the Privacy Policy and Terms of Service
      Then the user will click on Continue Button for further process





