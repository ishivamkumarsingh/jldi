package stepdefinition;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import utility.BaseClass;

public class CommonSteps {
    WebDriver driver = BaseClass.getDriver();

    @Given("I am on the Let's Kode It practice page")
    public void i_am_on_the_lets_kode_it_practice_page() {
        driver.get("https://www.letskodeit.com/practice");
    }
}
