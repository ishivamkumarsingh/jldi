package com.nopcommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckoutPage {
    WebDriver driver;
    WebDriverWait wait;

    // Locators
    By giftWrappingSelect = By.id("checkout_attribute_1");
    By agreeTermsCheckbox = By.id("termsofservice");
    By checkoutButton = By.id("checkout");
    By firstNameField = By.id("BillingNewAddress_FirstName");
    By lastNameField = By.id("BillingNewAddress_LastName");
    By emailField = By.id("BillingNewAddress_Email");
    By countryDropdown = By.id("BillingNewAddress_CountryId");
    By stateDropdown = By.id("BillingNewAddress_StateProvinceId");
    By cityField = By.id("BillingNewAddress_City");
    By address1Field = By.id("BillingNewAddress_Address1");
    By zipCodeField = By.id("BillingNewAddress_ZipPostalCode");
    By phoneNumberField = By.id("BillingNewAddress_PhoneNumber");
    By continueButton = By.xpath("//button[contains(@class,'new-address-next-step-button')]");
    By shippingMethodContinueButton = By.xpath("//button[contains(@class,'shipping-method-next-step-button')]");
    By paymentMethodContinueButton = By.xpath("//button[contains(@class,'payment-method-next-step-button')]");
    By paymentInfoContinueButton = By.xpath("//button[contains(@class,'payment-info-next-step-button')]");
    By confirmButton = By.xpath("//button[contains(@class,'confirm-order-next-step-button')]");
    By successMessage = By.xpath("//div[@class='page-body checkout-data']//strong[contains(text(),'Your order has been successfully processed')]");
    By logoutButton = By.linkText("Log out");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectGiftWrapping() {
        WebElement giftWrapDropdown = wait.until(ExpectedConditions.elementToBeClickable(giftWrappingSelect));
        Select select = new Select(giftWrapDropdown);
        select.selectByVisibleText("Yes [+$10.00]");
    }

    public void agreeToTerms() {
        wait.until(ExpectedConditions.elementToBeClickable(agreeTermsCheckbox)).click();
    }

    public void proceedToCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
    }

    public void fillBillingAddress() {
        // Check if form is already filled (registered user might have saved address)
        try {
            // Try to click continue button directly
            WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(continueButton));
            continueBtn.click();
            return;
        } catch (Exception e) {
            // Form needs to be filled
        }

        // Fill in billing address details if fields are empty
        if (driver.findElements(firstNameField).size() > 0 && 
            driver.findElement(firstNameField).getAttribute("value").isEmpty()) {
            driver.findElement(firstNameField).sendKeys("Test");
            driver.findElement(lastNameField).sendKeys("User");
            driver.findElement(emailField).sendKeys("test@example.com");
            
            // Select country
            Select countrySelect = new Select(driver.findElement(countryDropdown));
            countrySelect.selectByVisibleText("United States");
            
            // Wait for state dropdown to be populated
            wait.until(ExpectedConditions.elementToBeClickable(stateDropdown));
            
            // Select state
            Select stateSelect = new Select(driver.findElement(stateDropdown));
            stateSelect.selectByVisibleText("California");
            
            driver.findElement(cityField).sendKeys("Los Angeles");
            driver.findElement(address1Field).sendKeys("123 Test Street");
            driver.findElement(zipCodeField).sendKeys("90001");
            driver.findElement(phoneNumberField).sendKeys("1234567890");
        }
        
        // Click continue
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }

    public void selectShippingMethod() {
        // Default shipping method is usually pre-selected
        wait.until(ExpectedConditions.elementToBeClickable(shippingMethodContinueButton)).click();
    }

    public void selectPaymentMethod() {
        // Default payment method is usually pre-selected
        wait.until(ExpectedConditions.elementToBeClickable(paymentMethodContinueButton)).click();
    }

    public void enterPaymentInformation() {
        // Payment information page - depends on payment method
        // For most default methods like "Check/Money Order" or "COD", just continue
        try {
            wait.until(ExpectedConditions.elementToBeClickable(paymentInfoContinueButton)).click();
        } catch (Exception e) {
            // Some payment methods might not have a payment info page
        }
    }

    public void confirmOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmButton)).click();
    }

    public boolean verifyOrderSuccess() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).isDisplayed();
    }

    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }
}
