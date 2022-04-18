package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        String expectedMessage = "Secure Area";

        //Enter “tomsmith” username
        WebElement userNameField = driver.findElement(By.id("username"));
        userNameField.sendKeys("tomsmith");

        //Enter “SuperSecretPassword!” password
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("SuperSecretPassword!");

        WebElement loginButton = driver.findElement(By.xpath("//i[contains(text(),'Login')]"));
        loginButton.click();

        WebElement actualMessageElement = driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/h2[1]"));
        String actualMessage = actualMessageElement.getText();

        Assert.assertEquals("Messged not displayed", expectedMessage, actualMessage);


    }
    @Test
    public void verifyTheUsernameErrorMessage(){

        String expectedMessage = "Your username is invalid!\n" +
                "×";
        //Enter “tomsmith1” username
        WebElement userNameField = driver.findElement(By.id("username"));
        userNameField.sendKeys("tomsmith1");

        //Enter “SuperSecretPassword!” password
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("SuperSecretPassword!");

        WebElement loginButton = driver.findElement(By.xpath("//i[contains(text(),'Login')]"));
        loginButton.click();

        WebElement actualMessageElement = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]"));
        String actualMessage = actualMessageElement.getText();

        Assert.assertEquals("Messaged is not displayed",expectedMessage,actualMessage);


    }
    @Test
    public void verifyThePasswordErrorMessage(){

        String expectedMessage = "Your password is invalid!\n" +
                "×";
        //Enter “tomsmith” username
        WebElement userNameField = driver.findElement(By.id("username"));
        userNameField.sendKeys("tomsmith");

        //Enter “SuperSecretPassword” password
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("SuperSecretPassword");

        WebElement loginButton = driver.findElement(By.xpath("//i[contains(text(),'Login')]"));
        loginButton.click();

        WebElement actualMessageElement = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]"));
        String actualMessage = actualMessageElement.getText();

        Assert.assertEquals("Messaged is not displayed",expectedMessage,actualMessage);

    }
    @After
    public void tearDown() {
        closeBrowser();
    }

}
