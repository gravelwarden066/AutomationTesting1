package utils;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.Set;


public class CommonMethods {

    WebDriver driver;

    public CommonMethods(WebDriver driver) {
        this.driver = driver;
    }

    public CommonMethods() {

    }

    public boolean isElementDisplayed(WebElement element) {
        boolean Presence = false;
        try {
            if (element.isDisplayed()) {
                Presence = true;
            }
        } catch (NoSuchElementException e) {
            System.out.println("element is not displayed");
        }
        return Presence;
    }

    public void hoverWebElement(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    public String getElementText(WebElement element) {
        return element.getText();
    }

    public void validatePage(String expectedURL) {
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURL);
    }
    public void newTabPageValidation(Set<String> pageTitle, String pageURL){
        pageTitle = driver.getWindowHandles();
        driver.switchTo().window(pageTitle.toString());
        validatePage(pageURL);
    }

    public void scrollToBottomOfThePage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    public String getXPathThatContainsText(String text){
        String xpath = "//*[contains(text(),'" + text + "')]";
        return xpath;
    }
    public void switchToTab(String name){}
}
