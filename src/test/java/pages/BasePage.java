package pages;

import helpers.PropertyProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) { //коструктор класса для определения драйвера
        this.driver = driver;
    }

    public WebDriver createDriver() {

        switch (PropertyProvider.getInstance().getProperty("browser.name")) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            default:
                Assert.fail("Incorrect platform or browser name: " +
                           PropertyProvider.getInstance().getProperty("browser.name"));
        }

        driver.manage().window().maximize();
        driver.manage().
               timeouts().
               implicitlyWait(Long.parseLong(PropertyProvider.getInstance().getProperty("page.load.timeout")), TimeUnit.SECONDS);
        return driver;
    }
}
