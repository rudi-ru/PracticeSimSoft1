package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerPage extends BasePage{

    public CustomerPage(WebDriver webDriver) {
        super(webDriver);
    }

    String xpathFirstName = "//tr[@ng-repeat='cust in Customers | orderBy:sortType:sortReverse " +
                       "| filter:searchCustomer']/td[text()='" + AddCustomerPage.account +  "']";

    String xpathLastName = "//tr[@ng-repeat='cust in Customers | orderBy:sortType:sortReverse " +
                      "| filter:searchCustomer']/td[text()='" + AddCustomerPage.lastName + "']";

    String xpathPostCode = "//tr[@ng-repeat='cust in Customers | orderBy:sortType:sortReverse " +
                           "| filter:searchCustomer']/td[text()='" + AddCustomerPage.postCode +"']";

    // переделать
    String xpathDeleteButoon = "//tr[@ng-repeat='cust in Customers | orderBy:sortType:sortReverse " +
                               "| filter:searchCustomer']//button[text()='Delete']";

    @FindBy(xpath = "//button[@ng-click='showCust()']")
    WebElement openCustomerButton;

    @FindBy(xpath = "//a[@ng-click=\"sortType = 'fName'; sortReverse = !sortReverse\" and text()='First Name']")
    WebElement firstColumnName;

    public CustomerPage clickCustomerPage() {
        openCustomerButton.click();
        return this;
    }

    public CustomerPage deleteUser() {

        return this;
    }

    public CustomerPage sortByFirstName() {
        firstColumnName.click();
        return this;
    }




}
