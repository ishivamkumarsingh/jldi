package stepdefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.en.*;
import pageobjects.AlertPage;
import utility.BaseClass;
import utility.Log4jConfig;

public class AlertSteps {

    WebDriver driver = BaseClass.getDriver();
    AlertPage alertPage = new AlertPage(driver);

    @When("I enter {string} in the alert textbox")
    public void i_enter_in_the_alert_textbox(String name) {
        alertPage.enterName(name);
    }

    @When("I click on the alert button")
    public void i_click_on_the_alert_button() {
        alertPage.clickAlertButton();
    }

    @Then("I should see an alert with message {string}")
    public void i_should_see_an_alert_with_message(String expectedMessage) {
        String actualMessage = alertPage.getAlertText();
        Assert.assertEquals(actualMessage, expectedMessage, "Alert message mismatch!");
        Log4jConfig.info("here i tried to read the alert pop up");
        alertPage.acceptAlert();
    }
}
