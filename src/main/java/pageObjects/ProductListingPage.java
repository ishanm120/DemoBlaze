package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utilsPackage.CommonUtils;

public class ProductListingPage extends CommonUtils {

	public ProductListingPage() {
		PageFactory.initElements(driver, this);
	}

	@FindAll({ @FindBy(how = How.XPATH, using = "//div[contains(@class,'card h-100')]//h4[contains(@class,'card-title')]/a") })
	private List<WebElement> productItems;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'row') and contains(@id,'tbodyid')]")
	WebElement productItemsContainer;
	
	public void clickOnProduct(String productName) throws Exception {
		Thread.sleep(3000);
		stepInfo("Click on "+productName+ " Product on Listing page");
		WebElement foundElement = productItems.stream().filter(element -> element.getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		if (foundElement != null) {
			foundElement.click();
		} else {
			throw new Exception("Given product name "+productName+" is not present on page");
		}
	}

}
