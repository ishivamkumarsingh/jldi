package stepdefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.en.*;
import pageobjects.LoginPage;
import utility.BaseClass;
import utility.Log4jConfig;

public class LoginSteps {

    WebDriver driver = BaseClass.getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @Given("I open the application home page")
    public void i_open_the_application_home_page() {
        driver.get("https://www.letskodeit.com");
    }

    @When("I click on the {string} link")
    public void i_click_on_the_link(String linkText) {
        loginPage.clickLoginLink();
    }

    @When("I enter username {string} and password {string}")
    public void i_enter_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

    @Then("I should see {string} as the login outcome")
    public void i_should_see_as_the_login_outcome(String expectedText) {
        boolean isSuccessful = loginPage.isLoginSuccessful();
        Assert.assertTrue(isSuccessful, "Login failed! Expected 'My Courses' header not found.");
        Log4jConfig.info("here i tried to pass data from feature file to stepdefinition");
    }
}
