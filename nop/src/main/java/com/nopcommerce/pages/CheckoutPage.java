package com.nopcommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckoutPage {
    WebDriver driver;
    WebDriverWait wait;

    By giftWrappingYes = By.id("giftwrap_1");
    By agreeTermsCheckbox = By.id("termsofservice");
    By checkoutButton = By.id("checkout");
    By confirmButton = By.xpath("//button[contains(text(),'Confirm')]");
    By successMessage = By.xpath("//strong[contains(text(),'Your order has been successfully processed')]");
    By logoutButton = By.linkText("Log out");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectGiftWrapping() {
        wait.until(ExpectedConditions.elementToBeClickable(giftWrappingYes)).click();
    }

    public void agreeToTerms() {
        wait.until(ExpectedConditions.elementToBeClickable(agreeTermsCheckbox)).click();
    }

    public void proceedToCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
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


