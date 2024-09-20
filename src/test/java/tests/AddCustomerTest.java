package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AddCustomerPage;
import pages.BasePage;
import pages.OpenAccountPage;
import pages.elements.BurgerHomeElement;

import static org.openqa.selenium.Keys.ENTER;

public class AddCustomerTest extends BaseTest {
    AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
    OpenAccountPage openAccountPage = new OpenAccountPage(driver);


    @BeforeTest
    public void openScreen() {
        basePage.open();
    }

    @Test
    public void addCustomer() throws InterruptedException {

        addCustomerPage //enterForm();
                .waitUntilOpen()
                .addPostCode()
                .addFirstName()
                .addLastName()
                .clickAddCustomerButton();

        Alert alert = driver.switchTo().alert();
        alert.accept();


    }

    @Test
    public void openAccount() throws InterruptedException {
        openAccountPage
                .waitUntilOpen()
                .chooseUser()
                .chooseCurrency()
                .clickProcessButton();

        Alert alert = driver.switchTo().alert();
        alert.accept();

    }





    //    @AfterTest
//    public void clickHomeButton() {
//        burgerHomeElement.clickHomeButton();
//    }

}
