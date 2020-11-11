package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilsPackage.CommonUtils;

public class ProductPage extends CommonUtils{
	
	public ProductPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//a[contains(.,'Add to cart')]")
	WebElement addToCartButton;
	
	public void clickAddToCartButton() {
		waitForElementVisible(addToCartButton);
		stepInfo("Click on Add to cart Button");
		addToCartButton.click();
	}
	
	public void clickAcceptButtonOnConfirmationPopUp() {
		waitForAlertPresnet();
		stepInfo("Click on Accept Button on confirmation pop up");
		acceptAlert();
	}
	
	 

}
