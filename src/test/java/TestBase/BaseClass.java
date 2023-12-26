package TestBase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.*;

import java.io.File;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class BaseClass extends CommonMethods {

    public WebDriver driver;
    public Logger log;
    public ResourceBundle res;
    public Map<String, Object> prefs = new HashMap<String, Object>();

    @Parameters({"browser"})
    @BeforeClass
    public void setup(String browser) {
        log = LogManager.getLogger(this.getClass());
        res = ResourceBundle.getBundle("conf");

        switch (browser){
           case "chrome"-> {
               ChromeOptions chrome = new ChromeOptions();
               prefs.put("autofill.profile_enabled", false);
               chrome.setExperimentalOption("prefs", prefs);
               chrome.setPageLoadStrategy(PageLoadStrategy.NORMAL);
               chrome.addExtensions(new File(System.getProperty("user.dir") +
                       "\\extensions\\uBlock Origin 1.54.0.0.crx"));

               driver = new ChromeDriver(chrome);
               log.info("Opening the chrome browser");
           }
           case "edge" -> {
               EdgeOptions edge = new EdgeOptions();
               prefs.put("autofill.profile_enabled", false);
               edge.setExperimentalOption("prefs", prefs);
               edge.setPageLoadStrategy(PageLoadStrategy.NORMAL);
               edge.addExtensions(new File(System.getProperty("user.dir") +
                       "\\extensions\\uBlock Origin 1.54.0.0.crx"));
               driver = new EdgeDriver(edge);
           }
           case "firefox" -> {
               File profilePath = Paths.get("src", "test", "resources", "n3do88la.automation").toFile();
               FirefoxProfile profile = new FirefoxProfile(profilePath);
               FirefoxOptions options = new FirefoxOptions();
               options.setProfile(profile);
               driver = new FirefoxDriver(options);
           }
        }

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
