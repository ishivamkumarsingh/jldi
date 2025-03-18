package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

    public static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            // Since you already have chromedriver.exe in the project root:
            // (assuming "chromedriver.exe" is at the same level as pom.xml)
            System.setProperty("webdriver.chrome.driver", 
                System.getProperty("user.dir") + "/chromedriver.exe");

            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
