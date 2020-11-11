package step_definition;


import org.junit.Assert;

import cucumber.api.java.en.And;
import pageObjects.OrderConfirmationPage;

public class OrderConfirmationPageSteps {
	
	OrderConfirmationPage orderConfirmationPage= new OrderConfirmationPage();
	
	@And("^Verify order amount on order confirmation page$")
	public void verifyOrderDetails() {
		Assert.assertTrue(orderConfirmationPage.isOrderPriceCorrect());
	}
	
	@And("^Verify Order is placed successfully$")
	public void verifyOrderPlacedSuccessfully() {
		Assert.assertTrue(orderConfirmationPage.isOrderPlacedSuccessfully());
	}
	
	@And("^Click 'OK' button on Order confirmation page$")
	public void clickPurchaseButton() {
		orderConfirmationPage.clickOKButton();
	}

}
