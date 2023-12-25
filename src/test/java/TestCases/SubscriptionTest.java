package TestCases;

import PageObjects.HomePage;
import TestBase.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SubscriptionTest extends BaseClass {

    @Test(priority = 1, description = "Test Case 10: Verify Subscription in home page")
    public void subscriptionInHomePageTest() {

        log.info("***** Starting testing for subscription in homepage *****");

        try {
            HomePage homePage = new HomePage(driver);

            log.info("Validation if user is in homepage");
            Assert.assertTrue(homePage.isSliderCarouselDisplayed());

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, document.body.scrollHeight)");

            log.info("Validation if subscription text is correct");
            Assert.assertEquals(homePage.getSubscriptionTextHdr(), "SUBSCRIPTION");

            homePage.setEmailAddress(res.getString("email"));
            log.info("Enters email address");
            homePage.clickSubscribeButton();
            log.info("Click subscribe button");

            log.info("Validation if success subscription message is displayed");
            Assert.assertTrue(homePage.isSuccessSubscriptionMsgDisplayed());
        }
        catch (Exception e) {
            log.error(e.fillInStackTrace());
        }
        log.info("***** Finish testing for subscription in homepage *****");
    }

    @Test(priority = 2, description = "Test Case 11: Verify Subscription in Cart page")
    public void subscriptionInCartPageTest() {

        log.info("***** Starting testing for subscription in homepage *****");
        try {
            HomePage homePage = new HomePage(driver);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, -document.body.scrollHeight)");

            log.info("Validation if user is in homepage");
            Assert.assertTrue(homePage.isSliderCarouselDisplayed());

            homePage.clickCart();
            log.info("Click cart");

            log.info("Validation if subscription text is correct");
            Assert.assertEquals(homePage.getSubscriptionTextHdr(), "SUBSCRIPTION");

            homePage.setEmailAddress(res.getString("email"));
            log.info("Enters email address");
            homePage.clickSubscribeButton();
            log.info("Click subscribe button");

            log.info("Validation if success subscription message is displayed");
            Assert.assertTrue(homePage.isSuccessSubscriptionMsgDisplayed());

        }
        catch (Exception e) {
            log.error(e.fillInStackTrace());
        }
    }
}
