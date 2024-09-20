package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static helpers.Wait.*;

public class OpenAccountPage extends BasePage {

    final String xpathUserAccount = "//select[@id='userSelect']/option[text()='" + AddCustomerPage.account + "']";

    @FindBy(css = "button.btn:nth-child(2)")
    WebElement openAccount;

    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement userSelect;

    @FindBy(xpath = "//select[@id='currency']")
    WebElement currencySelect;

    @FindBy(xpath = "//button[@type='submit' and text()='Process']")
    WebElement addProcessButton;


    public OpenAccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Wait until form Open Account is open")
    public OpenAccountPage waitUntilOpen() {
        openAccount.click();
        return this;
    }

    @Step("Choose added user")
    public OpenAccountPage chooseUser() {
        waitUntilVisible(driver, userSelect);
        userSelect.click();
        waitThenClick(driver, driver.findElement(By.xpath(xpathUserAccount)));
        driver.findElement(By.xpath(xpathUserAccount)).click();
        return this;
    }

    @Step("Choose currency")
    public OpenAccountPage chooseCurrency() {
        currencySelect.click();
        currencySelect.sendKeys(Keys.DOWN);
        currencySelect.sendKeys(Keys.ENTER);
        return this;
    }


    @Step("Click button Pocess")
    public OpenAccountPage clickProcessButton() {
        addProcessButton.click();
        return this;
    }

}
