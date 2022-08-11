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
public class AuthPage extends AbstractPage{

    TestContext wbs =  TestContext.getTestContext();
    public CommonMethods commonMethods = new CommonMethods();

    public AuthPage() {
        PageFactory.initElements(wbs.getDriver(), this);
    }
    public void navigateTo() {
        navigateTo("https://www.saucedemo.com/");
    }

    @FindBy(id = "user-name")
    private WebElement userNameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement logInButton;

    public void fillInLogInForm(String username, String password) {
        userNameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    public void performLogIn(String username, String password) {
        fillInLogInForm(username, password);
        logInButton.click();
    }

    public String getErrorMessage(){
        WebElement errorBox = wbs.getDriver().findElement(By.className("error-message-container"));
        final String text = errorBox.getText();
        return text;
    }
}
