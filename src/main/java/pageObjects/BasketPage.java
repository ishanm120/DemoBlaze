package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import blocks.CheckoutPopUp;
import utilsPackage.CommonUtils;

public class BasketPage extends CommonUtils{
	
	public BasketPage() {
		PageFactory.initElements(driver, this);
	}
	
	CheckoutPopUp checkoutPopUp = new CheckoutPopUp();
	
	@FindBy(how = How.XPATH, using = "//h3[contains(@id,'totalp')]")
	WebElement basketPrice;
	
	@FindAll({ @FindBy(how = How.XPATH, using = "//tr[contains(@class,'success')]") })
	private List<WebElement> productItems;
	
	@FindBy(how = How.XPATH, using = "//button[contains(@type,'button') and contains(text(),'Place Order')]")
	WebElement placeOrderButton;
	
	private static final String PRODUCT_NAME_XPATH= ".//td[2]";
	
	private static final String DELETE_BUTTON_XPATH= ".//td[4]/a";
	
	
	
	public void clickDeleteButtonForProduct(String productName) throws Exception {
		waitForAllElementVisible(productItems);
		stepInfo("Click Delete button for "+productName+ " Product");
		WebElement foundElement = productItems.stream().filter(element -> element.findElement(By.xpath(PRODUCT_NAME_XPATH)).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		if (foundElement != null) {
			foundElement.findElement(By.xpath(DELETE_BUTTON_XPATH)).click();
			waitForElementNotVisible(foundElement);
		} else {
			throw new Exception("Given product name "+productName+" is not present in cart");
		}
	}
	
	public void clickPlaceOrderButton() {
		stepInfo("Click on 'Place Order' button");
		placeOrderButton.click();
	}
	
	public void savebasketPrice() {
		waitForElementVisible(basketPrice);
		stepInfo("Save the total price from basket");
		productPrice= basketPrice.getText();
	}
	
	public void fillUserInformation() {
		stepInfo("Fill User Information on Checkout Pop up");
		checkoutPopUp.fillUserInformation();
	}
	
	public void clickPurchaseButton() {
		checkoutPopUp.clickPurchaseButton();
	}
	
	

}
