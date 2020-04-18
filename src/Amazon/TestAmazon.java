package Amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;


import java.util.concurrent.TimeUnit;










public class TestAmazon {

    WebDriver driver = null;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.gecko.driver", "/Volumes/D/IdeaProjects/SeleniumDemo/driver/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.navigate().to("https://www.amazon.com");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void cleanUp(){
        driver.close();
    }

    @Test
    public void testTitle(){
        String expectedTitle = driver.getTitle();
        System.out.println(expectedTitle);
        String actualTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
        SoftAssert softAssert = new SoftAssert();
        try {
            softAssert.assertEquals(expectedTitle, actualTitle);
          }catch(Exception ex) {
            System.out.println("Title did not match. So you need to double check");
        }

        softAssert.assertAll();
        System.out.println(actualTitle);
        System.out.println(expectedTitle);
    }

    @Test
    public void testTypingOnSearchBox() {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java books", Keys.ENTER);

    }
}