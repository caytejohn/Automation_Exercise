package TestCases;

import PageObjects.HomePage;
import PageObjects.SignupLoginPage;
import PageObjects.SignupPage;
import TestBase.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseClass {

    @Test(priority = 1, description = "Test Case 1: Register User")
    public void registerUserTest(){

        log.info("***** Starting testing for user registration *****");

        try {
            HomePage homePage = new HomePage(driver);
            SignupLoginPage signupLoginPage = new SignupLoginPage(driver);
            SignupPage signupPage = new SignupPage(driver);

            log.info("Validation if user is in homepage");
            Assert.assertTrue(homePage.isSliderCarouselDisplayed());

            homePage.clickSignupLogin();
            log.info("Click Signup / Login");

            log.info("Validation if New User Signup is displayed");
            Assert.assertTrue(signupLoginPage.isNewUserSignUpDisplayed());

            signupLoginPage.setName("HelloWorld");
            log.info("Enters name");
            signupLoginPage.setEmail("testing1234@test.test");
            log.info("Enters email");
            signupLoginPage.clickSignup();
            log.info("Click signup button");

            log.info("Validation if Enter Account Information is displayed");
            Assert.assertTrue(signupPage.isEnterAccountInformationDisplayed());

            signupPage.selectTitle();
            log.info("Select title");
            signupPage.setPassword("!@t3st@t3st@!");
            log.info("Enter password");
            signupPage.selectDays("20");
            log.info("Select day");
            signupPage.selectMonths("March");
            log.info("Select month");
            signupPage.selectYears("1995");
            log.info("Select year");
            signupPage.checkNewsletter();
            log.info("Check newsletter checkbox");
            signupPage.checkOffers();
            log.info("Check offers checkbox");
            signupPage.setFirstName("First Name");
            log.info("Enter first name");
            signupPage.setLastName("Last Name");
            log.info("Enter last name");
            signupPage.setAddress1("Address 1");
            log.info("Enter address 1");
            signupPage.selectCountry("Canada");
            log.info("Select country");
            signupPage.setState("State");
            log.info("Enter state");
            signupPage.setCity("City");
            log.info("Enter city");
            signupPage.setZipCode("1234567890");
            log.info("Enter zip code");
            signupPage.setMobile("65496012");
            log.info("Enter mobile number");
            signupPage.clickCreateAccount();
            log.info("Click create account button");

            log.info("Validation if Account Created is displayed");
            Assert.assertTrue(signupPage.isAccountCreatedDisplayed());

            signupPage.clickContinue();
            log.info("Click continue button");

            log.info("Validation if Logged in as username is displayed");
            Assert.assertTrue(homePage.isLoginAsUsernameDisplayed());

            homePage.clickDeleteAccount();
            log.info("Click delete account");

            log.info("Validation if Account Deleted is displayed");
            Assert.assertTrue(homePage.isAccountDeleteDisplayed());

            homePage.clickAccountDeleteContinue();
            log.info("Click continue button");
        }
        catch (Exception e) {
            log.error(e.fillInStackTrace());
        }
        log.info("***** Finish testing for user registration *****");
    }

    @Test(priority = 2, description = "Test Case 5: Register User with existing email")
    public void registerUserWithExistingEmailTest() {

        log.info("***** Starting testing for user registration with existing email *****");

        try {
            HomePage homePage = new HomePage(driver);
            SignupLoginPage signupLoginPage = new SignupLoginPage(driver);

            log.info("Validation if user is in homepage");
            Assert.assertTrue(homePage.isSliderCarouselDisplayed());

            homePage.clickSignupLogin();
            log.info("Click Signup / Login");

            signupLoginPage.setName("HelloWorld");
            log.info("Enters name");
            signupLoginPage.setEmail("testing123@test.test");
            log.info("Enters email");
            signupLoginPage.clickSignup();
            log.info("Click signup button");

            log.info("Validation if error message is correct");
            Assert.assertEquals(signupLoginPage.getEmailAlreadyExistMsg(), "Email Address already exist!");
        }
        catch (Exception e) {
            log.error(e.fillInStackTrace());
        }
        log.info("***** Finish testing for user registration with existing email *****");
    }
}
