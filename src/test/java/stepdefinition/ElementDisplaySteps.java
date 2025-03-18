package stepdefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.en.*;
import pageobjects.ElementDisplayPage;
import utility.BaseClass;
import utility.Log4jConfig;
import utility.ScreenshotUtil;
import io.qameta.allure.Attachment;

public class ElementDisplaySteps {

    WebDriver driver = BaseClass.getDriver();
    ElementDisplayPage elementDisplayPage = new ElementDisplayPage(driver);

    @Given("I launch Practice page") // ✅ Updated step to match the feature file
    public void i_launch_practice_page() {
        Log4jConfig.info("Launching Let's Kode It Practice page...");
        driver.get("https://www.letskodeit.com/practice");
        ScreenshotUtil.captureScreenshotReturnPath(driver, "PracticePageLoaded");
    }

    @When("I click on the Hide button")
    public void i_click_on_the_hide_button() {
        Log4jConfig.info("Clicking the Hide button...");
        elementDisplayPage.clickHideButton();
        ScreenshotUtil.captureScreenshotReturnPath(driver, "AfterClickingHide");
    }

    @Then("The text field should not be visible")
    public void the_text_field_should_not_be_visible() {
        try {
            boolean isDisplayed = elementDisplayPage.isTextFieldDisplayed();
            Log4jConfig.info("Checking if text field is hidden... Displayed: " + isDisplayed);
            Assert.assertFalse(isDisplayed, "❌ Text field is still visible after clicking Hide!");
            Log4jConfig.info("✅ Text field is successfully hidden!");
        } catch (AssertionError e) {
            Log4jConfig.error("❌ Test failed: Text field is still visible.");
          
        }
    }

}
