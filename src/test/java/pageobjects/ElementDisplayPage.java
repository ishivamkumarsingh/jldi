package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ElementDisplayPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "hide-textbox") // ✅ "Hide" button
    private WebElement hideButton;

    @FindBy(id = "displayed-text") // ✅ Text field
    private WebElement textField;

    public ElementDisplayPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void clickHideButton() {
        wait.until(ExpectedConditions.elementToBeClickable(hideButton)).click();
    }

    public boolean isTextFieldDisplayed() {
        try {
            return textField.isDisplayed();
        } catch (Exception e) {
            return false; // If NoSuchElementException occurs, return false
        }
    }
}
