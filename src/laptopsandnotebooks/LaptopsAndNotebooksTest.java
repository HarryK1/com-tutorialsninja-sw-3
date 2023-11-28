package laptopsandnotebooks;
/*
 * Create the class LaptopsAndNotebooksTest
 * Write the following test
 * 1. Test name verifyProductsPriceDisplayHighToLowSuccessfully()
 * 1.1 Mouse hover on Laptops & Notebooks Tab.and click
 * 1.2 Click on “Show All Laptops & Notebooks”
 * 1.3 Select Sort By "Price (High > Low)"
 * 1.4 Verify the Product price will arrange in High to Low order.
 * 2. Test name verifyThatUserPlaceOrderSuccessfully()
 * 2.1 Mouse hover on Laptops & Notebooks Tab and click
 * 2.2 Click on “Show All Laptops & Notebooks”
 * 2.3 Select Sort By "Price (High > Low)"
 * 2.4 Select Product “MacBook”
 * 2.5 Verify the text “MacBook”
 * 2.6 Click on ‘Add To Cart’ button
 * 2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
 * 2.8 Click on link “shopping cart” display into success message
 * 2.9 Verify the text "Shopping Cart"
 * 2.10 Verify the Product name "MacBook"
 * 2.11 Change Quantity "2"
 * 2.12 Click on “Update” Tab
 * 2.13 Verify the message “Success: You have modified your shopping cart!”
 * 2.14 Verify the Total £737.45
 * 2.15 Click on “Checkout” button
 * 2.16 Verify the text “Checkout”
 * 2.17 Verify the Text “New Customer”
 *
 * 2.18 Click on “Guest Checkout” radio button
 * 2.19 Click on “Continue” tab
 * 2.20 Fill the mandatory fields
 * 2.21 Click on “Continue” Button
 * 2.22 Add Comments About your order into text area
 * 2.23 Check the Terms & Conditions check box
 * 2.24 Click on “Continue” button
 * 2.25 Verify the message “Warning: Payment method required!”
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LaptopsAndNotebooksTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        //Mouse hover on Laptops & Notebooks Tab.and click
        mouseHoverToElementAndClick(By.xpath("(//a[normalize-space()='Laptops & Notebooks'])[1]"));
        // Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
        // Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");
        //Verify the Product price will arrange in High to Low order.
        verifyText(By.xpath("//option[contains(text(),'Price (High > Low)')]"), "Price (High > Low)");

    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        //Mouse hover on Laptops & Notebooks Tab.and click
        mouseHoverToElementAndClick(By.xpath("(//a[normalize-space()='Laptops & Notebooks'])[1]"));
        // Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
        // Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");
        //Select Product “MacBook”
        clickOnElement(By.xpath("//a[normalize-space()='MacBook']"));//img[@title='MacBook'])[1]
        //Verify the text “MacBook”
        verifyText(By.xpath("//h1[contains(text(),'MacBook')]"), "MacBook");
        //Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        //Verify the message “Success: You have added MacBook to your shopping cart!”
        //verifyText(By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible"), "Success: You have added MacBook to your shopping cart!\n"+"×");
        verifyText(By.xpath("div[@class='alert alert-success alert-dismissible']"), "Success: You have added MacBook to your shopping cart!");
        //Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        //Verify the text "Shopping Cart"
        verifyText(By.cssSelector("div[id='content'] h1"), "Shopping Cart  (0.00kg)");
        //Verify the Product name "MacBook"
        verifyText(By.xpath("(//a[contains(text(),'MacBook')])[2]"), "MacBook");
        //Change Quantity "2"
        driver.findElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]")).clear();//quantity[79688] name
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"), "2");
        Thread.sleep(2000);
        //Click on “Update” Tab
        clickOnElement(By.xpath("//button[@data-original-title='Update']"));
        Thread.sleep(2000);
        //Verify the message “Success: You have modified your shopping cart!”
        verifyText(By.xpath("//div[@class='alert alert-success alert-dismissible']"), "Success: You have modified your shopping cart!\n"+"×");
        //Verify the Total £737.45
        verifyText(By.xpath("(//td[contains(text(),'£737.45')])[3]"), "£737.45");
        //Click on “Checkout” button
        clickOnElement(By.cssSelector("a[class='btn btn-primary']"));
        //Verify the text “Checkout”
        verifyText(By.xpath("//h1[normalize-space()='Checkout']"), "Checkout");
        //Verify the Text “New Customer”
        verifyText(By.xpath("(//h2[normalize-space()='New Customer']"), "New Customer");
        //Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//input[@value='guest']"));
        //Click on “Continue” tab
        clickOnElement(By.id("button-account"));
        //Fill the mandatory fields
        sendTextToElement(By.id("input-payment-firstname"),"Shawnyl");
        sendTextToElement(By.id("input-payment-lastname"),"Glenn");
        sendTextToElement(By.id("input-payment-email"),"shawnyyl@example.com");
        sendTextToElement(By.id("input-payment-telephone"),"9875290212");
        sendTextToElement(By.id("input-payment-address-1"),"12 Proctoer Close");
        sendTextToElement(By.id("input-payment-city"),"Coventry");
        sendTextToElement(By.id("input-payment-postcode"),"111115");
        selectByValueFromDropDown(By.id("input-payment-country"),"222");
        selectByValueFromDropDown(By.id("input-payment-zone"),"3523");
        //Click on “Continue” Button
        clickOnElement(By.id("button-guest"));
        // Add Comments About your order into text area
        sendTextToElement(By.xpath("//textarea[@name='comment']"), "Not Available");
        //Check the Terms & Conditions check box
        selectCheckBox(By.name("agree"));
        //Click on “Continue” button
        clickOnElement(By.id("button-payment-method"));
        //Verify the message “Warning: Payment method required!”
        verifyText(By.xpath("(//div[@class='alert alert-danger alert-dismissible'])[1]"), "Warning: Payment method required!");
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
