package stepdefinition;

import io.cucumber.java.en.*;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import utility.BaseClass;
import utility.Log4jConfig;
import utility.ScreenshotUtil;
import pageobjects.AllCoursesPage;

public class AllCoursesSteps extends BaseClass {

    private WebDriver driver;
    private AllCoursesPage allCoursesPage;

    @Given("I open the All Courses page")
    public void i_open_the_all_courses_page() {
        Log4jConfig.info("Navigating to All Courses page...");
        driver = getDriver();
        driver.get("https://www.letskodeit.com/courses"); // Adjust URL if needed
        allCoursesPage = new AllCoursesPage(driver);
        ScreenshotUtil.captureScreenshotReturnPath(driver, "AllCoursesPage");
    }

    @When("I see the available course cards")
    public void i_see_the_available_course_cards() {
        Log4jConfig.info("Checking if course cards are displayed...");
        boolean cardsDisplayed = allCoursesPage.areCourseCardsDisplayed();
        Assert.assertTrue(cardsDisplayed, "No course cards found on the All Courses page!");
        ScreenshotUtil.captureScreenshotReturnPath(driver, "CourseCardsDisplayed");
    }

    @When("I click on the course card {string}")
    public void i_click_on_the_course_card(String courseName) {
        Log4jConfig.info("Clicking on course card: " + courseName);
        allCoursesPage.clickCourseCardByName(courseName);
        ScreenshotUtil.captureScreenshotReturnPath(driver, "CourseCardClicked_" + courseName);
    }

    @Then("I should be taken to the course details page")
    public void i_should_be_taken_to_the_course_details_page() {
        // You can verify the new page's title or a unique element
        Log4jConfig.info("Verifying we are on the course details page...");
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains("courses/"), 
            "Expected to be on a course details page, but URL is: " + currentURL);
        ScreenshotUtil.captureScreenshotReturnPath(driver, "CourseDetailsPage");
    }

    @When("I enter {string} in the course search box")
    public void i_enter_in_the_course_search_box(String term) {
        Log4jConfig.info("Entering search term: " + term);
        allCoursesPage.enterSearchTerm(term);
        ScreenshotUtil.captureScreenshotReturnPath(driver, "SearchTermEntered");
    }

    @When("I press enter or click the search icon")
    public void i_press_enter_or_click_the_search_icon() {
        Log4jConfig.info("Submitting the search...");
        allCoursesPage.pressEnterInSearchBox();
        ScreenshotUtil.captureScreenshotReturnPath(driver, "SearchSubmitted");
    }

    @Then("I should see courses related to {string}")
    public void i_should_see_courses_related_to(String term) {
        Log4jConfig.info("Verifying courses related to: " + term);
        boolean found = allCoursesPage.verifySeleniumCourses(term);
        Assert.assertTrue(found, "No courses found matching the search term: " + term);
        ScreenshotUtil.captureScreenshotReturnPath(driver, "SearchResults_" + term);
    }
}