package utils;

import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;


public class TestContext {
    private static WebDriver driver;
    private Scenario scenario;
    private static TestContext testContext = null;

    private TestContext() {

    }

    public static TestContext getTestContext() {
        if (testContext == null) {
            testContext = new TestContext();
        }
        return testContext;
    }

    public void initDriver() {
        BrowserDriverLoader browserDriverLoader = new BrowserDriverLoader();
        browserDriverLoader.getBrowserName();
        driver = browserDriverLoader.loadDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public Scenario getScenario() {
        return scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

}
