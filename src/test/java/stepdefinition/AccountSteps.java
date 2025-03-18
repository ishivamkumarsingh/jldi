package stepdefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.en.*;
import pageobjects.AccountPage;
import utility.BaseClass;
import utility.ExcelUtils;
import utility.Log4jConfig;

public class AccountSteps {

    WebDriver driver = BaseClass.getDriver();
    AccountPage accountPage = new AccountPage(driver);

    String excelFilePath = System.getProperty("user.dir") + "/"; // ✅ Dynamic project root path

    @Given("I navigate to the account page")
    public void i_navigate_to_the_account_page() {
        driver.get("https://www.letskodeit.com/account");
    }

    @When("I enter email {string} and password {string}")
    public void i_enter_email_and_password(String email, String password) {
        accountPage.enterEmail(email);
        accountPage.enterPassword(password);
        System.out.println("Entered email: " + email);
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        accountPage.clickLogin();
    }

    @When("I wait for the form to load")
    public void i_wait_for_the_form_to_load() {
        accountPage.waitForFormToLoad();
    }

    @When("I fill the address and zip code using {string} sheet {string}")
    public void i_fill_the_address_and_zip_code_using_excel(String fileName, String sheetName) {
        String filePath = excelFilePath + fileName;

        String address = ExcelUtils.getCellValue(filePath, sheetName, 1, 0);
        String zipCode = ExcelUtils.getCellValue(filePath, sheetName, 1, 1);

        accountPage.enterAddress(address);
        accountPage.enterZipCode(zipCode);

        System.out.println("Entered Address: " + address);
        System.out.println("Entered Zip Code: " + zipCode);
        Log4jConfig.info("here i tried to enter data using apache poi");
    }

    @When("I click on the update button")
    public void i_click_on_the_update_button() {
        accountPage.clickUpdateButton();
      
    }

    @Then("The update should be successful")
    public void the_update_should_be_successful() {
        boolean isUpdated = accountPage.isUpdateSuccessful();
        Assert.assertTrue(isUpdated, "Profile update failed!");
    }
}
