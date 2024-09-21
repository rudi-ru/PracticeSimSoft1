package pages;

import helpers.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class CustomerPage extends BasePage {

    public CustomerPage(WebDriver webDriver) {
        super(webDriver);
    }

    public static String cssDeleteButton = "tr.ng-scope:nth-child(5) > td:nth-child(5) > button:nth-child(1)";

    @FindBy(xpath = "//button[@ng-click='showCust()']")
    WebElement openCustomerButton;

    @FindBy(xpath = "//a[@ng-click=\"sortType = 'fName'; sortReverse = !sortReverse\"]")
    WebElement firstColumnName;

    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    WebElement searchCustomer;



    //public static boolean byAlphabet;

    public CustomerPage clickCustomerPage() {
        openCustomerButton.click();
        return this;
    }

    public CustomerPage clickSearchCustomer(String name) {
        searchCustomer.click();
        searchCustomer.sendKeys(name);
        return this;
    }

    public CustomerPage deleteUser() {
        driver.findElement(By.cssSelector(cssDeleteButton));
        return this;
    }

    public CustomerPage sortByClickFirstName() {
        firstColumnName.click();
        Wait.waitUntilVisible(driver, By.xpath("//tbody"));
        if (sortedByAlphabet(driver) == false) {
            firstColumnName.click();
        }
        return this;
    }

    public static boolean sortedByAlphabet(WebDriver driver) {
        List<WebElement> list = driver.findElements(By.xpath("//tbody"));
        boolean byAlphabet = false;
        if (!list.isEmpty()) {
            if (list.getFirst().getText().toLowerCase().startsWith("a")) {
                byAlphabet = true;
            } else byAlphabet = false;
        }
        return byAlphabet;
    }


}
