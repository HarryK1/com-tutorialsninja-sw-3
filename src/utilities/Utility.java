package utilities;
/*
 * Create the package utilities and create the class with the name ‘Utility’ inside the ‘utilities’
 * package. And write the all the utility methods in it’.
 */

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
    //this method will click on method
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    //this method will enter the input into Text Field
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    //this method will Get Text from Element
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    // Verify text from Element
    public void verifyText(By by, String text) {
        String expectedText = text;
        String actualText = getTextFromElement(by);
        Assert.assertEquals(expectedText, actualText);

    }

    //this method will select the option by visible text

    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByVisibleText(text);
    }

    //this method will select the option by visible value
    public void selectByValueFromDropDown(By by, String value) {
        new Select(driver.findElement(by)).selectByValue(value);
    }

    //select By Index (int index)
    public void selectByIndex(By by, int index) {
        new Select(driver.findElement(by)).selectByIndex(index);
    }

    //selectOptionByContainsText
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        WebElement computer = driver.findElement(by);
        WebElement software = driver.findElement(by);
        //mouse hover to computers
        actions.moveToElement(computer).build().perform();
    }

    //mouseHoverToElementAndClick
    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        WebElement computer = driver.findElement(by);
        WebElement software = driver.findElement(by);
        //click on software in computer
        actions.moveToElement(software).click().build().perform();
    }

    //this method is used to select radio button
    public void selectRadioButton(By by) {
        driver.findElement(by).click();
    }

    //this method is used to select checkBox
    public void selectCheckBox(By by) {
        WebElement checkBox = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(checkBox);
        actions.perform();
        if (checkBox.isSelected()) {

        } else {
            checkBox.click();
        }

    }
    //1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
    public void selectMenu(String menu) {
        // * 1.2 This method should click on the menu whatever name is passed as parameter.
        WebElement menuList = driver.findElement(By.linkText(menu));
        Actions actions = new Actions(driver);
        actions.moveToElement(menuList).click().build().perform();
    }

    }



