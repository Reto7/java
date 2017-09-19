package TestautomatisierungSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;


public class Selenium2TestOpenOlat {
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
        driver.get("https://openolat.ibw.ch/dmz/");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");


        // Find the text input element by its name
        // <input id="o_fiooolat_login_name" name="o_fiooolat_login_name" class="form-control" size="20" maxlength="128" value="" placeholder="OpenOLAT-Benutzername" autofocus="" type="text">
        WebElement elementUserName = driver.findElement(By.id("o_fiooolat_login_name"));
        // Enter something
        elementUserName.sendKeys("reto.kaufmann@adon.li");

        // Find the text input element by its name
        // <input id="o_fiooolat_login_pass" name="o_fiooolat_login_pass" class="form-control" size="20" maxlength="128" value="" placeholder="OpenOLAT-Passwort" type="password">
        WebElement elementPassword = driver.findElement(By.id("o_fiooolat_login_pass"));
        // Enter something
        elementPassword.sendKeys("rk70");

        // Now submit the form. WebDriver will find the form for us from the element
        // <button type="button" id="o_fiooolat_login_button" name="o_fiooolat_login_button" value="Login" onclick="o_ffEvent('ofo_oolat_login','ofo_oolat_login_dispatchuri','o_fiooolat_login_button','ofo_oolat_login_eventval','2')" class="btn btn-primary o_button_dirty"><span>Login</span></button>
        WebElement elementLoginButton = driver.findElement(By.id("o_fiooolat_login_button"));
        elementLoginButton.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        // (A) Anzahl eingeloggte User -- mit FindById
        //<span id="o_counter">(<span id="o_c67047369155">80</span> Personen sind online)</span>
        WebElement elementAnzahlUserA = driver.findElement(By.id("o_counter"));
        System.out.println("***** resultat findById******: " +elementAnzahlUserA.getText() );

        // (B) Anzahl eingeloggte User -- mit FindById
        //<span id="o_counter">(<span id="o_c67047369155">80</span> Personen sind online)</span>
        // mit Chrome Inspektor auf Element klicken, rechte Maustaste Copy XPath, so einfach!
        WebElement elementAnzahlUserB = driver.findElement(By.xpath("//*[@id=\"o_counter\"]"));
        System.out.println("***** resultat findByXPath******: " +elementAnzahlUserB.getText() );

        //Close the browser
        driver.quit();
    }
}