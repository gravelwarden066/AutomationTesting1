package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.CommonMethods;
import utils.TestContext;

@Getter
public class HomePage extends AbstractPage{
    TestContext wbs =  TestContext.getTestContext();
    public CommonMethods methods = new CommonMethods();

    public HomePage() {
        PageFactory.initElements(wbs.getDriver(), this);
    }
    public void navigateTo() {
        navigateTo("https://www.saucedemo.com/inventory.html");
    }


    @FindBy(id = "react-burger-menu-btn")
    private WebElement topLeftMenuButton;

    @FindBy(className = "product_sort_container")
    private WebElement productSortDropdown;

    @FindBy(xpath = "//button[contains(text(),'Add to cart')]")
    private WebElement addToCartButton;

    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCartButton;

    @FindBy(xpath = "//a[contains(text(),'Twitter')]")
    private WebElement twitterButton;

    @FindBy(xpath = "//a[contains(text(),'Facebook')]")
    private WebElement facebookButton;

    @FindBy(xpath = "//a[contains(text(),'LinkedIn')]")
    private WebElement linkedInButton;

    public void validateProduct(String expectedProductName){
        String xpath = methods.getXPathThatContainsText(expectedProductName);
        WebElement product = wbs.getDriver().findElement(By.xpath(xpath));
        String actualProductName = product.getText();
        Assert.assertEquals(expectedProductName,actualProductName);
    }
    public WebElement getProductByName(String productName){
        String xpath = "//*[contains(text(),'" + productName + "')]/ancestor::div[@class='inventory_item']";
        WebElement productContainer = wbs.getDriver().findElement(By.xpath(xpath));
        WebElement product = productContainer.findElement(By.className("inventory_item_name"));
        return product;
    }
    public String getProductPriceByName(String productName) {
        WebElement productContainer = getProductByName(productName);
        String productPrice = productContainer.findElement(By.className("inventory_item_price")).getText();
        return productPrice;
    }
    public void addProductToCartByName(String productName){
        WebElement productContainer = getProductByName(productName);
        WebElement addToCartButton = productContainer.findElement(By.xpath("//button[contains(text(),'Add to cart')]"));
        addToCartButton.click();
    }
}
