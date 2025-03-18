package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadioButtonPage {

    WebDriver driver;

    @FindBy(id = "bmwradio")
    private WebElement bmwRadioButton;

    public RadioButtonPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectBMWRadioButton() {
        if (!bmwRadioButton.isSelected()) {
            bmwRadioButton.click();
        }
    }

    public boolean isBMWSelected() {
        return bmwRadioButton.isSelected();
    }
}
