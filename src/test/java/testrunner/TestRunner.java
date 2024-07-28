package testrunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        // Rerun failed tests from rerun.txt file
        plugin = {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/rerun.txt" },
        features = "src/test/resources/features/",
        glue = {"stepdefinitions", "hooks"},
        dryRun = true


)

public class TestRunner {
}
