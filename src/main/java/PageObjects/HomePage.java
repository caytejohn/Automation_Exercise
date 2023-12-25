package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "slider-carousel")
    WebElement homeSliderCarousel;

    @FindBy(xpath = "//a[contains(text(), 'Signup / Login')]")
    WebElement lnkSignupLogin;

    @FindBy(xpath = "//a[contains(.,'Logged in as ') and b]")
    WebElement txtLoginAsUsername;

    @FindBy(xpath = "//a[normalize-space()='Delete Account']")
    WebElement lnkDeleteAccount;

    @FindBy(xpath = "//b[text()='Account Deleted!']")
    WebElement hdrAccountDeleted;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    WebElement btnContinueAccountDeleted;

    @FindBy(xpath = "//a[text()=' Logout']")
    WebElement lnkLogout;

    @FindBy(xpath = "//a[text()=' Contact us']")
    WebElement lnkContactUs;

    @FindBy(xpath = "//a[text()=' Test Cases']")
    WebElement lnkTestCases;

    @FindBy(xpath = "//a[contains(text(),'Products')]")
    WebElement lnkProducts;

    @FindBy(xpath = "//h2[.='Subscription']")
    WebElement hdrSubscription;

    @FindBy(id = "susbscribe_email")
    WebElement inputEmailAddress;

    @FindBy(xpath = "//button[@id='subscribe']")
    WebElement btnSubscribe;

    @FindBy(xpath = "//div[@class='alert-success alert']")
    WebElement msgSuccessSubscription;

    @FindBy(xpath = "//a[contains(text(),'Cart')]")
    WebElement lnkCart;

    public boolean isSliderCarouselDisplayed() {
        return homeSliderCarousel.isDisplayed();
    }

    public void clickSignupLogin() {
        lnkSignupLogin.click();
    }

    public boolean isLoginAsUsernameDisplayed() {
        return txtLoginAsUsername.isDisplayed();
    }

    public void clickDeleteAccount() {
        lnkDeleteAccount.click();
    }

    public boolean isAccountDeleteDisplayed() {
        return hdrAccountDeleted.isDisplayed();
    }

    public void clickAccountDeleteContinue() {
        btnContinueAccountDeleted.click();
    }

    public void clickLogout() {
        lnkLogout.click();
    }

    public void clickContactUs() {
        lnkContactUs.click();
    }

    public void clickTestCases() {
        lnkTestCases.click();
    }

    public void clickProduct() {
        lnkProducts.click();
    }

    public String getSubscriptionTextHdr() {
        return hdrSubscription.getText();
    }

    public void setEmailAddress(String email) {
        inputEmailAddress.sendKeys(email);
    }

    public void clickSubscribeButton() {
        btnSubscribe.click();
    }

    public boolean isSuccessSubscriptionMsgDisplayed() {
        return msgSuccessSubscription.isDisplayed();
    }

    public void clickCart() {
        lnkCart.click();
    }
}
