package com.nopcommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductPage {
    WebDriver driver;
    WebDriverWait wait;

    // Locators
    By addToCartButton = By.xpath("//button[contains(@class,'add-to-cart-button')]");
    By productAddedMessage = By.xpath("//div[contains(@class,'bar-notification-success')]");
    By goToCartButton = By.xpath("//button[contains(text(),'Go to cart')]");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

    public boolean isProductAddedMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productAddedMessage)).isDisplayed();
    }

    public void goToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(goToCartButton)).click();
    }
}
