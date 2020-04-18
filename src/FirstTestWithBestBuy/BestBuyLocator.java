package FirstTestWithBestBuy;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;

public class BestBuyLocator {

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "/Volumes/D/IdeaProjects/SeleniumDemo/driver/geckodriver");
//        FirefoxOptions options = new FirefoxOptions();
//        options.setHeadless(true);
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.bestbuy.com/");

        //driver.manage().window().maximize();
        String title = driver.getTitle();
        System.out.println("The title of Application: " +driver.getTitle());
        SoftAssert softAssert = new SoftAssert();
        try {


            softAssert.assertEquals(title, "| Official Online Store | Shop Now & Save");
        } catch (Exception ex) {
            System.out.println("you got a soft assert");
        }
        driver.findElement(By.id("gh-search-input")).sendKeys("iPhone Xs max", Keys.ENTER);

       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       // driver.close();


    }
}