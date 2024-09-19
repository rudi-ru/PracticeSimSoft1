package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AddCustomerPage;
import pages.BasePage;

public class AddCustomerTest extends BaseTest{
    AddCustomerPage addCustomerPage;
    @BeforeTest
    public void openScreen(){
        basePage.open();
    }

    @Test
    public void ultrahernya() throws InterruptedException {
        addCustomerPage.waitUntilOpen()
                .addPostCode();
                //.addFirstName();

    }

}
