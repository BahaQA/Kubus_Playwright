package hooks;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Tracing;
import driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.BrowserUtils;

import java.nio.file.Paths;

public class Hooks {
    public Driver driver;
    public Page page;

    @Before
    public void launchBrowser() {
        String browserName = BrowserUtils.getProperty("browser");
        driver = new Driver();
        page = driver.getDriver(browserName);
    }

    //After runs in reverse order so order=1 will run first
    @After(order = 0)
    public void quitBrowser() {
        page.close();
    }

    @After(order = 1)
    public void takeScreenshotAndTrace(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll("", "_"); //Replace all space in scenario name with underscore
            byte[] sourcePath = page.screenshot();
            scenario.attach(sourcePath, "image/png", screenshotName);  //Attach screenshot to report if scenario fails
            Driver.context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("target/" + screenshotName + ".zip")));
        }
    }


}
