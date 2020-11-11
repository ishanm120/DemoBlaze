package step_definition;

import cucumber.api.java.en.And;
import pageObjects.BasketPage;

public class BasketPageSteps {
	BasketPage basketPage= new BasketPage();
	
	@And("^Delete product \"([^\"]*)\" from cart$")
	public void navigateToCategory(String productName) throws Exception {
		basketPage.clickDeleteButtonForProduct(productName);
	}
	
	@And("^Click 'Place order' button$")
	public void clickPlaceOrderButton() {
		basketPage.clickPlaceOrderButton();
	}
	
	@And("^Save basket Order Total price$")
	public void saveBasketPrice() {
		basketPage.savebasketPrice();
	}
	
	@And("^Fill the user information$")
	public void fillUserInformation() {
		basketPage.fillUserInformation();
	}
	
	@And("^Click 'Purchase' button$")
	public void clickPurchaseButton() {
		basketPage.clickPurchaseButton();
	}

}
