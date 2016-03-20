package venus.regression;

import com.sun.jdi.connect.spi.TransportService;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import venus.Env;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by sriramangajala on 07/02/16.
 */
public class BaseTest {
    public static WebDriver driver;
    static boolean ci = false;
    @BeforeClass
    public static void start()
    {
        System.out.println("Starting browser ...... "+ Env.browser);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("firefox");
        if(ci) {
            try {
                driver = new RemoteWebDriver(new URL("localhost:4444"), capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        else
        {
            driver= new FirefoxDriver();
        }
        System.out.println("Opening the home page...... "+Env.homeURL);
        driver.get(Env.homeURL);
        System.out.println("Checking the home page is shown......");
        Assert.assertTrue("Checking the welcome message shown ",driver.findElement(By.tagName("body")).getText().contains("Providing researchers"));
    }
    @AfterClass
    public static void stop()
    {
        driver.close();
        driver.quit();
    }



}
