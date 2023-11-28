package desktops;
/*
 * 1. Create class “DesktopsTest”
 * Write the following Test:
 * 1.Test name verifyProductArrangeInAlphaBaticalOrder()
 * 1.1 Mouse hover on Desktops Tab.and click
 * 1.2 Click on “Show All Desktops”
 * 1.3 Select Sort By position "Name: Z to A"
 * 1.4 Verify the Product will arrange in Descending order.
 * 2. Test name verifyProductAddedToShoppingCartSuccessFully()
 *
 * 2.1 Mouse hover on Currency Dropdown and click
 * 2.2 Mouse hover on £Pound Sterling and click
 * 2.3 Mouse hover on Desktops Tab.
 * 2.4 Click on “Show All Desktops”
 * 2.5 Select Sort By position "Name: A to Z"
 * 2.6 Select product “HP LP3065”
 * 2.7 Verify the Text "HP LP3065"
 * 2.8 Select Delivery Date "2023-11-27"
 * 2.9.Enter Qty "1” using Select class.
 * 2.10 Click on “Add to Cart” button
 * 2.11 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
 * 2.12 Click on link “shopping cart” display into success message
 * 2.13 Verify the text "Shopping Cart"
 * 2.14 Verify the Product name "HP LP3065"
 * 2.15 Verify the Delivery Date "2023-11-27"
 * 2.16 Verify the Model "Product21"
 * 2.17 Verify the Todat "£74.73"
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class DesktopsTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder(){
        // Mouse hover on Desktops Tab.and click
        mouseHoverToElementAndClick(By.xpath("(//a[normalize-space()='Desktops'])[1]"));
        // Click on “Show All Desktops”
        clickOnElement(By.cssSelector("li[class='dropdown open'] a[class='see-all']"));
        // Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (Z - A)");
        // Verify the Product will arrange in Descending order.
        verifyText(By.xpath("//option[@value='https://tutorialsninja.com/demo/index.php?route=product/category&path=20&sort=pd.name&order=DESC']"), "Name (Z - A)");
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully(){
        // Mouse hover on Currency Dropdown and click
        mouseHoverToElementAndClick(By.xpath("(//i[@class='fa fa-caret-down'])[1]"));
        //Mouse hover on £Pound Sterling and click
        mouseHoverToElementAndClick(By.xpath("(//button[@class='currency-select btn btn-link btn-block'])[2]"));// or //button[normalize-space()='£Pound Sterling']
        //Mouse hover on Desktops Tab.
        mouseHoverToElement(By.xpath("//a[normalize-space()='Desktops']"));
        // Click on “Show All Desktops”
        clickOnElement(By.linkText("Show AllDesktops"));
        // Select Sort By position "Name: A to Z"
        //selectByVisibleTextFromDropDown(By.xpath("(//select[@id='input-sort'])[1]"), "Name: A to Z");
        //Select product “HP LP3065”
        clickOnElement(By.xpath("(//div[@class='image'])[3]"));
        // Verify the Text "HP LP3065"
        verifyText(By.xpath("(//h1[normalize-space()='HP LP3065'])[1]"), "HP LP3065");
        // Select Delivery Date "2023-11-27"
        String year = "2023";
        String month = "November";
        String date = "27";
        clickOnElement(By.xpath("//div[@class = 'input-group date']//button"));
        while (true) {
            String monthAndYear = driver.findElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")).getText();
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']"));
            }
        }
        List<WebElement> allDates = driver.findElements(By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']"));
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }
        //Enter Qty "1” using Select class.
        driver.findElement(By.id("input-quantity")).clear();
        sendTextToElement(By.id("input-quantity"), "1");
        // Click on “Add to Cart” button
        clickOnElement(By.xpath("//button[@id='button-cart']"));// id button-cart
        //Verify the Message “Success: You have added HP LP3065 to your shopping cart!"
        verifyText(By.xpath("//div[@class='alert alert-success alert-dismissible']"), "Success: You have added HP LP3065 to your shopping cart!\n" + "×");
        //Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        //Verify the text "Shopping Cart"
        verifyText(By.xpath("//h1[contains(text(),'Shopping Cart')]"), "Shopping Cart");
        //Verify the Product name "HP LP3065"
        verifyText(By.xpath("(//a[contains(text(),'HP LP3065')])[2]"), "HP LP3065");
        //Verify the Delivery Date "2023-11-27"
        verifyText(By.xpath("//small[normalize-space()='Delivery Date:2020-11-27']"), "2023-11-27");

        //Verify the Model "Product21"
        verifyText(By.xpath("(//td[normalize-space()='Product 21'])[1]"), "Product 21");
        //Verify the Total "£74.73"
        verifyText(By.xpath("(//td[contains(text(),'£74.73')])[4]"), "£74.73");
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}

