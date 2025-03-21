package stepdefinition;

import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;
import org.testng.Assert;

import pageobjects.HeaderPage;
import utility.BaseClass;
import utility.Log4jConfig;
import utility.ScreenshotUtil;

import java.util.List;

public class HeaderVerificationSteps extends BaseClass {

    HeaderPage headerPage;

    @Given("I navigate to the application homepage")
    public void i_navigate_to_the_application_homepage() {
        Log4jConfig.info("Launching browser and navigating to Let's Kode It...");
        driver = getDriver(); // from BaseClass
        driver.get("https://www.letskodeit.com/");
        headerPage = new HeaderPage(driver);
        ScreenshotUtil.captureScreenshotReturnPath(driver, "ApplicationHomePage");
    }

    @Then("The webpage title should be {string}")
    public void the_webpage_title_should_be(String expectedTitle) {
        Log4jConfig.info("Verifying webpage title...");
        String actualTitle = headerPage.getPageTitle();
        Assert.assertEquals(actualTitle, expectedTitle, 
                "Expected title: '" + expectedTitle + "' but found: '" + actualTitle + "'");
        Log4jConfig.info("Webpage title verified: " + actualTitle);
        ScreenshotUtil.captureScreenshotReturnPath(driver, "WebpageTitle");
    }

    @Then("The following navigation sections should be displayed")
    public void the_following_navigation_sections_should_be_displayed(DataTable sectionsTable) {
        Log4jConfig.info("Verifying navigation sections...");
        
        List<String> expectedSections = sectionsTable.asList();
        
        for (String section : expectedSections) {
            boolean isDisplayed = headerPage.isNavigationSectionDisplayed(section);
            Assert.assertTrue(isDisplayed, "Navigation section '" + section + "' is NOT displayed");
            Log4jConfig.info("Navigation section verified: " + section);
        }
        
        ScreenshotUtil.captureScreenshotReturnPath(driver, "NavigationSections");
    }

    @When("I click on the {string} navigation link")
    public void i_click_on_the_navigation_link(String sectionName) {
        Log4jConfig.info("Clicking on navigation link: " + sectionName);
        headerPage.clickNavigationSection(sectionName);
        ScreenshotUtil.captureScreenshotReturnPath(driver, "Click_" + sectionName.replaceAll("\\s+", "_"));
    }

    @Then("I should be navigated to the {string} page")
    public void i_should_be_navigated_to_the_page(String expectedPageTitle) {
        Log4jConfig.info("Verifying navigation to page with expected title: " + expectedPageTitle);
        String actualTitle = headerPage.getPageTitle();
        Assert.assertEquals(actualTitle, expectedPageTitle, 
                "Expected to navigate to page with title '" + expectedPageTitle + "' but landed on '" + actualTitle + "'");
        Log4jConfig.info("Successfully navigated to: " + expectedPageTitle);
        ScreenshotUtil.captureScreenshotReturnPath(driver, "Page_" + expectedPageTitle.replaceAll("\\s+", "_"));
    }
}
