package pages;

import helpers.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CustomerPage extends BasePage {

    // Класс для работы с формой Customers
    public CustomerPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//button[@ng-click='showCust()']")
    WebElement openCustomerButton;

    @FindBy(xpath = "//a[@ng-click=\"sortType = 'fName'; sortReverse = !sortReverse\"]")
    WebElement firstColumnName;

    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    public WebElement searchCustomer;

    @FindBy(xpath = "//tbody//button[text()='Delete']")
    WebElement deleteButton;

    public CustomerPage clickCustomerPage() {
        openCustomerButton.click();
        return this;
    }

    public CustomerPage setTextToSearchCustomer(String text) {
        searchCustomer.click();
        searchCustomer.sendKeys(text);
        return this;
    }

    public CustomerPage deleteUser(String name) {
        setTextToSearchCustomer(name);
        Wait.waitUntilClickable(driver, deleteButton);
        deleteButton.click();
        searchCustomer.clear();
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
