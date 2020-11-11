package pageObjects;

import org.openqa.selenium.support.PageFactory;

import baseTest.BaseUtils;
import blocks.LeftNavigationBlock;
import utilsPackage.CommonUtils;

public class HomePage extends CommonUtils {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	LeftNavigationBlock leftNavigationBlock= new LeftNavigationBlock();
	

	public void openHomePage() {
		String url = BaseUtils.properties.getProperty("appUrl");
		stepInfo("Open Home Page Url:" + url);
		driver.get(url);
	}
	
	public void navigateToCategory(String categoryName) {
		leftNavigationBlock.clickOnnCategoryName(categoryName);
	}
	

}
