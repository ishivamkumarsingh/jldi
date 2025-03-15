package com.nopcommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CellPhonesPage {
    WebDriver driver;
    WebDriverWait wait;

    By thirdProduct = By.xpath("(//div[@class='product-item'])[3]//a");
    By addToCartButton = By.xpath("(//button[contains(text(),'Add to cart')])[3]");

    public CellPhonesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectThirdProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(thirdProduct)).click();
    }

    public void addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }
}


