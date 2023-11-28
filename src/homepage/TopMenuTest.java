package homepage;
/*
 * 1. create class "TopMenuTest"
 * 1.1 create method with name "selectMenu" it has one parameter name "menu" of type
 * string
 * 1.2 This method should click on the menu whatever name is passed as parameter.
 * Write the following Test:
 * 1. verifyUserShouldNavigateToDesktopsPageSuccessfully()
 * 1.1 Mouse hover on “Desktops” Tab and click
 * 1.2 call selectMenu method and pass the menu = “Show All Desktops”
 * 1.3 Verify the text ‘Desktops’
 * 2. verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully()
 * 2.1 Mouse hover on “Laptops & Notebooks” Tab and click
 * 2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
 * 2.3 Verify the text ‘Laptops & Notebooks’
 * 3. verifyUserShouldNavigateToComponentsPageSuccessfully()
 * 3.1 Mouse hover on “Components” Tab and click
 * 3.2 call selectMenu method and pass the menu = “Show All Components”
 * 3.3 Verify the text ‘Components’
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp(){

        openBrowser(baseUrl);
    }
//    public void selectMenu(String menu) {
//        WebElement menu1 = driver.findElement(By.linkText(menu));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(menu1).click().perform();
//    }

//    public void selectMenu(String menu){
//        String exp = String.format("//a[text()='%s']", menu) ;
//        driver.findElement(By.xpath(exp)).click();
//    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
        //Mouse hover on “Desktops” Tab and click
        mouseHoverToElementAndClick(By.xpath("//a[normalize-space()='Desktops']"));
        //call selectMenu method and pass the menu = “Show All Desktops”
        selectMenu("Show AllDesktops");
        //Verify the text ‘Desktops’
        verifyText(By.xpath("//h2[normalize-space()='Desktops']"),"Desktops");

    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){

        //Mouse hover on “Laptops & Notebooks” Tab and click
        mouseHoverToElement(By.xpath("//a[text()='Laptops & Notebooks']"));

        //call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        selectMenu("Show AllLaptops & Notebooks");

        //Verify the text ‘Laptops & Notebooks’
        verifyText(By.xpath("//h2[normalize-space()='Laptops & Notebooks']"),"Laptops & Notebooks");

    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){

        //Mouse hover on “Components” Tab and click
        mouseHoverToElement(By.xpath("//a[text()='Components']"));

        //call selectMenu method and pass the menu = “Show All Components”
        selectMenu("Show AllComponents");

        // Verify the text
        verifyText(By.xpath("//a[normalize-space()='Components']"),"Components");
    }

    @After
    public void teardown(){
        closeBrowser();
    }
}
