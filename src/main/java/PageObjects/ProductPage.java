package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='features_items']")
    WebElement featureItems;

    @FindBy(css = "a[href='/product_details/1']")
    WebElement viewFirstProduct;

    @FindBy(xpath = "//div[@class='product-information']")
    WebElement productInformation;

    @FindBy(xpath = "//input[@id='search_product']")
    WebElement inputSearchProduct;

    @FindBy(xpath = "//button[@id='submit_search']")
    WebElement btnSearchProduct;

    @FindBy(xpath = "//h2[text()='Searched Products']")
    WebElement hdrSearchedProducts;

    public String getProductPageTitle() {
        return driver.getTitle();
    }

    public boolean isProductListDisplayed() {
        return featureItems.isDisplayed();
    }

    public void clickViewProductOnFirstProduct() {
        viewFirstProduct.click();
    }

    public boolean isProductInformationDisplayed() {
        return productInformation.isDisplayed();
    }

    public void enterItemInSearchBox(String product) {
        inputSearchProduct.sendKeys(product);
    }

    public void clickSearch() {
        btnSearchProduct.click();
    }

    public boolean isSearchedProductsDisplayed() {
        return hdrSearchedProducts.isDisplayed();
    }

}
