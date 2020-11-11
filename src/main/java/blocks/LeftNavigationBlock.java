package blocks;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utilsPackage.CommonUtils;

public class LeftNavigationBlock extends CommonUtils{
	
	
	public LeftNavigationBlock() {
		PageFactory.initElements(driver, this);
	}
	
	private static final String LEFT_NAVIGATION_CATEGORY = "//div[contains(@class,'list-group')]//a[contains(@id,'itemc') and contains(.,'%s')]";
	
	public void clickOnnCategoryName(String categoryName) {
		stepInfo("Click on category name '"+categoryName+"' from laft navigatio menu");
		driver.findElement(By.xpath(String.format(LEFT_NAVIGATION_CATEGORY,categoryName))).click();;
	}

}
