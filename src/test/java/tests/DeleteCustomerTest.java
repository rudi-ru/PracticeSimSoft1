package tests;

import helpers.SelectorCustomersToDelete;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CustomerPage;

import java.util.List;


public class DeleteCustomerTest extends BaseTest {
    CustomerPage customerPage = new CustomerPage(driver);


    @BeforeTest
    public void openScreen() {
        basePage.open();
    }

    @Test
    @Step("Searching and delete an account")
    public void checkAndDeleteCustomer() throws InterruptedException {
        customerPage.clickCustomerPage();
        String list = driver.findElement(By.xpath("//tbody")).getText();

        List<String> namesToDelete = SelectorCustomersToDelete.customersRemover(list);
        for (String nameToDelete : namesToDelete) {
            customerPage
                    .deleteUser(nameToDelete);
        }
    }

//    @Test
//    @Step("Select an account, select currency and click Process")
////    public void openAccount() throws InterruptedException {
//        openAccountPage
//                .waitUntilOpen()
//                .chooseUser()
//                .chooseCurrency()
//                .clickProcessButton();
//
//        Alert alert = driver.switchTo().alert();
//        alert.accept();
//    }
}
