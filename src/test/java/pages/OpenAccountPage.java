package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.Wait.waitUntilClickable;

public class OpenAccountPage extends BasePage{
    final String xpathUserAccount = "//select[@id='userSelect']/option[text()='" + AddCustomerPage.account + "']"; // "option.ng-binding.ng-scope:contains('')";


    @FindBy(css = "button.btn:nth-child(2)")
    WebElement openAccount;

    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement userSelect;


    public OpenAccountPage(WebDriver webDriver) {
        super(webDriver);
    }



    @Step("Wait until form Open Account is open")
    public OpenAccountPage waitUntilOpen() {
        openAccount.click();
        waitUntilClickable(driver, userSelect);
        return this;
    }

    @Step("Choose added user")
    public OpenAccountPage chooseUser() {
        if (userSelect.isDisplayed()) {
            userSelect.click();
            driver.findElement(By.xpath(xpathUserAccount)).click();
        }
        return this;
    }

//    @Step("Add First Name")
//    public OpenAccountPage addFirstName() {
//        firstNameField.sendKeys(firstName);
//        return this;
//    }
//
//    @Step("Add Last Name")
//    public OpenAccountPage addLastName() {
//        lastNameField.sendKeys("zxcvv");
//        return this;
//    }
//
//    @Step("Click button \"Add Cuctomer\"")
//    public AddCustomerPage clickAddCustomerButton() {
//        addCustomerButton.click();
//        return this;
//    }

}
