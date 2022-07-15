package tests;

import constants.Urls;
import org.openqa.selenium.*;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.PropertyManager;

import java.util.concurrent.TimeUnit;

public class extraWebPageTests {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        PropertyManager propertyManager = new PropertyManager();
        propertyManager.loadData();
        System.setProperty("webdriver.Safari.driver", propertyManager.get("PATH_TO_DRIVER"));
        driver = new SafariDriver();
    }

    @Test
    public void greetingsExistTest() {
        driver.get(Urls.REGISTER_FORM_URL);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
        //check greetings message exists
        String greetingsMessage = driver.findElement(By.id("div_1")).getAttribute("name");

        Assert.assertEquals(greetingsMessage, "div_one");
    }

    @Test
    public void dropdownWithBandsExistsTest() {
        driver.get(Urls.REGISTER_FORM_URL);
        //check dropdown list with bands exists
        String dropdownWithBands = driver.findElement(By.id("div_5")).getAttribute("name");

        Assert.assertEquals(dropdownWithBands, "div_five");
    }

    @Test
    public void buttonWithAlertExistsTest() {
        driver.get(Urls.REGISTER_FORM_URL);
        //check a button with alert exists
        String dropdownWithBands = driver.findElement(By.id("el")).getAttribute("value");

        Assert.assertEquals(dropdownWithBands, "Click Here!");
    }

    @Test
    public void firstNameBlockContainsNameTest() {
        driver.get(Urls.REGISTER_FORM_URL);
        //check first name exists
        String firstName = driver.findElement(By.id("div_2")).getText();

        Assert.assertEquals(firstName, "I'm Maria.");
    }

    @Test
    public void hyperlinkIsValidTest() {
        driver.get(Urls.REGISTER_FORM_URL);
        //click link
        driver.findElement(By.xpath("//a[@href='https://htmlcolorcodes.com']")).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);

        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "\t");

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://htmlcolorcodes.com/");
    }

    @Test
    public void pictureAltTextExistsTest() {
        driver.get(Urls.REGISTER_FORM_URL);
        //check alternative text exists
        String altText = driver.findElement(By.cssSelector("img")).getAttribute("alt");
        Assert.assertEquals(altText, "oops, you found it");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
