/**
 * @author Rick Fogle
 * @version 0.2.01
 * GitHub URL: https://github.com/rickfogle/RFogleWeebly
 * DESCRIPTION
 * Project to automate testing of my personal website located at 
 * http://www.rfogle.weebly.com and as an exercise in learning bot the Java
 * language and the Selenium web test automation tool.  As a side effect, I 
 * am learning to use the GIT source code control system.
 * 
 * DEPENDENCIES:
 * website at http://www.rfogle.weebly.com, log4j, Selenium.
 * 
 * NOTES/CHANGES:
 * 05/13/2016 RF: Project created.
 * 05/13/2016 RF: Added log4j integration.
 * 05/13/2016 RF: Created github repository and did initial commit, push.
 * 
 */

package rfogleweebly;

// import external classes/libraries for Selenium
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Wait;

// import external classes/libraries for log4j
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

// import external classes/libraries for JUnit.

public class RFogleWeebly  {
    
    static WebDriver driver;
    static Wait<WebDriver> wait;

    public static void main(String[] args) {
        // Variable Declarations
        String Title;
        int Status = 0;  // Used to track and report status as the test runs.  0 = pass, 1
                
        // Here we need to create logger instance so we need to pass 
        // Class name for which  we want to create log file in my case 
        // Google is classname
        Logger logger=Logger.getLogger("RFogleWeebly");
         
        // configure log4j properties file
        PropertyConfigurator.configure("Log4j.properties");
       
        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface, 
        // not the implementation.
        WebDriver driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 30);
        logger.info("********** Start of test run **********");
        logger.info("Browser Opened.");
    
        // And now use this to visit my website.
        driver.get("http://rfogle.weebly.com");
        logger.info("Navigate to RFogle's Website.");
        
        // Check the title of the page and report or exit if not correct.
         driver.manage().window().maximize();
        Title = driver.getTitle();
        System.out.println("Page title is: "+Title);

        logger.info("Test complete, quitting test.");
        logger.info("********** End of RFogleWeebly test run **********");

        //Close the browser
        driver.quit();
    }
}
/*
// Example Code
public class GoogleSearch {
    static WebDriver driver;
    static Wait<WebDriver> wait;

    public static void main(String[] args) {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 30);
        driver.get("http://www.google.com/");

        boolean result;
        try {
            result = firstPageContainsQAANet();
        } catch(Exception e) {
            e.printStackTrace();
            result = false;
        } finally {
            driver.close();
        }

        System.out.println("Test " + (result? "passed." : "failed."));
        if (!result) {
            System.exit(1);
        }
    }

    private static boolean firstPageContainsQAANet() {
        //type search query
        driver.findElement(By.name("q")).sendKeys("qa automation\n");

        // click search
        driver.findElement(By.name("btnG")).click();

        // Wait for search to complete
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                System.out.println("Searching ...");
                return webDriver.findElement(By.id("resultStats")) != null;
            }
        });

        // Look for QAAutomation.net in the results
        return driver.findElement(By.tagName("body")).getText().contains("qaautomation.net");
    }
}

*/