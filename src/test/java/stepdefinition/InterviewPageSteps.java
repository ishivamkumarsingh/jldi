package stepdefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.en.*;
import pageobjects.InterviewPage;
import utility.BaseClass;
import utility.Log4jConfig;

public class InterviewPageSteps {

    WebDriver driver = BaseClass.getDriver();
    InterviewPage interviewPage = new InterviewPage(driver);

    String fetchedPrice;

    @Given("I navigate to the interview page")
    public void i_navigate_to_the_interview_page() {
        driver.get("https://www.letskodeit.com/interview");
    }

    @When("I fetch the displayed price")
    public void i_fetch_the_displayed_price() {
        fetchedPrice = interviewPage.getPrice();
        System.out.println("Fetched Price: " + fetchedPrice);
    }

    @Then("The price should be {string}")
    public void the_price_should_be(String expectedPrice) {
        Assert.assertEquals(fetchedPrice, expectedPrice, 
                "Price mismatch! Expected: " + expectedPrice + ", but found: " + fetchedPrice);
        Log4jConfig.info("here i tried to fetach the price from a div");
    }
}
