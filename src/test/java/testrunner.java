import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = {
//        "src/test/resources/features/price.feature",
//        "src/test/resources/features/GD.feature",
//        "src/test/resources/features/headerverification.feature",
//        "src/test/resources/features/SignIn.feature",
//        "src/test/resources/features/SwitchAlert.feature",
//        "src/test/resources/features/radiobutton.feature",
//        "src/test/resources/features/verifyname.feature",
//        "src/test/resources/features/search.feature"
    		 "src/test/resources/features/elementverify.feature"
    		
       

        
        
    }, 
    glue = {"stepdefinition", "utility", "pageobjects"}, 
    plugin = {
        "pretty",
        "html:target/cucumber-html-report.html",
        "json:target/cucumber-report.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", // Extent Reports adapter
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" // Allure adapter
    },
    monochrome = true
)
public class testrunner extends AbstractTestNGCucumberTests {
    // No additional implementation needed unless parallel execution is required.
}
