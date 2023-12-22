package com.timus.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {
  private Driver() {
  }

  private static InheritableThreadLocal<WebDriver> driverPool= new InheritableThreadLocal<>();

  public static WebDriver get() {
    // Test
    if (driverPool.get() == null) {
      // this line will tell which browser should open based on the value from properties file
      String browser = System.getProperty("browser") != null ? browser = System.getProperty("browser") : ConfigurationReader.get("browser");
      switch (browser) {
        case "chrome":
          WebDriverManager.chromedriver().setup();
          driverPool.set(new ChromeDriver());
          Driver.get().navigate().to(ConfigurationReader.get("url"));
          break;
        case "chrome-headless":
          WebDriverManager.chromedriver().setup();
          driverPool.set(new ChromeDriver(new ChromeOptions().setHeadless(true)));
          break;
        case "firefox":
          WebDriverManager.firefoxdriver().setup();
          driverPool.set(new FirefoxDriver());
          break;
        case "firefox-headless":
          WebDriverManager.firefoxdriver().setup();
          driverPool.set(new FirefoxDriver(new FirefoxOptions().setHeadless(true)));
          break;
        case "edge":
          if (!System.getProperty("os.name").toLowerCase().contains("windows"))
            throw new WebDriverException("Your OS doesn't support Edge");
          WebDriverManager.edgedriver().setup();
          driverPool.set(new EdgeDriver());
          break;

        case "safari":
          if (!System.getProperty("os.name").toLowerCase().contains("mac"))
            throw new WebDriverException("Your OS doesn't support Safari");
          WebDriverManager.getInstance(SafariDriver.class).setup();
          driverPool.set(new SafariDriver());
          break;
        case "remote_chrome":
          ChromeOptions chromeOptions=new ChromeOptions();
          chromeOptions.setCapability("platform", Platform.ANY);
          try {
            driverPool.set(new RemoteWebDriver(new URL("http://44.202.70.234:4444/wd/hub"),chromeOptions));
          }catch (MalformedURLException e){
            e.printStackTrace();
          }
      }
    }
    return driverPool.get();
  }

  public static void closeDriver() {
    driverPool.get().quit();
    driverPool.remove();
  }
}
