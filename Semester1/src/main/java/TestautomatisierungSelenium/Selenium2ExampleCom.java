package TestautomatisierungSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.List;

public class Selenium2ExampleCom {
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

        // And now use this to visit Google
        driver.get("http://www.example.com");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        /*
        <body>
        <div>
            <h1>Example Domain</h1>
            <p>This domain is established to be used for illustrative examples in documents. You may use this
                domain in examples without prior coordination or asking for permission.</p>
            <p><a href="http://www.iana.org/domains/example">More information...</a></p>
        </div>
        </body>
        */


        // Find the text input element by tag name
        List<WebElement> li = driver.findElements(By.tagName("h1"));
        System.out.println("Number of H1 Tags: "+li.size());
        for(WebElement we : li){
            System.out.println("Text of H1 Tag: "+we.getText());
        }
        //Other way to print all links:
        //for(int i = 0; i < li.size(); i++){
        //    System.out.println(li.get(i).getText());
        //}

        //Close the browser
        driver.quit();
    }
}