package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.CommonMethods;
import utils.TestContext;

@Getter
public class CartPage {
    TestContext wbs = TestContext.getTestContext();
    public CommonMethods methods = new CommonMethods();

    public CartPage() {
        PageFactory.initElements(wbs.getDriver(), this);
    }


    @FindBy(id = "react-burger-menu-btn")
    private WebElement topLeftMenuButton;


    @FindBy(xpath = "//a[contains(text(),'All Items')]")
    private WebElement allItemsButton;

    @FindBy(xpath = "//a[contains(text(),'About')]")
    private WebElement aboutButton;

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    private WebElement logOutButton;

    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCartButton;

    @FindBy(id = "continue-shopping")
    private WebElement continueShoppingButton;

    @FindBy(id = "checkout")
    private WebElement checkOutButton;

    @FindBy(xpath = "//a[contains(text(),'Twitter')]")
    private WebElement twitterButton;

    @FindBy(xpath = "//a[contains(text(),'Facebook')]")
    private WebElement facebookButton;

    @FindBy(xpath = "//a[contains(text(),'LinkedIn')]")
    private WebElement linkedInButton;

    @FindBy(xpath = "//div/button[@id='finish']")
    private WebElement finishButton;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastNameField;


    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement zipCodeField;


    public void logOut() {
        topLeftMenuButton.click();
        logOutButton.click();
    }

    public void navigateToAboutUsPage() {
        topLeftMenuButton.click();
        aboutButton.click();
        methods.validatePage("https://saucelabs.com/");
    }

    public void performCheckout(String firstName, String lastName, String zipCode) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        zipCodeField.sendKeys(zipCode);
        continueButton.click();
        finishButton.click();
    }

    public WebElement getCartProductByName(String productName){
        String xpath = "//div/div/div/a/div[contains(text(),'" + productName + "')]/ancestor::div[@class='cart_item']";
        WebElement productContainer = wbs.getDriver().findElement(By.xpath(xpath));
        WebElement product = productContainer.findElement(By.className("inventory_item_name"));
        return product;
    }

    public void removeProductFromCart(String productName) {
        WebElement productContainer = getCartProductByName(productName);
        WebElement removeButton = productContainer.findElement(By.xpath("//*[contains(text(),'Remove')]"));
        WebElement product = productContainer.findElement(By.className("inventory_item_name"));
        removeButton.click();
        Assert.assertFalse(product.isDisplayed());
    }

    public String getProductPriceByName(String productName) {
        WebElement productContainer = getCartProductByName(productName);
        String productPrice = productContainer.findElement(By.className("inventory_item_price")).getText();
        return productPrice;
    }


}

