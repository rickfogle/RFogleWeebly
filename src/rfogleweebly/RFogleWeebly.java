/**
 *
 * @author rfogle
 */

package rfogleweebly;

// import external libraries for Selenium
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
// import external libraries for log4j
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class RFogleWeebly  {
    public static void main(String[] args) {
        // Here we need to create logger instance so we need to pass 
        // Class name for which  we want to create log file in my case 
        // Google is classname
        Logger logger=Logger.getLogger("RFogleWeebly");
         
        // configure log4j properties file
        PropertyConfigurator.configure("Log4j.properties");
       
        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface, 
        // not the implementation.
        logger.info("********** Start of test run **********");

        WebDriver driver = new FirefoxDriver();
        logger.info("Browser Opened.");
        
        // And now use this to visit my website.
        driver.get("http://rfogle.weebly.com");
        logger.info("Navigate to RFogle's Website.");
        // Check the title of the page and report or exit if not correct.
         driver.manage().window().maximize();
        Title = driver.getTitle();
        System.out.println("Page title is: "+Title);
        Assert.assertTrue(Title.contains("rfogle.com"));

        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());
        logger.info("Test complete, quitting test.");
        logger.info("********** End of RFogleWeebly test run **********");
        //Close the browser
        driver.quit();
    }
}