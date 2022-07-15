import org.openqa.selenium.*;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class extraWebPageTests {
    @Test
    public void greetingsExistTest() {
        System.setProperty("webdriver.Safari.driver", "src/test/resources/safari-driver");
        WebDriver driver = new SafariDriver();
        driver.get("file:///Users/masha/IdeaProjects/healthUnify/src/main/resources/index.html");

        //check greetings message exists
        String greetingsMessage = driver.findElement(By.id("div_1")).getAttribute("name");
        driver.quit();
        Assert.assertEquals(greetingsMessage, "div_one");
    }

    @Test
    public void dropdownWithBandsExistsTest() {
        System.setProperty("webdriver.Safari.driver", "src/test/resources/safari-driver");
        WebDriver driver = new SafariDriver();
        driver.get("file:///Users/masha/IdeaProjects/healthUnify/src/main/resources/index.html");

        //check dropdown list with bands exists
        String dropdownWithBands = driver.findElement(By.id("div_5")).getAttribute("name");
        driver.quit();
        Assert.assertEquals(dropdownWithBands, "div_five");
    }

    @Test
    public void buttonWithAlertExistsTest() {
        System.setProperty("webdriver.Safari.driver", "src/test/resources/safari-driver");
        WebDriver driver = new SafariDriver();
        driver.get("file:///Users/masha/IdeaProjects/healthUnify/src/main/resources/index.html");

        //check a button with alert exists
        String dropdownWithBands = driver.findElement(By.id("el")).getAttribute("value");
        driver.quit();
        Assert.assertEquals(dropdownWithBands, "Click Here!");
    }

    @Test
    public void firstNameBlockContainsNameTest() {
        System.setProperty("webdriver.Safari.driver", "src/test/resources/safari-driver");
        WebDriver driver = new SafariDriver();
        driver.get("file:///Users/masha/IdeaProjects/healthUnify/src/main/resources/index.html");

        //check first name exists
        String firstName = driver.findElement(By.id("div_2")).getText();
        driver.quit();
        Assert.assertEquals(firstName, "I'm Maria.");
    }

    @Test
    public void hyperlinkIsValidTest() {
        System.setProperty("webdriver.Safari.driver", "src/test/resources/safari-driver");
        WebDriver driver = new SafariDriver();
        driver.get("file:///Users/masha/IdeaProjects/healthUnify/src/main/resources/index.html");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);

        //click link
        driver.findElement(By.xpath("//a[@href='https://htmlcolorcodes.com']")).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);

        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "\t");

        String currentUrl = driver.getCurrentUrl();
        driver.quit();
        Assert.assertEquals(currentUrl, "https://htmlcolorcodes.com/");
    }

    @Test
    public void pictureAltTextExistsTest() {
        System.setProperty("webdriver.Safari.driver", "src/test/resources/safari-driver");
        WebDriver driver = new SafariDriver();
        driver.get("file:///Users/masha/IdeaProjects/healthUnify/src/main/resources/index.html");

        //check alternative text exists
        String altText = driver.findElement(By.cssSelector("img")).getAttribute("alt");
        driver.quit();
        Assert.assertEquals(altText, "oops, you found it");
    }
}
