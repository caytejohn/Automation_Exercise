package TestCases;

import PageObjects.HomePage;
import PageObjects.SignupLoginPage;
import TestBase.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {

    @Test(priority = 1, description = "Test Case 2: Login User with correct email and password")
    public void loginWithValidCredentialTest() {

        log.info("***** Starting testing for login with valid credentials *****");

        try {
            HomePage homePage = new HomePage(driver);
            SignupLoginPage signupLoginPage = new SignupLoginPage(driver);

            log.info("Validation if user is in homepage");
            Assert.assertTrue(homePage.isSliderCarouselDisplayed());

            homePage.clickSignupLogin();
            log.info("Click Signup / Login");

            log.info("Validation if Login to your account is displayed");
            Assert.assertTrue(signupLoginPage.isLoginToYourAccountDisplayed());

            signupLoginPage.setLoginEmail(res.getString("email"));
            log.info("Enters login email");
            signupLoginPage.setPassword(res.getString("password"));
            log.info("Enters password");
            signupLoginPage.clickLogin();
            log.info("Click login button");

            log.info("Validation if Logged in as username is displayed");
            Assert.assertTrue(homePage.isLoginAsUsernameDisplayed());
        }
        catch (Exception e) {
            log.error(e.fillInStackTrace());
        }
        log.info("***** Finish testing for login with valid credentials *****");
    }

    @Test(priority = 2, dependsOnMethods = {"loginWithValidCredentialTest"}, description = "Test Case 4: Logout User")
    public void logoutTest() {

        log.info("***** Starting testing for logout user *****");

        try {
            HomePage homePage = new HomePage(driver);
            SignupLoginPage signupLoginPage = new SignupLoginPage(driver);

            homePage.clickLogout();
            log.info("Click logout");

            log.info("Validation if Login to your account is displayed");
            Assert.assertTrue(signupLoginPage.isLoginToYourAccountDisplayed());
        }
        catch (Exception e) {
            log.error(e.fillInStackTrace());
        }
        log.info("***** Finish testing for logout user *****");
    }

    @Test(priority = 3,
            dependsOnMethods = {"logoutTest"},
            description = "Test Case 3: Login User with incorrect email and password")
    public void loginWithInvalidCredentialsTest() {

        log.info("***** Starting testing for login with invalid credentials *****");

        try {
            SignupLoginPage signupLoginPage = new SignupLoginPage(driver);

            signupLoginPage.setLoginEmail("incorrect@email.com");
            log.info("Enters login email");
            signupLoginPage.setPassword("incorrectpassword");
            log.info("Enters password");
            signupLoginPage.clickLogin();
            log.info("Click login button");

            log.info("Validation if error message is correct");
            Assert.assertEquals(signupLoginPage.getIncorrectMsg(), "Your email or password is incorrect!");
        }
        catch (Exception e) {
            log.error(e.fillInStackTrace());
        }
        log.info("***** Finish testing for login with invalid credentials *****");
    }
}
