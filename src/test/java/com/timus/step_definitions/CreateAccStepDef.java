package com.timus.step_definitions;

import com.timus.pages.CreateAccountPage;
import com.timus.utilities.BrowserUtils;
import com.timus.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.security.Key;
import java.util.Map;

public class CreateAccStepDef {

  CreateAccountPage createAccountPage=new CreateAccountPage();
  Actions actions =new Actions(Driver.get());

  @When("the user clicks on create account")
  public void the_user_clicks_on_create_account() throws InterruptedException {
    actions.click(createAccountPage.createAccountBtn).perform();
    BrowserUtils.waitForVisibility(createAccountPage.firstNameInput,10);
  }

  @Then("the user will enter the desired credentials")
  public void the_user_will_enter_the_desired_credentials() throws InterruptedException {
    createAccountPage.firstNameInput.click();
    createAccountPage.firstNameInput.sendKeys("ege");

    createAccountPage.lastNameInput.click();
    createAccountPage.lastNameInput.sendKeys("yelken");

    createAccountPage.emailInput.sendKeys("egehilalyelken");

    createAccountPage.country.click();
    createAccountPage.country.sendKeys("Turkey");
    createAccountPage.country.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
  }

  @Then("the user will accept the Privacy Policy and Terms of Service")
  public void the_user_will_accept_the_Privacy_Policy_and_Terms_of_Service() throws InterruptedException {
    createAccountPage.privacyCheckBox.click();

    JavascriptExecutor js = (JavascriptExecutor) Driver.get().switchTo().frame(0);
    js.executeScript("window.scrollBy(0,10000)");
    Driver.get().switchTo().defaultContent();
    createAccountPage.acceptPrivacyAndTerms.click();

    Thread.sleep(1000);

    createAccountPage.termsOfServiceCheckBox.click();
    Thread.sleep(2000);
    JavascriptExecutor jse = (JavascriptExecutor) Driver.get().switchTo().frame(0);
    jse.executeScript("window.scrollBy(0,10500)");
    Driver.get().switchTo().defaultContent();
    createAccountPage.acceptPrivacyAndTerms.click();

    Thread.sleep(3000);

  }
  @Then("the user will click on Continue Button for further process")
  public void the_user_will_click_on_Continue_Button_for_further_process() {
    createAccountPage.continueBtn.click();

    if (createAccountPage.emailExistsMsg.isDisplayed()) {
      System.out.println("The given email already exists. message has been seen on the page.");
    } else {
      createAccountPage.verifyEmail.isDisplayed();
      System.out.println("Please verify your email address. message has been seen on the page.");
    }

  }
}
