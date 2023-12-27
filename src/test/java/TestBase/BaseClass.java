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
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class BaseClass extends CommonMethods {

    public WebDriver driver;
    public Logger log;
    public ResourceBundle res;
    public ProcessBuilder pb;
    public Map<String, Object> prefs = new HashMap<String, Object>();

    @BeforeTest
    public void startGrid() {
        try {
            pb = new ProcessBuilder("cmd.exe", "/C", "start", "start_dockergrid.bat");
            pb.start();

            TimeUnit.MILLISECONDS.sleep(7000);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Parameters({"browser"})
    @BeforeClass
    public void setup(String browser) {
        log = LogManager.getLogger(this.getClass());
        res = ResourceBundle.getBundle("conf");

        try {
            URI uri = new URI("http://localhost:4444");
            URL url = uri.toURL();

            switch (browser){
                case "chrome"-> {
                    DesiredCapabilities chrome = new DesiredCapabilities();
                    chrome.setBrowserName(Browser.CHROME.browserName());
                    chrome.setVersion("120.0");
                    driver = new RemoteWebDriver(url, chrome);
                    log.info("Opening the chrome browser");
                }
                case "edge" -> {
                    DesiredCapabilities edge = new DesiredCapabilities();
                    edge.setBrowserName(Browser.EDGE.browserName());
                    edge.setVersion("120.0");
                    driver = new RemoteWebDriver(url, edge);
                    log.info("Opening the edge browser");
                }
                case "firefox" -> {
                    DesiredCapabilities firefox = new DesiredCapabilities();
                    firefox.setBrowserName(Browser.FIREFOX.browserName());
                    firefox.setVersion("120.0");
                    driver = new RemoteWebDriver(url ,firefox);
                    log.info("Opening the firefox browser");
                }
            }
        }
        catch (Exception e) {
            log.error(e.getMessage());
        }
        driver.get(res.getString("URL"));
        log.info("Load URL: " + res.getString("URL"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        log.info("Closed browsers");
    }

    @AfterTest
    public void stopGrid() {
        try {
            pb = new ProcessBuilder("cmd.exe", "/C", "start", "stop_dockergrid.bat");
            pb.start();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
