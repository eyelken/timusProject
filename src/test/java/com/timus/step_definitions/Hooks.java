package com.timus.step_definitions;
import com.timus.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {
  @Before
  public void setUp() {
    System.out.println("\tthis is coming from BEFORE");
    Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    Driver.get().manage().window().maximize();
  }

  @After
  public void tearDown(Scenario scenario){
    if(scenario.isFailed()){
      final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
      scenario.attach(screenshot, "image/png", "screenshot");
    }
    Driver.closeDriver();
  }

}
