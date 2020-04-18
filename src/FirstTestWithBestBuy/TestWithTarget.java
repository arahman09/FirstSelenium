package FirstTestWithBestBuy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestWithTarget {

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver","/Volumes/D/IdeaProjects/SeleniumDemo/driver/geckodriver");

//      ChromeOptions headless = new ChromeOptions();  // This reference statement will not open the browser
//      headless.setHeadless(true);
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.target.com/");

        // To maximize browser
    //  driver.manage().window().fullscreen();

        // Title of Application
        System.out.println("The title of the page is: " +driver.getTitle());
     //   driver.close();


    }
}
