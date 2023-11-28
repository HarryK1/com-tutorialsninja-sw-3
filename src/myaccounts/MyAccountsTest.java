package myaccounts;
/*
 *1. Create the class MyAccountsTest
1.1 create method with name "selectMyAccountOptions" it has one parameter name
"option" of type string
1.2 This method should click on the options whatever name is passed as parameter.
(Hint: Handle List of Element and Select options)

Write the following test
1. Test name verifyUserShouldNavigateToRegisterPageSuccessfully()

1.1 Clickr on My Account Link.
1.2 Call the method “selectMyAccountOptions” method and pass the parameter
“Register”
1.3 Verify the text “Register Account”.

2. Test name verifyUserShouldNavigateToLoginPageSuccessfully()

2.1 Clickr on My Account Link.
2.2 Call the method “selectMyAccountOptions” method and pass the parameter
“Login”
2.3 Verify the text “Returning Customer”.

3. Test name verifyThatUserRegisterAccountSuccessfully()

3.1 Clickr on My Account Link.
3.2 Call the method “selectMyAccountOptions” method and pass the parameter
“Register”
3.3 Enter First Name
3.4 Enter Last Name
3.5 Enter Email
3.6 Enter Telephone
3.7 Enter Password
3.8 Enter Password Confirm
3.9 Select Subscribe Yes radio button
3.10 Click on Privacy Policy check box
3.11 Click on Continue button
3.12 Verify the message “Your Account Has Been Created!”
3.13 Click on Continue button

3.14 Clickr on My Account Link.
3.15 Call the method “selectMyAccountOptions” method and pass the parameter
“Logout”
3.16 Verify the text “Account Logout”
3.17 Click on Continue button

4. Test name verifyThatUserShouldLoginAndLogoutSuccessfully()

4.1 Clickr on My Account Link.
4.2 Call the method “selectMyAccountOptions” method and pass the parameter
“Login”
4.3 Enter Email address
4.4 Enter Last Name
4.5 Enter Password
4.6 Click on Login button
4.7 Verify text “My Account”
4.8 Clickr on My Account Link.
4.9 Call the method “selectMyAccountOptions” method and pass the parameter
“Logout”
4.10 Verify the text “Account Logout”
4.11 Click on Continue button
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;
import java.util.UUID;

public class MyAccountsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php";


    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }


    //1.1 create method with name "selectMyAccountOptions" it has one parameter name "option" of type string
    public void selectMyAccountOptions(String option) {

        // * 1.2 This method should click on the options whatever name is passed as parameter.
        List<WebElement> topMenuNames = driver.findElements((By.xpath("//ul[@class = 'list-inline']//a")));
        for (WebElement names : topMenuNames) {
            System.out.println(names.getText());
            if (names.getText().equalsIgnoreCase(option)) {
                names.click();
                break;
            }
        }
    }

    //create method with name "selectMyAccountOptions" it has one parameter name "option" of type string


    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){

        //Click on My Account Link
        clickOnElement(By.xpath("//span[text()='My Account']"));

        //Call the method “selectMyAccountOptions”
        selectMyAccountOptions("Register");

        //Verify the text “Register Account”
        verifyText(By.xpath("//h1[text()='Register Account']"), "Register Account");
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){

        //Click on My Account Link
        clickOnElement(By.xpath("//span[text()='My Account']"));

        //Call the method “selectMyAccountOptions”
        selectMyAccountOptions("Login");

        //Verify the text “Register Account”
        verifyText(By.xpath("//h2[text()='Returning Customer']"), "Returning Customer");
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {

        //Click on My Account Link
        clickOnElement(By.xpath("//span[text()='My Account']"));

        //Call the method “selectMyAccountOptions”
        selectMyAccountOptions("Register");

        //Enter First Name
        sendTextToElement(By.id("input-firstname"), "Joel");
        sendTextToElement(By.id("input-lastname"),"Jhones");
        final String randomEmail = randomEmail();
        sendTextToElement(By.id("input-email"), randomEmail);
        Thread.sleep(1000);
        sendTextToElement(By.id("input-telephone"), "9876543213");
        sendTextToElement(By.id("input-password"), "joel2345");
        sendTextToElement(By.id("input-confirm"), "joel2345");
        clickOnElement(By.name("newsletter"));
        clickOnElement(By.name("agree"));
        clickOnElement(By.xpath("//input[@type='submit']"));
        verifyText(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"), "Your Account Has Been Created!");
        clickOnElement(By.xpath("//div[@class='pull-right']/a[text()='Continue']"));
        //Click on My Account Link
        clickOnElement(By.xpath("//span[text()='My Account']"));
        selectMyAccountOptions("Logout");
        //Verify the text “Register Account”
        verifyText(By.xpath("//h1[text()='Account Logout']"), "Account Logout");
        clickOnElement(By.xpath("//div[@class='pull-right']/a[text()='Continue']"));

    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){

        //Click on My Account Link.
        clickOnElement(By.xpath("//span[text()='My Account']"));

        //Call the method “selectMyAccountOptions” method and pass the parameter Login”
        selectMyAccountOptions("Login");

        //Enter Email address
        sendTextToElement(By.id("input-email"),"joel_jhones@gmail.com");

        //Enter Password
        sendTextToElement(By.id("input-password"),"joel2345");

        //Click on Login button
        clickOnElement(By.xpath("//input[@class='btn btn-primary']"));

        //Verify text “My Account”
        //verifyText(By.xpath("//h2[normalize-space()='My Account']"),"My Account");

        //Click on My Account Link.
        clickOnElement(By.xpath("//span[text()='My Account']"));

        //Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");

        //Verify the text “Account Logout”
        verifyText(By.xpath("//a[normalize-space()='Logout']"),"Logout");

        //Click on Continue button
        clickOnElement(By.xpath("//div[@class='pull-right']/a[text()='Continue']"));
    }
    private static String randomEmail() {

        return "random-" + UUID.randomUUID().toString() + "@gmail.com";
    }

    @After
    public void teardown(){
        closeBrowser();
    }

}


