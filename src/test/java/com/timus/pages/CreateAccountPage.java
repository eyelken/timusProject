package com.timus.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends BasePage{

  @FindBy(xpath = "//button[@data-testid='login-create-account']")
  public WebElement createAccountBtn;

  @FindBy(xpath = "//input[@data-testid='register-firstname-input']")
  public WebElement firstNameInput;

  @FindBy(xpath = "//input[@data-testid='register-lastname-input']")
  public WebElement lastNameInput;

  @FindBy(xpath = "//input[@data-testid='register-email-input']")
  public WebElement emailInput;

  @FindBy(xpath = "//input[@placeholder='Select']")
  public WebElement country;

  @FindBy(xpath = "//label[@id='privacy_box']")
  public WebElement privacyCheckBox;

  @FindBy(xpath = "//button[@data-testid='pages-register-index-zfrzzhrgq']")
  public WebElement acceptPrivacyAndTerms;

  @FindBy(xpath = "//label[@id='term_of_use_box']")
  public WebElement termsOfServiceCheckBox;

  @FindBy(xpath = "//button[@data-testid='register-continue']")
  public WebElement continueBtn;

  @FindBy(xpath = "//h1[@data-testid='pages-register-index-fcozvcbhdh']")
  public WebElement verifyEmail;

  @FindBy(xpath = "//div[@class='el-message el-message--error']")
  public WebElement emailExistsMsg;



}
