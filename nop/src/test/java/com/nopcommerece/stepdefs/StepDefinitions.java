package com.nopcommerce.stepdefinitions;

import com.nopcommerce.pages.*;
import com.nopcommerce.util.WebDriverUtil;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class StepDefinitions {
    private WebDriver driver;
    private LoginPage loginPage;
    private ElectronicsPage electronicsPage;
    private CellPhonesPage cellPhonesPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private ProductPage productPage;

    @Given("User launches the nopCommerce website")
    public void user_launches_nopcommerce_website() {
        driver = WebDriverUtil.getDriver();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("nopcommerce.com"), "Failed to navigate to nopCommerce website");
    }

    @When("User logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {
        loginPage = new LoginPage(driver);
        loginPage.clickLoginLink();
        // Replace with your actual email and password
        String testEmail = "test@example.com";
        String testPassword = "Password123";
        
        loginPage.enterEmail(testEmail);
        loginPage.enterPassword(testPassword);
        loginPage.clickLoginButton();
        
        // Assert successful login (verify "My account" link is visible)
        Assert.assertTrue(driver.getPageSource().contains("My account"), 
                "Login was not successful");
    }

    @When("User navigates to Electronics -> Cell Phones")
    public void user_navigates_to_electronics_cell_phones() {
        electronicsPage = new ElectronicsPage(driver);
        electronicsPage.navigateToCellPhones();
        
        // Assert navigation to Cell phones page
        Assert.assertTrue(driver.getPageSource().contains("Cell phones"), 
                "Failed to navigate to Cell phones page");
    }

    @When("User selects the third product and adds to cart")
    public void user_selects_third_product_and_adds_to_cart() {
        cellPhonesPage = new CellPhonesPage(driver);
        cellPhonesPage.selectThirdProduct();
        
        // Create ProductPage for the product detail page
        productPage = new ProductPage(driver);
        productPage.addToCart();
        
        // Assert product added to cart message
        Assert.assertTrue(productPage.isProductAddedMessageDisplayed(), 
                "Product added to cart message not displayed");
    }

    @When("User goes to the shopping cart")
    public void user_goes_to_the_shopping_cart() {
        cartPage = new CartPage(driver);
        cartPage.openCart();
        
        // Assert navigation to shopping cart
        Assert.assertTrue(driver.getPageSource().contains("Shopping cart"), 
                "Failed to navigate to Shopping cart");
    }

    @When("User selects Yes for Gift Wrapping and proceeds to checkout")
    public void user_selects_yes_for_gift_wrapping_and_proceeds_to_checkout() {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.selectGiftWrapping();
        checkoutPage.agreeToTerms();
        checkoutPage.proceedToCheckout();
        
        // Assert navigation to checkout page
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout"), 
                "Failed to navigate to checkout page");
    }

    @When("User fills required fields and confirms the order")
    public void user_fills_required_fields_and_confirms_the_order() {
        // Fill billing address if needed (if not pre-filled from account)
        checkoutPage.fillBillingAddress();
        
        // Choose shipping method if needed
        checkoutPage.selectShippingMethod();
        
        // Choose payment method if needed
        checkoutPage.selectPaymentMethod();
        
        // Payment information if needed
        checkoutPage.enterPaymentInformation();
        
        // Confirm order
        checkoutPage.confirmOrder();
    }

    @Then("User should see order confirmation message")
    public void user_should_see_order_confirmation_message() {
        Assert.assertTrue(checkoutPage.verifyOrderSuccess(), 
                "Order success message not displayed");
    }

    @Then("User logs out")
    public void user_logs_out() {
        checkoutPage.logout();
        
        // Assert successful logout
        Assert.assertTrue(driver.getPageSource().contains("Log in"), 
                "Logout was not successful");
    }
}
