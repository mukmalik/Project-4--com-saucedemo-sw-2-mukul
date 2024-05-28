package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest
{
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {

        // Click on ‘Sign In’ link
        driver.findElement(By.linkText("Sign In")).click();

        //Verify the text ‘Welcome Back!’
        String expectedText = "Welcome Back!";
        WebElement welcomeBackTextElement = driver.findElement(By.xpath("//h2"));
        String actualText = welcomeBackTextElement.getText();
        Assert.assertEquals("Welcome Back displayed", expectedText, actualText);
    }

    @Test
    public void verifyTheErrorMessage() {

        // Click on ‘Sign In’ link
        driver.findElement(By.linkText("Sign In")).click();

        // Enter the invalid email to email field.
        driver.findElement(By.id("user[email]")).sendKeys("beenarani@gmail.com");

        // Enter invalid password to password field.
        driver.findElement(By.id("user[password]")).sendKeys("Password123");

        //Click on Login Button.
        driver.findElement(By.linkText("Sign In")).click();

        //Verify the text ‘Invalid email or password.’
        String expectedText = "Invalid email or password.";
        WebElement invalidEmailOrPasswordElement = driver.findElement(By.xpath("//li[@class = 'form-error__list-item']"));
        String actualText = invalidEmailOrPasswordElement.getText();
        Assert.assertEquals("invalid email or password displayed", expectedText, actualText);
    }


    @After
    public void tearDown() {
        //driver.close();
    }

}
