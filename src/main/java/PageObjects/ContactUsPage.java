package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactUsPage extends BasePage {

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[text()='Get In Touch']")
    WebElement hdrGetTouch;

    @FindBy(css = "input[data-qa='name']")
    WebElement inputName;

    @FindBy(css = "input[data-qa='email']")
    WebElement inputEmail;

    @FindBy(css = "input[data-qa='subject']")
    WebElement inputSubject;

    @FindBy(css = "textarea[data-qa='message']")
    WebElement inputMessage;

    @FindBy(css = "input[name='upload_file']")
    WebElement inputFileUpload;

    @FindBy(css = "input[data-qa='submit-button']")
    WebElement btnSubmit;

    @FindBy(xpath = "//div[@class='status alert alert-success']")
    WebElement msgSuccessSubmit;

    @FindBy(xpath = "//a[@class='btn btn-success']")
    WebElement btnHome;

    public boolean isGetTouchDisplayed() {
        return hdrGetTouch.isDisplayed();
    }

    public void setName(String name) {
        inputName.sendKeys(name);
    }

    public void setEmail(String email) {
        inputEmail.sendKeys(email);
    }

    public void setSubject(String subject) {
        inputSubject.sendKeys(subject);
    }

    public void setMessage(String message) {
        inputMessage.sendKeys(message);
    }

    public void uploadChooseFile(String filePath) {
        inputFileUpload.sendKeys(filePath);
    }

    public void clickSubmit() {
        btnSubmit.click();
    }

    public void acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }

    public String getMsgSuccess() {
        return msgSuccessSubmit.getText();
    }

    public void clickHome() {
        btnHome.click();
    }
}
