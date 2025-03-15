package com.nopcommerece.stepdefs;

import com.nopcommerce.pages.*;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.time.Duration;

public class StepDefinitions {
    WebDriver driver;
    LoginPage loginPage;
    ElectronicsPage electronicsPage;
    CellPhonesPage cellPhonesPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    @Given("User launches the nopCommerce website")
    public void user_launches_nopcommerce_website() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }

    @When("User logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {
        loginPage = new LoginPage(driver);
        loginPage.clickLogin();
        loginPage.enterUsername("testuser@example.com");
        loginPage.enterPassword("Password123");
        loginPage.clickLoginButton();
    }

    @When("User navigates to Electronics -> Cell Phones")
    public void user_navigates_to_electronics_cell_phones() {
        electronicsPage = new ElectronicsPage(driver);
        electronicsPage.navigateToCellPhones();
    }

    @When("User selects the third product and adds to cart")
    public void user_selects_third_product_and_adds_to_cart() {
        cellPhonesPage = new CellPhonesPage(driver);
        cellPhonesPage.selectThirdProduct();
        cellPhonesPage.addToCart();
    }

    @When("User goes to the shopping cart")
    public void user_goes_to_the_shopping_cart() {
        cartPage = new CartPage(driver);
        cartPage.openCart();
        cartPage.goToCart();
    }

    @When("User selects Yes for Gift Wrapping and proceeds to checkout")
    public void user_selects_yes_for_gift_wrapping_and_proceeds_to_checkout() {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.selectGiftWrapping();
        checkoutPage.agreeToTerms();
        checkoutPage.proceedToCheckout();
    }

    @When("User fills required fields and confirms the order")
    public void user_fills_required_fields_and_confirms_the_order() {
        checkoutPage.confirmOrder();
    }

    @Then("User should see order confirmation message")
    public void user_should_see_order_confirmation_message() {
        Assert.assertTrue(checkoutPage.verifyOrderSuccess(), "Order success message not displayed");
    }

    @Then("User logs out")
    public void user_logs_out() {
        checkoutPage.logout();
        driver.quit();
    }
}


