package stepdefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.en.*;
import pageobjects.RadioButtonPage;
import utility.BaseClass;
import utility.Log4jConfig;

public class RadioButtonSteps {

    WebDriver driver = BaseClass.getDriver();
    RadioButtonPage radioButtonPage = new RadioButtonPage(driver);

    @When("I select the {string} radio button")
    public void i_select_the_radio_button(String radioButton) {
        if (radioButton.equalsIgnoreCase("BMW")) {
            radioButtonPage.selectBMWRadioButton();
        }
    }

    @Then("The {string} radio button should be selected")
    public void the_radio_button_should_be_selected(String radioButton) {
        boolean isSelected = radioButtonPage.isBMWSelected();
        Assert.assertTrue(isSelected, "The radio button '" + radioButton + "' was not selected!");
        Log4jConfig.info("here i tried to check the radio button");
    }
}
