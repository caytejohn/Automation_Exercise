package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SignupPage extends BasePage {

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//b[contains(text(),'Enter Account Information')]")
    WebElement hdrSignup;

    @FindBy(id = "id_gender1")
    WebElement radioTitle;

    @FindBy(css = "input[data-qa='password']")
    WebElement inputPassword;

    @FindBy(id = "days")
    WebElement drpDays;

    @FindBy(id = "months")
    WebElement drpMonths;

    @FindBy(id = "years")
    WebElement drpYears;

    @FindBy(id = "newsletter")
    WebElement chkNewsletter;

    @FindBy(id = "optin")
    WebElement chkOffers;

    @FindBy(name = "first_name")
    WebElement inputFirstName;

    @FindBy(name = "last_name")
    WebElement inputLastName;

    @FindBy(id = "address1")
    WebElement inputAddress1;

    @FindBy(name = "country")
    WebElement drpCountry;

    @FindBy(id = "state")
    WebElement inputState;

    @FindBy(xpath = "//input[@data-qa='city']")
    WebElement inputCity;

    @FindBy(xpath = "//input[@data-qa='zipcode']")
    WebElement inputZipCode;

    @FindBy(xpath = "//input[@data-qa='mobile_number']")
    WebElement inputMobile;

    @FindBy(css = "button[data-qa$='create-account']")
    WebElement btnCreateAccount;

    @FindBy(xpath = "//b[contains(text(), 'Account Created!')]")
    WebElement hdrAccountCreated;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    WebElement btnContinue;

    public boolean isEnterAccountInformationDisplayed() {
        return hdrSignup.isDisplayed();
    }

    public void selectTitle() {
        radioTitle.click();
    }

    public void setPassword(String password) {
        inputPassword.sendKeys(password);
    }

    public void selectDays(String days) {
        new Select(drpDays).selectByVisibleText(days);
    }

    public void selectMonths(String months) {
        new Select(drpMonths).selectByVisibleText(months);
    }

    public void selectYears(String years) {
        new Select(drpYears).selectByVisibleText(years);
    }

    public void checkNewsletter() {
        chkNewsletter.click();
    }

    public void checkOffers() {
        chkOffers.click();
    }

    public void setFirstName(String firstName) {
        inputFirstName.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        inputLastName.sendKeys(lastName);
    }

    public void setAddress1(String address1) {
        inputAddress1.sendKeys(address1);
    }

    public void selectCountry(String country) {
        new Select(drpCountry).selectByVisibleText(country);
    }

    public void setState(String state) {
        inputState.sendKeys(state);
    }

    public void setCity(String city) {
        inputCity.sendKeys(city);
    }

    public void setZipCode(String zipCode) {
        inputZipCode.sendKeys(zipCode);
    }

    public void setMobile(String mobile) {
        inputMobile.sendKeys(mobile);
    }

    public void clickCreateAccount() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", btnCreateAccount);
    }

    public boolean isAccountCreatedDisplayed() {
        return hdrAccountCreated.isDisplayed();
    }

    public void clickContinue() {
        btnContinue.click();
    }
}
