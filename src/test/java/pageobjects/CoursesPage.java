package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CoursesPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//a[text()='ALL COURSES']") // ✅ Ensure XPath is correct
    private WebElement allCoursesLink;

    public CoursesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void clickAllCourses() {
        wait.until(ExpectedConditions.elementToBeClickable(allCoursesLink)).click();
    }

    public String getPageTitle() {
        return driver.getTitle().trim();
    }
}
