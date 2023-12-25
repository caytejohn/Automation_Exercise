package TestBase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class BaseClass extends CommonMethods {

    public WebDriver driver;
    public Logger log;
    public ResourceBundle res;
    public Map<String, Object> prefs = new HashMap<String, Object>();

    @BeforeClass
    public void setup() {
        log = LogManager.getLogger(this.getClass());
        res = ResourceBundle.getBundle("conf");

        ChromeOptions options = new ChromeOptions();
        prefs.put("autofill.profile_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addExtensions(new File(System.getProperty("user.dir") +
                "\\extensions\\uBlock Origin 1.54.0.0.crx"));

        driver = new ChromeDriver(options);
        log.info("Opening the chrome browser");

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        driver.get(res.getString("URL"));
        log.info("Load URL: " + res.getString("URL"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        log.info("Closed browsers");
    }
}
