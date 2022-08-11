package utils;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.InputStream;
import java.util.Properties;

@Getter
public class BrowserDriverLoader {

    WebDriver driver;

    public WebDriver loadDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\projects\\chromedriver.exe");
        String browser = getBrowserName();
        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
            System.out.println("Chrome driver loaded");
            return driver;
        }

        driver = new ChromeDriver();
        System.out.println("Chrome driver loaded as default");
        return driver;
    }

    public String getBrowserName() {
        String systemBrowserProperty = getParameter();
        if (null != systemBrowserProperty)
            return systemBrowserProperty;
        else
            return getBrowserFromFile();
    }

    private String getParameter() {
        return System.getProperty("browser");
    }

    private String getBrowserFromFile() {
        Properties prop = new Properties();
        String propFileName = "properties/browser.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        try {
            prop.load(inputStream);
        } catch (Exception e) {
            throw new Error("property file '" + propFileName + "' not found in the classpath");
        }
        return prop.getProperty("browser");
    }

}