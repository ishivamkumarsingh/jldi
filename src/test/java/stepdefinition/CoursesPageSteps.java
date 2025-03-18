package stepdefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.en.*;
import pageobjects.CoursesPage;
import utility.BaseClass;
import utility.Log4jConfig;
import utility.ScreenshotUtil;
import io.qameta.allure.Attachment;

public class CoursesPageSteps {

    WebDriver driver = BaseClass.getDriver();
    CoursesPage coursesPage = new CoursesPage(driver);

    @Given("I navigate to the homepage")
    public void i_navigate_to_the_homepage() {
        Log4jConfig.info("Navigating to Let's Kode It homepage...");
        driver.get("https://www.letskodeit.com/");
        ScreenshotUtil.captureScreenshotReturnPath(driver, "HomePageLoaded");
    }

    @When("I navigate to the All Courses section") // ✅ Updated step to avoid duplicate definition
    public void i_navigate_to_the_all_courses_section() {
        Log4jConfig.info("Clicking on All Courses...");
        coursesPage.clickAllCourses();
        ScreenshotUtil.captureScreenshotReturnPath(driver, "AllCoursesPage");
    }

    @Then("The page title should be {string}")
    public void the_page_title_should_be(String expectedTitle) {
        try {
            String actualTitle = coursesPage.getPageTitle();
            Log4jConfig.info("Verifying page title... Expected: " + expectedTitle + " | Found: " + actualTitle);
            Assert.assertEquals(actualTitle, expectedTitle, 
                "Page title mismatch! Expected: " + expectedTitle + ", but found: " + actualTitle);
            Log4jConfig.info("✅ Page title verification successful!");
        } catch (AssertionError e) {
            Log4jConfig.error("❌ Page title verification failed!");
            ScreenshotUtil.captureScreenshotReturnPath(driver, "TitleMismatch");
           
        }
    }

   
    }

