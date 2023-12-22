$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/feature/createAccount.feature");
formatter.feature({
  "name": "User should be able to create an account",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@createAccount"
    }
  ]
});
formatter.background({
  "name": "Given the user is on the login page",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.scenario({
  "name": "Creating account for user",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@createAccount"
    }
  ]
});
formatter.step({
  "name": "the user clicks on create account",
  "keyword": "When "
});
formatter.match({
  "location": "com.timus.step_definitions.CreateAccStepDef.the_user_clicks_on_create_account()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user will enter the desired credentials",
  "keyword": "Then "
});
formatter.match({
  "location": "com.timus.step_definitions.CreateAccStepDef.the_user_will_enter_the_desired_credentials()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user will accept the Privacy Policy and Terms of Service",
  "keyword": "And "
});
formatter.match({
  "location": "com.timus.step_definitions.CreateAccStepDef.the_user_will_accept_the_Privacy_Policy_and_Terms_of_Service()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user will click on Continue Button for further process",
  "keyword": "Then "
});
formatter.match({
  "location": "com.timus.step_definitions.CreateAccStepDef.the_user_will_click_on_Continue_Button_for_further_process()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});