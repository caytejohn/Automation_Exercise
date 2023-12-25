package TestCases;

import PageObjects.ContactUsPage;
import PageObjects.HomePage;
import TestBase.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUsTest extends BaseClass {

    @Test(description = "Test Case 6: Contact Us Form")
    public void contactUsFormTest() {

        log.info("***** Starting testing for contact us form *****");

        try {
            HomePage homePage = new HomePage(driver);
            ContactUsPage contactUsPage = new ContactUsPage(driver);

            log.info("Validation if user is in homepage");
            Assert.assertTrue(homePage.isSliderCarouselDisplayed());

            homePage.clickContactUs();
            log.info("Click contact us");

            log.info("Validation if Get Touch is displayed");
            Assert.assertTrue(contactUsPage.isGetTouchDisplayed());

            contactUsPage.setName("Name");
            log.info("Enters name");
            contactUsPage.setEmail(res.getString("email"));
            log.info("Enters email");
            contactUsPage.setSubject("Hello, World!");
            log.info("Enters subject");
            contactUsPage.setMessage("""
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam fringilla.
                    """);
            log.info("Enters message");
            contactUsPage.uploadChooseFile(System.getProperty("user.dir") + "\\src\\test\\resources\\conf.properties");
            log.info("Upload file");
            contactUsPage.clickSubmit();
            log.info("Click submit");
            contactUsPage.acceptAlert();
            log.info("Accept alert");

            log.info("Validation if success message is correct");
            Assert.assertEquals(contactUsPage.getMsgSuccess(), "Success! Your details have been submitted successfully.");

            contactUsPage.clickHome();
            log.info("Click home");

            log.info("Validation if user is in homepage");
            Assert.assertTrue(homePage.isSliderCarouselDisplayed());
        }
        catch (Exception e) {
            log.error(e.fillInStackTrace());
        }
    }
}
