package com.nopcommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ElectronicsPage {
    WebDriver driver;
    WebDriverWait wait;

    By electronicsMenu = By.linkText("Electronics");
    By cellPhonesLink = By.linkText("Cell phones");

    public ElectronicsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToCellPhones() {
        wait.until(ExpectedConditions.elementToBeClickable(electronicsMenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(cellPhonesLink)).click();
    }
}
