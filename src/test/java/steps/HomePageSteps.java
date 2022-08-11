package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PageFactory;
import utils.CommonMethods;
import utils.TestContext;

import java.util.concurrent.TimeUnit;

public class HomePageSteps {

    PageFactory factory = new PageFactory();
    TestContext wbs = TestContext.getTestContext();
    CommonMethods methods = new CommonMethods(wbs.getDriver());


    @Given("User navigates to the Home Page")
    public void navigate_to_home_page() {
        factory.getAuthPage().navigateTo();
        factory.getAuthPage().performLogIn("standard_user", "secret_sauce");
    }

    @When("^User clicks on a specific product (.*)$")
    public void click_on_a_specific_product(String name) {
        factory.getHomePage().getProductByKeyWord(name);
    }

    @And("^User adds to cart product1 (.*)$")
    public void add_product1_to_cart(String name) {
        factory.getHomePage().addProductToCartByName(name);
        factory.getHomePage().navigateTo();
    }

    @And("^User adds to cart product2 (.*)$")
    public void add_product2_to_cart(String name) {
        factory.getHomePage().addProductToCartByName(name);
        factory.getHomePage().navigateTo();
    }

    @And("User clicks on Twitter button")
    public void click_twitter_button(){
        methods.scrollToBottomOfThePage();
        factory.getHomePage().getTwitterButton().click();
    }

    @And("User clicks on Facebook button")
    public void click_facebook_button(){
        methods.scrollToBottomOfThePage();
        factory.getHomePage().getFacebookButton().click();
    }

    @And("User clicks on LinkedIn button")
    public void click_linkedin_button(){
        methods.scrollToBottomOfThePage();
        factory.getHomePage().getLinkedInButton().click();
    }

    @Then("User should be on Twitter page")
    public void twitter_page_validation(){
        wbs.getDriver().getWindowHandles();
        wbs.getDriver().switchTo().window("Sauce Labs (@saucelabs) / Twitter");
        methods.validatePage("https://twitter.com/saucelabs");
    }

    @Then("User should be on Facebook page")
    public void facebook_page_validation(){
        methods.validatePage("https://www.facebook.com/saucelabs");
    }

    @Then("User should be on LinkedIn page")
    public void linkedin_page_validation(){
        methods.validatePage("https://www.linkedin.com/company/sauce-labs/");
    }

    @Then("User navigates to the Shopping Cart and should see product1 (.*) and product2 (.*)$")
    public void navigate_to_the_shopping_cart(String product1, String product2) {
        factory.getHomePage().getShoppingCartButton().click();
        factory.getHomePage().validateProduct(product1);
        factory.getHomePage().validateProduct(product2);
    }

}
