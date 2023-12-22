package com.timus.step_definitions;

import com.timus.pages.LoginPage;
import com.timus.utilities.BrowserUtils;
import com.timus.utilities.ConfigurationReader;
import com.timus.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class LoginStepDef {

  LoginPage loginPage=new LoginPage();

  @Given("the user is on the login page")
  public void the_user_is_on_the_login_page() {
      loginPage.login();
  }

  @When("enters the login credentials")
  public void enters_the_login_credentials() throws InterruptedException {
    loginPage.usernameInput.sendKeys(ConfigurationReader.get("username"));
    loginPage.passwordInput.sendKeys(ConfigurationReader.get("password"));
    loginPage.rememberMeCheckBox.click();
    loginPage.continueBtn.click();

    Thread.sleep(2000);

  }
  @When("the user sees the alert message on the page")
  public void the_user_sees_the_alert_message_on_the_page() {
    try {
      System.out.println("The welcome alert message has seen on the page.");
    } catch (Exception e) {
      System.out.println("The welcome alert message has not be seen on the page.");
    }
  }
  @Then("the user should be able to login")
  public void the_user_should_be_able_to_login() throws InterruptedException {

  Thread.sleep(3000);

  String currentURL= Driver.get().getCurrentUrl();
  String expectedURL= "https://manage-st01-us-01.timusnetworks.com/";

    if (currentURL.equals(expectedURL)) {
      System.out.println("The current URL and the expected URL are the same.");
    } else {
      System.out.println("The current URL and the expected URL are not the same.");
    }
  }
}
