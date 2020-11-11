package blocks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilsPackage.CommonUtils;

public class HeaderBlock extends CommonUtils{
	
	public HeaderBlock() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'navbar')]//li[contains(@class,'nav-item')]//a[contains(@id,'cartur')]")
	WebElement cartLink;
	
	
	public void clickBasketIcon() {
		stepInfo("Click on Cart Link from Header");
		cartLink.click();
	}

}
