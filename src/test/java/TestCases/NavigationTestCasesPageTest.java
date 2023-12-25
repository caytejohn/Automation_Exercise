package TestCases;

import PageObjects.HomePage;
import PageObjects.TestCasesPage;
import TestBase.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTestCasesPageTest extends BaseClass {

    @Test(description = "Test Case 7: Verify Test Cases Page")
    public void navigationToTestCasesPageTest() {

        log.info("***** Starting testing for navigation to test cases page *****");

        try {
            HomePage homePage = new HomePage(driver);
            TestCasesPage testCasesPage = new TestCasesPage(driver);

            log.info("Validation if user is in homepage");
            Assert.assertTrue(homePage.isSliderCarouselDisplayed());

            homePage.clickTestCases();
            log.info("Click test cases");

            log.info("Validation if user successfully navigated to test cases page");
            Assert.assertEquals(testCasesPage.getTestCasesPageTitle(),
                    "Automation Practice Website for UI Testing - Test Cases");
        }
        catch (Exception e) {
            log.error(e.fillInStackTrace());
        }
        log.info("***** Finish testing for navigation to test cases page *****");
    }
}
