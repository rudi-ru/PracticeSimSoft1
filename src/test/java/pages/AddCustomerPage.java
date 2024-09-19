package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.FirstNameGenerator.getFirstName;
import static helpers.PostCodeGenerator.getPostCode;
import static helpers.Wait.waitUntilVisible;

public class AddCustomerPage extends BasePage {

    final String postCode = getPostCode();
    final String firstName = getFirstName(postCode);

    @FindBy(xpath = "//div[@class='center']/button[@class='btn btn-lg tab'][1]")
    WebElement addCustomer;

    @FindBy(xpath = "//div[@class='form-group'][1]/input[@class='form-control ng-pristine ng-invalid ng-invalid-required ng-touched']")
    WebElement firstNameField;

    @FindBy(xpath = "//div[@class='form-group'][2]/input[@class='form-control ng-pristine ng-untouched ng-invalid ng-invalid-required']")
    WebElement lastNameField;

    @FindBy(xpath = "//div[@class='form-group'][3]/input[@class='form-control ng-pristine ng-invalid ng-invalid-required ng-touched']")
    WebElement postCodeField;

    public AddCustomerPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean izFormOpen() {
        addCustomer.click();
        waitUntilOpen();
        return postCodeField.isDisplayed();
    }

    @Step("Wait until form Add Customer is open")
    public AddCustomerPage waitUntilOpen() {
        waitUntilVisible(driver, postCodeField);
        return this;
    }

    @Step("Add Post Code")
    public AddCustomerPage addPostCode() {
        if (izFormOpen() == true) {
            postCodeField.sendKeys(postCode);
        }
        return this;
    }

    @Step("Add First Name")
    public AddCustomerPage addFirstName(String postCode) {
        firstNameField.sendKeys(firstName);
        return this;
    }

    @Step("Add Last Name")
    public AddCustomerPage addLastName() {
        lastNameField.sendKeys("zxcvv");
        return this;
    }

}
