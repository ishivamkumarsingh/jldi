package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(xpath = "//a[text()='Login']")
    private WebElement loginLink;

    @FindBy(id = "email") // Assuming 'email' is the input field ID
    private WebElement usernameField;

    @FindBy(id = "password") // Assuming 'password' is the input field ID
    private WebElement passwordField;

    @FindBy(id = "login") // Assuming 'login' is the button ID
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id='page']/div[2]/div/div/div/div/div/div[1]/h1")
    private WebElement myCoursesHeader;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLoginLink() {
        loginLink.click();
    }

    public void enterUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public boolean isLoginSuccessful() {
        return myCoursesHeader.isDisplayed();
    }
}
