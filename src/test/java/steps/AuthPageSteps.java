package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.PageFactory;
import utils.CommonMethods;
import utils.TestContext;

public class AuthPageSteps {

    PageFactory factory = new PageFactory();
    TestContext wbs = TestContext.getTestContext();
    CommonMethods methods;

    @Given("Navigate to the Landing Page")
    public void navigate_to_landing_page() {
        factory.getAuthPage().navigateTo();
    }

    @When("^I enter username (.*) and password (.*)$")
    public void fill_in_login_form(String username, String password) {
        factory.getAuthPage().fillInLogInForm(username, password);
    }

    @And("The user clicks on LogIn button")
    public void user_clicks_logIn_button() {
        factory.getAuthPage().getLogInButton().click();
    }

    @Then("User is able to access the Home Page")
    public void user_accesses_home_page() {
        methods.validatePage("https://www.saucedemo.com/inventory.html");
    }

    @Then("^User should see an error (.*) message$")
    public void error_message(String error) {
        String errorMsg = factory.getAuthPage().getErrorMessage();
        Assert.assertEquals(error, errorMsg);
    }
}
