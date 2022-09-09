package pages.testpages;


import org.openqa.selenium.support.PageFactory;
import pages.AbstractPage;
import utils.CommonMethods;
import utils.TestContext;

//This Page Object is created for testing individual pages (TEMPORARY FEATURE)
public class TestPage extends AbstractPage {

    TestContext wbs =  TestContext.getTestContext();
    public CommonMethods methods = new CommonMethods();
    private String testURL = "";

    public TestPage() {
        PageFactory.initElements(wbs.getDriver(), this);
    }
    public void navigateTo(){ navigateTo(testURL);
    }


}
