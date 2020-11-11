package blocks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilsPackage.CommonConstants;
import utilsPackage.CommonUtils;

public class CheckoutPopUp extends CommonUtils {

	public CheckoutPopUp() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'orderModal')]//div[contains(@class,'modal-content')]")
	WebElement checkoutPopup;

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'orderModal')]//input[contains(@id,'name')]")
	WebElement nameInput;

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'orderModal')]//input[contains(@id,'country')]")
	WebElement countryInput;

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'orderModal')]//input[contains(@id,'city')]")
	WebElement cityInput;

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'orderModal')]//input[contains(@id,'card')]")
	WebElement cardInput;

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'orderModal')]//input[contains(@id,'month')]")
	WebElement monthInput;

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'orderModal')]//input[contains(@id,'year')]")
	WebElement yearInput;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'modal-footer')]//button[contains(.,'Purchase')]")
	WebElement purchaseButton;

	public void fillUserInformation() {
		waitForElementVisible(checkoutPopup);
		stepInfo("Enter User name: " + CommonConstants.USERNAME);
		nameInput.sendKeys(CommonConstants.USERNAME);
		stepInfo("Enter Country: " + CommonConstants.COUNTRY);
		countryInput.sendKeys(CommonConstants.COUNTRY);
		stepInfo("Enter City: " + CommonConstants.CITY);
		cityInput.sendKeys(CommonConstants.CITY);
		stepInfo("Enter Card: " + CommonConstants.CARD);
		cardInput.sendKeys(CommonConstants.CARD);
		stepInfo("Enter Month: " + CommonConstants.MONTH);
		monthInput.sendKeys(CommonConstants.MONTH);
		stepInfo("Enter Year: " + CommonConstants.YEAR);
		yearInput.sendKeys(CommonConstants.YEAR);
	}

	public void clickPurchaseButton() {
		stepInfo("Click on 'Purchase' button");
		purchaseButton.click();
	}

}
