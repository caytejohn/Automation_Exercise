package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestCasesPage extends BasePage {

    public TestCasesPage(WebDriver driver) {
        super(driver);
    }

    public String getTestCasesPageTitle() {
        return driver.getTitle();
    }
}
