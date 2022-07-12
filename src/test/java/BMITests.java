import org.openqa.selenium.*;
import org.openqa.selenium.safari.SafariDriver;
//import org.open.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BMITests {
    @Test
    public void categoryStarvationTest() {
        System.setProperty("webdriver.Safari.driver", "src/test/resources/safari-driver");
        WebDriver driver = new SafariDriver();
        driver.get("https://healthunify.com/bmicalculator/");

        //input weight
        driver.findElement(By.name("wg")).sendKeys("40");

        //input height
        driver.findElement(By.name("ht")).sendKeys("190");

        //click calculate
        driver.findElement(By.cssSelector("[value=Calculate]")).click();

        //add check - 'Starvation' value exists

        String resultField = driver.findElement(By.className("content")).getAttribute("value");
        driver.quit();
        Assert.assertEquals(resultField, "Your category is Starvation");
    }

    @Test
    public void categoryUnderweightTest() {
        System.setProperty("webdriver.Safari.driver", "src/test/resources/safari-driver");
        WebDriver driver = new SafariDriver();
        driver.get("https://healthunify.com/bmicalculator/");

        //input weight
        driver.findElement(By.name("wg")).sendKeys("45");

        //input height
        driver.findElement(By.name("ht")).sendKeys("165");

        //click calculate
        driver.findElement(By.cssSelector("[value=Calculate]")).click();

        //add check - 'Underweight' value exists
        String resultField = driver.findElement(By.className("content")).getAttribute("value");
        driver.quit();
        Assert.assertEquals(resultField, "Your category is Underweight");
    }

    @Test
    public void categoryNormalTest() {
        System.setProperty("webdriver.Safari.driver", "src/test/resources/safari-driver");
        WebDriver driver = new SafariDriver();
        driver.get("https://healthunify.com/bmicalculator/");

        //input weight
        driver.findElement(By.name("wg")).sendKeys("55");

        //input height
        driver.findElement(By.name("ht")).sendKeys("165");

        //click calculate
        driver.findElement(By.cssSelector("[value=Calculate]")).click();

        //add check - 'Normal' value exists
        String resultField = driver.findElement(By.className("content")).getAttribute("value");
        driver.quit();
        Assert.assertEquals(resultField, "Your category is Normal");
    }

    @Test
    public void categoryOverweightTest() {
        System.setProperty("webdriver.Safari.driver", "src/test/resources/safari-driver");
        WebDriver driver = new SafariDriver();
        driver.get("https://healthunify.com/bmicalculator/");

        //input weight
        driver.findElement(By.name("wg")).sendKeys("70");

        //input height
        driver.findElement(By.name("ht")).sendKeys("165");

        //click calculate
        driver.findElement(By.cssSelector("[value=Calculate]")).click();

        //add check - 'Overweight' value exists
        String resultField = driver.findElement(By.className("content")).getAttribute("value");
        driver.quit();
        Assert.assertEquals(resultField, "Your category is Overweight");
    }

    @Test
    public void categoryObeseTest() {
        System.setProperty("webdriver.Safari.driver", "src/test/resources/safari-driver");
        WebDriver driver = new SafariDriver();
        driver.get("https://healthunify.com/bmicalculator/");

        //input weight
        driver.findElement(By.name("wg")).sendKeys("90");

        //input height
        driver.findElement(By.name("ht")).sendKeys("165");

        //click calculate
        driver.findElement(By.cssSelector("[value=Calculate]")).click();

        //add check - 'Obese' value exists
        String resultField = driver.findElement(By.className("content")).getAttribute("value");
        driver.quit();
        Assert.assertEquals(resultField, "Your category is Obese");
    }
}
