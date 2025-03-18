package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AllCoursesPage {

    private WebDriver driver;

    // Example locators (adjust for actual HTML)
    private By courseCards = By.xpath("//*[@id=\"course-list\"]"); 
    private By searchBox   = By.id("search");
    // Alternatively: By searchIcon = By.xpath("//button[@type='submit']");

    public AllCoursesPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean areCourseCardsDisplayed() {
        List<WebElement> cards = driver.findElements(courseCards);
        return !cards.isEmpty(); // returns true if at least 1 card is found
    }

    public void clickCourseCardByName(String courseName) {
        // For example, each card might have a heading or text matching courseName
        // We'll do a simple approach: find all cards, check their text, click if matches
        List<WebElement> cards = driver.findElements(courseCards);
        for (WebElement card : cards) {
            if (card.getText().contains(courseName)) {
                card.click();
                break;
            }
        }
    }

    public void enterSearchTerm(String term) {
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         // Wait for the element to be visible
         WebElement searchBoxElement = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
         // Scroll the element into view
         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchBoxElement);
         // Wait until the element is clickable
         searchBoxElement = wait.until(ExpectedConditions.elementToBeClickable(searchBox));
         try {
             searchBoxElement.clear();
             searchBoxElement.sendKeys(term);
         } catch (Exception e) {
             // Fallback: use JavaScript to set the value
             ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", searchBoxElement, term);
         }
    }

    public void pressEnterInSearchBox() {
        // You can do a simple .sendKeys(Keys.ENTER) or click a search icon
        driver.findElement(searchBox).submit();
    }

    public boolean verifySeleniumCourses(String term) {
        // Reuse the areCourseCardsDisplayed() or parse the card text 
        // to ensure it contains 'Selenium' or the search term
        List<WebElement> cards = driver.findElements(courseCards);
        for (WebElement card : cards) {
            if (card.getText().toLowerCase().contains(term.toLowerCase())) {
                return true; // Found at least one matching card
            }
        }
        return false;
    }
}