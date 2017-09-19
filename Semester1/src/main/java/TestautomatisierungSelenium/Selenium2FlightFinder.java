package TestautomatisierungSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;





public class Selenium2FlightFinder {
    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "/home/rk/Apps/Mozilla-Geckodriver-Selenium-Linux/geckodriver");

        System.out.println("Debug 1");
        DesiredCapabilities capabilities=DesiredCapabilities.firefox();
        System.out.println("Debug 2");
        capabilities.setCapability("marionette", true);
        System.out.println("Debug 3");

        File pathToBinary = new File("/home/rk/Apps/firefox/firefox");
        FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        WebDriver driver = new FirefoxDriver(ffBinary,firefoxProfile);

        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.
        //WebDriver driver = new FirefoxDriver();



        //---------------------------------------
        //http://newtours.demoaut.com/mercurysignon.php
        //<input maxlength=60 name="userName" size="20">
        //<input maxlength=60 name="password" size="20" type=password>
        //<input type=image name=login value=Login alt=Login border=0 src='/images/forms/submit.gif' width=60 height=23></a></td>

        // And now use this to visit Google
        driver.get("http://newtours.demoaut.com/mercurysignon.php");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");


        // Find the text input element by its name
        WebElement elementUserName = driver.findElement(By.name("userName"));
        // Enter something
        elementUserName.sendKeys("a");

        // Find the text input element by its name
        WebElement elementPassword = driver.findElement(By.name("password"));
        // Enter something
        elementPassword.sendKeys("a");

        // Now submit the form. WebDriver will find the form for us from the element
        elementUserName.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });

        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());

        //Close the browser
        driver.quit();
    }
}