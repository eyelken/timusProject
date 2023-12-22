package com.timus.pages;

import com.timus.utilities.ConfigurationReader;
import com.timus.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//input[@data-testid='login-email-input']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@data-testid='pages-login-niigwirnsa']")
    public WebElement passwordInput;

    @FindBy(xpath = "//*[@data-testid='login-remember-me-checkbox']")
    public WebElement rememberMeCheckBox;

    @FindBy(xpath = "//*[@data-testid='login-continue']")
    public WebElement continueBtn;

    @FindBy(xpath = "//div[@class='el-message el-message--success]")
    public WebElement alertMessage;

    public void login () {
      Driver.get().navigate().to(ConfigurationReader.get("url"));
    }

  }

