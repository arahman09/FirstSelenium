package FirstTestWithBestBuy;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestBestBuy {

    WebDriver driver = null;

    @BeforeMethod
    public void introBestBuy() {

        System.setProperty("webdriver.gecko.driver", "/Volumes/D/IdeaProjects/SeleniumDemo/driver/geckodriver");
//        FirefoxOptions options = new FirefoxOptions();
//        options.setHeadless(true);
        driver = new FirefoxDriver();
        driver.get("https://www.bestbuy.com/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void clean() {
        driver.close();
    }

    @Test

    public void PrintTitle() {
        String title = driver.getTitle();
        System.out.println("The title of Application: " + driver.getTitle());
        SoftAssert softAssert = new SoftAssert();
        try {
            softAssert.assertEquals(title, "Best Buy | Official Online Store | Shop Now & Save");
        } catch (Exception ex) {
            System.out.println("you got a soft trouble");

        }
    }

    @Test
    public void searchBox() {
        driver.findElement(By.id("gh-search-input")).sendKeys("iPhone Xs max", Keys.ENTER);

    }
}
