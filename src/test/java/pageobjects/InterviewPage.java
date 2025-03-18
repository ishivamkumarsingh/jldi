package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class InterviewPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//*[@id='cu-form-1687049812970']/div/a/p") // ✅ XPath for the price
    private WebElement priceElement;

    public InterviewPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public String getPrice() {
        wait.until(ExpectedConditions.visibilityOf(priceElement));
        return priceElement.getText().trim();
    }
}
