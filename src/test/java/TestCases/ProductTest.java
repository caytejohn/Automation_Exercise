package TestCases;

import PageObjects.HomePage;
import PageObjects.ProductPage;
import TestBase.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends BaseClass {

    @Test(priority = 1, description = "Test Case 8: Verify All Products and product detail page")
    public void navigationToProductPageTest() {

        log.info("***** Starting testing for navigation to product page *****");

        try {
            HomePage homePage = new HomePage(driver);
            ProductPage productPage = new ProductPage(driver);

            log.info("Validation if user is in homepage");
            Assert.assertTrue(homePage.isSliderCarouselDisplayed());

            homePage.clickProduct();
            log.info("Click product");

            log.info("Validation if user successfully navigated to product page");
            Assert.assertEquals(productPage.getProductPageTitle(), "Automation Exercise - All Products");

            log.info("Validation if product list is displayed");
            Assert.assertTrue(productPage.isProductListDisplayed());

            productPage.clickViewProductOnFirstProduct();
            log.info("Click view product on first product");

            log.info("Validation if product information is displayed");
            Assert.assertTrue(productPage.isProductInformationDisplayed());
        }
        catch (Exception e) {
            log.error(e.fillInStackTrace());
        }
        log.info("***** Finish testing for navigation to product page *****");
    }

    @Test(priority = 2, description = "Test Case 9: Search Product")
    public void searchProductTest() {

        log.info("***** Starting testing for searching products *****");

        try {
            HomePage homePage = new HomePage(driver);
            ProductPage productPage = new ProductPage(driver);

            homePage.clickProduct();
            log.info("Click product");

            log.info("Validation if user successfully navigated to product page");
            Assert.assertEquals(productPage.getProductPageTitle(), "Automation Exercise - All Products");

            productPage.enterItemInSearchBox("Pure Cotton V-Neck T-Shirt");
            log.info("Enter item name in search-box");

            productPage.clickSearch();
            log.info("Click search button");

            log.info("Validation if searched product is displayed");
            Assert.assertTrue(productPage.isSearchedProductsDisplayed());
        }
        catch (Exception e) {
            log.error(e.fillInStackTrace());
        }
        log.info("***** Finish testing for searching products *****");
    }
}
