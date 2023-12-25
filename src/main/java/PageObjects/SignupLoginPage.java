package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupLoginPage extends BasePage {

    public SignupLoginPage(WebDriver driver) {
        super(driver);
    }

    // Signup section WebElements
    @FindBy(xpath = "//h2[normalize-space()='New User Signup!']")
    WebElement hdrNewUserSignup;

    @FindBy(css = "input[data-qa='signup-name']")
    WebElement inputName;

    @FindBy(css = "input[data-qa='signup-email']")
    WebElement inputSignupEmail;

    @FindBy(css = "button[data-qa='signup-button']")
    WebElement btnSignup;

    @FindBy(xpath = "//p[contains(text(), 'already exist!')]")
    WebElement msgEmailAlreadyExist;

    // Login section WebElements
    @FindBy(xpath = "//h2[contains(text(), 'Login to your account')]")
    WebElement hdrLoginToYouAccount;

    @FindBy(css = "input[data-qa='login-email']")
    WebElement inputLoginEmail;

    @FindBy(css = "input[data-qa='login-password']")
    WebElement inputPassword;

    @FindBy(css = "button[data-qa='login-button']")
    WebElement btnLogin;

    @FindBy(xpath = "//p[contains(text(), 'incorrect')]")
    WebElement msgIncorrectCredentials;

    // Signup section Methods
    public boolean isNewUserSignUpDisplayed() {
        return hdrNewUserSignup.isDisplayed();
    }

    public void setName(String name) {
        inputName.sendKeys(name);
    }

    public void setEmail(String email) {
        inputSignupEmail.sendKeys(email);
    }

    public void clickSignup() {
        btnSignup.click();
    }

    public String getEmailAlreadyExistMsg() {
        return msgEmailAlreadyExist.getText();
    }

    // Login section Methods
    public boolean isLoginToYourAccountDisplayed() {
        return hdrLoginToYouAccount.isDisplayed();
    }

    public void setLoginEmail(String loginEmail) {
        inputLoginEmail.sendKeys(loginEmail);
    }

    public void setPassword(String password) {
        inputPassword.sendKeys(password);
    }

    public void clickLogin() {
        btnLogin.click();
    }

    public String getIncorrectMsg() {
        return msgIncorrectCredentials.getText();
    }
}
