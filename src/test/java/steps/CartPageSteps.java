package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.PageFactory;
import utils.CommonMethods;
import utils.TestContext;

public class CartPageSteps {

    PageFactory factory = new PageFactory();
    TestContext wbs = TestContext.getTestContext();
    CommonMethods methods = new CommonMethods(wbs.getDriver());

    @Given("User navigates to the Cart Page")
    public void navigate_to_the_cart_page(){
        factory.getHomePage().getShoppingCartButton().click();
    }
    @When("^User removes a specific product(.*) by clicking Remove Button$")
    public void click_on_remove_button(String productName){
        factory.getCartPage().removeProductFromCart(productName);
    }
    @Then("^User should no longer see the deleted product(.*) in the shopping cart$")
    public void deleted_product_validation(String productName){
        WebElement product = factory.getCartPage().getCartProductByName(productName);
        Assert.assertFalse(product.isDisplayed());
    }
    @And("User clicks on Checkout button")
    public void user_clicks_on_checkout_button(){
        factory.getCartPage().getCheckOutButton().click();
    }
    @And("User clicks on Continue button")
    public void user_clicks_on_continue_button(){
        factory.getCartPage().getContinueButton().click();
    }

    @And("^User fills CheckOut Form with his/her first name(.*) , last name(.*) and zip code(.*)$")
    public void user_fills_checkout_form(String firstName, String lastName, String zipCode){
        WebDriverWait wait = new WebDriverWait(wbs.getDriver(), 1);
        factory.getCartPage().performCheckout(firstName,lastName,zipCode);
    }
    @When("User clicks Finish button")
    public void user_clicks_on_finish_button(){
        WebDriverWait wait = new WebDriverWait(wbs.getDriver(), 2);
        factory.getCartPage().getFinishButton().click();
    }
    @Then("User should see the Order Confirmation Page")
    public void order_confirmation_page(){
        methods.validatePage("https://www.saucedemo.com/checkout-complete.html");
    }

}
