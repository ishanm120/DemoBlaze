package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilsPackage.CommonConstants;
import utilsPackage.CommonUtils;
import utilsPackage.VerificationUtils;

public class OrderConfirmationPage extends CommonUtils {

	public OrderConfirmationPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'sweet-alert')]//p//br[1]")
	WebElement amount;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'sweet-alert')]//p")
	WebElement orderID;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'sweet-alert')]")
	WebElement orderConfirmationPopUp;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'sa-confirm-button')]//button[contains(.,'OK')]")
	WebElement okButton;

	public void clickOKButton() {
		stepInfo("Click on 'Ok' button");
		okButton.click();
	}

	public boolean isOrderPriceCorrect() {
		String expectedPrice= CommonConstants.AMOUNT+ ": "+ productPrice+" "  +CommonConstants.PRICE_USD;
		return VerificationUtils.containsString("Verify Order price is same as on Basket", orderID.getText().split("\\n")[1],
				expectedPrice);
	}

	public boolean isOrderConfirmationPOPUpDisplayed() {
		waitForElementVisible(orderConfirmationPopUp);
		stepInfo("Verify if Order confimation pop up displayed");
		return orderConfirmationPopUp.isDisplayed();
	}

	public boolean isOrderPlacedSuccessfully() {
		boolean isPlaced = false;
		if (isOrderConfirmationPOPUpDisplayed()) {
			stepInfo("Order is placed successfully with order ID: " + orderID.getText().split("\\n")[0]);
			isPlaced = true;
			return isPlaced;
		} else {
			stepInfo("There is some Error, Order is not Placed");
			return isPlaced;
		}
	}

}
