package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.FirstNameGenerator.getFirstName;
import static helpers.PostCodeGenerator.getPostCode;
import static helpers.Wait.waitUntilClickable;
import static helpers.Wait.waitUntilVisible;

public class AddCustomerPage extends BasePage {

    final String postCode = getPostCode();
    final String firstName = getFirstName(postCode);

    @FindBy(xpath = "//*[contains(text(), 'Add Customer')]")
    WebElement addCustomer ;


    @FindBy(xpath = "//div[@class='form-group']//input[@placeholder='First Name']")
    WebElement firstNameField;

    @FindBy(xpath = "//div[@class='form-group']//input[@placeholder='Last Name']")
    WebElement lastNameField;

    @FindBy(xpath = "//div[@class='form-group']//input[@placeholder='Post Code']")
    WebElement postCodeField;

    @FindBy(xpath = "//button[@type='submit' and text()='Add Customer']")
    WebElement addCustomerButton;


    public AddCustomerPage(WebDriver webDriver) {
        super(webDriver);
    }


    public boolean izFormOpen() {
        waitUntilOpen();
        addCustomer.click();

        return postCodeField.isDisplayed();
    }

    @Step("Wait until form Add Customer is open")
    public AddCustomerPage waitUntilOpen() {
        waitUntilClickable(driver, addCustomer);
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
    public AddCustomerPage addFirstName() {
        firstNameField.sendKeys(firstName);
        return this;
    }

    @Step("Add Last Name")
    public AddCustomerPage addLastName() {
        lastNameField.sendKeys("zxcvv");
        return this;
    }

    @Step("Click button \"Add Cuctomer\"")
    public AddCustomerPage clickAddCustomerButton() {
        addCustomerButton.click();
        return this;
    }

}
