package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AccountPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//*[@id='email']") // ✅ XPath stays here
    private WebElement emailField;

    @FindBy(xpath = "//*[@id='login-password']") // ✅ XPath stays here
    private WebElement passwordField;

    @FindBy(xpath = "//button[contains(text(),'Login')]") 
    private WebElement loginButton;

    @FindBy(id = "address") 
    private WebElement addressField;

    @FindBy(id = "zipcode") 
    private WebElement zipCodeField;

    @FindBy(xpath = "//button[contains(text(),'Update')]") 
    private WebElement updateButton;

    @FindBy(xpath = "//*[contains(text(),'Profile updated successfully')]")
    private WebElement successMessage;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailField)).clear();
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField)).clear();
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public void waitForFormToLoad() {
        wait.until(ExpectedConditions.visibilityOf(addressField));
    }

    public void enterAddress(String address) {
        wait.until(ExpectedConditions.visibilityOf(addressField)).clear();
        addressField.sendKeys(address);
    }

    public void enterZipCode(String zipCode) {
        wait.until(ExpectedConditions.visibilityOf(zipCodeField)).clear();
        zipCodeField.sendKeys(zipCode);
    }

    public void clickUpdateButton() {
        wait.until(ExpectedConditions.elementToBeClickable(updateButton)).click();
    }

    public boolean isUpdateSuccessful() {
        return wait.until(ExpectedConditions.visibilityOf(successMessage)).isDisplayed();
    }
}
