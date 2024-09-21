package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerPage extends BasePage{

    public CustomerPage(WebDriver webDriver) {
        super(webDriver);
    }

    public static String cssDeleteButton = "tr.ng-scope:nth-child(5) > td:nth-child(5) > button:nth-child(1)";

    @FindBy(xpath = "//button[@ng-click='showCust()']")
    WebElement openCustomerButton;

    @FindBy(xpath = "//a[@ng-click=\"sortType = 'fName'; sortReverse = !sortReverse\" and text()='First Name']")
    WebElement firstColumnName;

    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    WebElement searchCustomer;

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

    public CustomerPage sortByFirstName() {
        firstColumnName.click();
        return this;
    }




}
