package step_definition;

import blocks.HeaderBlock;
import cucumber.api.java.en.And;

public class NavigationSteps {
	
	HeaderBlock headerBlock= new HeaderBlock();
	
	@And("^Navigate to cart$")
	public void clickAddToCartButton() {
		headerBlock.clickBasketIcon();
	}

}
