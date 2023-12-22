package com.timus.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

  @RunWith(Cucumber.class)
  @CucumberOptions(
    plugin = {
      "pretty",
      "json:target/cucumber.json",
      "html:target/default-html-reports",
      "rerun:target/rerun.txt"},
    features = "/Users/egeyelken/IdeaProjects/timusProject/src/test/resources/feature",
    glue = "com/timus/step_definitions",
    dryRun = false,
    tags = "@createAccount"
  )
  public class CukesRunner {
  }

