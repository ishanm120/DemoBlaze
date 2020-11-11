package step_definition;

import cucumber.api.java.en.And;
import pageObjects.ProductListingPage;
import utilsPackage.CommonUtils;

public class ProductListingPageSteps extends CommonUtils{
	
	ProductListingPage productListingPage=new ProductListingPage();
	
	@And("^Open product \"([^\"]*)\" from product listing page$")
	public void navigateToCategory(String productName) throws Exception {
		productListingPage.clickOnProduct(productName);
	}

}
