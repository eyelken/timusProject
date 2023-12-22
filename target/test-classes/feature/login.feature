@login
Feature: User should be able to login
  Background: Given the user is on the login page
  Scenario: Login with default account
    When enters the login credentials
    And the user sees the alert message on the page
    Then the user should be able to login




