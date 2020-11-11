package step_definition;

import cucumber.api.java.en.And;
import pageObjects.ProductPage;
import utilsPackage.CommonUtils;

public class ProductPageSteps extends CommonUtils{
	
	ProductPage productPage=new ProductPage();
	
	@And("^Click Add to cart on product page$")
	public void clickAddToCartButton() {
		productPage.clickAddToCartButton();
	}
	
	@And("^Accept confirmation popup$")
	public void acceptConnfimationPopUp() {
		productPage.clickAcceptButtonOnConfirmationPopUp();
	}

}
