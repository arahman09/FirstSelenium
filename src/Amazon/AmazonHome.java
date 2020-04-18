package Amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class AmazonHome {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "/Volumes/D/IdeaProjects/SeleniumDemo/driver/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://www.amazon.com");
        String title = driver.getTitle();
        System.out.println(title);
        SoftAssert softAssert = new SoftAssert();
        try {
            softAssert.assertEquals(title, "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more",
                    "Title did not match. So you need to double check");
        }catch(Exception ex) {
            System.out.println("Title did not match. So you need to double check");
        }
        driver.manage().window().maximize();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java books", Keys.ENTER);
        driver.close();
    }

}