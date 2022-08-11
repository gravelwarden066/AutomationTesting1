package pages;

import utils.TestContext;

import java.util.concurrent.TimeUnit;

public class AbstractPage {
    TestContext wbs = TestContext.getTestContext();

    public AbstractPage(TestContext wbs)  {
        this.wbs = wbs;
    }

    public AbstractPage() {
    }

    public void navigateTo(final String value) {
        wbs.getDriver().navigate().to(value);
        wbs.getDriver().manage().window().maximize();
        wbs.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public String pageTitle() {
        return wbs.getDriver().getTitle();
    }

}
