package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.TestContext;
import java.io.IOException;

public class Hooks {


   TestContext wbs = TestContext.getTestContext();

    @Before
    public void loadFileProperty(Scenario scenario) throws IOException {
        wbs.initDriver();
        wbs.setScenario(scenario);
    }

    @After
    public void tearDown() {
        if (wbs.getDriver() != null) {
            wbs.getDriver().quit();
        }
    }
}
